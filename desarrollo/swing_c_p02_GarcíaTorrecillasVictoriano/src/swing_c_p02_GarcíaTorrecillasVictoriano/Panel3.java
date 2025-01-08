/**
 * Panel3.java
 * 13 nov 2024 11:05:21
 * @author Victoriano García Torrecillas
 */
package swing_c_p02_GarcíaTorrecillasVictoriano;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// TODO: Auto-generado Javadoc
/**
 * La Clase Panel3.
 */
public class Panel3 extends JPanel implements ActionListener, ChangeListener, DocumentListener {

	/** La etiqueta tipo. */
	JLabel labelTipo;

	/** Los tipos. */
	String[] tipos = { "Simple", "Doble", "Suite" };

	/** El cb tipo. */
	JComboBox<String> cbTipo;

	/** La etiqueta habitacion. */
	JLabel labelHabitacion;

	/** El modelo habitacion. */
	SpinnerNumberModel modeloHabitacion = new SpinnerNumberModel(0, 0, 50, 1);

	/** El sp habitacion. */
	JSpinner spHabitacion;

	/** Los niños. */
	JCheckBox niños;

	/** El extra niños. */
	JPanel extraNiños;

	/** La etiqueta edad. */
	JLabel labelEdad;

	/** El modelo edad. */
	SpinnerNumberModel modeloEdad = new SpinnerNumberModel(0, 0, 15, 1);

	/** La edad niños. */
	JSpinner edadNiños;

	/** Los extras. */
	JTextArea extras;

	/** La label importe. */
	JLabel labelImporte;

	/** El importe. */
	JTextField importe;

	/** Las imagenes. */
	JPanel imagenes;

	/** La imagen 1. */
	JLabel imagen1;

	/** La imagen 2. */
	JLabel imagen2;

	/** La imagen 3. */
	JLabel imagen3;

	/** Las constraints. */
	GridBagConstraints constraints = new GridBagConstraints();

	/** El layout. */
	GridBagLayout layout = new GridBagLayout();

	/** El importe total. */
	Integer importeTotal;

	/** El panel 2 datos. */
	Panel2 panel2Datos; // Para obtener datos de panel2

	/** La Constante COLOR_TEXTO. */
	public static final Color COLOR_TEXTO = new Color(248, 248, 255);

	/**
	 * Instancia un nuevo panel 3.
	 *
	 * @param panel2 the panel 2
	 */
	public Panel3(Panel2 panel2) {
		panel2Datos = panel2;

		this.setLayout(layout);
		this.setBackground(new Color(0, 51, 102));

		this.setBorder(new LineBorder(new Color(255, 215, 0), 3));

		labelTipo = new JLabel("Tipo de habitación: ");
		labelTipo.setForeground(COLOR_TEXTO);
		cbTipo = new JComboBox<String>(tipos);
		cbTipo.addActionListener(this);

		labelHabitacion = new JLabel("Nº de habitaciones (*)");
		labelHabitacion.setForeground(COLOR_TEXTO);
		spHabitacion = new JSpinner(modeloHabitacion);
		spHabitacion.addChangeListener(e -> actualizarImporteTotal());

		niños = new JCheckBox("¿Niños?");
		niños.setBackground(new Color(0, 51, 102));
		niños.setForeground(COLOR_TEXTO);
		niños.addActionListener(this);

		extraNiños = new JPanel(new FlowLayout());

		labelEdad = new JLabel("Edad de niños");
		labelEdad.setForeground(COLOR_TEXTO);
		edadNiños = new JSpinner(modeloEdad);

		extras = new JTextArea();
		extras.setText("Cuna");

		labelImporte = new JLabel("Importe Total: ");
		labelImporte.setForeground(COLOR_TEXTO);
		importe = new JTextField("0 €");
		importe.setEditable(false);

		imagenes = new JPanel();
		imagenes.setBackground(new Color(0, 51, 102));
		imagenes.setLayout(new FlowLayout(FlowLayout.CENTER));

		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(3, 1, 3, 3);

		constraints.weightx = 2;
		constraints.weighty = 1;

		this.addComponent(labelTipo, 0, 0, 1, 1);
		this.addComponent(cbTipo, 1, 0, 1, 1);

		this.addComponent(labelHabitacion, 2, 0, 1, 1);
		this.addComponent(spHabitacion, 3, 0, 1, 1);

		this.addComponent(niños, 4, 0, 1, 2);

		extraNiños.add(labelEdad);
		extraNiños.add(edadNiños);
		extraNiños.add(extras, FlowLayout.RIGHT);
		extraNiños.setBackground(new Color(0, 51, 102));
		this.addComponent(extraNiños, 1, 1, 2, 2);
		extraNiños.setVisible(false);

		this.addComponent(labelImporte, 1, 3, 1, 1);
		this.addComponent(importe, 2, 3, 1, 1);

		ImageIcon icono1 = new ImageIcon(getClass().getResource("/recursos/habitacion1.jpg"));
		Image imagen1Escalada = icono1.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagen1 = new JLabel(new ImageIcon(imagen1Escalada));

		ImageIcon icono2 = new ImageIcon(getClass().getResource("/recursos/habitacion2.jpg"));
		Image imagen2Escalada = icono2.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagen2 = new JLabel(new ImageIcon(imagen2Escalada));

		ImageIcon icono3 = new ImageIcon(getClass().getResource("/recursos/habitacion3.jpg"));
		Image imagen3Escalada = icono3.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagen3 = new JLabel(new ImageIcon(imagen3Escalada));

		imagenes.add(imagen1);
		imagenes.add(imagen2);
		imagenes.add(imagen3);
		this.addComponent(imagenes, 0, 4, 5, 2);

		edadNiños.addChangeListener(this);
		panel2Datos.fieldDias.getDocument().addDocumentListener(this);
	}

