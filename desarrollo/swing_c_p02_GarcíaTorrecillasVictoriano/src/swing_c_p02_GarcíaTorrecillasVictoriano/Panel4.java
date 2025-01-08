/**
 * Panel4.java
 * 13 nov 2024 11:05:29
 * @author Victoriano García Torrecillas
 */
package swing_c_p02_GarcíaTorrecillasVictoriano;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

// TODO: Auto-generado Javadoc
/**
 * La Clase Panel4.
 */
public class Panel4 extends JPanel implements ActionListener {

	/** El panel botones. */
	JPanel panelBotones;

	/** Imprimir. */
	JButton imprimir;

	/** Nuevo. */
	JButton nuevo;

	/** Guardar. */
	JButton guardar;

	/** El panel cliente. */
	JPanel panelCliente;

	/** La etiqueta nombre apellidos. */
	JLabel labelNombreApellidos;

	/** El campo texto nombre apellidos. */
	JLabel textFieldNombreApellidos;

	/** La etiqueta dni. */
	JLabel labelDni;

	/** El campo texto dni. */
	JLabel textFieldDni;

	/** La etiqueta telefono. */
	JLabel labelTelefono;

	/** El campo texto telefono. */
	JLabel textFieldTelefono;

	/** La etiqueta fecha entrada. */
	JLabel labelFechaEntrada;

	/** El campo texto fecha entrada. */
	JLabel textFieldFechaEntrada;

	/** La etiqueta fecha salida. */
	JLabel labelFechaSalida;

	/** El campo texto fecha salida. */
	JLabel textFieldFechaSalida;

	/** La etiqueta dias. */
	JLabel labelDias;

	/** El campo texto dias. */
	JLabel textFieldDias;

	/** El panel habitacion. */
	JPanel panelHabitacion;

	/** La etiqueta tipo. */
	JLabel labelTipo;

	/** El campo texto tipo. */
	JLabel textFieldTipo;

	/** La etiqueta habitaciones. */
	JLabel labelHabitaciones;

	/** El campo texto habitaciones. */
	JLabel textFieldHabitaciones;

	/** La etiqueta niños. */
	JLabel labelNiños;

	/** El campo texto niños. */
	JLabel textFieldNiños;

	/** La etiqueta extras. */
	JLabel labelExtras;

	/** El campo texto extras. */
	JLabel textFieldExtras;

	/** La etiqueta importe. */
	JLabel labelImporte;

	/** El campo texto importe. */
	JLabel textFieldImporte;

	/** Las constraints. */
	GridBagConstraints constraints = new GridBagConstraints();

	/** El layout. */
	GridBagLayout layout = new GridBagLayout();

	/** Las constraints 1. */
	GridBagConstraints constraints1 = new GridBagConstraints();

	/** El layout 1. */
	GridBagLayout layout1 = new GridBagLayout();

	/** Las pestañas. */
	JTabbedPane pestañas;

	/** El panel 2 datos. */
	Panel2 panel2Datos; // Esto es para obtener los datos de Panel2

	/** El panel 3 datos. */
	Panel3 panel3Datos; // Esto es para obtener los datos de Panel3

