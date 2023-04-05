package modelo;

public class Recepcionista extends Empleado{
	private String puntoAtencion;
	private PropertyManagamentSystem subirInformacion;
	private ReservarHabitacion reservar;
	
	public Recepcionista(String name, String id, String correo, String password, String rol, PropertyManagamentSystem pms) {
		super(name, id, correo, password, rol, pms);
		// TODO Auto-generated constructor stub
	}
}
