package modelo;

import java.util.ArrayList;

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
	private Facturacion factura;
	private ArrayList<Huesped> huespeds;
	
}
