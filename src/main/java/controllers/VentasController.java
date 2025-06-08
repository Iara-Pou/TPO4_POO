package controllers;

import dtos.FuncionDTO;
import dtos.VentaDTO;
import models.Funcion;
import models.Sucursal;
import models.Venta;
import models.enums.TipoGenero;
import models.enums.TipoTarjeta;

import java.util.*;


/**
 *
 */
public class VentasController {
    private List<Venta> ventas;

    private static VentasController instancia = null;

    public VentasController() {
        ventas = new ArrayList<>();
        Venta venta = new Venta(1, new Date(), null, null);
        ventas.add(venta);
    }

    public static synchronized VentasController getInstancia() {
        if (instancia == null) {
            instancia = new VentasController();
        }
        return instancia;
    }

    private FuncionController funcionController = FuncionController.getInstancia();

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * @param funcionID
     * @return
     */
    public float recaudacionPorFuncion(int funcionID) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * Caso de secuencia a desarrollar
     *
     * @param peliculaID
     * @return
     */
    public float recaudacionPorPelicula(int peliculaID) {
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if (funciones.isEmpty()) {
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion : funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if (Objects.isNull(venta)) {
                totalrecuadado = +venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
        return totalrecuadado;
    }

    /**
     * @param tipoTarjeta
     * @return
     */
    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        // TODO implement here
        return 0.0f;
    }

    /**
     *
     */
    public void comboMasVendido() {
        // TODO implement here
    }

    private Venta buscarVentaPorFuncion(Funcion funcion) {
        for (Venta venta : getVentas()) {
            if (Objects.equals(funcion, venta.getFuncion())) {
                return venta;
            }
        }
        return null;
    }

    /**
     * View a desarrollar
     *
     * @param genero
     * @return
     */
    public List<VentaDTO> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDTO> VentaDTOs = new ArrayList<>();
        List<Funcion> funciones = funcionController.buscarPeliculaPorGenerosFuncion(genero);
        if (funciones.isEmpty()) {
            return VentaDTOs;
        }
        for (Funcion funcion : funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if (Objects.isNull(venta)) {
                VentaDTOs.add(modelVentaToDto(venta));
            }
        }
        return VentaDTOs;
    }

    public VentaDTO modelVentaToDto(Venta venta) {
        return new VentaDTO(modelFuncionToDto(venta.getFuncion()));
    }

    public FuncionDTO modelFuncionToDto(Funcion funcion) {
        return new FuncionDTO(funcion);
    }

}