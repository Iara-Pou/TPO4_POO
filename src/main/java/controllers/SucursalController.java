package controllers;

import models.Sucursal;

import java.util.*;


/**
 *
 */
public class SucursalController {
    private List<Sucursal> sucursales;
    private static SucursalController instancia = null;

    public SucursalController() {
        sucursales = new ArrayList<>();
        sucursales.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", null));
    }

    public static synchronized SucursalController getInstancia() {
        if (instancia == null) {
            instancia = new SucursalController();
        }
        return instancia;
    }

    /**
     * @param id
     * @param denom
     * @param dir
     */
    public void agregarSucursal(int id, String denom, String dir) {
        // TODO implement here
    }

    /**
     * @param idSucursal
     * @param salaID
     * @param denom
     * @param nroasientos
     */
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        // TODO implement here
    }

}