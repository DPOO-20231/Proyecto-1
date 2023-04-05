package modelo;

import java.util.ArrayList;

public class Huesped {
    private String idGrupo;
    private String nombre;
    private String documento;

    public Huesped(String idGrupo, String nombre, String documento) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public ArrayList<Object> getEspecificaciones(){
        ArrayList<Object> rta = new ArrayList<Object>();
        rta.add(getIdGrupo());
        rta.add(getNombre());
        rta.add(getDocumento());
        return rta;
    }

}