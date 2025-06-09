package views;

import controllers.FuncionController;
import dtos.FuncionDTO;

import javax.swing.*;
import java.awt.*;

public class RegistrarFuncion extends JFrame {
    private JButton guardar;
    private JButton cancelar;

    private JTextField sala;
    private JTextField hora;
    private JTextField fecha;
    private JTextField pelicula;

    FuncionController controller;

    public RegistrarFuncion() {
        setTitle("BLOCKBUSTER - Agregar función");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,2));
        setSize(500, 400);
        setVisible(true);

        add(new JLabel("Sala"));
        sala = new JTextField();
        add(sala);

        add(new JLabel("Fecha (dd/mm/yyyy)"));
        fecha = new JTextField();
        add(fecha);

        add(new JLabel("Hora"));
        hora = new JTextField();
        add(hora);

        add(new JLabel("Pelicula"));
        pelicula = new JTextField();
        add(pelicula);

        guardar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");

        add(cancelar);
        add(guardar);

        guardar.addActionListener(e -> guardar());
        cancelar.addActionListener(e -> dispose());
    }

    private void guardar(){
        try{
            this.controller = FuncionController.getInstancia();
            FuncionDTO funcion = new FuncionDTO(
                    this.sala.getText(),
                    this.hora.getText(),
                    this.fecha.getText(),
                    this.pelicula.getText()
            );

            String uuid = controller.agregarFuncion(funcion);
            JOptionPane.showMessageDialog(null,"Función guardada correctamente, funcionID: " + uuid);
            dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
