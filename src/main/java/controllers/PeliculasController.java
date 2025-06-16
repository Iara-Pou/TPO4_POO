package controllers;

import dtos.MostrarPeliculaDTO;
import dtos.MostrarRecaudacionDTO;
import dtos.PeliculaDTO;
import models.CondicionesDescuento;
import models.Pelicula;
import models.enums.TipoGenero;
import models.enums.TipoProyeccion;

import java.util.*;

public class PeliculasController {
    private List<Pelicula> peliculas;
    private static PeliculasController instancia = null;

    private VentasController ventasController = VentasController.getInstancia();

    private PeliculasController() {
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(2, TipoGenero.Suspenso, "Pelicula1", 180, "Director X", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        peliculas.add(new Pelicula(3, TipoGenero.Drama, "Pelicula2", 190, "Director Y", TipoProyeccion.TresD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        peliculas.add(new Pelicula(4, TipoGenero.Terror, "Pelicula3", 165, "Director J", TipoProyeccion.TresDMax, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        peliculas.add(new Pelicula(5, TipoGenero.Biografica, "Pelicula4", 120, "Director K", TipoProyeccion.CuatroD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
        peliculas.add(new Pelicula(6, TipoGenero.Drama, "Pelicula5", 95, "Director L", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"), null));
    }

    public static synchronized PeliculasController getInstancia() {
        if (instancia == null) {
            instancia = new PeliculasController();
        }
        return instancia;
    }

    public void ABM() {
        // TODO implement here
    }

    public List<MostrarPeliculaDTO> getPeliculasByGenero(String genero) {
        List<MostrarPeliculaDTO> listaPeliculas = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getGeneroID().toString().equals(genero)) {
                listaPeliculas.add(toDto(pelicula));
            }
        }
        return listaPeliculas;
    }

    private MostrarPeliculaDTO toDto(Pelicula pelicula) {
        return new MostrarPeliculaDTO(pelicula.getDirector(), pelicula.getDuracionEnMinutos(), pelicula.getNombrePelicula(), pelicula.getTipo().toString(), pelicula.getActores());
    }

    public Pelicula obtenerPelicula(String nombre) {
        Pelicula pelicula = null;

        for (Pelicula current : this.peliculas) {
            if (current.getNombrePelicula().equals(nombre)) pelicula = current;
        }

        return pelicula;
    }

    public List<MostrarRecaudacionDTO> getPeliculasConMayorRecaudacion() {
        List<MostrarRecaudacionDTO> peliculasConMayorRecaudacion = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {
            float recaudacionActual = ventasController.recaudacionPorPelicula(pelicula.getPeliculaID());
            MostrarRecaudacionDTO mostrarRecaudacionDTO = new MostrarRecaudacionDTO(toDto(pelicula), recaudacionActual);
            peliculasConMayorRecaudacion.add(mostrarRecaudacionDTO);
        }

        peliculasConMayorRecaudacion.sort((a, b) -> Float.compare(b.getTotalRecaudacion(), a.getTotalRecaudacion()));
        // Retornar solo las primeras 10 o menos si hay menos de 10
        if (peliculasConMayorRecaudacion.size() > 10) {
            peliculasConMayorRecaudacion = peliculasConMayorRecaudacion.subList(0, 10);
        }

        return peliculasConMayorRecaudacion;
    }

    public void agregarPelicula(Pelicula pelicula) {
        if (obtenerPelicula(pelicula.getNombrePelicula()) == null) {
            peliculas.add(pelicula);
        }
    }

    public void registrarPelicula(PeliculaDTO dto) throws Exception {
        CondicionesDescuento condicionesDescuento = null;

        String dtoGenero = dto.getGeneroID();
        TipoGenero genero = buscarTipoGenero(dtoGenero);
        if (genero == null) {
            throw new Exception("No existe el tipo de genero " + dtoGenero);
        }

        String dtoProyeccion = dto.getTipo();
        TipoProyeccion proyeccion = buscarTipoProyeccion(dtoProyeccion);

        if (proyeccion == null) {
            throw new Exception("No existe el tipo de proyeccion " + dtoProyeccion);
        }

        String actor1 = dto.getActor1();
        String actor2 = dto.getActor2();
        List<String> actores = new ArrayList<>();
        actores.add(actor1);
        actores.add(actor2);

        Pelicula pelicula = new Pelicula(
                genero,
                dto.getNombrePelicula(),
                dto.getDuracionEnMinutos(),
                dto.getDirector(),
                actores,
                proyeccion,
                condicionesDescuento
        );
        if (!existePelicula(pelicula.getNombrePelicula())) {
            peliculas.add(pelicula);
        } else {
            throw new Exception("La película ya existe");
        }
    }

    public TipoGenero buscarTipoGenero(String genero)   {
        for (TipoGenero opcion : TipoGenero.values()) {
            if (opcion.name().equalsIgnoreCase(genero)) {
                return opcion;
            }
        }
        return null;
    }

    public TipoProyeccion buscarTipoProyeccion(String proyeccion)   {
        for (TipoProyeccion opcion : TipoProyeccion.values()) {
            if (opcion.name().equalsIgnoreCase(proyeccion)) {
                return opcion;
            }
        }
        return null;
    }

    public List<Pelicula> consultarPeliculaPorNombre(String nombre) {
        List<Pelicula> peliculasConsultadas = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getNombrePelicula().equals(nombre)) {
                peliculasConsultadas.add(pelicula);
            }
        }
        return peliculasConsultadas;
    }

    public boolean existePelicula(String nombre) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getNombrePelicula().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public List<Pelicula> consultarPeliculaPorGenero(TipoGenero genero) {
        List<Pelicula> peliculasConsultadas = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTipo().equals(genero)) {
                peliculasConsultadas.add(pelicula);
            }
        }
        return peliculasConsultadas;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
}