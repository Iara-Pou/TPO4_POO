package models;

public class Entrada {
    private float precio;

    private int nroAsiento;

    public Funcion funcion;

    public Entrada(int nroAsiento, Funcion funcion, float precio) {
        this.funcion = funcion;
        this.nroAsiento = nroAsiento;
        this.precio = precio;
    }

    public Entrada() {
    }

    public float getPrecio() {
        return precio;
    }

    public int getFuncionID() {
        return 0;
    }

    public void getPeliculaID() {
    }
}
