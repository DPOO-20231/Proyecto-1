package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Facturacion {
	private Date fecha;
	private String concepto;
	private double precioTotal;
	private ArrayList<Consumible> serviciosConsumidos;
	private ArrayList<ArchivoHuesped> historialFacturacion;
}
