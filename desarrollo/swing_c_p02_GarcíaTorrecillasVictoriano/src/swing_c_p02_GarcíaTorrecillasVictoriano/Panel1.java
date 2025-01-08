/**
 * Panel1.java
 * 13 nov 2024 11:05:03
 * @author Victoriano García Torrecillas
 */
package swing_c_p02_GarcíaTorrecillasVictoriano;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generado Javadoc
/**
 * La clase Panel1.
 */
public class Panel1 extends JPanel {

	/**
	 * Instancia un nuevo panel 1.
	 */
	public Panel1() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panelCentrado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel titulo = new JLabel("Hotel Tiber Septim");
		titulo.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 22));
		titulo.setForeground(Color.WHITE);

		panelCentrado.setBackground(Color.BLACK);

		panelCentrado.add(titulo);

		this.add(panelCentrado);
	}
}
