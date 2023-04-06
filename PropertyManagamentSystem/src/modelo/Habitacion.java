package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Habitacion {
	private String idHabi;
	private String ubicacion;
	private int capacidad;
	private String tipo;
	private int numCamas;
	private HashMap<String,Integer> elementosDeCobro;
	private ArrayList<Cama> elementosAdicionales;
	private ArrayList<Reserva> reservas;
	private ArrayList<Tarifa> tarifas;
	private ArrayList<Cama> camas;
	private ArrayList<Facturacion> cuenta;
	private ArrayList<Huesped> huespeds;
	
	public Habitacion(String idHabi, String ubicacion, int capacidad, String tipo, int numCamas, HashMap<String, Integer> elementosDeCobro,
			 ArrayList<Tarifa> tarifas, ArrayList<Cama> camas) {
		this.idHabi = idHabi;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.numCamas = numCamas;
		this.camas = camas;
		this.elementosDeCobro = elementosDeCobro;
		this.elementosAdicionales = new ArrayList<Cama>();
		this.tarifas = tarifas;
		this.cuenta = new ArrayList<Facturacion>();
		this.huespeds = new ArrayList<Huesped>();
		this.reservas = new ArrayList<Reserva>();
	}

	public String getIdHabi() {
		return idHabi;
	}



	public String getUbicacion() {
		return ubicacion;
	}



	public int getCapacidad() {
		return capacidad;
	}



	public String getTipo() {
		return tipo;
	}



	public int getNumCamas() {
		return numCamas;
	}



	public Set<String> getElementosDeCobro() {
		return elementosDeCobro.keySet();
	}



	public void setIdHabi(String idHabi) {
		this.idHabi = idHabi;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public void setElementosDeCobro(HashMap<String, Integer> elementosDeCobro) {
		this.elementosDeCobro = elementosDeCobro;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void setTarifas(ArrayList<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public void setCamas(ArrayList<Cama> camas) {
		this.camas = camas;
	}

	public ArrayList<Object> getElementosAdicionales() {
		ArrayList<Object> rta = new ArrayList<>();
		for (Cama item:elementosAdicionales) {
			rta.add(item.getEspecificaciones());
		}
		return rta;
	}



	public ArrayList<Reserva> getReservas() {
		return reservas;
	}



	public ArrayList<Tarifa> getTarifas() {
		return tarifas;
	}



	public ArrayList<Object> getCamas() {
		ArrayList<Object> rta = new ArrayList<>();
		for (Cama item:camas) {
			rta.add(item.getEspecificaciones());
		}
		return rta;
	}



	public ArrayList<Facturacion> getCuenta() {
		return cuenta;
	}



	public ArrayList<Huesped> getHuespeds() {
		return huespeds;
	}



	public void setElementosAdicionales(ArrayList<Cama> elementosAdicionales) {
		this.elementosAdicionales = elementosAdicionales;
	}



	public void setReservas(Reserva reserva) {
		reservas.add(reserva);
	}
	
	
	
	public void cancelarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}



	public void setCuenta(ArrayList<Facturacion> cuenta) {
		this.cuenta = cuenta;
	}



	public void setHuespeds(ArrayList<Huesped> huespeds) {
		this.huespeds = huespeds;
	}
	
	public Reserva getReservaEspecifica(Date date) {
		for (Reserva item:reservas) {
			Date fechaI = item.getDateInicio();
			Date fechaF = item.getDateFin();
			if (date.after(fechaI) && date.before(fechaF)) {
				return item;
			}
		}
		return null;

	}

	public ArrayList<Object> getDescripcion() {
		ArrayList<Object> descripcion = new ArrayList<Object>();
		descripcion.add(getIdHabi());
		descripcion.add(getUbicacion());
		descripcion.add(getCapacidad());
		descripcion.add(getTipo());
		descripcion.add(getNumCamas());
		descripcion.add(getElementosDeCobro());
		descripcion.add(getCamas());
		return descripcion;
		
	}
	
	 
	public int getPrecioHabitacion(Date date) {
		ArrayList<Tarifa> tarifas = getTarifas();
		int indice = tarifas.indexOf(date);
		Tarifa tarifa = tarifas.get(indice);
		Collection<Integer> preciosC = elementosDeCobro.values();
		int precio= tarifa.getPrecio();
		for (Integer item:preciosC) {
			precio += item;
		}
		return precio;
		
	}
	
	public void agregarElementoAdicional(Cama cama) {
		if (verificarCapacidad() == false) {
			elementosAdicionales.add(cama);
		}
		else {
			System.out.println("No se pueden agregar mas camas, pues la capacidad ya esta en su limite");
		}
	}
	
	public boolean verificarCapacidad() {
		int capBase = 0;
		for (Cama item:camas) {
			capBase += item.getCapacidad();
		}
		boolean rta = false;
		if (!elementosAdicionales.isEmpty()) {
			for (Cama item:elementosAdicionales) {
				int cap = item.getCapacidad();
				capBase += cap;
			}
		}
		if (capBase <= capacidad) {
			rta = false;
		}
		else {
			rta = true;
		}
		return rta;
	}
	public void addFacturacion(Date fechaConsumo, String concepto, int precio, boolean grupal, boolean pago, String nombreHuesped) {
		cuenta.add(new Facturacion(fechaConsumo, concepto, precio, grupal, pago, nombreHuesped));
	}
}
