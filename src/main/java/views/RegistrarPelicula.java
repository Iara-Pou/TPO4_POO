package views;

import controllers.PeliculasController;
import dtos.PeliculaDTO;

import javax.swing.*;
import java.awt.*;


public class RegistrarPelicula extends JFrame {
    private PeliculasController controller;

    private JTextField generoID;
    private JTextField nombrePelicula;
    private JTextField duracionEnMinutos;
    private JTextField director;
    private JTextField actor1;
    private JTextField actor2;
    private JTextField tipo;

    private JButton registrar;
    private JButton cancelar;

    public RegistrarPelicula() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8,2));
        setSize(900,500);

        this.controller = PeliculasController.getInstancia();

        this.setTitle("Registrar películas por género");

        add(new JLabel("Género de la película (Drama, Romance, Terror, Biográfica, Suspenso): "));
        this.generoID = new JTextField();
        add(this.generoID);

        add(new JLabel("Nombre de la película: "));
        this.nombrePelicula = new JTextField();
        add(this.nombrePelicula);

        add(new JLabel("Duración en minutos: "));
        this.duracionEnMinutos = new JTextField();
        add(this.duracionEnMinutos);

        add(new JLabel("Director: "));
        this.director = new JTextField();
        add(this.director);

        add(new JLabel("Actor principal: "));
        this.actor1 = new JTextField();
        add(this.actor1);

        add(new JLabel("Otro actor principal o secundario: "));
        this.actor2 = new JTextField();
        add(this.actor2);

        add(new JLabel("Tipo de proyección (DosD, TresD, TresDMax, CuatroD): "));
        this.tipo = new JTextField();
        add(this.tipo);

        this.registrar = new JButton("Registrar");
        this.cancelar = new JButton("Cancelar");

        add(this.registrar);
        add(this.cancelar);


        this.registrar.addActionListener(e -> registrar());
        this.cancelar.addActionListener(e -> dispose());

        setVisible(true);
    }

    public void registrar() {
        try {
            validar();
            PeliculaDTO pelicula = new PeliculaDTO();
            pelicula.setGeneroID(this.generoID.getText());
            pelicula.setNombrePelicula(this.nombrePelicula.getText());
            pelicula.setDuracionEnMinutos(Integer.parseInt(this.duracionEnMinutos.getText()));
            pelicula.setDirector(this.director.getText());
            pelicula.setActor1(this.actor1.getText());
            pelicula.setActor2(this.actor2.getText());
            pelicula.setTipo(this.tipo.getText());

            this.controller.registrarPelicula(pelicula);
            JOptionPane.showMessageDialog(null, "La película fue registrada exitosamente");
            limpiar();
        }
        catch (Exception e) {
            //System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void validar() throws Exception {
        if (generoID.getText().isEmpty()
                || nombrePelicula.getText().isEmpty()
                || duracionEnMinutos.getText().isEmpty()
                || director.getText().isEmpty()
                || actor1.getText().isEmpty()
                || actor2.getText().isEmpty()
                || tipo.getText().isEmpty()) {
            throw new Exception("Los datos no son válidos");
        }
    }

    private void limpiar() {

        generoID.setText("");
        nombrePelicula.setText("");
        duracionEnMinutos.setText("");
        director.setText("");
        actor1.setText("");
        actor2.setText("");
        tipo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrarPelicula::new);
    }
}
