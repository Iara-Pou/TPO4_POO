package controllers;

import dtos.FuncionDTO;
import models.Funcion;
import models.Pelicula;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

class FuncionControllerTest {

    private static FuncionController funcionController;
    private static PeliculasController peliculasController;
    private static SucursalController sucursalController;

    @BeforeAll
    public static void setUp() throws Exception {
        funcionController = FuncionController.getInstancia();
        peliculasController = PeliculasController.getInstancia();
        sucursalController = SucursalController.getInstancia();

        //agregar funciones
        funcionController.agregarFuncion(new FuncionDTO("Sala 1", "20:20", "10/10/2000", "Pelicula1"));
        funcionController.agregarFuncion(new FuncionDTO("Sala 1", "20:20", "10/10/2000", "Pelicula4"));
    }

    @Test
    void buscarFuncionesPorPeliculaIDSiExiste() {
        List<Funcion> funciones = funcionController.buscarFuncionesPorPeliculaID(1);

        Assertions.assertEquals(1, funciones.size());
        Assertions.assertNotNull(funciones);
    }

    @Test
    void buscarFuncionesPorPeliculaIDSiNoExiste() {
        List<Funcion> funciones = funcionController.buscarFuncionesPorPeliculaID(100);

        Assertions.assertEquals(0, funciones.size());
    }

    @Test
    void buscarFuncionesPorGeneroSiExiste() {
        List<Funcion> funciones = funcionController.buscarFuncionesPorGenero(TipoGenero.Suspenso);

        Assertions.assertNotNull(funciones);
        Assertions.assertFalse(funciones.isEmpty());
    }

    @Test
    void buscarFuncionesPorGeneroSiNoExiste() {
        List<Funcion> funciones = funcionController.buscarFuncionesPorGenero(TipoGenero.Drama);

        Assertions.assertNotNull(funciones);
        Assertions.assertTrue(funciones.isEmpty());
    }

    @Test
    void agregarFuncion() {
        Assertions.assertDoesNotThrow(() -> {
            String id = funcionController.agregarFuncion(
                    new FuncionDTO("Sala 1", "22:00", "12/10/2000", "Pelicula3"));
            Assertions.assertNotNull(id);
        });
    }

    @Test
    void agregarFuncionSiSalaNoExiste() {
        Exception ex = Assertions.assertThrows(Exception.class, () -> {
            funcionController.agregarFuncion(
                    new FuncionDTO("Sala Inexistente", "22:00", "12/10/2000", "Pelicula2"));
        });

        Assertions.assertEquals("La sala especficada no existe o no está disponible", ex.getMessage());
    }

    @Test
    void agregarFuncionSiPeliculaNoExiste() {
        Exception ex = Assertions.assertThrows(Exception.class, () -> {
            funcionController.agregarFuncion(
                    new FuncionDTO("Sala 1", "22:00", "12/10/2000", "NoExiste"));
        });

        Assertions.assertEquals("La pelicula no fue encontrada", ex.getMessage());
    }
}