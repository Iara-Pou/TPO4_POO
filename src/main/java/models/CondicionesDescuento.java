package models;

import models.enums.TipoTarjeta;

import java.util.*;

public class CondicionesDescuento {
    public CondicionesDescuento(Date fchDesde, Date fchHasta, int diaSemana, float porcentaje, TipoTarjeta tipoTarjeta, List<TarjetaDescuento> TarjetaDescuento) {
        this.diaSemana = diaSemana;
        this.fchDesde = fchDesde;
        this.fchHasta = fchHasta;
        this.porcentaje = porcentaje;
        this.tipoTarjeta = tipoTarjeta;
        this.TarjetaDescuento = TarjetaDescuento;
    }

    public CondicionesDescuento() {
    }
    private Date fchDesde;
    private Date fchHasta;
    private int diaSemana;
    private float porcentaje;
    private TipoTarjeta tipoTarjeta;
    private List<TarjetaDescuento> TarjetaDescuento;

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFchDesde() {
        return fchDesde;
    }

    public Date getFchHasta() {
        return fchHasta;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public List<TarjetaDescuento> getTarjetaDescuento() {
        return TarjetaDescuento;
    }


    public float getDescuento() {
        float descuento = 0.0f;
        for (TarjetaDescuento tarjetaDescuento : getTarjetaDescuento()) {
            descuento += getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta());
        }
        descuento = descuento + porcentaje;
        return descuento;
    }


    public static float getDescuentoPorTarjeta(TipoTarjeta tipoTarjeta) {
        switch (tipoTarjeta) {
            case PAMI -> {
                return 0.25f;
            }
            case UADE, MovieClub -> {
                return 0.15f;
            }
            case LaNacion, Clarin365 -> {
                return 0.5f;
            }
            default -> {
                return 0.0f;
            }
        }
    }
}
