package view.gui;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;

public class TratamientoTablePanel extends JPanel {
        public DefaultTableModel modelo;

        public TratamientoTablePanel() {
                setLayout(new BorderLayout());
                setBackground(Color.WHITE);

                setBorder(
                                BorderFactory.createTitledBorder("Lista de tratamientos"));

                modelo = new DefaultTableModel(
                                new Object[] {
                                                "ID",
                                                "Paciente",
                                                "Tratamiento",
                                                "Costo",
                                                "Estado"
                                },
                                0);

                add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        }

}