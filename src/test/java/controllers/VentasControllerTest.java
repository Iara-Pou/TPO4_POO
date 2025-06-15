package controllers;

import dtos.FuncionDTO;
import dtos.VentaDTO;
import models.*;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;
import models.enums.TipoTarjeta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VentasControllerTest {

    private static FuncionController funcionController;
    private static VentasController ventasController;
    private static SucursalController sucursalController;
    private static PeliculasController peliculasController;


    @BeforeAll
    static void setUp() throws Exception {
        funcionController = FuncionController.getInstancia();
        ventasController = VentasController.getInstancia();
        sucursalController = SucursalController.getInstancia();
        peliculasController = PeliculasController.getInstancia();

        // Crear sucursal, sala, película y función
        sucursalController.agregarSucursal(1, "Barracas", "Av Montes de Oca 1100");
        sucursalController.agregarSala(1,1, "Sala 1",20);
        peliculasController.agregarPelicula(new Pelicula(1, TipoGenero.Suspenso, "Pelicula1", 180, "Director X", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));

        FuncionDTO funcionDTO = new FuncionDTO("Sala 1", "20:20", "10/10/2000", "Pelicula1");
        funcionController.agregarFuncion(funcionDTO);
    }

    @Test
    void recaudacionPorPeliculaSiNoExiste() {
        //si la pelicula no existe, no tiene recaudacion
        float recaudacion = VentasController.getInstancia().recaudacionPorPelicula(999);
        assertEquals(0.0f, recaudacion);
    }

    @Test
    void funcionesVendidasPorGeneroSiNoExiste() {
        List<VentaDTO> result = VentasController.getInstancia().funcionesVendidasPorGenero(TipoGenero.Drama);
        assertTrue(result.isEmpty());
    }
}