package view.gui;

import controller.CitaController;
import model.Cita;
import util.MensajeUtil;
import util.NumberUtil;
import java.awt.BorderLayout;

public class CitaPanel extends BasePanel {
    private CitaController controller;
    private CitaFormPanel form;
    private CitaTablePanel tabla;

    public CitaPanel(CitaController controller) {
        super("gestion de citas");
        this.controller = controller;
        form = new CitaFormPanel();
        tabla = new CitaTablePanel();
        add(form, BorderLayout.WEST);
        add(tabla, BorderLayout.CENTER);
        cargarTabla();
        form.btnGuardar.addActionListener(e -> guardar());
    }

    private void guardar() {
        String r = controller.programarCita(NumberUtil.convertirEntero(form.txtId.getText()), form.txtDni.getText(), NumberUtil.convertirEntero(form.txtIdOdontologo.getText()), form.txtFecha.getText(), form.txtHora.getText());
        MensajeUtil.info(this, r);
        cargarTabla();
    }

    private void cargarTabla() {
        tabla.modelo.setRowCount(0);
        for (Cita c : controller.listarCitas()) {
            tabla.modelo.addRow(new Object[]{c.getId(), c.getPaciente().getNombre(), c.getOdontologo().getNombre(), c.getFecha(), c.getHora(), c.getEstado()});
        }
    }
}
