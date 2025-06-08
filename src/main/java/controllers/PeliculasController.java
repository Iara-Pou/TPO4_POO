package controllers;

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

}