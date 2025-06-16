package models;

import models.enums.TipoTarjeta;

public class TarjetaDescuento {

    private int tarjetaID;

    private TipoTarjeta tipoTarjeta;

    private String numeroTarjeta;

    public TarjetaDescuento(int tarjetaID, TipoTarjeta tipoTarjeta, String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.tarjetaID = tarjetaID;
        this.tipoTarjeta = tipoTarjeta;
    }

    /**
     * @return
     */
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

}