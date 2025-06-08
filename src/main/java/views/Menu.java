package views;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private JButton registrarFuncion;
    private JButton registrarPelicula;
    private JButton consultarPeliculas;
    private JButton emitirReporteRecaudacion;

    public Menu() {
        setTitle("BLOCKBUSTER - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 400);

        // Panel que contiene el contenido del menú
        JPanel contenidoMenu = new JPanel(new GridLayout(4, 1, 0, 10));

        registrarFuncion = new JButton("Agregar Tarjeta");
        registrarPelicula = new JButton("Agregar Cliente");
        consultarPeliculas = new JButton("Agregar Consumo");
        emitirReporteRecaudacion = new JButton("Listar Clientes");

        registrarFuncion.addActionListener(e -> SwingUtilities.invokeLater(RegistrarFuncion::new));
        registrarPelicula.addActionListener(e -> SwingUtilities.invokeLater(RegistrarPelicula::new));
        consultarPeliculas.addActionListener(e -> SwingUtilities.invokeLater(ConsultarPeliculas::new));
        emitirReporteRecaudacion.addActionListener(e -> SwingUtilities.invokeLater(EmitirReporteRecaudacion::new));

        contenidoMenu.add(registrarFuncion);
        contenidoMenu.add(registrarPelicula);
        contenidoMenu.add(consultarPeliculas);
        contenidoMenu.add(emitirReporteRecaudacion);

        //crea padding interno
        contenidoMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(contenidoMenu, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }

}
