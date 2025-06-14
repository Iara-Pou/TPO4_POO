package models;

import dtos.MostrarRecaudacionDTO;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;

import java.util.*;

public class Pelicula {
    public Pelicula(TipoGenero generoID, String nombrePelicula, int duracionEnMinutos, String director, TipoProyeccion tipo, List<String> actores, CondicionesDescuento descuento) {
        this.actores = actores;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.tipo = tipo;
        this.condicionesDescuento = descuento;
    }

    public TipoGenero getGeneroID() {
        return generoID;
    }

    public void setGeneroID(TipoGenero generoID) {
        this.generoID = generoID;
    }

    /**
     *
     */
    private TipoGenero generoID;

    /**
     *
     */
    private String nombrePelicula;

    /**
     *
     */
    private int duracionEnMinutos;

    /**
     *
     */
    private String director;

    /**
     *
     */
    private List<String> actores;

    /**
     *
     */
    private TipoProyeccion tipo;

    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }

    private CondicionesDescuento condicionesDescuento;


    /**
     *
     */
    public int getPeliculaID() {
        // TODO implement here
        return 0;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActores() {
        return actores;
    }

    public TipoProyeccion getTipo() {
        return tipo;
    }
}