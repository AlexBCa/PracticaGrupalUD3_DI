package org.openjfx.ActividadGrupal_UD3_UI;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Manager;
import Model.Servicio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


public class EdicionController implements Initializable {
	
	@FXML
	private ComboBox<String> tipos;
	
	@FXML
	private TextField nombre;
	@FXML
	private TextField prioridad;
	@FXML
	private TextArea observaciones;
	@FXML
	private Button guardar;
	
	private Manager manager;
	
	private Servicio service;
	
	public void initData(Servicio service) {
		this.service = service;
		nombre.setText(service.getNombre());
		prioridad.setText(String.valueOf(service.getPrioridad()));
		observaciones.setText(service.getObservaciones());
		tipos.getSelectionModel().select(service.getTipo());
	}
	
	public void alerta(String nombre, Alert.AlertType alert) {
		Alert alerta = new Alert(alert, nombre);
		
		alerta.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//¨Cargamos el desplegable
		tipos.setItems(PrincipalController.TIPOS);
		manager = new Manager();
		manager.setup();
		// Evento del boton guardar
		guardar.setOnMouseClicked(event -> {
			// Comprobamos que todos los campos esten informados
			if(nombre.getText().isEmpty()
					||prioridad.getText().isEmpty() || observaciones.getText().isEmpty()) {
				alerta("Rellena todos los campos", AlertType.WARNING);
			} else {
				// Actualizamos el objeto original service con la nueva informacion
				service.setNombre(nombre.getText());
				service.setObservaciones(observaciones.getText());
				service.setPrioridad(Integer.parseInt(prioridad.getText()));
				service.setTipo(tipos.getSelectionModel().getSelectedItem());
				// Realizamos el guardado en base de datos
				manager.update(service);
				
				// Lanzamos el cerrado de la ventana de edicion y lanzamos el evento para poder refrescar la tabla
				Window window = guardar.getScene().getWindow();
				window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
			}
		});
		
	}

}

