package modelo;

public abstract class Consumible {
	private int precioTotal;
	private String ID;
	private String concepto;

	public Consumible(int precioTotal, String iD, String concepto){
		this.precioTotal = precioTotal;
		this.concepto = concepto;
		ID = iD;
	}
	
	public String getID() {
		return ID;
	}

	public String getConcepto() {
		return concepto;
	}
	
	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
	
	
}
