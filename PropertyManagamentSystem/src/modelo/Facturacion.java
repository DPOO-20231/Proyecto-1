package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Facturacion {
	private LocalDate fecha;
	private String concepto;
	private int precio;
	private boolean grupal;
	private boolean pago;
	private String nombreHuesped;
	public Facturacion(LocalDate fecha, String concepto, int precio, boolean grupal, boolean pago, String nombreHuesped) {
		super();
		this.fecha = fecha;
		this.concepto = concepto;
		this.precio = precio;
		this.grupal = grupal;
		this.pago = pago;
		this.nombreHuesped = nombreHuesped;
	}
	
	
	

}
