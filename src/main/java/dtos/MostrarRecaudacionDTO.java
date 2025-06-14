package dtos;

public class MostrarRecaudacionDTO {
    MostrarPeliculaDTO peliculaDTO;
    float totalRecaudacion;

    public MostrarRecaudacionDTO(MostrarPeliculaDTO peliculaDTO, float totalRecaudacion) {
        this.peliculaDTO = peliculaDTO;
        this.totalRecaudacion = totalRecaudacion;
    }

    public MostrarPeliculaDTO getPeliculaDTO() {
        return peliculaDTO;
    }

    public float getTotalRecaudacion() {
        return totalRecaudacion;
    }
}
