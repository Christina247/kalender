package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import kalender.Kalender;

/**
 * Klasse welches das Hauptfenster erstellt.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class FensterKalender extends JFrame {

	// Konstanten
	private static final long serialVersionUID = 1L;
	public static final String[] STRRADIOBUTTON = { "Kalender fuer das ganze Jahr ohne Feiertage",
			"Ausgabe Monatsblatt ohne Feiertage", "Kalender fuer das ganze Jahr mit Feiertagen",
			"Ausgabe Monatsblatt mit Feiertagen" };
	public static final String[] STRCHECKBOX = { "Format wechseln?" };
	public static final String[] STRLABEL = { "Bitte auswaehlen:", "Monat:", "Jahr:", "Wochenbeginn mit So/Mo",
			"Aktion waehlen:" };
	public static final String[] STRMONATE = { "   ", "Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli",
			"August", "September", "Oktober", "November", "Dezember" };

	// Attribute
	private JRadioButton[] radioButton = new JRadioButton[STRRADIOBUTTON.length];
	private JCheckBox[] checkBox = new JCheckBox[STRCHECKBOX.length];
	private JLabel[] label = new JLabel[STRLABEL.length];
	private JLabel picLab = new JLabel();
	private JComboBox<String> comboBoxMonate = new JComboBox<>();
	private JComboBox<Integer> comboBoxJahre = new JComboBox<>();
	private static JTextPane textPane = new JTextPane();
	private ButtonGroup buttongrp = new ButtonGroup();

	// Weitere Attribute
	private Calendar cal = Calendar.getInstance();
	private Container container = this.getContentPane();
	private static FensterKalender instance = null;

	// Panel
	private JPanel pnlNord = new JPanel();
	private JPanel pnlOst = new JPanel();
	private JPanel pnlSued = new JPanel();
	private JPanel pnlWest = new JPanel();
	private JPanel pnlMitte = new JPanel();

	/**
	 * Singleton
	 * 
	 * @return instance
	 */
	public static FensterKalender getInstance() {
		if (instance == null) {
			instance = new FensterKalender();
		}
		return instance;
	}

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @throws HeadlessException
	 */
	private FensterKalender() throws HeadlessException {
		this("Kalender");
	}

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @param title
	 * @throws HeadlessException
	 */
	private FensterKalender(String title) throws HeadlessException {
		super(title);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1000, 650));
		this.setLocationRelativeTo(null);
		this.setJMenuBar(new MenueKalender(this));

		container.setLayout(new BorderLayout());

		// Alle Panel auf die ContentPane legen
		container.add(pnlNord, BorderLayout.NORTH);
		container.add(pnlOst, BorderLayout.EAST);
		container.add(pnlSued, BorderLayout.SOUTH);
		container.add(pnlWest, BorderLayout.WEST);
		container.add(pnlMitte, BorderLayout.CENTER);

		// Panel mit Raendern versehen
		pnlSued.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
		pnlWest.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
		pnlMitte.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));

		// Layout fuer die Panel
		GridBagLayout grid = new GridBagLayout();
		pnlNord.setLayout(grid);
		pnlOst.setLayout(grid);
		pnlSued.setLayout(grid);
		pnlWest.setLayout(grid);

		panelOst();
		panelWest();
		panelMitte();

		// Abschliessend
		this.pack();
		auswahl();

	}

	/**
	 * Methode fuer das PanelOst.
	 */
	public void panelOst() {

		// Panel Ost - Label - "Aktion waehlen"
		GridBagConstraints constrEast1 = new GridBagConstraints();
		constrEast1.gridx = 0;
		constrEast1.gridy = 0;
		constrEast1.anchor = GridBagConstraints.WEST;
		for (int i = 4; i <= 4; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlOst.add(label[i], constrEast1);
		}
		radioButton();
	}

	/**
	 * Methode fuer den Radio Button.
	 */
	public void radioButton() {
		// Panel Ost - RadioButtons
		GridBagConstraints constrEast2 = new GridBagConstraints();
		constrEast2.gridx = 0;
		constrEast2.gridy = 10;
		constrEast2.anchor = GridBagConstraints.WEST;
		for (int i = 0; i < radioButton.length; i++) {
			radioButton[i] = new JRadioButton(STRRADIOBUTTON[i]);
			buttongrp.add(radioButton[i]);
			constrEast2.gridy += 10;
			pnlOst.add(radioButton[i], constrEast2);
			radioButton[i].addActionListener(new ActionListenerRadioButton(this));
		}
		radioButton[0].setSelected(true);
	}

	/**
	 * Methode fuer das Panel West.
	 */
	public void panelWest() {

		label5();
		label4();
		label3();
		comboBoxMonate();
		comboBoxJahre();
		bild();
		label2();
		checkBox();

	}

	/**
	 * Methode fuer das Label.
	 */
	public void label5() {
		// Panel West - Label - "Bitte auswaehlen"
		GridBagConstraints constrWest1 = new GridBagConstraints();
		constrWest1.insets = new Insets(0, 10, 2, 0);
		constrWest1.gridx = 0;
		constrWest1.gridy = 0;
		constrWest1.anchor = GridBagConstraints.WEST;
		for (int i = 0; i <= 0; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlWest.add(label[i], constrWest1);
		}
	}

	/**
	 * Methode fuer das Label.
	 */
	public void label4() {
		// Panel West - Label "Monat:"
		GridBagConstraints constrWest2 = new GridBagConstraints();
		constrWest2.insets = new Insets(0, 10, 0, 0);
		constrWest2.gridx = 0;
		constrWest2.gridy = 10;
		constrWest2.anchor = GridBagConstraints.WEST;
		for (int i = 1; i <= 1; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlWest.add(label[i], constrWest2);
		}
	}

	/**
	 * Methode fuer das Label.
	 */
	public void label3() {
		// Panel West - Label - "Jahr:"
		GridBagConstraints constrWest3 = new GridBagConstraints();
		constrWest3.insets = new Insets(0, -56, 0, 0);
		constrWest3.gridx = 10;
		constrWest3.gridy = 10;
		constrWest3.anchor = GridBagConstraints.WEST;
		for (int i = 2; i <= 2; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlWest.add(label[i], constrWest3);
		}
	}

	/**
	 * Methode fuer die ComboBox.
	 */
	public void comboBoxMonate() {
		// Panel West - ComboBoxMonate
		ItemListenerComboBoxMonate itemListenerComboBoxMonate = new ItemListenerComboBoxMonate();
		GridBagConstraints constrWest4 = new GridBagConstraints();
		constrWest4.insets = new Insets(0, 10, 2, 0);
		constrWest4.gridx = 0;
		constrWest4.gridy = 20;
		constrWest4.anchor = GridBagConstraints.WEST;
		this.cbMonatfuellen(comboBoxMonate);
		comboBoxMonate.setSelectedItem(STRMONATE[cal.get(Calendar.MONTH) + 1]);
		comboBoxMonate.addItemListener(itemListenerComboBoxMonate);
		pnlWest.add(comboBoxMonate, constrWest4);
	}

	/**
	 * Methode fuer die ComboBox.
	 */
	public void comboBoxJahre() {
		// Panel West - ComboBoxJahre
		ItemListenerComboBoxJahre itemListenerComboBoxJahre = new ItemListenerComboBoxJahre();
		GridBagConstraints constrWest5 = new GridBagConstraints();
		constrWest5.insets = new Insets(0, -56, 2, 10);
		constrWest5.gridx = 10;
		constrWest5.gridy = 20;
		this.cbJahrefuellen(comboBoxJahre);
		comboBoxJahre.setSelectedItem(new Integer(cal.get(Calendar.YEAR)));
		comboBoxJahre.addItemListener(itemListenerComboBoxJahre);
		pnlWest.add(comboBoxJahre, constrWest5);
	}

	/**
	 * Methode fuer das Bild.
	 */
	public void bild() {
		// Panel West - Bild
		ImageIcon icon = new ImageIcon(".\\meineBilder\\Ewiger_Kalender.jpg");
		GridBagConstraints constrWest6 = new GridBagConstraints();
		constrWest6.insets = new Insets(0, 10, 0, 2);
		constrWest6.gridx = 0;
		constrWest6.gridy = 30;
		constrWest6.anchor = GridBagConstraints.WEST;
		icon.setImage(icon.getImage().getScaledInstance(200, -1, Image.SCALE_DEFAULT));
		picLab.setIcon(icon);
		pnlWest.add(picLab, constrWest6);
	}

	/**
	 * Methode fuer das Label.
	 */
	public void label2() {
		// Panel West - Label - "Wochenbeginn mit So/Mo"
		GridBagConstraints constrWest7 = new GridBagConstraints();
		constrWest7.insets = new Insets(0, 10, 0, 0);
		constrWest7.gridx = 0;
		constrWest7.gridy = 40;
		constrWest7.anchor = GridBagConstraints.WEST;
		for (int i = 3; i < 4; i++) {
			label[i] = new JLabel(STRLABEL[i]);
			pnlWest.add(label[i], constrWest7);
		}
	}

	/**
	 * Methode fuer die Check Box.
	 */
	public void checkBox() {
		// Panel West - CheckBox
		GridBagConstraints constrWest8 = new GridBagConstraints();
		constrWest8.insets = new Insets(0, 10, 0, 0);
		constrWest8.gridx = 0;
		constrWest8.gridy = 50;
		constrWest8.anchor = GridBagConstraints.WEST;
		for (int i = 0; i < checkBox.length; i++) {
			checkBox[i] = new JCheckBox(STRCHECKBOX[i]);
			pnlWest.add(checkBox[i], constrWest8);
			checkBox[i].addActionListener(new ActionListenerCheckBox(this));
		}
	}

	/**
	 * Methode, fuer das Panel Mitte.
	 */
	public void panelMitte() {
		// Panel Mitte - TextPane - ScrollPane
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("monospaced", Font.PLAIN, 12));
		JScrollPane scrollContainer = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		container.add(BorderLayout.CENTER, scrollContainer);
	}

	/**
	 * Methode, welche den ausgewaehlten RadioButton zurueckgibt.
	 * 
	 * @return radioButton
	 */
	public JRadioButton getSelectedRadioButton() {
		int i = 0;
		for (; i < radioButton.length; i++) {
			if (radioButton[i].isSelected())
				break;
		}
		return radioButton[i];
	}

	/**
	 * Methode, welche das ausgewahlte Item in der ComboBox der Jahre
	 * zurueckgibt.
	 * 
	 * @return Das ausgewaehlte Jahr.
	 */
	public int getSelectedItemComboBoxJahre() {
		return (int) this.comboBoxJahre.getSelectedItem();
	}

	/**
	 * Methode, welche das ausgewaehlte Item in der ComboBox der Monate
	 * zurueckgibt.
	 * 
	 * @return Der ausgewaehlte Monat.
	 */
	public int getSelectedItemComboBoxMonate() {
		return this.comboBoxMonate.getSelectedIndex() + 1;
	}

	/**
	 * Methode, welche das Bild austauscht.
	 * 
	 * @param bildName
	 */
	public void tauscheBild(String bildName) {
		ImageIcon icon = new ImageIcon(".\\meineBilder\\" + bildName + ".jpg");
		icon.setImage(icon.getImage().getScaledInstance(200, -1, Image.SCALE_DEFAULT));
		picLab.setIcon(icon);
	}

	/**
	 * Methode, welche die ComboBox mit Jahren befuellt.
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
	 * Methode, welche die ComboBox mit Monaten befuellt.
	 * 
	 * @param cbMonate
	 * @return cbMonate
	 */
	private JComboBox<String> cbMonatfuellen(JComboBox<String> cbMonate) {
		for (int monat = 1; monat < STRMONATE.length; monat++) {
			cbMonate.addItem(STRMONATE[monat]);
		}
		return cbMonate;
	}

	/**
	 * Methode, welche das richtige Kalenderblatt in Abhaengigkeit des
	 * gedrueckten RadioButtons.
	 */
	public void auswahl() {

		int jahr = getSelectedItemComboBoxJahre();
		int monat = getSelectedItemComboBoxMonate();

		if (radioButton[0].isSelected()) {
			Kalender.getInstance().setModusFeiertage(-1);
			setTextPane(Kalender.getInstance().getJahresblatt(jahr));
		} else if (radioButton[1].isSelected()) {
			Kalender.getInstance().setModusFeiertage(-1);
			setTextPane(Kalender.getInstance().getMonatsblatt(jahr, monat));
		} else if (radioButton[2].isSelected()) {
			Kalender.getInstance().setModusFeiertage(1);
			setTextPane(createTextPane(Kalender.getInstance().getJahresblatt(jahr)));
		} else if (radioButton[3].isSelected()) {
			Kalender.getInstance().setModusFeiertage(1);
			setTextPane(createTextPane(Kalender.getInstance().getMonatsblatt(jahr, monat)));
		}
	}

	/**
	 * in dieser Methode wird eine TextPane konstruiert und mit einem
	 * StyledDocument versehen. Das StyledDocument wird mit Text gefuellt.
	 * 
	 * @return
	 */
	public static JTextPane createTextPane(String s) {

		textPane.setText(null);
		String[] initString = s.split("~");
		StyledDocument doc = textPane.getStyledDocument();
		addStylesToDocument(doc);
		Style style;

		boolean highlighted = false;
		for (int i = 0; i < initString.length; i++) {
			if (highlighted) {
				style = doc.getStyle("highlighted");
				try {
					doc.insertString(doc.getLength(), initString[i], style);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			} else {
				style = doc.getStyle("regular");
				try {
					doc.insertString(doc.getLength(), initString[i], style);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
			if (highlighted == true) {
				highlighted = false;
			} else if (highlighted == false) {
				highlighted = true;
			}
		}
		return textPane;
	}

	/**
	 * in dieser Methode werden Styles definiert. Den Namen der Styles kann man
	 * selber festlegen.
	 * 
	 * @param doc
	 */
	protected static void addStylesToDocument(StyledDocument doc) {

		Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

		Style regular = doc.addStyle("regular", defaultStyle);
		StyleConstants.setFontFamily(regular, "monospaced");

		Style highlighted = doc.addStyle("highlighted", regular);
		StyleConstants.setForeground(highlighted, Color.MAGENTA);
	}

	/**
	 * Methode, welche die TextPane zurueck gibt.
	 * 
	 * @return textPane
	 */
	public static JTextPane getTextPane() {
		return textPane;
	}

	/**
	 * Methode, welche die TextPane setzt.
	 * 
	 * @param textPane
	 */
	public static void setTextPane(JTextPane textPane) {
		FensterKalender.textPane = textPane;
	}

	/**
	 * Methode, welche den Inhalt fuer die TextPane setzt.
	 * 
	 * @param content
	 */
	public static void setTextPane(String content) {
		FensterKalender.textPane.setText(content);
	}

	/**
	 * Klasse, welche den ItemListener fuer die ComboBox Monate beinhaltet.
	 * 
	 * @author Christina
	 */
	public class ItemListenerComboBoxMonate implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {

			if (event.getSource() == comboBoxMonate) {
				for (int i = 1; i <= 12; i++) {
					if (comboBoxMonate.getSelectedItem().equals(STRMONATE[i])) {
						tauscheBild(STRMONATE[i]);
					}
				}
				auswahl();
			}
		}
	}

	/**
	 * Klasse, welche den ItemListener fuer die ComboBox Jahre beinhaltet.
	 * 
	 * @author Christina
	 *
	 */
	public class ItemListenerComboBoxJahre implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {

			auswahl();
		}
	}

	/**
	 * Klasse, welche den ActionListener fuer die RadioButtons beinhaltet.
	 * 
	 * @author Christina
	 *
	 */
	public class ActionListenerRadioButton implements ActionListener {

		public ActionListenerRadioButton(FensterKalender kalenderFenster) {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			auswahl();
		}
	}

	/**
	 * Klasse, welche den ActionListener fuer die Checkbox beinhaltet.
	 * 
	 * @author Christina
	 *
	 */
	public class ActionListenerCheckBox implements ActionListener {

		public ActionListenerCheckBox(FensterKalender kalenderFenster) {
		}

		@Override
		public void actionPerformed(ActionEvent event) {

			JCheckBox quellobj = (JCheckBox) event.getSource();

			if (quellobj.isSelected()) {
				Kalender.getInstance().setzteModusWochentag();
			} else {
				Kalender.getInstance().setzteModusWochentag();
			}
			auswahl();
		}
	}
}