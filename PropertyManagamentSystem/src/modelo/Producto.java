package modelo;

import java.time.LocalTime;

public class Producto {
	private String nombre;
	private String descripcion;
	private boolean disponibleHabitacion;
	private int precio;
	private LocalTime inicioDisponible;
	private LocalTime finDisponible;
	
	public Producto(String nombre, String descripcion, int precio, boolean disponibleHabitacion,
			LocalTime inicioDisponible, LocalTime finDisponible) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.disponibleHabitacion = disponibleHabitacion;
		this.precio = precio;
		this.inicioDisponible = inicioDisponible;
		this.finDisponible = finDisponible;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean getDisponibleHabitacion(){
		return disponibleHabitacion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDisponibleHabitacion(boolean disponibleHabitacion) {
		this.disponibleHabitacion = disponibleHabitacion;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setInicioDisponible(LocalTime inicioDisponible) {
		this.inicioDisponible = inicioDisponible;
	}

	public void setFinDisponible(LocalTime finDisponible) {
		this.finDisponible = finDisponible;
	}

	public LocalTime getInicioDisponible() {
		return inicioDisponible;
	}
	
	public LocalTime getFinDisponible() {
		return finDisponible;
	}
	
}
