package view.gui;

import javax.swing.*;
import java.awt.*;

public class RecetaPanel extends BasePanel {
    public RecetaPanel() {
        super("Recetas");
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 15));
        area.setText("Módulo de Recetas.\n\nEste panel queda preparado para registrar, consultar y listar información del módulo.");
        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
