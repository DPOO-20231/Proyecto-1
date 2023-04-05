package modelo;

import java.util.ArrayList;

public class Cama {
    private String size;
    private Integer capacidad;
    private String uso;

    public Cama(String size, int capacidad, String uso) {
        this.size = size;
        this.capacidad = capacidad;
        this.uso = uso;
    }

    public String getSize() {
        return size;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public String getUso() {
        return uso;
    }

    public ArrayList<Object> getEspecificaciones(){
        ArrayList<Object> informacion = new ArrayList<Object>();
        informacion.add(getSize());
        informacion.add(getCapacidad());
        informacion.add(getUso());
        return informacion;
    }

}