	/**
	 * Añade el componente.
	 *
	 * @param component the component
	 * @param column    the column
	 * @param row       the row
	 * @param width     the width
	 * @param height    the height
	 */
	private void addComponent(Component component, int column, int row, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		this.add(component);
	}

	/**
	 * Actualizar importe total.
	 */
	private void actualizarImporteTotal() {
		importeTotal = 0;

		if (cbTipo.getSelectedItem() == "Simple") {
			importeTotal += 50;
		} else if (cbTipo.getSelectedItem() == "Doble") {
			importeTotal += 75;
		} else {
			importeTotal += 125;
		}

		if (niños.isSelected()) {
			importeTotal += 20;
		}

		String textoDias = panel2Datos.fieldDias.getText();
		Integer dias = 0;

		try {
			dias = Integer.parseInt(textoDias);

			if (dias < 0) {
				dias = 0;
			}
		} catch (NumberFormatException e) {
			importe.setText("0 €");
		}

		importeTotal = (importeTotal * (Integer) spHabitacion.getValue()) * dias;

		importe.setText(importeTotal.toString() + " €");
	}

	/**
	 * Resetear panel.
	 */
	public void resetearPanel() {
		cbTipo.setSelectedIndex(0);
		spHabitacion.setValue(0);

		niños.setSelected(false);
		extraNiños.setVisible(false);
		edadNiños.setValue(0);
		extras.setText("Cuna");

		importe.setText("0 €");
		actualizarImporteTotal();
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (niños.isSelected()) {
			extraNiños.setVisible(true);
		} else {
			extraNiños.setVisible(false);
		}

		actualizarImporteTotal();
	}

	/**
	 * State changed.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if ((Integer) edadNiños.getValue() >= 0 && (Integer) edadNiños.getValue() <= 3) {
			extras.setText("Cuna");
		} else if ((Integer) edadNiños.getValue() >= 4 && (Integer) edadNiños.getValue() <= 10) {
			extras.setText("Cama supletoria pequeña");
		} else if ((Integer) edadNiños.getValue() >= 11 && (Integer) edadNiños.getValue() <= 14) {
			extras.setText("Cama supletoria normal");
		}
	}

	/**
	 * Insert update.
	 *
	 * @param e the e
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		actualizarImporteTotal();
	}

	/**
	 * Removes the update.
	 *
	 * @param e the e
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		actualizarImporteTotal();
	}

	/**
	 * Changed update.
	 *
	 * @param e the e
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		actualizarImporteTotal();
	}
}
