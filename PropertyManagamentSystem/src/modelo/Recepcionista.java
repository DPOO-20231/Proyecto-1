package modelo;

public class Recepcionista extends Empleado{
	private String puntoAtencion;
	private PropertyManagamentSystem subirInformacion;
	private ReservarHabitacion reservar;
	
	public Recepcionista(String name, String id, String correo, String password, String contacto, String rol) {
		super(name, id, correo, password, contacto, rol);
		// TODO Auto-generated constructor stub
	}
}
