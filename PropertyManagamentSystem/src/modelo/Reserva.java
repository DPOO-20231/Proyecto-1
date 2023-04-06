package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Date;

public class Reserva {
	private Date dateInicio;
	private Date dateFin;
	private double precioTotal;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Huesped> huespeds;
	private ArrayList<Facturacion> cuenta;
	private String documento;
	private String correo;
	private String numero;

	public Reserva(Date dateInicio, Date dateFin, ArrayList<Habitacion> habitaciones, ArrayList<Huesped> huespeds,
			String documento, String correo, String numero) {
		this.dateInicio = dateInicio;
		this.dateFin = dateFin;
		this.habitaciones = habitaciones;
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



	public ArrayList<Object> getHabitacion() {
		ArrayList<Object> rta = new ArrayList<Object>();
		for (Habitacion item:habitaciones) {
			rta.add(item.getDescripcion());
		}
		return rta;
	}
	
	public ArrayList<Huesped> getListaHuespedes(){
		return huespeds;
	}


	public ArrayList<Object> getHuespeds() {
		ArrayList<Object> rta = new ArrayList<Object>();
		for (Huesped item:huespeds) {
			rta.add(item.getEspecificaciones());
		}
		return rta;
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

	public ArrayList<Object> getEspecificaciones(){
		ArrayList<Object> especificaciones = new ArrayList<Object>();
		especificaciones.add(getDateInicio());
		especificaciones.add(getDateFin());
		especificaciones.add(getPrecioTotal());
		especificaciones.add(getHuespeds());
		especificaciones.add(getCuenta());
		especificaciones.add(getDocumento());
		especificaciones.add(getCorreo());
		especificaciones.add(getNumero());
		
		return especificaciones;
		
	}

	public void setPrecioTotal(File archivo) throws IOException {
		FileWriter fw = new FileWriter(archivo);
		String factura = "";
		for (Habitacion item:habitaciones) {
			ArrayList<Tarifa> tarifas = item.getTarifas();
			int indice = tarifas.indexOf(dateInicio);
			Tarifa tarifa = tarifas.get(indice);
			Date inicio = tarifa.getDateInicio();
			Date fin = tarifa.getDateFin();
			if (inicio.before(dateFin) && dateFin.before(fin)) {
				int precio= tarifa.getPrecio();
				long duracion = (dateFin.getTime() - dateInicio.getTime())/1000*60*60*24;
				int precioHabitacion = (int) (duracion * precio);
				precioTotal = precioHabitacion;
				factura = duracion+","+precioTotal;
				fw.write(factura);
			}
			else {
				int precio= tarifa.getPrecio();
				long duracion = (tarifa.getDateFin().getTime() - dateInicio.getTime())/1000*60*60*24;
				int precioHabitacion = (int) (duracion * precio);
				Tarifa tarifa2 = tarifas.get(indice+1);
				int precio2= tarifa2.getPrecio();
				long duracion2 = (dateFin.getTime() - tarifa.getDateFin().getTime())/1000*60*60*24;
				int precioHabitacion2 = (int) (duracion2 * precio2);
				precioTotal = precioHabitacion + precioHabitacion2;
				factura = duracion+","+precioHabitacion+";"+duracion2+","+precioHabitacion2;
				fw.write(factura);
			}
		}
		
		String texto = "";
		for (Facturacion item:cuenta) {
			if (!item.isPago()) {
				int precio = (int) item.getPrecioTotal();
				precioTotal += precio;
				texto = item.getFecha()+","+item.getConcepto()+","+item.getPrecioTotal()+","+item.getNombre();
				fw.write(texto);
			}
			
			fw.close();
			
		}
		
	}
	
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}



	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}



	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
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
	
	
}