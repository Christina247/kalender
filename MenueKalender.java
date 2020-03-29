package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;

import dateiIO.Reader;
import kalender.Event;

/**
 * Erstellt die Menueleiste fuer das Hauptfenster.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class MenueKalender extends JMenuBar {

	// Konstanten
	private static final long serialVersionUID = 1L;

	// Menueleiste
	private JMenuBar menuBar = new JMenuBar();

	// Menueleiste Elemente
	private JMenu datei = new JMenu("Datei");
	private JMenu kalender = new JMenu("Kaleder");
	private JMenu jahresplaner = new JMenu("Jahresplaner");
	private JMenu lookAndFeel = new JMenu("Look & Feel");
	private JMenu info = new JMenu("Info");

	// Datei
	private JMenuItem oeffnen = new JMenuItem("Oeffnen");
	private JMenuItem sichern = new JMenuItem("Sichern");
	private JMenuItem beenden = new JMenuItem("Beenden");

	// Kalender
	private JMenuItem feiertage = new JMenuItem("Feiertage");
	private JMenuItem feiertageOhne = new JMenuItem("Feiertage ohne So oder Sa");

	// Jahresplaner
	private JMenuItem show = new JMenuItem("Show");
	private JMenuItem save = new JMenuItem("Save");

	// Look&Feel
	private JMenuItem windows = new JMenuItem("Windows");
	private JMenuItem metal = new JMenuItem("Metal");
	private JMenuItem motif = new JMenuItem("Motif");

	// Info
	private JMenuItem autor = new JMenuItem("Autor");
	private JMenuItem help = new JMenuItem("Hilfe");

	/**
	 * Konstruktor fuer die Menueleiste.
	 * 
	 * @param kalenderFenster
	 */
	public MenueKalender(FensterKalender kalenderFenster) {
		// Menueelemente hinzufuegen
		menuBar.add(datei);
		menuBar.add(kalender);
		menuBar.add(jahresplaner);
		menuBar.add(lookAndFeel);
		menuBar.add(info);

		// Untermenueelemente hinzufuegen
		datei.add(oeffnen);
		datei.add(sichern);
		datei.add(beenden);
		kalender.add(feiertage);
		kalender.add(feiertageOhne);
		jahresplaner.add(show);
		jahresplaner.add(save);
		lookAndFeel.add(windows);
		lookAndFeel.add(metal);
		lookAndFeel.add(motif);
		info.add(autor);
		info.add(help);

		this.add(datei);
		this.add(kalender);
		this.add(jahresplaner);
		this.add(lookAndFeel);
		this.add(info);

		oeffnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					oeffnen();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		sichern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Document doc = FensterKalender.getTextPane().getDocument();
					speichern(doc);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		beenden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		feiertage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FensterFeiertage fenster = new FensterFeiertage();
				fenster.setVisible(true);
			}
		});

		feiertageOhne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FensterFeiertageOhne fenster = new FensterFeiertageOhne();
				fenster.setVisible(true);
			}
		});

		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FensterJahresplanerAbfrage.getInstance().setVisible(true);
			}
		});

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Document doc = FensterJahresplaner.getTextPane().getDocument();
				try {
					speichern(doc);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		windows.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingUtilities.updateComponentTreeUI(kalenderFenster);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
			}
		});

		metal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(kalenderFenster);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
			}
		});

		motif.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(kalenderFenster);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
			}
		});

		autor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hilfetext = "Autor: Christina Bachhuber\nErstelldatum: 14.06.2017\nVersion: 1.8.0";

				JOptionPane.showMessageDialog(null, hilfetext, "Autor", JOptionPane.PLAIN_MESSAGE);
			}
		});

		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hilfetext = "Ich bin ein Hilfetext";
				JOptionPane.showMessageDialog(null, hilfetext, "Help", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	/**
	 * Oeffnet ein Fenster zum oeffnen von Dateien.
	 * 
	 * @throws IOException
	 */
	public void oeffnen() throws IOException {
		JFileChooser dateiOeffnen = new JFileChooser();
		dateiOeffnen.addChoosableFileFilter(new FileNameExtensionFilter("Textdokumente (*.txt)", "txt"));
		dateiOeffnen.addChoosableFileFilter(new FileNameExtensionFilter("Comma-separated Values (*.csv)", "csv"));
		dateiOeffnen.addChoosableFileFilter(new FileNameExtensionFilter("RichText Format (*.rtf)", "rtf"));
		if (dateiOeffnen.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			ArrayList<Event> content = Reader.reader(dateiOeffnen.getSelectedFile().getAbsolutePath());
			String str = Reader.wandleUm(content);
			FensterEingeleseneGeburtstage fef = new FensterEingeleseneGeburtstage(str);
			fef.setVisible(true);
		}
	}

	/**
	 * Oeffnet ein Fenster zum speichern von Dateien.
	 * 
	 * @throws IOException
	 */
	public void speichern(Document doc) throws IOException {
		JFileChooser dateiSpeichern = new JFileChooser();
		dateiSpeichern.addChoosableFileFilter(new FileNameExtensionFilter("RichText Format (*.rtf)", "rtf"));
		if (dateiSpeichern.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			dateiIO.Writer.speicherStream(doc, dateiSpeichern.getSelectedFile().getAbsolutePath());
		}
	}
}