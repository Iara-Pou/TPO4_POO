package models;

import java.util.*;

/**
 *
 */
public class Sucursal {
    public Sucursal(int sucursalID, String denominacion, String direccion, ArrayList<Sala> sala) {
        this.denominacion = denominacion;
        this.direccion = direccion;
        this.sucursalID = sucursalID;
        this.salas = sala;
    }

    /**
     *
     */
    private int sucursalID;

    /**
     *
     */
    private String denominacion;

    /**
     *
     */
    private String direccion;

    private ArrayList<Sala> salas;


    /**
     * @return
     */
    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }
}