package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Facturacion {
    private Date fecha;
    private String concepto;
    private int precioTotal;
    private boolean grupal;
    private boolean pago;
    private String nombre;

    public Facturacion(Date fecha, String concepto, int preicoTotal, boolean grupal, boolean pago, String nombre) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.precioTotal = preicoTotal;
        this.grupal = grupal;
        this.pago = pago;
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public boolean isGrupal() {
        return grupal;
    }

    public boolean isPago() {
        return pago;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Object> getEspecificaciones(){
        ArrayList<Object> rta = new ArrayList<Object>();
        rta.add(getFecha());
        rta.add(getConcepto());
        rta.add(getPrecioTotal());
        rta.add(getNombre());
        return rta;
    }

}