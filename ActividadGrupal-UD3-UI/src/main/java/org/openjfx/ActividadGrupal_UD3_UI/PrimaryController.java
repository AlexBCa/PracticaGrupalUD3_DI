package org.openjfx.ActividadGrupal_UD3_UI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import Model.Manager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
    	Manager manager = new Manager();
        manager.setup();
        
        
        //manager.create(alum);
    	//manager.read(52);
    	//manager.update(alum);
    	
    	//manager.read(2);
    	//manager.delete(alum);
        /*
    	List<Servicios> todosAl = manager.findAllAlumnos();
        for(Alumno a: todosAl) {
        	System.out.println(a.getId());
        }
        */
     
        //No puede invocarse a Exit hasta que el programa finalice sino no permite realizarme más ejecuciones.
       // manager.exit();
        
        
    	
        //App.setRoot("secondary");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}
}
