package models;

import java.util.*;

/**
 *
 */
public class Funcion {
    public Funcion(Date fecha, UUID funcionID, String horario, List<Entrada> entradas, Sala sala, Pelicula pelicula) {
        this.entradas = entradas;
        this.fecha = fecha;
        this.funcionID = funcionID;
        this.horario = horario;
        this.sala = sala;
        this.pelicula = pelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    /*
     *
     *
     */
    private Pelicula pelicula;

    /**
     *
     */
    private UUID funcionID;

    /**
     *
     */
    private String horario;

    /**
     *
     */
    private Date fecha;

    public List<Entrada> getEntradas() {
        return entradas;
    }

    /**
     *
     */
    private List<Entrada> entradas;

    private Sala sala;


    /**
     * @return
     */
    public int getSalaID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getPeliculaID() {
        return getPelicula().getPeliculaID();
    }

    /**
     *
     */
    public int getCantidadAsientosDisponibles() {

        return 0;
        // TODO implement here
    }

    /**
     * @return
     */
    public UUID getFuncionID() {

        return this.funcionID;
    }

    /**
     *
     */
    public Date getFecha() {
        return fecha;
        // TODO implement here
    }

    public float calcularMontoPorEntradaDeLaPelicula() {
        float total = 0.0f;
        for (Entrada entrada : getEntradas()) {
            total = total + (entrada.getPrecio() -
                    (entrada.getPrecio() * pelicula.getCondicionesDescuento().getDescuento()));
        }
        return total;
    }

}