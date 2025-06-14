package views;

import controllers.PeliculasController;
import dtos.MostrarRecaudacionDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmitirReporteRecaudacion extends JFrame {
    private DefaultTableModel tablaModelo;
    private JTable tablaRecaudacion;
    PeliculasController peliculasController = PeliculasController.getInstancia();

    public EmitirReporteRecaudacion() {
        setTitle("Top 10 Películas con Mayor Recaudación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);

        List<MostrarRecaudacionDTO> topPeliculas = peliculasController.getPeliculasConMayorRecaudacion();

        if (topPeliculas.isEmpty()) {
            JLabel mensaje = new JLabel("No hay películas con recaudación registrada.");
            mensaje.setHorizontalAlignment(SwingConstants.CENTER);
            add(mensaje, BorderLayout.CENTER);
        } else {
            tablaModelo = new DefaultTableModel(new String[]{"Nombre", "Duración (min)", "Director", "Tipo", "Recaudación Total"}, 0);

            for (MostrarRecaudacionDTO dto : topPeliculas) {
                tablaModelo.addRow(new Object[]{
                        dto.getPeliculaDTO().getNombrePelicula(),
                        dto.getPeliculaDTO().getDuracionEnMinutos(),
                        dto.getPeliculaDTO().getDirector(),
                        dto.getPeliculaDTO().getTipo(),
                        String.format("$ %.2f", dto.getTotalRecaudacion())
                });
            }

            tablaRecaudacion = new JTable(tablaModelo);
            JScrollPane scrollPane = new JScrollPane(tablaRecaudacion);
            add(scrollPane, BorderLayout.CENTER);
        }

        setVisible(true);
    }
}
