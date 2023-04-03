package modelo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalTime;

public class Restaurante extends Consumible {
	private ArrayList<Producto> menu;
	private ArrayList<Producto> pedidoEnCurso;
	private LectorArchivos lector;
	private ModificadorDeArchivo modificadorArchivo;
	
//	public static void main(String[] args) throws IOException, ParseException {
//	    Restaurante restaurante = new Restaurante("id-restaurante");
//	    restaurante.cargarMenu();
//	    restaurante.addProducto("colorado", "perro asado", 2399999, false, LocalTime.parse("12:00"), LocalTime.parse("13:00"));
//	    restaurante.consultarMenu();
//	    restaurante.consultarMenu(true);
//	}
	
	public Restaurante(String id) {
		super(0, id);
		lector = new LectorArchivos();
		modificadorArchivo = new ModificadorDeArchivo();
		menu = new ArrayList<Producto>();
		pedidoEnCurso = new ArrayList<Producto>();
	}
	
	public void cargarMenu() throws IOException, ParseException {
		ArrayList<String> info = lector.leerArchivo("menuRestaurante.txt");
		for(String linea : info) {
			String[] producto = linea.split(";");
			int precio = Integer.parseInt(producto[2]);
			String[] horas = producto[4].split(" - ");
			LocalTime[] disponibilidad = new LocalTime[2];
			boolean habitacion = Boolean.parseBoolean(producto[3]);
			disponibilidad[0] = LocalTime.parse(horas[0]);
			disponibilidad[1] = LocalTime.parse(horas[1]);
			addProducto(producto[0], producto[1], precio, habitacion, disponibilidad[0], disponibilidad[1], false);
		
		}
	}
	
	

	public void cargarMenu(String nombreArchivo) throws IOException, ParseException {
		if (nombreArchivo != "menuRestaurante.txt"){				
			ArrayList<String> info = lector.leerArchivo(nombreArchivo);
			for(String linea : info) {
				String[] producto = linea.split(";");
				int precio = Integer.parseInt(producto[2]);
				String[] horas = producto[4].split(" - ");
				LocalTime[] disponibilidad = new LocalTime[2];
				boolean habitacion = Boolean.parseBoolean(producto[3]);
				disponibilidad[0] = LocalTime.parse(horas[0]);
				disponibilidad[1] = LocalTime.parse(horas[1]);
				addProducto(producto[0], producto[1], precio, habitacion, disponibilidad[0], disponibilidad[1]);
			}
		}
		else {
			System.out.println("El archivo menuRestaurante.txt ya está cargado");
		}
	}
	
	public ArrayList<String> consultarMenu() {
		LocalTime ahora = LocalTime.now();
		ArrayList<String> menuDisponible = new ArrayList<String>();
		
		for(Producto p: menu) {
			if(ahora.isAfter(p.getInicioDisponible()) && ahora.isBefore(p.getFinDisponible())) {
				String productoDisponible = p.getNombre() + " $" + p.getPrecio();
				if(p.getDisponibleHabitacion()) {					
					productoDisponible += " (Disponible Habitación)";
				}
				else{
					productoDisponible += " (No Disponible Habitación)";
				}
				
				productoDisponible += "\n    " + p.getDescripcion();
				menuDisponible.add(productoDisponible);
				System.out.println(productoDisponible);
			}			
		}
		return menuDisponible;
	}
	
	public ArrayList<String> consultarMenu(boolean disponibleHabitacion) {
		LocalTime ahora = LocalTime.now();
		ArrayList<String> menuDisponible = new ArrayList<String>();
		
		for(Producto p: menu) {
			if(ahora.isAfter(p.getInicioDisponible()) && ahora.isBefore(p.getFinDisponible()) && (p.getDisponibleHabitacion() == disponibleHabitacion || !disponibleHabitacion)) {
				String productoDisponible = p.getNombre() + " $" + p.getPrecio();
				
				productoDisponible += "\n    " + p.getDescripcion();
				menuDisponible.add(productoDisponible);
				System.out.println(productoDisponible);
			}			
		}
		return menuDisponible;
	}
	
	
	public void addProducto(String nombre, String descripcion, int precio, boolean disponibleHabitacion, LocalTime horaInicio,
			LocalTime horaFin, boolean b) {
		menu.add(new Producto(nombre, descripcion, precio, disponibleHabitacion, horaInicio, horaFin));
		System.out.println(nombre);
	}
	
	public void addProducto(String nombre, String descripcion, int precio, boolean disponibleHabitacion, LocalTime horaInicio, LocalTime horaFin) {
		menu.add(new Producto(nombre, descripcion, precio, disponibleHabitacion, horaInicio, horaFin));
		String info = nombre+";"+descripcion+";"+precio+";"+disponibleHabitacion+";"+horaInicio+" - "+horaFin+"\n";
		//modificadorArchivo.modificarArchivo("menuRestaurante.txt", info);
		System.out.println(info);
	}
	
	public void addAlPedido(String producto) {
		for(Producto p: menu) {
			if (producto == p.getNombre()) {
				pedidoEnCurso.add(p);
				break;
			}
		}
		
	}
	//TODO: Hacer que finalizar pedido tambien realize el registro del consumo.
	public void finalizarPedido(){
		for(Producto p: pedidoEnCurso) {
			int precioActual = getPrecioTotal();
			int precioProducto = p.getPrecio();
			setPrecioTotal(precioActual + precioProducto);
		}
		
	}
	
	
	
}
