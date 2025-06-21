package models;

public class Combo {

    private int comboID;
    private String descripcion;
    private float precio;

    public Combo(int comboID, String descripcion, float precio, CondicionesDescuento condicionesDescuento) {
        this.comboID = comboID;
        this.condicionesDescuento = condicionesDescuento;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Combo() {
    }

    public CondicionesDescuento condicionesDescuento;

    public float getPrecio() {
        return precio;
    }

    public int getComboID() {
        return comboID;
    }

}