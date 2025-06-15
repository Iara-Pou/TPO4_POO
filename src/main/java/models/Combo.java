package models;

/**
 *
 */
public class Combo {

    private int comboID;
    private String descripcion;
    private float precio;

    public Combo(int comboID, String descripcion, float precio, CondicionesDescuento Contiene) {
        this.comboID = comboID;
        this.Contiene = Contiene;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Combo() {
    }

    public CondicionesDescuento Contiene;

    public float getPrecio() {
        return precio;
    }

    public int getComboID() {
        return comboID;
    }

}