package models;

import models.enums.TipoTarjeta;

/**
 *
 */
public class TarjetaDescuento {
    public TarjetaDescuento(int tarjetaID, TipoTarjeta tipoTarjeta, String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.tarjetaID = tarjetaID;
        this.tipoTarjeta = tipoTarjeta;
    }

    /**
     *
     */
    private int tarjetaID;

    /**
     *
     */
    private TipoTarjeta tipoTarjeta;

    /**
     *
     */
    private String numeroTarjeta;


    /**
     * @return
     */
    public TipoTarjeta getTipoTarjeta() {
        // TODO implement here
        return null;
    }


}