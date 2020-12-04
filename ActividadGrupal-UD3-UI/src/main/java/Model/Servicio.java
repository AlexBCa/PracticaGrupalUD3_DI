package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Servicios")
public class Servicio implements Serializable {
	
	private int id;
	private String nombre;
	private String tipo;
	private int prioridad;
	private String observaciones;
	
	public Servicio() {
		
	}

	public Servicio(int id, String nombre, String tipo, int prioridad, String observaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.prioridad = prioridad;
		this.observaciones = observaciones;
	}
	
	@Id
	@Column(name="Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
