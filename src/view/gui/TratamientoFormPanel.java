package view.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.awt.GridLayout;
import java.awt.Color;

public class TratamientoFormPanel extends JPanel {

    public JTextField txtId = new JTextField(12);
    public JTextField txtDni = new JTextField(12);
    public JTextField txtIdOdontologo = new JTextField(12);
    public JTextField txtNombre = new JTextField(12);
    public JTextField txtCosto = new JTextField(12);

    public JButton btnGuardar = new JButton("Guardar tratamiento");

    public TratamientoFormPanel() {

        setLayout(new GridLayout(6, 2, 8, 8));
        setBackground(Color.WHITE);

        setBorder(
                BorderFactory.createTitledBorder("Datos del tratamiento")
        );

        add(new JLabel("ID:"));
        add(txtId);

        add(new JLabel("DNI paciente:"));
        add(txtDni);

        add(new JLabel("ID odontólogo:"));
        add(txtIdOdontologo);

        add(new JLabel("Nombre:"));
        add(txtNombre);

        add(new JLabel("Costo:"));
        add(txtCosto);

        add(new JLabel(""));
        add(btnGuardar);
    }

}