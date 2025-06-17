package controllers;

import dtos.VentaDTO;
import models.Funcion;
import models.Venta;
import models.enums.TipoGenero;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VentasControllerTest {

    private static FuncionController funcionController;
    private static VentasController ventasController;
    private static SucursalController sucursalController;
    private static PeliculasController peliculasController;
    private static Venta newVenta;
    private static Funcion newFuncion;

    @BeforeAll
    static void setUp() throws Exception {
        funcionController = FuncionController.getInstancia();
        ventasController = VentasController.getInstancia();
        sucursalController = SucursalController.getInstancia();
        peliculasController = PeliculasController.getInstancia();

        Random rand = new Random();
        newFuncion = new Funcion(new Date(), UUID.randomUUID(), null, null, null, null);
        newVenta = new Venta(rand.nextInt(),new Date(), null, newFuncion);
    }

    @Test
    void recaudacionPorPeliculaSiNoExiste() {
        float recaudacion = ventasController.recaudacionPorPelicula(999);
        assertEquals(0.0f, recaudacion);
    }

    @Test
    void funcionesVendidasPorGeneroSiNoExiste() {
        List<VentaDTO> result = ventasController.funcionesVendidasPorGenero(TipoGenero.Drama);
        assertTrue(result.isEmpty());
    }

    @Test
    void buscarVentaPorFuncionSiNoExiste()
    {
        Venta venta = ventasController.buscarVentaPorFuncion(
                new Funcion(new Date(), UUID.randomUUID(), null, null, null, null)
        );

        // Verifica que la venta no exista
        Assertions.assertFalse(venta != null);
    }


    @Test
    void buscarVentaPorFuncion()
    {
        // Se agrega una nueva venta en el controlador de ventas
        List<Venta> ventas = ventasController.getVentas();
        ventas.add(newVenta);
        ventasController.setVentas(ventas);

        // Búsca la venta
        Venta ventaBuscada = ventasController.buscarVentaPorFuncion(newFuncion);

        // Verifica que la función que busca sea la misma que se añadió en un principio
        Assertions.assertEquals(ventaBuscada, newVenta);
    }
}
