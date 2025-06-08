package controllers;

import dtos.MostrarPeliculaDTO;
import models.Pelicula;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;

import java.util.*;


/**
 *
 */

public class PeliculasController {
    private List<Pelicula> peliculas;
    private static PeliculasController instancia = null;

    private PeliculasController() {
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(TipoGenero.Suspenso, "Pelicula1", 180, "Director X", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
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

    public List<MostrarPeliculaDTO> getPeliculasByGenero(String genero){
        List<MostrarPeliculaDTO> listaPeliculas = new ArrayList<>();
        for (Pelicula pelicula: peliculas){
            if (pelicula.getGeneroID().toString().equals(genero)){
                listaPeliculas.add(toDto(pelicula));
            }
        }
        return listaPeliculas;
    }

    private MostrarPeliculaDTO toDto(Pelicula pelicula){
        return new MostrarPeliculaDTO(pelicula.getDirector(), pelicula.getDuracionEnMinutos(), pelicula.getNombrePelicula(), pelicula.getTipo().toString(), pelicula.getActores());
    }
}