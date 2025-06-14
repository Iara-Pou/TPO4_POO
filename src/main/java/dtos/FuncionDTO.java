package dtos;

import models.Funcion;

public class FuncionDTO {
    private String sala;
    private String hora;
    private String fecha;
    private String pelicula;

    public FuncionDTO(String sala, String hora, String fecha, String pelicula) {
        this.sala = sala;
        this.hora = hora;
        this.fecha = fecha;
        this.pelicula = pelicula;
    }

    public FuncionDTO(Funcion funcion) {

    }

    public String getSala() {
        return sala;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPelicula() {
        return pelicula;
    }
}
