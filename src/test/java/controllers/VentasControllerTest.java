package controllers;

import dtos.VentaDTO;
import models.enums.TipoGenero;
import org.junit.jupiter.api.BeforeAll;
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
    }

    @Test
    void recaudacionPorPeliculaSiNoExiste() {
        float recaudacion = VentasController.getInstancia().recaudacionPorPelicula(999);
        assertEquals(0.0f, recaudacion);
    }

    @Test
    void funcionesVendidasPorGeneroSiNoExiste() {
        List<VentaDTO> result = VentasController.getInstancia().funcionesVendidasPorGenero(TipoGenero.Drama);
        assertTrue(result.isEmpty());
    }
}