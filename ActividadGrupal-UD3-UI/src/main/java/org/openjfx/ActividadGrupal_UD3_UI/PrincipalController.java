package org.openjfx.ActividadGrupal_UD3_UI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Model.Manager;
import Model.Servicio;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class PrincipalController implements Initializable {
	
	@FXML
	private ComboBox<String> tipos;
	
	//Necesitamos cargar un observable con los datos
	ObservableList<String> list = FXCollections.observableArrayList("Reparación",
			"Mantenimiento", "Instalación", "Desarrollo de Software");
	
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField nombre;
	
	@FXML
	private TextField prioridad;
	
	@FXML
	private TextArea observaciones;
	
	@FXML
	private TableView<Servicio> tabla;
	
	@FXML
    private TableColumn<Servicio, String> columnaId;
	
	@FXML
    private TableColumn<Servicio, String> columnaNombre;
	
	@FXML
    private TableColumn<Servicio, String> columnaTipo;
	
	@FXML
    private TableColumn<Servicio, String> columnaPrioridad;
	
	@FXML
    private TableColumn<Servicio, String> columnaObservaciones;
	
	@FXML
	private Button añadir;
	
	@FXML
	private Button editar;
	
	@FXML
	private Button borrar;
	
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		tipos.setItems(list);
		cargarServiciosTabla();
		añadir.setOnAction(this::botonAñadir);
		
		
		
		
	}
	
	public void cargarServiciosTabla() {
		Manager manager = new Manager();
		manager.setup();
		List<Servicio> serli = manager.findAllServicios();
		//Creamos una lista observable donde se guardaran todos los objetos servcios.
		ObservableList<Servicio> listaServicios = FXCollections.observableArrayList(serli);
		
		
		//se envia a la celda el parametro a mostar
		columnaId.setCellValueFactory(new PropertyValueFactory<Servicio, String>("id"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombre"));
		columnaTipo.setCellValueFactory(new PropertyValueFactory<Servicio, String>("tipo"));
		columnaPrioridad.setCellValueFactory(new PropertyValueFactory<Servicio, String>("prioridad"));
		columnaObservaciones.setCellValueFactory(new PropertyValueFactory<Servicio, String>("observaciones"));
		
		
		//Añadimos los servicos a la tabla.
		tabla.setItems(listaServicios);
		
	}
	
	
	
	
	public void botonAñadir(ActionEvent event) {
		
		
		
		Servicio servicio = new Servicio();
		
		servicio.setId(Integer.parseInt(id.getText()));
		servicio.setNombre(nombre.getText());
		servicio.setTipo(tipos.getValue());
		servicio.setPrioridad(Integer.parseInt(prioridad.getText()));
		servicio.setObservaciones(observaciones.getText());
		
		Manager manager = new Manager();
		manager.setup();
		manager.create(servicio);
		
		cargarServiciosTabla();
		
		
		
		
		
		
	}
	
	public void botonBorrar() {
		
		
		
	}

}

