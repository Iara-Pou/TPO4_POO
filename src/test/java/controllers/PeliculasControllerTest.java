package controllers;

import dtos.MostrarPeliculaDTO;
import dtos.MostrarRecaudacionDTO;
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

    @BeforeEach
    void setUp() {
        controller = PeliculasController.getInstancia();
        controller.agregarPelicula(new Pelicula(1, TipoGenero.Suspenso, "Pelicula1", 180, "Director X", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        controller.agregarPelicula(new Pelicula(2, TipoGenero.Drama, "Pelicula2", 190, "Director Y", TipoProyeccion.TresD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        controller.agregarPelicula(new Pelicula(3, TipoGenero.Terror, "Pelicula3", 165, "Director J", TipoProyeccion.TresDMax, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        controller.agregarPelicula(new Pelicula(4, TipoGenero.Biografica, "Pelicula4", 120, "Director K", TipoProyeccion.CuatroD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        controller.agregarPelicula(new Pelicula(5, TipoGenero.Drama, "Pelicula5", 95, "Director L", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));

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

    @AfterEach
    void tearDown() {

    }

}