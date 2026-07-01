package view.gui;

import controller.TratamientoController;
import model.Tratamiento;
import util.MensajeUtil;
import util.NumberUtil;

import java.awt.BorderLayout;

public class TratamientoPanel extends BasePanel {

    private TratamientoController controller;
    private TratamientoFormPanel form;
    private TratamientoTablePanel tabla;

    public TratamientoPanel(TratamientoController controller) {
        super("Gestión de tratamientos");

        this.controller = controller;

        form = new TratamientoFormPanel();
        tabla = new TratamientoTablePanel();

        add(form, BorderLayout.WEST);
        add(tabla, BorderLayout.CENTER);

        cargarTabla();

        form.btnGuardar.addActionListener(e -> guardar());
    }

    private void guardar() {

        String resultado = controller.registrarTratamiento(
                NumberUtil.convertirEntero(form.txtId.getText()),
                form.txtDni.getText(),
                NumberUtil.convertirEntero(form.txtIdOdontologo.getText()),
                form.txtNombre.getText(),
                NumberUtil.convertirDecimal(form.txtCosto.getText())
        );

        MensajeUtil.info(this, resultado);

        cargarTabla();
    }

    private void cargarTabla() {

        tabla.modelo.setRowCount(0);

        for (Tratamiento t : controller.listarTratamientos()) {

            tabla.modelo.addRow(new Object[]{
                    t.getId(),
                    t.getPaciente().getNombre(),
                    t.getNombre(),
                    t.getCosto(),
                    t.getEstado()
            });

        }
    }

}