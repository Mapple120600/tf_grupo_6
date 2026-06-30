ppackage view.gui;

import controller.InventarioController;
import model.MaterialDental;
import util.MensajeUtil;
import util.NumberUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventarioPanel extends BasePanel {
    private InventarioController controller;
    private JTextField txtId = new JTextField(10), txtNombre = new JTextField(10), txtStock = new JTextField(10), txtUnidad = new JTextField(10);
    private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Material", "Stock", "Unidad"}, 0);

    public InventarioPanel(InventarioController controller) {
        super("Gestión de inventario");
        this.controller = controller;
        JPanel form = crearCaja("Material dental");
        JPanel campos = new JPanel(new GridLayout(5, 2, 8, 8));
        campos.add(new JLabel("ID:")); campos.add(txtId);
        campos.add(new JLabel("Nombre:")); campos.add(txtNombre);
        campos.add(new JLabel("Stock:")); campos.add(txtStock);
        campos.add(new JLabel("Unidad:")); campos.add(txtUnidad);
        JButton guardar = new JButton("Guardar material"); campos.add(new JLabel("")); campos.add(guardar);
        form.add(campos, BorderLayout.NORTH);
        JPanel lista = crearCaja("Materiales"); lista.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        add(form, BorderLayout.WEST); add(lista, BorderLayout.CENTER);
        guardar.addActionListener(e -> guardar());
        cargar();
    }

    private void guardar() {
        MensajeUtil.info(this, controller.registrarMaterial(NumberUtil.convertirEntero(txtId.getText()), txtNombre.getText(), NumberUtil.convertirEntero(txtStock.getText()), txtUnidad.getText()));
        cargar();
    }

    private void cargar() {
        modelo.setRowCount(0);
        for (MaterialDental m : controller.listarMateriales()) modelo.addRow(new Object[]{m.getId(), m.getNombre(), m.getStock(), m.getUnidad()});
    }
}