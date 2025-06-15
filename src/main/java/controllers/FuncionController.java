package controllers;

import dtos.FuncionDTO;
import models.Entrada;
import models.Funcion;
import models.Pelicula;
import models.Sala;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
public class FuncionController {

    private static List<Funcion> funciones;
    private static FuncionController instancia = null;

    private FuncionController() {
        funciones = new ArrayList<>();
        funciones.add(new Funcion(new Date(), UUID.randomUUID() , "11:00", new ArrayList<Entrada>(), new Sala(0, null, 0),
                new Pelicula(1, TipoGenero.Terror, "steven spielberg", 120, "Tiburon", TipoProyeccion.DosD, new ArrayList<>(), null)));

    }

    public static synchronized FuncionController getInstancia() {
        if (instancia == null) {
            instancia = new FuncionController();
        }
        return instancia;
    }
    /**
     *
     */
    public void ABM() {
        // TODO implement here
    }

    /**
     * @param funcionID
     * @return
     */
    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
        return -1;
    }

    /**
     * @param fchFuncion
     * @return
     */
    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int peliculaMasVista() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int diaDeLaSemanaConMenorVentas() {
        // TODO implement here
        return 0;
    }

    public List<Funcion> buscarFuncionesPorPeliculaID(int peliculaID) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPeliculaID() == peliculaID) {
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funcionesDeLaPelicula;
    }

    public List<Funcion> buscarFuncionesPorGenero(TipoGenero genero) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPelicula().getGeneroID() == genero) {
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funcionesDeLaPelicula;
    }

    /**
     * Agrega la función a la lista de funciones
     * @param funcionDTO
     * @return
     * @throws Exception
     */
    public String agregarFuncion(FuncionDTO funcionDTO) throws Exception
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SucursalController sucursales = SucursalController.getInstancia();
        PeliculasController peliculas = PeliculasController.getInstancia();

        Date fecha = format.parse(funcionDTO.getFecha());
        UUID funcionID = UUID.randomUUID();

        Sala sala = sucursales.obtenerSala(funcionDTO.getSala());
        Pelicula pelicula = peliculas.obtenerPelicula(funcionDTO.getPelicula());

        if(sala == null) throw new Exception("La sala especficada no existe o no está disponible");
        if(pelicula == null) throw new Exception("La pelicula no fue encontrada");

        Funcion funcion = new Funcion(
            fecha,
            funcionID,
            funcionDTO.getHora(),
            new ArrayList<Entrada>(),
            sala,
            pelicula
        );

        this.funciones.add(funcion);
        return funcionID.toString();
    }
}