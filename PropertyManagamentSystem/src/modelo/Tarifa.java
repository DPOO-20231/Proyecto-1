package modelo;

import java.util.Date;

public class Tarifa {
    private int precio;
    private Date dateInicio;
    private Date dateFin;
    private String IdProducto;

    public  Tarifa(int precio, Date dateInicio, Date dateFin, String IdProducto) {
        this.precio = precio;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
        this.IdProducto = IdProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public Date getDateInicio() {
        return dateInicio;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getIdProducto() {
        return IdProducto;
    }

}