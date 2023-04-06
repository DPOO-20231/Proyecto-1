package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelo.Administrador;
import modelo.Consumible;
import modelo.Administrador;
import modelo.Recepcionista;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Habitacion;
import modelo.Usuario;
import modelo.Loader;

public class PropertyManagamentSystem {
	private ArrayList<Consumible> servicios;
	private ArrayList<Habitacion> habitaciones;
	private ModificadorDeArchivo modificadorArchivo;
	private ArrayList<Reserva> ConsultaReserva;
	private ArrayList<Producto> productos;
	private ArrayList<Recepcionista> opcionesRecepcionista;
	private ArrayList<Empleado> opcionesEmpleado;
	private HashMap<String, ArrayList<String>> habitacionesOcupadas;
	private ArrayList<Usuario> usuarios;
	private Map<String, Empleado> empleados;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public PropertyManagamentSystem()
	{
		try {
			ArrayList<Object> DataC = Loader.cargarData(this);
			this.empleados = (Map<String, Empleado>) DataC.get(0);
			this.servicios = (ArrayList<Consumible>) DataC.get(1);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	
	public ArrayList<Consumible> getServicios(){
		return servicios;
	}
	
	public void cargarHabitaciones(ArrayList<Habitacion> habitaciones, String Namefile)
	{
		
	}
	public void crearservicio()
	{
		Administrador Admin=null;
		Admin.crearservicio(productos);
	}

	public void Modificaservicio()
	{
		Administrador Admin=null;
		Admin.modificarServicio(productos);
	}
	public void consultaservicio()
	{
		Administrador Admin=null;
	}
	public void crearHabi(String NameFile)
	{
		Administrador Admin=null;
		Admin.cargarHabitaciones_txt(habitaciones, NameFile);
	}
	public void ModifyHabi()
	{
		Administrador Admin=null;
		Admin.modificarHabitacion(habitaciones);
	}


	public String VerifyLogin(String IDusuario, String Contraseña)
	{
		String rol="No encontrado";
		Empleado elempleado= null;
			
		elempleado = empleados.get(IDusuario);
		if (elempleado == null)
		{
			rol = "ID erroneo";
		}
		else 
		{
			if (elempleado.getPassword().equals(Contraseña)){
			rol=elempleado.getrol();;
			}
			else {
				rol = "contraseña erronea";

		}
		}
		return rol;
	}

}
