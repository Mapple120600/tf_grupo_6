package view.gui;

import controller.ReporteController;

import javax.swing.*;
import java.awt.*;

public class ReportePanel extends BasePanel {

    public ReportePanel(ReporteController controller) {

        super("Reportes y análisis");

        JTextArea area = new JTextArea();

        area.setFont(new Font("Arial", Font.PLAIN, 16));
        area.setEditable(false);

        JButton generar = new JButton("Generar resumen");

        generar.addActionListener(
                e -> area.setText(controller.generarResumen())
        );

        add(generar, BorderLayout.WEST);
        add(new JScrollPane(area), BorderLayout.CENTER);
    }

}