package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 *
 */
public class FensterEingeleseneGeburtstage extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @param title
	 * @throws HeadlessException
	 */
	public FensterEingeleseneGeburtstage(String title) throws HeadlessException {

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(1000, 650));
		this.setLocationRelativeTo(null);

		Container container = this.getContentPane();
		JTextPane textPane = new JTextPane();
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPain = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(textPane);
		container.setLayout(new BorderLayout());
		textPane.setEditable(false);
		textPane.setFont(new Font("monospaced", Font.PLAIN, 12));
		container.add(scrollPain, BorderLayout.CENTER);
		this.pack();
		textPane.setText(title);
	}
}