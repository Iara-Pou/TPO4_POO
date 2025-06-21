package controllers;

import models.Sala;
import models.Sucursal;

import java.util.*;

public class SucursalController {
    private static SucursalController instancia = null;
    private List<Sucursal> sucursales;
    private List<Sala> salas;

    public SucursalController() {
        sucursales = new ArrayList<>();
        salas = new ArrayList<>();

        salas.add(new Sala(1, "Sala 1", 20));
        sucursales.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", (ArrayList<Sala>) this.salas));
    }

    public static synchronized SucursalController getInstancia() {
        if (instancia == null) {
            instancia = new SucursalController();
        }
        return instancia;
    }

    public void agregarSucursal(int id, String denominacion, String dir) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getSucursalID() == id)
                throw new RuntimeException("ERROR EN CREACIÓN. El ID de sucursal no debe repetirse.");
        }

        Sucursal sucursal = new Sucursal(id, denominacion, dir, new ArrayList<>());
        sucursales.add(sucursal);
    }

    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        Sala sala = new Sala(salaID, denom, nroasientos);
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getSucursalID() == idSucursal) {
                sucursal.getSalas().add(sala);
                salas.add(sala);
            }
        }
    }

    public Sala obtenerSala(String denominacion) {
        Sala sala = null;

        for (Sucursal currentSucursal : this.sucursales) {
            for (Sala currentSala : currentSucursal.getSalas()) {
                if (currentSala.getDenominacion().equals(denominacion)) sala = currentSala;
            }
        }
        return sala;
    }
}