	/**
	 * Instancia un nuevo panel 4.
	 *
	 * @param panel2 the panel 2
	 * @param panel3 the panel 3
	 */
	public Panel4(Panel2 panel2, Panel3 panel3) {
		panel2Datos = panel2;
		panel3Datos = panel3;

		this.setLayout(new BorderLayout());
		this.setBackground(new Color(139, 90, 43));

		panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBotones.setBackground(new Color(139, 90, 43));

		imprimir = new JButton("Imprimir a Documento");
		nuevo = new JButton("Nuevo");
		guardar = new JButton("Guardar");

		imprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/imprimir.png")));
		nuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/nuevo.png")));
		guardar.setIcon(new ImageIcon(getClass().getResource("/recursos/guardar.png")));

		imprimir.addActionListener(this);
		nuevo.addActionListener(this);
		guardar.addActionListener(this);

		panelBotones.add(imprimir);
		panelBotones.add(nuevo);
		panelBotones.add(guardar);

		panelCliente = new JPanel();
		panelCliente.setLayout(layout);

		panelHabitacion = new JPanel();
		panelHabitacion.setLayout(layout1);

		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(3, 1, 3, 3);

		constraints.weightx = 2;
		constraints.weighty = 1;

		constraints1.fill = GridBagConstraints.BOTH;
		constraints1.insets = new Insets(3, 1, 3, 3);

		constraints1.weightx = 2;
		constraints1.weighty = 1;

		labelNombreApellidos = new JLabel();
		textFieldNombreApellidos = new JLabel();

		labelDni = new JLabel();
		textFieldDni = new JLabel();

		labelTelefono = new JLabel();
		textFieldTelefono = new JLabel();

		labelFechaEntrada = new JLabel();
		textFieldFechaEntrada = new JLabel();

		labelFechaSalida = new JLabel();
		textFieldFechaSalida = new JLabel();

		// -----------------------------------------------------------

		labelDias = new JLabel();
		textFieldDias = new JLabel();

		labelTipo = new JLabel();
		textFieldTipo = new JLabel();

		labelHabitaciones = new JLabel();
		textFieldHabitaciones = new JLabel();

		labelNiños = new JLabel();
		textFieldNiños = new JLabel();

		labelExtras = new JLabel();
		textFieldExtras = new JLabel();

		labelImporte = new JLabel();
		textFieldImporte = new JLabel();

		// ---------------------------------------------------------------

		this.addComponentCliente(labelNombreApellidos, 0, 0, 1, 1);
		this.addComponentCliente(textFieldNombreApellidos, 1, 0, 1, 1);

		this.addComponentCliente(labelDni, 0, 1, 1, 1);
		this.addComponentCliente(textFieldDni, 1, 1, 1, 1);

		this.addComponentCliente(labelTelefono, 0, 2, 1, 1);
		this.addComponentCliente(textFieldTelefono, 1, 2, 1, 1);

		this.addComponentCliente(labelFechaEntrada, 0, 3, 1, 1);
		this.addComponentCliente(textFieldFechaEntrada, 1, 3, 1, 1);

		this.addComponentCliente(labelFechaSalida, 0, 4, 1, 1);
		this.addComponentCliente(textFieldFechaSalida, 1, 4, 1, 1);

		this.addComponentCliente(labelDias, 0, 5, 1, 1);
		this.addComponentCliente(textFieldDias, 1, 5, 1, 1);

		// ------------------------------------------------------------------

		this.addComponentHabitacion(labelTipo, 0, 0, 1, 1);
		this.addComponentHabitacion(textFieldTipo, 1, 0, 1, 1);

		this.addComponentHabitacion(labelHabitaciones, 0, 1, 1, 1);
		this.addComponentHabitacion(textFieldHabitaciones, 1, 1, 1, 1);

		this.addComponentHabitacion(labelNiños, 0, 2, 1, 1);
		this.addComponentHabitacion(textFieldNiños, 1, 2, 1, 1);

		this.addComponentHabitacion(labelExtras, 0, 3, 1, 1);
		this.addComponentHabitacion(textFieldExtras, 1, 3, 1, 1);

		this.addComponentHabitacion(labelImporte, 0, 4, 1, 1);
		this.addComponentHabitacion(textFieldImporte, 1, 4, 1, 1);

		pestañas = new JTabbedPane();
		pestañas.addTab("Datos del cliente", panelCliente);
		pestañas.addTab("Datos de la Habitación", panelHabitacion);

		this.add(panelBotones, BorderLayout.NORTH);
		this.add(pestañas, BorderLayout.CENTER);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == imprimir) {
			labelNombreApellidos.setText("Nombre: ");
			textFieldNombreApellidos
					.setText(panel2Datos.fieldNombre.getText() + " " + panel2Datos.fieldApellidos.getText());

			labelDni.setText("DNI: ");
			textFieldDni.setText(panel2Datos.fieldDni.getText());

			labelTelefono.setText("Telefono: ");
			textFieldTelefono.setText(panel2Datos.fieldTelefono.getText());

			labelFechaEntrada.setText("Fecha de entrada: ");
			textFieldFechaEntrada.setText(panel2Datos.fieldFechaEntrada.getText());

			labelFechaSalida.setText("Fecha de salida: ");
			textFieldFechaSalida.setText(panel2Datos.fieldFechaSalida.getText());

			labelDias.setText("Dias restantes: ");
			textFieldDias.setText(panel2Datos.fieldDias.getText());

			// ------------------------------------------------------------------
			labelTipo.setText("Tipo de habitacion: ");
			textFieldTipo.setText((String) panel3Datos.cbTipo.getSelectedItem());

			labelHabitaciones.setText("Nº de habitaciones: ");
			textFieldHabitaciones.setText(panel3Datos.spHabitacion.getValue().toString());

			labelNiños.setText("Niños: ");
			labelExtras.setText("Extras: ");
			if (panel3Datos.niños.isSelected()) {
				textFieldNiños.setText("Si");
				textFieldExtras.setText(panel3Datos.extras.getText());
			} else {
				textFieldNiños.setText("No");
				textFieldExtras.setText("X");
			}

			labelImporte.setText("Importe: ");
			textFieldImporte.setText(panel3Datos.importe.getText());
		}

