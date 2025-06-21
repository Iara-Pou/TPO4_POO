package models;

public class Sala {

    private int salaID;

    private String denominacion;

    private int asientos;

    public Sala(int salaID, String denominacion, int asientos) {
        this.asientos = asientos;
        this.denominacion = denominacion;
        this.salaID = salaID;
    }

    public int getSucursalID() {
        return 0;
    }

    public int getSalaID() {
        return 0;
    }

    public int getAsientos() {
        return asientos;
    }

    public String getDenominacion() {
        return denominacion;
    }
}