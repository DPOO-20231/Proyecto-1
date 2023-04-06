package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Recepcionista extends Empleado{

	private ArrayList<ReservarHabitacion> reservas;
	
	public Recepcionista(String name, String id, String correo, String password, String rol,
			PropertyManagamentSystem pms) {
		super(name, id, correo, password, rol, pms);
		// TODO Auto-generated constructor stub
	}
	
	public String consultarHabitacion(String idHabitacion){
		ArrayList<Habitacion> habitaciones = super.PMS.getHabitaciones();
		String descripcion = "";
		for (Habitacion h:habitaciones) {
			
			if(h.getIdHabi().equals(idHabitacion)) {
				ArrayList<Object> infoHabi = h.getDescripcion();
				descripcion =   "-- Habitacion " + infoHabi.get(0) + " --" +
								"\n   - Tipo: " + infoHabi.get(3)+
								"\n   - Ubicacion: " + infoHabi.get(1)+
								"\n   - Capacidad: " + infoHabi.get(2)+
								"\n   - No. Camas: " + infoHabi.get(4)+
								"\n	  - Caracteristicas: ";
				List<ArrayList<Object>> listaCamas = (List<ArrayList<Object>>) infoHabi.get(6);
				for(ArrayList<Object> o : listaCamas) {
					descripcion += "\n	    Cama";
					for(Object i: o) {
						descripcion += "\n	      " + i;
					}
					
				}
								
				descripcion += "\n	    Atributos";
				List<Set<String>> listaElementos = (List<Set<String>>) infoHabi.get(5);
				for(Set<String> e: listaElementos) {
					descripcion += "\n	      ";
					for(String i: e) {
						descripcion += i + " ";
					}
				}
			}
		}
		return descripcion;
	}
	
	
	public String consultarReserva(String idHabitacion, Date fecha){
		String descripcion;
		Reserva rsv = null;
		ArrayList<Habitacion> habitaciones = super.PMS.getHabitaciones();
		for (Habitacion h: habitaciones) {
			if (h.getIdHabi().equals(idHabitacion)) {
				rsv = h.getReservaEspecifica(fecha);
				break;
			}
		}
		
		if (rsv != null) {
			descripcion = formatearInfoReserva(rsv, idHabitacion, fecha);
		}else {
			descripcion = "No hay reservas para la habitación " + idHabitacion + " en la fecha " + fecha;
		}
		return descripcion;
	}
	
	public String formatearInfoReserva(Reserva rsv, String IdHabitacion, Date fecha) {
		
		ArrayList<Object> infoReserva = rsv.getEspecificaciones();
		String descripcion =	"Reserva de la habitación " + IdHabitacion + "para la fecha: " + fecha +
								"\n		Fechas: " + infoReserva.get(0) + " hasta " + infoReserva.get(1);
		return descripcion;
	}
	
	
	public void crearReserva(Date inicio, Date fin, ArrayList<String> idHabitaciones, ArrayList<ArrayList<String>> huespeds, String documento, String correo, String numero, String IDGrupo) {
		ArrayList<Habitacion> habitaciones = super.PMS.getHabitaciones();
		ArrayList<Habitacion> habitacionesReservadas = new ArrayList<Habitacion>();
		ArrayList<Huesped> huespedsReserva = new ArrayList<Huesped>();
		for (String id: idHabitaciones) {
			for (Habitacion h: habitaciones) {
				if (id.equals(h.getIdHabi())){
					habitacionesReservadas.add(h);
					break;
				}
			}
		}
		
		for(ArrayList<String> infoHuesped: huespeds) {
			huespedsReserva.add(new Huesped(IDGrupo, infoHuesped.get(0), infoHuesped.get(1)));
		}
		
		reservas.add(new ReservarHabitacion(inicio, fin, habitacionesReservadas, huespedsReserva, documento, correo, numero));
		reservas.get(reservas.size() - 1).crearReserva();
	}
}
