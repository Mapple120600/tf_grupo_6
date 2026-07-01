package view.gui;

import javax.swing.*;
import java.awt.*;

public class PacienteFormPanel extends JPanel {
    public JTextField txtId = new JTextField(12);
    public JTextField txtNombre = new JTextField(12);
    public JTextField txtDni = new JTextField(12);
    public JTextField txtTelefono = new JTextField(12);
    public JButton btnGuardar = new JButton("Guardar paciente");
    public JButton btnLimpiar = new JButton("Limpiar");

    public PacienteFormPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createTitledBorder("Datos del paciente"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        agregar(gbc, "ID:", txtId, 0);
        agregar(gbc, "Nombre:", txtNombre, 1);
        agregar(gbc, "DNI:", txtDni, 2);
        agregar(gbc, "Teléfono:", txtTelefono, 3);
        JPanel botones = new JPanel();
        botones.setBackground(Color.WHITE);
        botones.add(btnGuardar);
        botones.add(btnLimpiar);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(botones, gbc);
    }

    private void agregar(GridBagConstraints gbc, String etiqueta, JTextField campo, int fila) {
        gbc.gridx = 0; gbc.gridy = fila; gbc.gridwidth = 1;
        add(new JLabel(etiqueta), gbc);
        gbc.gridx = 1;
        add(campo, gbc);
    }
}