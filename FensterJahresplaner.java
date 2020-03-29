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
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import kalender.Jahresplaner;

/**
 * Fenster, welches den Jahresplaner beinhaltet.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 *
 */
public class FensterJahresplaner extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JTextPane textPane = new JTextPane();

	private int jahr = FensterJahresplanerAbfrage.getInstance().getSelectedItemComboBoxJahre();
	private int von = FensterJahresplanerAbfrage.getInstance().getSelectedItemComboBoxVon();
	private int bis = FensterJahresplanerAbfrage.getInstance().getSelectedItemComboBoxBis();
	private int modus = FensterJahresplanerAbfrage.getInstance().getSelectedItemComboBoxModus();

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @throws HeadlessException
	 */
	public FensterJahresplaner() throws HeadlessException {
		this("Jahresplan");
	}

	/**
	 * Konstruktor fuer das Fenster.
	 * 
	 * @param title
	 * @throws HeadlessException
	 */
	public FensterJahresplaner(String title) throws HeadlessException {
		super(title);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(1000, 650));
		this.setLocationRelativeTo(null);

		Container container = this.getContentPane();
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		String jp = new Jahresplaner(jahr).gibJahresplan(von, bis, modus);

		container.setLayout(new BorderLayout());
		textPane.setEditable(false);
		textPane.setFont(new Font("monospaced", Font.PLAIN, 12));
		container.add(scrollPane);
		this.pack();
		panel.add(textPane);
		setTextPane(createTextPane(jp));
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

		boolean bold = false;
		for (int i = 0; i < initString.length; i++) {
			if (bold) {
				style = doc.getStyle("bold");
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
			if (bold == true) {
				bold = false;
			} else if (bold == false) {
				bold = true;
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

		Style bold = doc.addStyle("bold", regular);
		StyleConstants.setBold(bold, true);
	}

	/**
	 * Setter-Methode, welche die TextPane setzt.
	 * 
	 * @param textPane
	 */
	public void setTextPane(JTextPane textPane) {
		FensterJahresplaner.textPane = textPane;
	}

	/**
	 * Getter-Methode, welche die TextPane zurueck gibt.
	 * 
	 * @return textPane
	 */
	public static JTextPane getTextPane() {
		return textPane;
	}
}