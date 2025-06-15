package controllers;

import models.Sala;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SucursalControllerTest {
    private static SucursalController controller;

    @BeforeAll
    public static void setUp() {
        controller = SucursalController.getInstancia();
    }

    @Test
    public void agregarSucursal() {
        controller.agregarSucursal(2, "Barracasi", "Av Montes de Oca 11");
        controller.agregarSala(2, 2, "Sala Palermo", 40);
        Sala sala = controller.obtenerSala("Sala Palermo");

        assertEquals("Sala Palermo", sala.getDenominacion());
        assertEquals(40, sala.getAsientos());
    }

    @Test
    public void agregarSucursalConIDRepetido() {
        controller.agregarSucursal(6, "Barracas", "Av Montes de Oca 1100");

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            controller.agregarSucursal(6, "Duplicado", "Otra dirección");
        });
        assertEquals("ERROR EN CREACIÓN. El ID de sucursal no debe repetirse.", ex.getMessage());
    }

    @Test
    public void agregarSala() {
        controller.agregarSucursal(3, "Belgrano", "Av Cabildo 500");
        controller.agregarSala(3, 10, "Sala Belgrano", 35);
        Sala sala = controller.obtenerSala("Sala Belgrano");

        assertNotNull(sala);
        assertEquals("Sala Belgrano", sala.getDenominacion());
        assertEquals(35, sala.getAsientos());
    }

    @Test
    public void agregarSalaConSucursalInexistente() {
        controller.agregarSala(999, 55, "Sala Fantasma", 15);
        Sala sala = controller.obtenerSala("Sala Fantasma");

        assertNull(sala, "No debe agregar la sala si la sucursal no existe");
    }

    @Test
    public void obtenerSalaSiExiste() {
        Sala sala = controller.obtenerSala("Sala 1");

        assertEquals("Sala 1", sala.getDenominacion());
        assertEquals(20, sala.getAsientos());
    }

    @Test
    public void obtenerSalaSiNoExiste() {
        Sala sala = controller.obtenerSala("Sala Inexistente");

        assertNull(sala, "Debe devolver null si no existe la sala");
    }

}