/**
 * Panel2.java
 * 13 nov 2024 11:05:11
 * @author Victoriano García Torrecillas
 */
package swing_c_p02_GarcíaTorrecillasVictoriano;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generado Javadoc
/**
 * La clase Panel2.
 */
public class Panel2 extends JPanel implements DocumentListener {

	/** La etiqueta nombre. */
	JLabel labelNombre;

	/** El campo nombre. */
	public JTextField fieldNombre;

	/** La etiqueta apellidos. */
	JLabel labelApellidos;

	/** El campo apellidos. */
	public JTextField fieldApellidos;

	/** La etiqueta dni. */
	JLabel labelDni;

	/** El campo dni. */
	public JFormattedTextField fieldDni;

	/** La etiqueta telefono. */
	JLabel labelTelefono;

	/** El campo telefono. */
	public JFormattedTextField fieldTelefono;

	/** La etiqueta fecha entrada. */
	JLabel labelFechaEntrada;

	/** El campo fecha entrada. */
	public JFormattedTextField fieldFechaEntrada;

	/** La etiqueta fecha salida. */
	JLabel labelFechaSalida;

	/** El campo fecha salida. */
	public JFormattedTextField fieldFechaSalida;

	/** La etiqueta dias. */
	JLabel labelDias;

	/** el campo dias. */
	public JTextField fieldDias;

	/** La mascara dni. */
	MaskFormatter mascaraDni;

	/** La mascara nueve digitos. */
	MaskFormatter mascaraNueveDigitos;

	/** La mascara fecha. */
	MaskFormatter mascaraFecha;

	/** Los constraints. */
	GridBagConstraints constraints = new GridBagConstraints();

	/** El layout. */
	GridBagLayout layout = new GridBagLayout();

	/** La constante COLOR_TEXTO. */
	public static final Color COLOR_TEXTO = new Color(212, 175, 55);

	/**
	 * Instancia un nuevo panel 2.
	 */
	public Panel2() {
		this.setLayout(layout);
		this.setBackground(new Color(245, 245, 220));

		labelNombre = new JLabel("Nombre (*): ");
		labelNombre.setForeground(COLOR_TEXTO);
		fieldNombre = new JTextField();

		labelApellidos = new JLabel("Apellidos (*): ");
		labelApellidos.setForeground(COLOR_TEXTO);
		fieldApellidos = new JTextField();

		labelDni = new JLabel("DNI: ");
		labelDni.setForeground(COLOR_TEXTO);
		try {
			mascaraDni = new MaskFormatter("########U");
			fieldDni = new JFormattedTextField(mascaraDni);
			fieldDni.setFocusLostBehavior(fieldDni.COMMIT);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		labelTelefono = new JLabel("Teléfono (*): ");
		labelTelefono.setForeground(COLOR_TEXTO);
		try {
			mascaraNueveDigitos = new MaskFormatter("#########");
			fieldTelefono = new JFormattedTextField(mascaraNueveDigitos);
			fieldTelefono.setFocusLostBehavior(fieldTelefono.COMMIT);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		labelFechaEntrada = new JLabel("Fecha de entrada (*): ");
		labelFechaEntrada.setForeground(COLOR_TEXTO);
		try {
			mascaraFecha = new MaskFormatter("##/##/####");
			fieldFechaEntrada = new JFormattedTextField(mascaraFecha);
			fieldFechaEntrada.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));
			fieldFechaEntrada.setFocusLostBehavior(fieldFechaEntrada.COMMIT);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		labelFechaSalida = new JLabel("Fecha de salida (*): ");
		labelFechaSalida.setForeground(COLOR_TEXTO);
		try {
			mascaraFecha = new MaskFormatter("##/##/####");
			fieldFechaSalida = new JFormattedTextField(mascaraFecha);
			fieldFechaSalida.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now().plusDays(1)));
			fieldFechaSalida.setFocusLostBehavior(fieldFechaEntrada.COMMIT);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		labelDias = new JLabel("Días de estancia: ");
		labelDias.setForeground(COLOR_TEXTO);
		fieldDias = new JTextField();
		fieldDias.setEditable(false);

		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(3, 1, 3, 3);

		constraints.weightx = 2;
		constraints.weighty = 1;

		this.addComponent(labelNombre, 0, 0, 1, 1);
		this.addComponent(fieldNombre, 1, 0, 1, 1);

		this.addComponent(labelApellidos, 2, 0, 1, 1);
		this.addComponent(fieldApellidos, 3, 0, 1, 1);

		this.addComponent(labelDni, 0, 1, 1, 1);
		this.addComponent(fieldDni, 1, 1, 1, 1);

		this.addComponent(labelTelefono, 2, 1, 1, 1);
		this.addComponent(fieldTelefono, 3, 1, 1, 1);

		this.addComponent(labelFechaEntrada, 0, 2, 1, 1);
		this.addComponent(fieldFechaEntrada, 1, 2, 1, 1);

		this.addComponent(labelFechaSalida, 2, 2, 1, 1);
		this.addComponent(fieldFechaSalida, 3, 2, 1, 1);

		this.addComponent(labelDias, 0, 3, 1, 1);
		this.addComponent(fieldDias, 1, 3, 3, 1);

		fieldDias.setText("1");

		fieldFechaEntrada.getDocument().addDocumentListener(this);
		fieldFechaSalida.getDocument().addDocumentListener(this);
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
	 * Actualizar dias restantes.
	 */
	public void actualizarDiasRestantes() {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate fechaEntrada = LocalDate.parse(fieldFechaEntrada.getText(), formatoFecha);
			LocalDate fechaSalida = LocalDate.parse(fieldFechaSalida.getText(), formatoFecha);
			long diasRestantes = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);

			if (diasRestantes <= 0) {
				fieldDias.setText(
						"Modifique las fechas, de tal manera que la fecha de entrada sea menor a la de salida...");
			} else {
				fieldDias.setText(String.valueOf(diasRestantes));
			}
		} catch (Exception e) {
			fieldDias.setText("El formato debe ser Dia/Mes/Año (el año debe ser de cuatro digitos...)");
		}
	}

	/**
	 * Resetear panel.
	 */
	public void resetearPanel() {
		fieldNombre.setText("");
		fieldApellidos.setText("");

		fieldDni.setText("");
		fieldTelefono.setText("");
		fieldFechaEntrada.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));
		fieldFechaSalida.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now().plusDays(1)));
		fieldDias.setText("1");
	}

	/**
	 * Insert update.
	 *
	 * @param e the e
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		actualizarDiasRestantes();
	}

	/**
	 * Removes the update.
	 *
	 * @param e the e
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		actualizarDiasRestantes();
	}

	/**
	 * Changed update.
	 *
	 * @param e the e
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		actualizarDiasRestantes();
	}
}
