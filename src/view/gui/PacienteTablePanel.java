package view.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import util.TableUtil;

public class PacienteTablePanel extends JPanel {
    public DefaultTableModel modelo;

    public PacienteTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createTitledBorder("Lista de pacientes"));
        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "DNI", "Teléfono"}, 0);
        JTable tabla = new JTable(modelo);
        TableUtil.ajustar(tabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}