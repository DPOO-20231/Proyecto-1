package modelo;

import java.util.ArrayList;
import java.util.Date;

public class ReservarHabitacion {
	private Date dateInicio;
	private Date dateFin;
	private int precioTotal;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Huesped> huespeds;
	private ArrayList<Facturacion> cuenta;
	private String documento;
	private String correo;
	private String numero;
	
	public ReservarHabitacion(Date dateInicio, Date dateFin, ArrayList<Habitacion> habitacion, ArrayList<Huesped> huespeds,
			String documento, String correo, String numero) {
		this.dateInicio = dateInicio;
		this.dateFin = dateFin;
		this.habitaciones = habitacion;
		this.huespeds = huespeds;
		this.documento = documento;
		this.correo = correo;
		this.numero = numero;
	}

	

	public Date getDateInicio() {
		return dateInicio;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public double getPrecioTotal() {
		return precioTotal;
	}



	public ArrayList<Habitacion> getHabitacion() {
		return habitaciones;
	}



	public ArrayList<Huesped> getHuespeds() {
		return huespeds;
	}



	public ArrayList<Facturacion> getCuenta() {
		return cuenta;
	}



	public String getDocumento() {
		return documento;
	}



	public String getCorreo() {
		return correo;
	}



	public String getNumero() {
		return numero;
	}



	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}



	public void setHabitacion(Habitacion habitacion) {
		habitaciones.add(habitacion);
	}



	public void setHuespeds(ArrayList<Huesped> huespeds) {
		this.huespeds = huespeds;
	}



	public void setCuenta(ArrayList<Facturacion> cuenta) {
		this.cuenta = cuenta;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public ArrayList<Object> ConsultarReserva(Reserva reserva) {
		int res = habitaciones.get(0).getReservas().indexOf(reserva);
		Reserva reser = habitaciones.get(0).getReservas().get(res);
		ArrayList<Object> informacion = reser.getEspecificaciones();
		return informacion;
		
	}
	
	public void crearReserva() {
		
		Reserva reserva = new Reserva(dateInicio, dateFin, habitaciones, huespeds, documento, correo, numero);
		for (Habitacion item:habitaciones) {
			item.setReservas(reserva);
		}	
		
	}
	
	public void cancelarReserva(Reserva reserva) {
		Date hoy = new Date();
		long horas = 172000000;	
		long duracion = hoy.getTime();
		long res = reserva.getDateInicio().getTime();
		long cancelar = (res - horas);
		if (duracion < cancelar) {
			for (Habitacion item:habitaciones) {
				item.cancelarReserva(reserva);
			}
		}
		else {
			System.out.println("Ya se supero el limite de 48 horas para poder cancelar la reserva");
		}
	}
	
}