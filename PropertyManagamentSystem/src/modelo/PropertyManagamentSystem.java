package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class PropertyManagamentSystem<Administrador> {
	private ArrayList<Consumible> servicios;
	private ArrayList<Habitacion> habitaciones;
	private ModificadorDeArchivo modificadorArchivo;
	private ArrayList<Reserva> ConsultaReserva;
	private Administrador Admin;
	private ArrayList<Recepcionista> opcionesRecepcionista;
	private ArrayList<Empleado> opcionesEmpleado;
	private HashMap<String, ArrayList<String>> habitacionesOcupadas;
	
	
	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	
	public ArrayList<Consumible> getServicios(){
		return servicios;
	}
}
