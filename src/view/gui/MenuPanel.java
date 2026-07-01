package view.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class MenuPanel  extends JPanel{
    public MenuPanel(MainFrame frame) {
        setLayout(new GridLayout(11, 1, 6, 6));
        setBackground(new Color(220, 230, 240));
        setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        agregarBoton("Inicio", e -> frame.mostrarDashboard());
        agregarBoton("Pacientes", e -> frame.mostrarPacientes());
        agregarBoton("Odontólogos", e -> frame.mostrarOdontologos());
        agregarBoton("Citas", e -> frame.mostrarCitas());
        agregarBoton("Tratamientos", e -> frame.mostrarTratamientos());
        agregarBoton("Pagos", e -> frame.mostrarPagos());
        agregarBoton("Inventario", e -> frame.mostrarInventario());
        agregarBoton("Reportes", e -> frame.mostrarReportes());
        agregarBoton("Historia", e -> frame.mostrarHistoria());
        agregarBoton("Facturas", e -> frame.mostrarFacturas());
        agregarBoton("Auditoría", e -> frame.mostrarAuditoria());
    }

    private void agregarBoton(String texto, java.awt.event.ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.addActionListener(accion);
        add(boton);
    }
}
