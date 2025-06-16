package controllers;

import models.CondicionesDescuento;
import models.TarjetaDescuento;
import models.enums.TipoTarjeta;

import java.util.*;

public class DescuentoController {
    private List<CondicionesDescuento> descuentos;
    private static DescuentoController instancia = null;

    private DescuentoController() {
        descuentos = new ArrayList<>();
        CondicionesDescuento CondicionesDescuento = new CondicionesDescuento(new Date(), new Date(), 5, 50, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuento>());
        descuentos.add(CondicionesDescuento);
    }

    public static synchronized DescuentoController getInstancia() {
        if (instancia == null) {
            instancia = new DescuentoController();
        }
        return instancia;
    }

    public void ABM() {
    }

}