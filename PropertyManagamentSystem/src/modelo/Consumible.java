package modelo;

public abstract class Consumible {
	private int precioTotal;
	private String ID;
	
	public int getPrecioTotal() {
		return precioTotal;
	}

	public Consumible(int precioTotal, String iD) {
		super();
		this.precioTotal = precioTotal;
		ID = iD;
	}
	
	public void setPrecioTotal(int newPrecioTotal) {
		precioTotal = newPrecioTotal;
	}
	
	
}
