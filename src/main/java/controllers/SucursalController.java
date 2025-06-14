package controllers;

import models.Sala;
import models.Sucursal;

import java.util.*;


/**
 *
 */
public class SucursalController {
    private List<Sucursal> sucursales;
    private static SucursalController instancia = null;
    private List<Sala> salas;

    public SucursalController() {
        sucursales = new ArrayList<>();
        salas = new ArrayList<Sala>();

        salas.add(new Sala(1,"Sala 1",20));
        sucursales.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", (ArrayList<Sala>) this.salas));
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

    /**
     * Obtiene una sala en base a una denominación
     * @param denominacion
     * @return
     */
    public Sala obtenerSala(String denominacion)
    {
        Sala sala = null;

        for(Sucursal currentSucursal : this.sucursales)
        {
            for(Sala currentSala: currentSucursal.getSalas()){
                if(currentSala.getDenominacion().equals(denominacion)) sala = currentSala;
            }
        }

        return sala;
    }

}