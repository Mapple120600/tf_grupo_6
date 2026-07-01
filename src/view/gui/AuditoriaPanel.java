package view.gui;

import controller.AuditoriaController;
import model.Auditoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AuditoriaPanel extends BasePanel {

    private AuditoriaController controller;
    private DefaultTableModel modeloTabla;

    public AuditoriaPanel(AuditoriaController controller) {

        super("Auditoría");

        this.controller = controller;

        add(crearPanelPrincipal(), BorderLayout.CENTER);

        cargarTabla();
    }

    private JPanel crearPanelPrincipal() {

        JPanel principal = new JPanel(new BorderLayout(15, 15));
        principal.setBackground(new Color(245, 247, 250));

        JPanel panelInfo = crearCaja("Información");

        JLabel texto = new JLabel(
                "La auditoría se registra automáticamente cuando se guardan datos en el sistema."
        );

        texto.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        panelInfo.add(texto, BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar historial");

        btnActualizar.addActionListener(e -> cargarTabla());

        panelInfo.add(btnActualizar, BorderLayout.SOUTH);

        principal.add(panelInfo, BorderLayout.NORTH);
        principal.add(crearTabla(), BorderLayout.CENTER);

        return principal;
    }

    private JPanel crearTabla() {

        JPanel panel = crearCaja("Historial de acciones");

        modeloTabla = new DefaultTableModel(
                new Object[]{
                        "ID",
                        "Acción",
                        "Usuario",
                        "Fecha"
                },
                0
        );

        JTable tabla = new JTable(modeloTabla);

        tabla.setRowHeight(24);

        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        return panel;
    }

    private void cargarTabla() {

        if (modeloTabla == null) {
            return;
        }

        modeloTabla.setRowCount(0);

        for (Auditoria a : controller.listarAuditorias()) {

            modeloTabla.addRow(new Object[]{
                    a.getId(),
                    a.getAccion(),
                    a.getUsuario(),
                    a.getFecha()
            });

        }
    }

}