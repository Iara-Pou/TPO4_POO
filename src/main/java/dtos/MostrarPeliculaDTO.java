package dtos;

import java.util.List;

public class MostrarPeliculaDTO {
    private List<String> actores;
    private String director;
    private int duracionEnMinutos;
    private String nombrePelicula;
    private String tipo;

    public MostrarPeliculaDTO(String director, int duracionEnMinutos, String nombrePelicula, String tipo, List<String> actores){
        this.actores = actores;
        this.tipo = tipo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.director = director;
        this.nombrePelicula = nombrePelicula;
    }

    public List<String> getActores() {
        return actores;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getTipo() {
        return tipo;
    }
}
