package kalender;

import java.util.GregorianCalendar;

/**
 * Die Klasse beinhaltet Algorithmen fuer den Kalender. Insbesondere zur
 * Berechnung des Schaltjahres, der Tagesnummer und dem Wochentag. Diese
 * Algorithmen sind zusammengetragen aus verschiedenen Quellen.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class KalenderFunktionen {

	/**
	 * Methode, welches eine Jahreszahl auf ein Schaltjahr ueberprueft. Jedes
	 * vierte Jahr ist ein Schaltjahr, wenn sich das Jahr durch vier ohne Rest
	 * teilen laesst. Ausnahme davon ist jedes hundertste Jahr, wenn sich das
	 * Jahr durch 100 ohne Rest teilen laesst. Ausnahme davon ist jedes
	 * vierhundertste Jahr, wenn sich das Jahr durch 400 ohne Rest teilen
	 * laesst.
	 * 
	 * @param jahr
	 *            Das Jahr, das auf ein Schaltjahr ueberprueft wird.
	 * @return boolean: True, wenn das Jahr ein Schaltjahr ist. False, wenn das
	 *         Jahr kein Schaltjahr ist.
	 */
	public static boolean istSchaltjahr(int jahr) {
		return ((jahr % 4 == 0) && ((jahr % 100 != 0) || (jahr % 400 == 0)));
	}

	/**
	 * Methode, welche auf ein Schaltjahr ueberprueft.
	 * 
	 * @param jahr
	 *            Das Jahr, das auf ein Schaltjahr ueberprueft wird.
	 * @return int 1, wenn das Jahr ein Schaltjahr ist. 0, wenn das Jahr kein
	 *         Schaltjahr ist.
	 */
	public static int schaltjahr(int jahr) {
		if (istSchaltjahr(jahr))
			return 1;
		else
			return 0;
	}

	/**
	 * Methode welche die Tagesnummer berechnet. Beispiel: 1=1.1; 2=1.2;
	 * 3=1.3;... 365/366=31.12.
	 * 
	 * @param tag
	 *            Tag fuer den die Tagesnummer berechnet werden soll.
	 * @param monat
	 *            Monat fuer den die Tagesnummer berechnet werden soll.
	 * @param jahr
	 *            Jahr fuer das die Tagesnummer berechnet werden soll.
	 * @return int Tagesnummer
	 */
	public static int tagesnummer(int tag, int monat, int jahr) {
		int d, e;
		d = (monat + 10) / 13;
		e = tag + (611 * (monat + 2)) / 20 - 2 * d - 91;

		return (e + schaltjahr(jahr) * d);
	}

	/**
	 * Methode, welche den Wochentag berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr, in dem die Berechnung statt finden soll.
	 * @param tagesnummer
	 *            Die Tagesnummer im Jahr.
	 * @return int Der Wochentag (0=So, 1=Mo, 2=Di, 3=Mi, 4=Do, 5=Fr, 6=Sa).
	 */
	public static int wochennummer(int jahr, int tagesnummer) {
		int j, c;
		j = (jahr - 1) % 100;
		c = (jahr - 1) / 100;

		return (28 + j + tagesnummer + (j / 4) + (c / 4) + 5 * c) % 7;
	}

	/**
	 * Methode, welche das Datum des Ostersonntags im gregorianischen Kalender
	 * berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des Ostersonntags berechnet werden
	 *            soll.
	 * @return Das Datum des Ostersonntags im gregorianischen Kalender.
	 */
	public static GregorianCalendar getOstersonntag(int jahr) {
		int c = jahr / 100;
		int n = jahr - 19 * (jahr / 19);
		int k = (c - 17) / 25;
		int l1 = c - c / 4 - (c - k) / 3 + 19 * n + 15;
		int l2 = l1 - 30 * (l1 / 30);
		int l3 = l2 - (l2 / 28) * (1 - (l2 / 28) * (29 / (l2 + 1)) * ((21 - n) / 11));
		int a1 = jahr + jahr / 4 + l3 + 2 - c + c / 4;
		int a2 = a1 - 7 * (a1 / 7);
		int l = l3 - a2;
		int monat = 3 + (l + 40) / 44;
		int tag = l + 28 - 31 * (monat / 4);

		return new GregorianCalendar(jahr, monat - 1, tag);
	}
}