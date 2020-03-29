package dateiIO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

/**
 * Die Klasse beinhaltet einen Stream zum Auslesen einer JTextPane.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class Writer {

	/**
	 * Methode speichert das Document der JTextPane in einer RTF-Textdatei.
	 * 
	 * @param document
	 * @param dateiname
	 */
	public static void speicherStream(Document document, String dateiname) {

		RTFEditorKit kit = new RTFEditorKit();

		if (!dateiname.endsWith(".rtf")) {
			dateiname += ".rtf";
		}

		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(dateiname));
			try {
				kit.write(out, document, 0, document.getLength());
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.err.println("Datei konnte nicht erstellt werden.");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}