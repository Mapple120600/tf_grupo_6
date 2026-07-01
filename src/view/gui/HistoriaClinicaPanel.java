package view.gui;

import controller.HistoriaClinicaController;
import model.HistoriaClinica;
import util.MensajeUtil;
import util.NumberUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoriaClinicaPanel extends BasePanel {
    private HistoriaClinicaController controller;
    private JTextField txtId;
    private JTextField txtDni;
    private JTextArea txtAntecedentes;
    private JTextArea txtObservacion;
    private DefaultTableModel modeloTabla;

    public HistoriaClinicaPanel(HistoriaClinicaController controller) {
        super("Historia clínica");
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
        JPanel panel = crearCaja("Datos de historia clínica");
        JPanel campos = new JPanel(new GridBagLayout());
        campos.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtId = new JTextField(16);
        txtDni = new JTextField(16);
        txtAntecedentes = new JTextArea(4, 16);
        txtObservacion = new JTextArea(4, 16);

        agregarCampo(campos, gbc, "ID:", txtId, 0);
        agregarCampo(campos, gbc, "DNI paciente:", txtDni, 1);
        agregarArea(campos, gbc, "Antecedentes:", txtAntecedentes, 2);
        agregarArea(campos, gbc, "Observaciones:", txtObservacion, 3);

        JButton btnGuardar = new JButton("Guardar historia");
        JButton btnLimpiar = new JButton("Limpiar");

        JPanel botones = new JPanel(new FlowLayout());
        botones.setBackground(Color.WHITE);
        botones.add(btnGuardar);
        botones.add(btnLimpiar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        campos.add(botones, gbc);

        btnGuardar.addActionListener(e -> guardarHistoria());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        panel.add(campos, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearTabla() {
        JPanel panel = crearCaja("Lista de historias clínicas");
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Paciente", "DNI", "Antecedentes", "Observaciones"}, 0);
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

    private void agregarArea(JPanel panel, GridBagConstraints gbc, String texto, JTextArea area, int fila) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 1;
        panel.add(new JLabel(texto), gbc);
        gbc.gridx = 1;
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        panel.add(new JScrollPane(area), gbc);
    }

    private void guardarHistoria() {
        if (txtId.getText().isEmpty() || txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete ID y DNI del paciente");
            return;
        }

        String r = controller.registrarHistoria(
                NumberUtil.convertirEntero(txtId.getText()),
                txtDni.getText(),
                txtAntecedentes.getText(),
                txtObservacion.getText()
        );
        MensajeUtil.info(this, r);
        limpiarCampos();
        cargarTabla();
    }

    private void cargarTabla() {
        if (modeloTabla == null) return;
        modeloTabla.setRowCount(0);
        for (HistoriaClinica h : controller.listarHistorias()) {
            modeloTabla.addRow(new Object[]{h.getId(), h.getPaciente().getNombre(), h.getPaciente().getDni(), h.getAntecedentes(), h.getObservaciones()});
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtDni.setText("");
        txtAntecedentes.setText("");
        txtObservacion.setText("");
    }
}