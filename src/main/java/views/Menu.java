package views;

import models.enums.TipoGenero;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Menu extends JFrame {

    private JButton registrarFuncion;
    private JButton registrarPelicula;
    private JButton consultarPeliculas;
    private JButton emitirReporteRecaudacion;
    private JPanel contenidoMenu;

    public Menu() {
        setTitle("BLOCKBUSTER - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 400);

        contenidoMenu = new JPanel(new GridLayout(4, 1, 0, 10));
        registrarFuncion = new JButton("Registrar Función");
        registrarPelicula = new JButton("Registrar Pelicula");
        consultarPeliculas = new JButton("Consultar Peliculas");
        emitirReporteRecaudacion = new JButton("Emitir Reporte Recaudación");

        manejarRedireccion();

        contenidoMenu.add(registrarFuncion);
        contenidoMenu.add(registrarPelicula);
        contenidoMenu.add(consultarPeliculas);
        contenidoMenu.add(emitirReporteRecaudacion);
        contenidoMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(contenidoMenu, BorderLayout.CENTER);
        setVisible(true);
    }

    private void manejarRedireccion() {
        //Si las funcionalidades que necesitan un género seleccionado, las hacemos pasar por un JDialog previo
        registrarFuncion.addActionListener(e -> {
            String genero = seleccionarGenero();
            SwingUtilities.invokeLater(() -> new RegistrarFuncion(genero));
        });

        registrarPelicula.addActionListener(e -> {
            String genero = seleccionarGenero();
            SwingUtilities.invokeLater(() -> new RegistrarPelicula(genero));
        });

        consultarPeliculas.addActionListener(e -> {
            String genero = seleccionarGenero();
            SwingUtilities.invokeLater(() -> new ConsultarPeliculas(genero));
            SwingUtilities.invokeLater(() -> new ConsultarPeliculas(genero));
        });

        emitirReporteRecaudacion.addActionListener(e -> SwingUtilities.invokeLater(EmitirReporteRecaudacion::new));
    }

    private String seleccionarGenero() {
        List<TipoGenero> generos = List.of(TipoGenero.values());
        String[] generoElegido = {""};

        JDialog dialogo = new JDialog(this, "Selecciona el género", true);
        dialogo.setLayout(new GridLayout(generos.size() + 1, 1, 0, 10));
        dialogo.setSize(300, 300);
        dialogo.setLocationRelativeTo(this);

        JLabel titulo = new JLabel("Selecciona el género:");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        dialogo.add(titulo);

        for (TipoGenero genero : generos) {
            JButton opcion = new JButton(genero.toString());
            opcion.addActionListener(e -> {
                generoElegido[0] = genero.toString();
                dialogo.dispose();
            });
            dialogo.add(opcion);
        }

        dialogo.setVisible(true);
        return generoElegido[0];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }

}
