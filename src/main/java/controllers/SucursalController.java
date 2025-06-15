package controllers;

import models.Sala;
import models.Sucursal;

import java.util.*;


/**
 *
 */
public class SucursalController {
    private static SucursalController instancia = null;
    private List<Sucursal> sucursales;
    private List<Sala> salas;

    public SucursalController() {
        sucursales = new ArrayList<>();
        salas = new ArrayList<>();
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
        for (Sucursal sucursal : sucursales){
            if (sucursal.getSucursalID() == id) throw new RuntimeException("ERROR EN CREACIÓN. El ID de sucursal no debe repetirse.");
        }

        Sucursal sucursal = new Sucursal(id, denom, dir, new ArrayList<>());
        sucursales.add(sucursal);
    }

    /**
     * @param idSucursal
     * @param salaID
     * @param denom
     * @param nroasientos
     */
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        Sala sala = new Sala(salaID, denom, nroasientos);
        for (Sucursal sucursal : sucursales){
            if (sucursal.getSucursalID() == idSucursal){
                sucursal.getSalas().add(sala);
                salas.add(sala);
            }
        }
    }

    /**
     * Obtiene una sala en base a una denominación
     * @param denominacion
     * @return
     */
    public Sala obtenerSala(String denominacion){
        Sala sala = null;

        for(Sucursal currentSucursal : this.sucursales){
            for(Sala currentSala: currentSucursal.getSalas()){
                if(currentSala.getDenominacion().equals(denominacion)) sala = currentSala;
            }
        }

        return sala;
    }

}