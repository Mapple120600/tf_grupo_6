package view.gui;

import javax.swing.*;
import java.awt.*;

public class CitaFormPanel extends JPanel {
    public JTextField txtId = new JTextField(12);
    public JTextField txtDni = new JTextField(12);
    public JTextField txtIdOdontologo = new JTextField(12);
    public JTextField txtFecha = new JTextField(12);
    public JTextField txtHora = new JTextField(12);
    public JButton btnGuardar = new JButton("Programar cita");

    public CitaFormPanel() {
        setLayout(new GridLayout(6, 2, 8, 8));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createTitledBorder("Datos de la cita"));
        add(new JLabel("ID:")); add(txtId);
        add(new JLabel("DNI paciente:")); add(txtDni);
        add(new JLabel("ID odontólogo:")); add(txtIdOdontologo);
        add(new JLabel("Fecha:")); add(txtFecha);
        add(new JLabel("Hora:")); add(txtHora);
        add(new JLabel("")); add(btnGuardar);
    }
}