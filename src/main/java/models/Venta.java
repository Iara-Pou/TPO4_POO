package models;

import models.enums.TipoTarjeta;

import java.util.*;

public class Venta {

    private int ventaID;

    private Date fchVenta;

    private List<Combo> combos;

    private Funcion funcion;

    private TarjetaDescuento tarjetaDescuento;

    public Venta(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion) {
        this.ventaID = ventaID;
        this.combos = combos;
        this.funcion = funcion;
        this.fchVenta = fchVenta;
    }

    public float calcularMontoPorComboDeVenta() {
        float total = 0.0f;
        for (Combo combo : getListaComboID()) {
            total += (combo.getPrecio() - (combo.getPrecio() * CondicionesDescuento.getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta())));
        }
        return total;
    }

    public float calcularMontoDeLaVentaPorFuncionCombos() {
        return funcion.calcularMontoPorEntradaDeLaPelicula() + calcularMontoPorComboDeVenta();
    }

    public int getVentaID() {
        return ventaID;
    }

    public Date getFchVenta() {
        return fchVenta;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }

    public UUID getFuncionID() {
        return funcion.getFuncionID();
    }

    public float getTotal() {
        return 0.0f;
    }

    public int getPeliculaID() {
        return 0;
    }

    public TipoTarjeta getTipoTarjeta() {
        return null;
    }

    public List<Combo> getListaComboID() {
        return combos;
    }
}
