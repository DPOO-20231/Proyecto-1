package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelo.Admin;
import modelo.Consumible;
import modelo.Admin;
import modelo.Recepcionista;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Habitacion;
import modelo.Usuario;

public class PropertyManagamentSystem {
	private ArrayList<Consumible> servicios;
	private ArrayList<Habitacion> habitaciones;
	private ModificadorDeArchivo modificadorArchivo;
	private ArrayList<Reserva> ConsultaReserva;
	private ArrayList<Recepcionista> opcionesRecepcionista;
	private ArrayList<Empleado> opcionesEmpleado;
	private HashMap<String, ArrayList<String>> habitacionesOcupadas;
	private ArrayList<Usuario> usuarios;
	private Map<String, Empleado> empleados = new HashMap<String, Empleado>();


	
	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	
	public ArrayList<Consumible> getServicios(){
		return servicios;
	}
	


	public String VerifyLogin(String IDusuario, String Contraseña)
	{
		String rol="No encontrado";
		Empleado elempleado= null;
		for (int i =0; i< usuarios.size() && elempleado== null; i++)
		{
			if (usuarios.get(i).getId().equals(IDusuario))
				if (usuarios.get(i).getPassword().equals(Contraseña))
				elempleado = empleados.get(IDusuario);
				rol=elempleado.getrol();;
		}
		return rol;
	}
}
