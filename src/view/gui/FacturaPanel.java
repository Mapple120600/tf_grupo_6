package view.gui;

import controller.FacturaController;
import model.Factura;
import util.MensajeUtil;
import util.NumberUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FacturaPanel extends BasePanel {
    private FacturaController controller;
    private JTextField txtIdFactura;
    private JTextField txtDni;
    private JTextField txtSubtotal;
    private JTextField txtIgv;
    private JTextField txtTotal;
    private JTextField txtFecha;
    private DefaultTableModel modeloTabla;

    public FacturaPanel(FacturaController controller) {
        super("Facturación");
        this.controller = controller;
        add(crearPanelPrincipal(), BorderLayout.CENTER);
        cargarTabla();
    }

    private JPanel crearPanelPrincipal() {
        JPanel principal = new JPanel(new BorderLayout(15, 15));
        principal.setBackground(new Color(245, 247, 250));
        principal.add(crearFormulario(), BorderLayout.WEST);
        principal.add(crearTabla(), BorderLayout.CENTER);
        return principal;
    }

    private JPanel crearFormulario() {
        JPanel panel = crearCaja("Datos de factura");
        JPanel campos = new JPanel(new GridBagLayout());
        campos.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtIdFactura = new JTextField(15);
        txtDni = new JTextField(15);
        txtSubtotal = new JTextField(15);
        txtIgv = new JTextField(15);
        txtTotal = new JTextField(15);
        txtFecha = new JTextField(15);

        agregarCampo(campos, gbc, "ID factura:", txtIdFactura, 0);
        agregarCampo(campos, gbc, "DNI paciente:", txtDni, 1);
        agregarCampo(campos, gbc, "Subtotal:", txtSubtotal, 2);
        agregarCampo(campos, gbc, "IGV:", txtIgv, 3);
        agregarCampo(campos, gbc, "Total:", txtTotal, 4);
        agregarCampo(campos, gbc, "Fecha:", txtFecha, 5);

        JButton btnCalcular = new JButton("Calcular total");
        JButton btnGuardar = new JButton("Generar factura");
        JButton btnLimpiar = new JButton("Limpiar");

        JPanel botones = new JPanel(new FlowLayout());
        botones.setBackground(Color.WHITE);
        botones.add(btnCalcular);
        botones.add(btnGuardar);
        botones.add(btnLimpiar);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        campos.add(botones, gbc);

        btnCalcular.addActionListener(e -> calcularTotal());
        btnGuardar.addActionListener(e -> guardarFactura());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        panel.add(campos, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearTabla() {
        JPanel panel = crearCaja("Facturas registradas");
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Paciente", "DNI", "Total", "Fecha"}, 0);
        JTable tabla = new JTable(modeloTabla);
        tabla.setRowHeight(24);
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, String texto, JTextField campo, int fila) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 1;
        panel.add(new JLabel(texto), gbc);
        gbc.gridx = 1;
        panel.add(campo, gbc);
    }

    private void calcularTotal() {
        double subtotal = NumberUtil.convertirDecimal(txtSubtotal.getText());
        double igv = subtotal * 0.18;
        double total = subtotal + igv;
        txtIgv.setText(String.valueOf(igv));
        txtTotal.setText(String.valueOf(total));
    }

    private void guardarFactura() {
        if (txtIdFactura.getText().isEmpty() || txtDni.getText().isEmpty() || txtTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete ID, DNI y total");
            return;
        }

        String r = controller.registrarFactura(
                NumberUtil.convertirEntero(txtIdFactura.getText()),
                txtDni.getText(),
                NumberUtil.convertirDecimal(txtTotal.getText()),
                txtFecha.getText()
        );
        MensajeUtil.info(this, r);
        limpiarCampos();
        cargarTabla();
    }

    private void cargarTabla() {
        if (modeloTabla == null) return;
        modeloTabla.setRowCount(0);
        for (Factura f : controller.listarFacturas()) {
            modeloTabla.addRow(new Object[]{f.getId(), f.getPaciente().getNombre(), f.getPaciente().getDni(), f.getTotal(), f.getFecha()});
        }
    }

    private void limpiarCampos() {
        txtIdFactura.setText("");
        txtDni.setText("");
        txtSubtotal.setText("");
        txtIgv.setText("");
        txtTotal.setText("");
        txtFecha.setText("");
    }
}