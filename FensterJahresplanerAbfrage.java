package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Klasse fuer das Fenster, welche die Abfrage fuer das Fenster anzeigt.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 *
 */
public class FensterJahresplanerAbfrage extends JFrame {

	// Konstanten
	private static final long serialVersionUID = 1L;
	public static final String[] MODUS = { "Mit Feiertag ", "Ohne Feiertag" };
	public static final String[] STRLABEL = { "Jahr:        ", "Von:         ", "Bis:         ", "Modus:       " };

	// Attribute
	private JTextField txtJahr = new JTextField(10);
	private JTextField txtVon = new JTextField(10);
	private JTextField txtBis = new JTextField(10);
	private JTextField txtModus = new JTextField(10);
	private JComboBox<Integer> cbJahre = new JComboBox<>();
	private JComboBox<Integer> cbVon = new JComboBox<>();
	private JComboBox<Integer> cbBis = new JComboBox<>();
	private JComboBox<String> cbModus = new JComboBox<>();
	private JPanel pnlMitte = new JPanel();
	private JLabel[] label = new JLabel[STRLABEL.length];
	private JButton button = new JButton("OK");

	// weitere Attribute
	private Calendar cal = Calendar.getInstance();
	private static FensterJahresplanerAbfrage instance = null;

	/**
	 * Singleton.
	 * 
	 * @return
	 */
	public static FensterJahresplanerAbfrage getInstance() {
		if (instance == null) {
			instance = new FensterJahresplanerAbfrage();
		}
		return instance;
	}

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @throws HeadlessException
	 */
	private FensterJahresplanerAbfrage() throws HeadlessException {
		this("Einstellungen");
	}

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @param title
	 * @throws HeadlessException
	 */
	private FensterJahresplanerAbfrage(String title) throws HeadlessException {
		super(title);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(300, 300));
		this.setLocationRelativeTo(null);

		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(pnlMitte, BorderLayout.CENTER);
		GridBagLayout grid = new GridBagLayout();
		pnlMitte.setLayout(grid);

		labelJahre();
		comboBoxJahre();
		labelVon();
		comboBoxVon();
		labelBis();
		comboBoxBis();
		labelModus();
		comboBoxModus();
		buttonOK();

