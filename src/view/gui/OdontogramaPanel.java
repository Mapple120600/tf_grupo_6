package view.gui;

import javax.swing.*;
import java.awt.*;

public class OdontogramaPanel extends BasePanel {
    public OdontogramaPanel() {
        super("Odontograma");
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 15));
        area.setText("Módulo de Odontograma.\n\nEste panel queda preparado para registrar, consultar y listar información del módulo.");
        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
