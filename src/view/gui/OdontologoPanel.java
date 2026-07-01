package view.gui;

import controller.OdontologoController;
import model.Odontologo;
import util.MensajeUtil;
import util.NumberUtil;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

public class OdontologoPanel extends BasePanel {
    private OdontologoController controller;
    private JTextField txtId = new JTextField(10);
    private JTextField txtNombre = new JTextField(10);
    private JTextField txtEspecialidad = new JTextField(10);
    private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Especialidad"}, 0);

    public OdontologoPanel(OdontologoController controller) {
        super("Gestión de odontólogos");
        this.controller = controller;
        JPanel form = crearCaja("Datos del odontólogo");
        JPanel campos = new JPanel(new GridLayout(4, 2, 8, 8));
        campos.add(new JLabel("ID:")); campos.add(txtId);
        campos.add(new JLabel("Nombre:")); campos.add(txtNombre);
        campos.add(new JLabel("Especialidad:")); campos.add(txtEspecialidad);
        JButton guardar = new JButton("Guardar"); campos.add(new JLabel("")); campos.add(guardar);
        form.add(campos, BorderLayout.NORTH);
        JPanel lista = crearCaja("Lista"); lista.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        add(form, BorderLayout.WEST); add(lista, BorderLayout.CENTER);
        guardar.addActionListener(e -> guardar());
        cargar();
    }

    private void guardar() {
        MensajeUtil.info(this, controller.registrarOdontologo(NumberUtil.convertirEntero(txtId.getText()), txtNombre.getText(), txtEspecialidad.getText()));
        cargar();
    }

    private void cargar() {
        modelo.setRowCount(0);
        for (Odontologo o : controller.listarOdontologos()) modelo.addRow(new Object[]{o.getId(), o.getNombre(), o.getEspecialidad()});
    }
}