package models;

import java.util.*;

public class Sucursal {
    private int sucursalID;

    private String denominacion;

    private String direccion;

    private List<Sala> salas;

    public Sucursal(int sucursalID, String denominacion, String direccion, List<Sala> sala) {
        this.denominacion = denominacion;
        this.direccion = direccion;
        this.sucursalID = sucursalID;
        this.salas = sala;
    }

    /**
     * @return
     */
    public int getSucursalID() {
        return sucursalID;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Sala> getSalas() {
        return salas;
    }
}