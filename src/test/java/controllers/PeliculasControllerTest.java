package controllers;

import dtos.MostrarPeliculaDTO;
import dtos.MostrarRecaudacionDTO;
import dtos.PeliculaDTO;
import models.Pelicula;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeliculasControllerTest {
    private PeliculasController controller;
    private PeliculaDTO peliculaDTO;

    @BeforeEach
    void setUp() {
        controller = PeliculasController.getInstancia();
    }

    @Test
    public void getPeliculasByGeneroSiExiste() {
        List<MostrarPeliculaDTO> dramas = controller.getPeliculasByGenero("Drama");
        assertFalse(dramas.isEmpty(), "Debe encontrar películas de género Drama");
        assertEquals("Drama", controller.obtenerPelicula(dramas.get(0).getNombrePelicula()).getGeneroID().toString());
    }

    @Test
    public void getPeliculasByGeneroSiNoExiste() {
        List<MostrarPeliculaDTO> inexistente = controller.getPeliculasByGenero("CienciaFiccion");
        assertTrue(inexistente.isEmpty(), "No debe encontrar películas de un género inexistente");
    }

    @Test
    public void obtenerPeliculaSiExiste() {
        var pelicula = controller.obtenerPelicula("Pelicula1");
        assertNotNull(pelicula);
        assertEquals("Pelicula1", pelicula.getNombrePelicula());
    }

    @Test
    public void obtenerPeliculaSiNoExiste() {
        var pelicula = controller.obtenerPelicula("Película Inexistente");
        assertNull(pelicula, "Debe devolver null si no existe la película");
    }

    @Test
    public void getPeliculasConMayorRecaudacion() {
        List<MostrarRecaudacionDTO> top = controller.getPeliculasConMayorRecaudacion();
        assertNotNull(top);
        assertFalse(top.isEmpty(), "Debe haber al menos una película con recaudación (aunque sea 0)");
        assertTrue(top.size() <= 10, "No deben devolverse más de 10 películas");
        // Deben estar ordenadas
        for (int i = 0; i < top.size() - 1; i++) {
            assertTrue(top.get(i).getTotalRecaudacion() >= top.get(i + 1).getTotalRecaudacion(),
                    "Las películas deben estar ordenadas por recaudación descendente");
        }
    }

    @Test
    void registrarPelicula() throws Exception {
        int cantidadInicial = controller.getPeliculas().size();

        controller.registrarPelicula(peliculaDTO);

        List<Pelicula> peliculas = controller.getPeliculas();
        assertEquals(cantidadInicial + 1, peliculas.size());

        Pelicula pelicula = peliculas.get(peliculas.size() - 1);
        assertEquals("Seven", pelicula.getNombrePelicula());
        assertEquals(156, pelicula.getDuracionEnMinutos());
        assertEquals("David Fincher", pelicula.getDirector());
        assertEquals(TipoGenero.Suspenso, pelicula.getGeneroID());
        assertEquals(TipoProyeccion.DosD, pelicula.getTipo());
        assertNotEquals("Jonathan Demme", pelicula.getDirector());
        assertTrue(pelicula.getActores().contains("Brad Pitt"));
        assertFalse(pelicula.getActores().contains("Alicia Silverstone"));
        assertTrue(pelicula.getActores().contains("Morgan Freeman"));
        assertDoesNotThrow(() -> controller.getPeliculas());
    }


    @AfterEach
    void tearDown() {

    }
}