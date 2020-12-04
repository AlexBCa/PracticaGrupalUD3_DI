package org.openjfx.ActividadGrupal_UD3_UI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Model.Manager;
import Model.Servicio;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
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
	private TableView<Servicio> tabla;
	
	@FXML
    private TableColumn<Servicio, String> columnaNombre;
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		tipos.setItems(list);
		cargarServiciosTabla();
		
		
		
	}
	
	public void cargarServiciosTabla() {
		Servicio e = new Servicio();
		e.setNombre("Alex");
		Manager manager = new Manager();
		manager.setup();
		List<Servicio> serli = manager.findAllServicios();
		//Creamos una lista observable donde se guardaran todos los objetos servcios.
		ObservableList<Servicio> listaServicios = FXCollections.observableArrayList(serli);
		
	
		
		
		//Columna nombre
		
		
		//se envia a la celda el parametro a mostar
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombre"));
		
		//Añadimos los servicos a la tabla.
		tabla.setItems(listaServicios);
		
	}

}