		this.pack();
	}

	/**
	 * Methode, fuer das Label.
	 */
	public void labelJahre() {
		GridBagConstraints constrWest4 = new GridBagConstraints();
		constrWest4.gridx = 0;
		constrWest4.gridy = 10;
		constrWest4.anchor = GridBagConstraints.WEST;
		for (int i = 0; i < 1; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlMitte.add(label[i], constrWest4);
		}
	}

	/**
	 * Methode fuer die ComboBox.
	 */
	public void comboBoxJahre() {
		GridBagConstraints constrWest1 = new GridBagConstraints();
		constrWest1.gridx = 10;
		constrWest1.gridy = 10;
		this.cbJahrefuellen(cbJahre);
		cbJahre.setPreferredSize(new Dimension(110, 20));
		cbJahre.setSelectedItem(new Integer(cal.get(Calendar.YEAR)));
		pnlMitte.add(cbJahre, constrWest1);
	}

	/**
	 * Methode fuer das Label.
	 */
	public void labelVon() {
		GridBagConstraints constrWest5 = new GridBagConstraints();
		constrWest5.gridx = 0;
		constrWest5.gridy = 20;
		constrWest5.anchor = GridBagConstraints.WEST;
		for (int i = 1; i < 2; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlMitte.add(label[i], constrWest5);
		}
	}

	/**
	 * Methode fuer die ComboBox.
	 */
	public void comboBoxVon() {
		GridBagConstraints constrWest2 = new GridBagConstraints();
		constrWest2.gridx = 10;
		constrWest2.gridy = 20;
		this.cbVonfuellen(cbVon);
		cbVon.setPreferredSize(new Dimension(110, 20));
		pnlMitte.add(cbVon, constrWest2);
		cbVon.setSelectedItem(new Integer(cal.get(Calendar.MONTH) + 1));
	}

	/**
	 * Methode fuer das Label.
	 */
	public void labelBis() {
		GridBagConstraints constrWest6 = new GridBagConstraints();
		constrWest6.gridx = 0;
		constrWest6.gridy = 30;
		constrWest6.anchor = GridBagConstraints.WEST;
		for (int i = 2; i < 3; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlMitte.add(label[i], constrWest6);
		}
	}

	/**
	 * Methode fuer die ComboBox.
	 */
	public void comboBoxBis() {
		GridBagConstraints constrWest3 = new GridBagConstraints();
		constrWest3.gridx = 10;
		constrWest3.gridy = 30;
		this.cbBisfuellen(cbBis);
		pnlMitte.add(cbBis, constrWest3);
		cbBis.setPreferredSize(new Dimension(110, 20));
		cbBis.setSelectedItem(new Integer(cal.get(Calendar.MONTH) + 1));
	}

	/**
	 * Methode fuer das Label.
	 */
	public void labelModus() {
		GridBagConstraints constrWest7 = new GridBagConstraints();
		constrWest7.gridx = 0;
		constrWest7.gridy = 40;
		constrWest7.anchor = GridBagConstraints.WEST;
		for (int i = 3; i < 4; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlMitte.add(label[i], constrWest7);
		}
	}

	/**
	 * Methode fuer die ComboBox.
	 */
	public void comboBoxModus() {
		GridBagConstraints constrWest8 = new GridBagConstraints();
		constrWest8.gridx = 10;
		constrWest8.gridy = 40;
		this.cbModusfuellen(cbModus);
		cbModus.setPreferredSize(new Dimension(110, 20));
		pnlMitte.add(cbModus, constrWest8);
	}

	/**
	 * Methode fuer den Button.
	 */
	public void buttonOK() {
		GridBagConstraints constrWest9 = new GridBagConstraints();
		constrWest9.gridwidth = GridBagConstraints.REMAINDER;
		constrWest9.anchor = GridBagConstraints.EAST;
		constrWest9.gridx = 10;
		constrWest9.gridy = 50;
		constrWest9.fill = GridBagConstraints.BOTH;
		pnlMitte.add(button, constrWest9);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FensterJahresplaner fj = new FensterJahresplaner();
				fj.setVisible(true);
				instance.setVisible(false);
			}
		});
	}

	/**
	 * Methode, welche das ausgewaehlte Jahr zurueck gibt.
	 * 
	 * @return Jahr von dem gestartet werden soll.
	 */
	public int getSelectedItemComboBoxJahre() {
		return (int) this.cbJahre.getSelectedItem();
	}

	/**
	 * Methode, welche den ausgewaehlten Monat von dem gestartet wird, zurueck
	 * gibt.
	 * 
	 * @return Monat von dem gestartet werden soll.
	 */
	public int getSelectedItemComboBoxVon() {
		return (int) this.cbVon.getSelectedItem();
	}

	/**
	 * Methode, welche den ausgewaehlten Monat bis der Jahresplaner gehen soll,
	 * zurueck gibt.
	 * 
	 * @return Monat wie weit der Jahresplaner gehen soll.
	 */
	public int getSelectedItemComboBoxBis() {
		return (int) this.cbBis.getSelectedItem();
	}

	/**
	 * Methode, welche den ausgewaehlten Modus in Integerwerten zurueck gibt.
	 * 
	 * @return Modus.
	 */
	public int getSelectedItemComboBoxModus() {
		return this.cbModus.getSelectedIndex();
	}

	/**
	 * Fuellt die Combobox mit Jahren.
	 * 
	 * @param cbJahre
	 * @return cbJahre
	 */
	private JComboBox<Integer> cbJahrefuellen(JComboBox<Integer> cbJahre) {
		for (int i = 1582; i < 2801; i++) {
			cbJahre.addItem(new Integer(i));
		}
		return cbJahre;
	}

	/**
	 * Fuellt die ComboBox mit Monaten.
	 * 
	 * @param cbVon
	 * @return cbVon
	 */
	private JComboBox<Integer> cbVonfuellen(JComboBox<Integer> cbVon) {
		for (int i = 1; i <= 12; i++) {
			cbVon.addItem(new Integer(i));
		}
		return cbVon;
	}

	/**
	 * Fuellt die ComboBox mit Monaten.
	 * 
	 * @param cbBis
	 * @return cbBis
	 */
	private JComboBox<Integer> cbBisfuellen(JComboBox<Integer> cbBis) {
		for (int i = 1; i <= 12; i++) {
			cbBis.addItem(new Integer(i));
		}
		return cbBis;
	}

	/**
	 * Fuellt die ComboBox mit Strings, ob der Jahresplaner mit oder ohne
	 * Feiertage ausgegeben werden soll.
	 * 
	 * @param cbModus
	 * @return cbModus
	 */
	private JComboBox<String> cbModusfuellen(JComboBox<String> cbModus) {
		for (int index = 0; index < MODUS.length; index++) {
			cbModus.addItem(MODUS[index]);
		}
		return cbModus;
	}

	/**
	 * Fuellt das Textfeld.
	 * 
	 * @param string
	 */
	public void fuelleTextFeldJahr(String string) {
		txtJahr.setText(string);
	}

	/**
	 * Fuellt das Textfeld.
	 * 
	 * @param string
	 */
	public void fuelleTextFeldVon(String string) {
		txtVon.setText(string);
	}

	/**
	 * Fuellt das Textfeld.
	 * 
	 * @param string
	 */
	public void fuelleTextFeldBis(String string) {
		txtBis.setText(string);
	}

	/**
	 * Fuellt das Textfeld.
	 * 
	 * @param string
	 */
	public void fuelleTextFeldModus(String string) {
		txtModus.setText(string);
	}
}