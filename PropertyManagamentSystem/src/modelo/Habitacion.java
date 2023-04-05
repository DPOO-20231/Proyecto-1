package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Habitacion {
	private String idHabi;
	private String ubicacion;
	private int capacidad;
	private String tipo;
	private int numCamas;
	private ArrayList<String> elementosDeCobro;
	private ArrayList<String> elementosAdicionales;
	private ArrayList<Reserva> reservas;
	private ArrayList<Tarifa> tarifas;
	private ArrayList<Cama> camas;
	private ArrayList<Facturacion> cuenta;
	private ArrayList<Huesped> huespeds;
	
	public Habitacion() {
		cuenta = new ArrayList<Facturacion>();
	}
	
	public String getidHabit() {
		return idHabi;
	}
	
	public void addFacturacion(LocalDate fechaConsumo, String concepto, int precio, boolean grupal, boolean pago, String nombreHuesped) {
		cuenta.add(new Facturacion(fechaConsumo, concepto, precio, grupal, pago, nombreHuesped));
	}
}
