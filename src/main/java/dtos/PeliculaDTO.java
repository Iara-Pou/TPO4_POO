package dtos;

public class PeliculaDTO {

    private String generoID;
    private String nombrePelicula;
    private int duracionEnMinutos;
    private String director;
    private String actor1;
    private String actor2;
    private String tipo;

    public PeliculaDTO(String generoID, String nombrePelicula, int duracionEnMinutos, String director, String actor1, String actor2, String tipo) {
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.duracionEnMinutos = duracionEnMinutos;
        this.director = director;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.tipo = tipo;
    }

    public PeliculaDTO() {

    }

    public String getGeneroID() {
        return generoID;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getDirector() {
        return director;
    }

    public String getActor1() {
        return actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setGeneroID(String generoID) {
        this.generoID = generoID;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