		if (e.getSource() == nuevo) {
			panel2Datos.resetearPanel();
			panel3Datos.resetearPanel();
			resetearPanel();
		}

		if (e.getSource() == guardar) {
			Boolean hayErrores = false;

			if (panel2Datos.fieldNombre.getText().trim().isEmpty()) {
				hayErrores = true;
				JOptionPane.showMessageDialog(this, "EL CAMPO NOMBRE ES OBLIGATORIO", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			if (panel2Datos.fieldApellidos.getText().trim().isEmpty()) {
				hayErrores = true;
				JOptionPane.showMessageDialog(this, "EL CAMPO APELLIDOS ES OBLIGATORIO", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			if (!panel2Datos.fieldDni.getText().trim().isEmpty()) {
				if (panel2Datos.fieldDni.getText().trim().length() != 9) {
					hayErrores = true;
					JOptionPane.showMessageDialog(this, "EL CAMPO DNI DEBE SER UN DNI REAL", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			if (!panel2Datos.fieldTelefono.getText().trim().isEmpty()) {
				if (panel2Datos.fieldTelefono.getText().trim().length() != 9) {
					hayErrores = true;
					JOptionPane.showMessageDialog(this, "EL CAMPO TELEFONO DEBE TENER NUEVE DIGITOS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			if (panel2Datos.fieldNombre.getText().trim().isEmpty()
					|| panel2Datos.fieldApellidos.getText().trim().isEmpty()
					|| panel2Datos.fieldTelefono.getText().trim().isEmpty()
					|| panel3Datos.importe.getText().trim().equals("0 €")) {
				hayErrores = true;
				JOptionPane.showMessageDialog(this, "DEBE COMPLETAR LOS CAMPOS CON LA MARCA (*)", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			if (hayErrores.equals(false)) {
				JOptionPane.showMessageDialog(this, "REGISTRO GUARDADO", "EXITO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Resetear panel.
	 */
	public void resetearPanel() {
		labelNombreApellidos.setText("");
		textFieldNombreApellidos.setText("");

		labelDni.setText("");
		textFieldDni.setText("");

		labelTelefono.setText("");
		textFieldTelefono.setText("");

		labelFechaEntrada.setText("");
		textFieldFechaEntrada.setText("");

		labelFechaSalida.setText("");
		textFieldFechaSalida.setText("");

		labelDias.setText("");
		textFieldDias.setText("");

		labelTipo.setText("");
		textFieldTipo.setText("");

		labelHabitaciones.setText("");
		textFieldHabitaciones.setText("");

		labelNiños.setText("");
		textFieldNiños.setText("");

		labelExtras.setText("");
		textFieldExtras.setText("");

		labelImporte.setText("");
		textFieldImporte.setText("");
	}

	/**
	 * Añade componentes al panel cliente.
	 *
	 * @param component the component
	 * @param column    the column
	 * @param row       the row
	 * @param width     the width
	 * @param height    the height
	 */
	private void addComponentCliente(Component component, int column, int row, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;

		layout.setConstraints(component, constraints);
		panelCliente.add(component);
	}

	/**
	 * Añade componentes al panel habitacion.
	 *
	 * @param component1 the component 1
	 * @param column     the column
	 * @param row        the row
	 * @param width      the width
	 * @param height     the height
	 */
	private void addComponentHabitacion(Component component1, int column, int row, int width, int height) {
		constraints1.gridx = column;
		constraints1.gridy = row;
		constraints1.gridwidth = width;
		constraints1.gridheight = height;

		layout1.setConstraints(component1, constraints1);
		panelHabitacion.add(component1);
	}
}
