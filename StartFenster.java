package start;

import gui.FensterKalender;

/**
 * Beinhaltet die Main-Methode.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class StartFenster {

	/**
	 * Main-Methode, welche das Kalenderfenster aufruft.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FensterKalender.getInstance().setVisible(true);
	}
}