package views;

import controllers.PeliculasController;
import dtos.MostrarPeliculaDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultarPeliculas extends JFrame {
    private DefaultTableModel tablaModelo;
    private JTable tablaPeliculas;
    PeliculasController peliculasController = PeliculasController.getInstancia();

    public ConsultarPeliculas(String genero) {
        setTitle("Mostrar películas - " + genero);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        setSize(500, 400);

        List<MostrarPeliculaDTO> mostrarPeliculaDTO = peliculasController.getPeliculasByGenero(genero);
        if (mostrarPeliculaDTO.isEmpty()) {
            JLabel mensaje = new JLabel("No se encontraron películas del género solicitado.");
            mensaje.setHorizontalAlignment(SwingConstants.CENTER);
            add(mensaje, BorderLayout.CENTER);
        } else {
            tablaModelo = new DefaultTableModel(new String[]{"Nombre", "Duración (min)", "Actores", "Director", "Tipo proyección"}, 0);
            for (MostrarPeliculaDTO peliculaDTO : mostrarPeliculaDTO) {
                tablaModelo.addRow(new Object[]{
                        peliculaDTO.getNombrePelicula(),
                        peliculaDTO.getDuracionEnMinutos(),
                        parseList(peliculaDTO.getActores().subList(0, 2)),
                        peliculaDTO.getDirector(),
                        peliculaDTO.getTipo()
                });
            }
            tablaPeliculas = new JTable(tablaModelo);
            JScrollPane scrollPane = new JScrollPane(tablaPeliculas);
            scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            add(scrollPane, BorderLayout.CENTER);
        }
        setVisible(true);
    }

    public String parseList(List<String> actores) {
        boolean isFirst = true;
        StringBuilder resultado = new StringBuilder();
        for (String actor : actores) {
            if (!isFirst) {
                resultado.append(", ").append(actor);
                continue;
            }
            resultado.append(actor);
            isFirst = false;
        }
        return resultado.toString();
    }
}
