package view.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import util.TableUtil;

public class CitaTablePanel extends JPanel {
    public DefaultTableModel modelo;

    public CitaTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createTitledBorder("Lista de citas"));
        modelo = new DefaultTableModel(new Object[]{"ID", "Paciente", "Odontólogo", "Fecha", "Hora", "Estado"}, 0);
        JTable tabla = new JTable(modelo);
        TableUtil.ajustar(tabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}
