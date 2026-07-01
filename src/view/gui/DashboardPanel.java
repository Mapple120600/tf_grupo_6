package view.gui;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.BorderLayout;

public class DashboardPanel extends BasePanel {
    public DashboardPanel() {
        super("panel principal");
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setFont(new Font("Arial", Font.PLAIN, 16));
        info.setText("Bienvenido al sistema de gestión para clínica dental shaddai :D");
        add(info, BorderLayout.CENTER);
    }
    
}
