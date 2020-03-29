package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import kalender.Event;
import kalender.Feiertage;

/**
 * Das Fenster, dass die Feiertage fuer ein bestimmtes Jahr anzeigt.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class FensterFeiertage extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor, fuer das Fenster.
	 * 
	 * @throws HeadlessException
	 */
	public FensterFeiertage() throws HeadlessException {
		this("Feiertage");
	}

	/**
	 * Konstruktor, welcher das Fenster erstellt.
	 * 
	 * @param title
	 * @throws HeadlessException
	 */
	public FensterFeiertage(String title) throws HeadlessException {
		super(title);

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
		textPane.setText(txt());
	}

	/**
	 * Liest die Hash-Map aus und gibt diese als String zurueck.
	 * 
	 * @return feiertage.
	 */
	public String txt() {

		String feiertage = "";
		int jahr = FensterKalender.getInstance().getSelectedItemComboBoxJahre();

		Map<String, Event> feiertageJahr = new Feiertage().getFeiertageJahr(jahr);
		if (feiertageJahr.size() > 0) {
			for (String key : feiertageJahr.keySet()) {
				try {
					Event e = feiertageJahr.get(key);
					feiertage += e.getDatumAsString() + ": " + e.getName();
					feiertage += System.lineSeparator();
				} catch (NullPointerException g) {
				}
			}
		}
		return feiertage;
	}
}