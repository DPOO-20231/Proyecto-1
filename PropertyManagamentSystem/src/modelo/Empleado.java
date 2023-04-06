package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Empleado extends Usuario{	
	private String rol;
	private static ArrayList<Habitacion> habitacionesHotel;
	
	public Empleado(String name, String id, String correo, String password, String rol, PropertyManagamentSystem pms) {
		super(name, id, correo, password, rol, pms);
	}
	public String getrol() {
		return rol;
	}
	public void setHabitacionesHotel(ArrayList<Habitacion> habitaciones) {
		habitacionesHotel = habitaciones;
	}
	
	public void registrarConsumo(String idConsumo, String idHabitacion, boolean pago) {
		ArrayList<Habitacion> habitaciones = super.PMS.getHabitaciones();
		ArrayList<Consumible> servicios = super.PMS.getServicios();
		int precio = 0;
		String concepto = "";
		
		for (Consumible c: servicios) {
			if (c.getID().equals(idConsumo)) {
				precio = c.getPrecioTotal();
				concepto = c.getConcepto();
			}
		}
		Date fechaConsumo = new Date();
		
		for (Habitacion h: habitaciones) {
			if (h.getIdHabi().equals(idHabitacion)) {
				h.addFacturacion(fechaConsumo, concepto, precio, true, pago, "Grupal");
				break;
			}
		}
		
	}
	
	public void registrarConsumo(String idConsumo, String idHabitacion, boolean pago, String nombre) {
		ArrayList<Habitacion> habitaciones = super.PMS.getHabitaciones();
		ArrayList<Consumible> servicios = super.PMS.getServicios();
		int precio = 0;
		String concepto = "";
		
		for (Consumible c: servicios) {
			if (c.getID().equals(idConsumo)) {
				precio = c.getPrecioTotal();
				concepto = c.getConcepto();
			}
		}
		Date fechaConsumo = new Date();
		
		for (Habitacion h: habitaciones) {
			if (h.getIdHabi().equals(idHabitacion)) {
				h.addFacturacion(fechaConsumo, concepto, precio, false, pago, nombre);
				break;
			}
		}
		
	}
	
	
	
}
