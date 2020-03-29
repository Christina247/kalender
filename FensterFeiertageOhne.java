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
import kalender.KalenderFunktionen;

/**
 * Das Fenster, dass die Feiertage fuer ein bestimmtes Jahr anzeigt. Die
 * Feiertage die sich an einem Samstag oder Sonntag befinden, werden
 * aussortiert.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class FensterFeiertageOhne extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @throws HeadlessException
	 */
	public FensterFeiertageOhne() throws HeadlessException {
		this("Feiertage ohne Samstag und Sonntag");
	}

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @param title
	 * @throws HeadlessException
	 */
	public FensterFeiertageOhne(String title) throws HeadlessException {
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
	 * Legt den Text fuer das Pannel fest. Die Feiertage eines Jahres werden
	 * ausgegeben.
	 * 
	 * @return
	 */
	public String txt() {

		String feiertage = "";
		FensterKalender fk = FensterKalender.getInstance();
		int jahr = fk.getSelectedItemComboBoxJahre();
		Map<String, Event> feiertageJahr = new Feiertage().getFeiertageJahr(jahr);
		int wochennummer = -1;

		if (feiertageJahr.size() > 0) {
			for (String key : feiertageJahr.keySet()) {

				String[] arr = key.split("-");
				String tagstr = arr[0];
				String monatstr = arr[1];
				String jahrstr = arr[2];

				int tagint = Integer.parseInt(tagstr);
				int monatint = Integer.parseInt(monatstr);
				int jahrint = Integer.parseInt(jahrstr);

				wochennummer = KalenderFunktionen.wochennummer(jahr,
						KalenderFunktionen.tagesnummer(tagint, monatint, jahrint));
				if (wochennummer != 0 && wochennummer != 6) {
					try {
						Event e = feiertageJahr.get(key);
						feiertage += e.getDatumAsString() + ": " + e.getName();
						feiertage += System.lineSeparator();
					} catch (NullPointerException g) {
					}
				}
			}
		}
		return feiertage;
	}
}