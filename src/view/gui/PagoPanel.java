package view.gui;

import controller.PagoController;
import model.Pago;
import strategy.*;
import util.MensajeUtil;
import util.NumberUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PagoPanel extends BasePanel {
    private PagoController controller;
    private JTextField txtId = new JTextField(10), txtDni = new JTextField(10), txtMonto = new JTextField(10), txtFecha = new JTextField(10);
    private JComboBox<String> cboMetodo = new JComboBox<>(new String[]{"Efectivo", "Tarjeta", "Yape"});
    private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Paciente", "Monto", "Método", "Fecha"}, 0);

    public PagoPanel(PagoController controller) {
        super("Gestión de pagos");
        this.controller = controller;
        JPanel form = crearCaja("Datos del pago");
        JPanel campos = new JPanel(new GridLayout(6, 2, 8, 8));
        campos.add(new JLabel("ID:")); campos.add(txtId);
        campos.add(new JLabel("DNI paciente:")); campos.add(txtDni);
        campos.add(new JLabel("Monto:")); campos.add(txtMonto);
        campos.add(new JLabel("Fecha:")); campos.add(txtFecha);
        campos.add(new JLabel("Método:")); campos.add(cboMetodo);
        JButton guardar = new JButton("Guardar pago"); campos.add(new JLabel("")); campos.add(guardar);
        form.add(campos, BorderLayout.NORTH);
        JPanel lista = crearCaja("Pagos registrados"); lista.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        add(form, BorderLayout.WEST); add(lista, BorderLayout.CENTER);
        guardar.addActionListener(e -> guardar());
        cargar();
    }

    private MetodoPagoStrategy estrategia() {
        String metodo = cboMetodo.getSelectedItem().toString();
        if (metodo.equals("Tarjeta")) return new PagoTarjetaStrategy();
        if (metodo.equals("Yape")) return new PagoYapeStrategy();
        return new PagoEfectivoStrategy();
    }

    private void guardar() {
        MensajeUtil.info(this, controller.registrarPago(NumberUtil.convertirEntero(txtId.getText()), txtDni.getText(), NumberUtil.convertirDecimal(txtMonto.getText()), txtFecha.getText(), estrategia()));
        cargar();
    }

    private void cargar() {
        modelo.setRowCount(0);
        for (Pago p : controller.listarPagos()) modelo.addRow(new Object[]{p.getId(), p.getPaciente().getNombre(), p.getMonto(), p.getMetodo(), p.getFecha()});
    }
