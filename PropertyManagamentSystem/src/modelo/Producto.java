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
	
	public LocalTime getInicioDisponible() {
		return inicioDisponible;
	}
	
	public LocalTime getFinDisponible() {
		return finDisponible;
	}
	
}
