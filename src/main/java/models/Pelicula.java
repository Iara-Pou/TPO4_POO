package models;

import dtos.MostrarRecaudacionDTO;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;

import java.util.*;

public class Pelicula {
    public Pelicula(int idPelicula, TipoGenero generoID, String nombrePelicula, int duracionEnMinutos, String director, TipoProyeccion tipo, List<String> actores, CondicionesDescuento descuento) {
        this.idPelicula = idPelicula;
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

    private int idPelicula;
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
        return idPelicula;
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