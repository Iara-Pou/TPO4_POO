package controllers;

import dtos.MostrarPeliculaDTO;
import dtos.MostrarRecaudacionDTO;
import models.Pelicula;
import models.Venta;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;

import java.util.*;
import java.util.stream.Collectors;


/**
 *
 */

public class PeliculasController {
    private List<Pelicula> peliculas;
    private static PeliculasController instancia = null;

    private VentasController ventasController = VentasController.getInstancia();

    private PeliculasController() {
        peliculas = new ArrayList<>();
    }

    public static synchronized PeliculasController getInstancia() {
        if (instancia == null) {
            instancia = new PeliculasController();
        }
        return instancia;
    }

    /**
     *
     */
    public void ABM() {
        // TODO implement here
    }

    public List<MostrarPeliculaDTO> getPeliculasByGenero(String genero) {
        List<MostrarPeliculaDTO> listaPeliculas = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getGeneroID().toString().equals(genero)) {
                listaPeliculas.add(toDto(pelicula));
            }
        }
        return listaPeliculas;
    }

    private MostrarPeliculaDTO toDto(Pelicula pelicula) {
        return new MostrarPeliculaDTO(pelicula.getDirector(), pelicula.getDuracionEnMinutos(), pelicula.getNombrePelicula(), pelicula.getTipo().toString(), pelicula.getActores());
    }

    public Pelicula obtenerPelicula(String nombre) {
        Pelicula pelicula = null;

        for (Pelicula current : this.peliculas) {
            if (current.getNombrePelicula().equals(nombre)) pelicula = current;
        }

        return pelicula;
    }

    public List<MostrarRecaudacionDTO> getPeliculasConMayorRecaudacion() {
        List<MostrarRecaudacionDTO> peliculasConMayorRecaudacion = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {
            float recaudacionActual = ventasController.recaudacionPorPelicula(pelicula.getPeliculaID());
            MostrarRecaudacionDTO mostrarRecaudacionDTO = new MostrarRecaudacionDTO(toDto(pelicula), recaudacionActual);
            peliculasConMayorRecaudacion.add(mostrarRecaudacionDTO);
        }

        // Ordenar por recaudación descendente
        peliculasConMayorRecaudacion.sort((a, b) -> Float.compare(b.getTotalRecaudacion(), a.getTotalRecaudacion()));

        // Retornar solo las primeras 10 o menos si hay menos de 10
        if (peliculasConMayorRecaudacion.size() > 10){
            peliculasConMayorRecaudacion = peliculasConMayorRecaudacion.subList(0,10);
        }

        return peliculasConMayorRecaudacion;
    }

    public void agregarPelicula(Pelicula pelicula){
        if(obtenerPelicula(pelicula.getNombrePelicula()) == null) {
            peliculas.add(pelicula);
        }
    }

}