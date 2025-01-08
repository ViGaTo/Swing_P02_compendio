/**
 * VentanaDialogo.java
 * 13 nov 2024 10:44:10
 * @author Victoriano García Torrecillas
 */
package swing_c_p02_GarcíaTorrecillasVictoriano;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

// TODO: Auto-generado Javadoc
/**
 * La clase VentanaDialogo.
 */
public class VentanaDialogo extends JDialog {

	/** El panel 1. */
	Panel1 panel1;

	/** El panel 2. */
	Panel2 panel2;

	/** El panel 3. */
	Panel3 panel3;

	/** El panel 4. */
	Panel4 panel4;

	/**
	 * Instancia una nueva ventana dialogo.
	 *
	 * @param parent the parent
	 */
	public VentanaDialogo(JFrame parent) {
		super(parent, "Altas Reservas", true);
		Image miIcono = new ImageIcon(getClass().getResource("/recursos/vigato.png")).getImage();

		// this.setSize(parent.getSize());
		// this.setLocation(parent.getLocation());

		int width = (int) (parent.getWidth() * 1.5);
		int height = (int) (parent.getHeight() * 1.5);
		this.setSize(width, height);
		setLocationRelativeTo(parent);
		this.setIconImage(miIcono);

		this.setLayout(new BorderLayout());

		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

		panel1 = new Panel1();
		this.add(panel1, BorderLayout.NORTH);

		panel2 = new Panel2();
		panelCentro.add(panel2);

		panel3 = new Panel3(panel2);
		panelCentro.add(panel3);

		panel4 = new Panel4(panel2, panel3);
		panelCentro.add(panel4);

		this.add(panelCentro, BorderLayout.CENTER);

		this.setVisible(true);
	}
}
