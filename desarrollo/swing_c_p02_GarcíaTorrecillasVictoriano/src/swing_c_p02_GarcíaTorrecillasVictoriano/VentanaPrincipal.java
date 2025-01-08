/**
 * VentanaPrincipal.java
 * 12 nov 2024 19:05:48
 * @author Victoriano García Torrecillas
 */
package swing_c_p02_GarcíaTorrecillasVictoriano;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

// TODO: Auto-generado Javadoc
/**
 * La clase VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame {

	/** La ventana dialogo. */
	JDialog ventanaDialogo;

	/**
	 * Instancia una nueva ventana principal.
	 */
	public VentanaPrincipal() {
		super("Gestión Hotel Tiber Septim");

		JMenuBar barraMenu = new JMenuBar();

		JMenu archivo = new JMenu("Archivo");
		JMenu registro = new JMenu("Registro");
		JMenu ayuda = new JMenu("Ayuda");

		JMenuItem salir = new JMenuItem("Salir");

		JMenuItem altas_reservas = new JMenuItem("Altas Reservas");
		JMenuItem bajas_reservas = new JMenuItem("Bajas Reservas");

		JMenuItem acercaDe = new JMenuItem("Acerca de...");

		JButton btnAltasReservas = new JButton("Altas Reservas");
		JButton btnBajasReservas = new JButton("Bajas Reservas");

		btnAltasReservas.setIcon(new ImageIcon(getClass().getResource("/recursos/anadir.png")));
		btnBajasReservas.setIcon(new ImageIcon(getClass().getResource("/recursos/eliminar.png")));

		Image miIcono = new ImageIcon(getClass().getResource("/recursos/vigato.png")).getImage();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();

		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		this.setSize(anchoPantalla / 2, altoPantalla / 2);
		this.setLocation(anchoPantalla / 4, altoPantalla / 4);

		salir.addActionListener((ActionEvent e) -> {
			this.dispose();
		});

		registro.setMnemonic(KeyEvent.VK_G);

		this.setJMenuBar(barraMenu);
		barraMenu.add(archivo);
		barraMenu.add(registro);
		barraMenu.add(ayuda);

		archivo.add(salir);

		registro.add(altas_reservas);
		registro.add(bajas_reservas);

		ayuda.add(acercaDe);

		altas_reservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
		altas_reservas.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(this,
					"Cargando, por favor pulse OK y espere... \\n (Este es el componente nuevo, al ser un Timer no puedo ponerle un ToolTipText).",
					"CARGANDO...", JOptionPane.WARNING_MESSAGE);

			Timer timer = new Timer(5000, i -> {
				new VentanaDialogo(this);
			});

			timer.setRepeats(false);
			timer.start();
		});

		bajas_reservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
		bajas_reservas.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(this,
					"ESTA OPCION TODAVIA ESTA EN DESARROLLO, PULSE EN OK PARA CERRAR ESTA VENTANA", "EN DESARROLLO",
					JOptionPane.ERROR_MESSAGE);
		});

		acercaDe.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(this,
					"El interior del hotel cuenta con muebles de alta calidad, tapices ricos en detalles y paredes decoradas con esculturas y cuadros que recuerdan la grandeza del Imperio.\nLos pasillos y habitaciones están bien iluminados y cuidadosamente decorados, ofreciendo una experiencia de alojamiento sofisticada.\nLa recepción y áreas comunes son atendidas por un personal educado que asegura una estadía cómoda y sin inconvenientes.\n \n Aplicación desarrollada por ViGaTo (Victoriano García Torrecillas)",
					"Hotel Tiber Septim", JOptionPane.INFORMATION_MESSAGE);
		});

		btnBajasReservas.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(this,
					"ESTA OPCION TODAVIA ESTA EN DESARROLLO, PULSE EN OK PARA CERRAR ESTA VENTANA", "EN DESARROLLO",
					JOptionPane.ERROR_MESSAGE);
		});

		btnAltasReservas.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(this,
					"Cargando, por favor pulse OK y espere... \n (Este es el componente nuevo, al ser un Timer no puedo ponerle un ToolTipText).",
					"CARGANDO...", JOptionPane.WARNING_MESSAGE);

			Timer timer = new Timer(5000, i -> {
				new VentanaDialogo(this);
			});

			timer.setRepeats(false);
			timer.start();
		});

		this.add(btnAltasReservas);
		this.add(btnBajasReservas);

		this.setIconImage(miIcono);
		this.setVisible(true);
	}
}
