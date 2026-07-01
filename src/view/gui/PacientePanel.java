package view.gui;

import controller.PacienteController;
import model.Paciente;
import util.MensajeUtil;
import util.NumberUtil;

import java.awt.BorderLayout;

public class PacientePanel extends BasePanel {
    private PacienteController controller;
    private PacienteFormPanel form;
    private PacienteTablePanel tabla;

    public PacientePanel(PacienteController controller) {
        super("Gestión de pacientes");
        this.controller = controller;
        form = new PacienteFormPanel();
        tabla = new PacienteTablePanel();
        add(form, BorderLayout.WEST);
        add(tabla, BorderLayout.CENTER);
        cargarTabla();
        form.btnGuardar.addActionListener(e -> guardar());
        form.btnLimpiar.addActionListener(e -> limpiar());
    }

    private void guardar() {
        try {
            String r = controller.registrarPaciente(NumberUtil.convertirEntero(form.txtId.getText()), form.txtNombre.getText(), form.txtDni.getText(), form.txtTelefono.getText());
            MensajeUtil.info(this, r);
            limpiar();
            cargarTabla();
        } catch (Exception e) {
            MensajeUtil.error(this, "Revise los datos ingresados");
        }
    }

    private void cargarTabla() {
        tabla.modelo.setRowCount(0);
        for (Paciente p : controller.listarPacientes()) {
            tabla.modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getDni(), p.getTelefono()});
        }
    }

    private void limpiar() {
        form.txtId.setText(""); form.txtNombre.setText(""); form.txtDni.setText(""); form.txtTelefono.setText("");
    }
}
