package kalender;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Klasse die den Kalender zusammenbaut und das Benutzermenue beinhaltet.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class Kalender {

	private int modusWochentag = 0;
	private int modusFeiertage;
	private int zeilenumbruch = 1;
	private int monatslaenge[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final String MONATSNAME[] = { "Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August",
			"September", "Oktober", "November", "Dezember" };
	public final String WOCHENTAGNAME[] = { "So", "Mo", "Di", "Mi", "Do", "Fr", "Sa", "So" };
	private static Kalender instance = null;

	/**
	 * Private Konstruktor
	 */
	private Kalender() {

	}

	/**
	 * Erzeugung eines Singleton.
	 * 
	 * @return instance.
	 */
	public static Kalender getInstance() {

		if (instance == null) {
			instance = new Kalender();
		}
		return instance;
	}

	/**
	 * Erzeugt ein Monatsblatt eines bestimmten Jahres und Monat.
	 * 
	 * @param jahr
	 * @param monat
	 * @return monatsblatt
	 */
	public String getMonatsblatt(int jahr, int monat) {

		int wochennummer = KalenderFunktionen.wochennummer(jahr, KalenderFunktionen.tagesnummer(1, monat, jahr));
		int wochentag = 1;
		String monatsblatt = "";

		monatsblatt += getKopfzeileMonatsblatt(jahr, monat);

		istSchaltjahr(jahr);

		// Amerikanisches Kalenderformat
		if (modusWochentag == 0) {
			wochentag = wochennummer;
		}

		// Deutsches Kalenderformat
		else {
			if (wochennummer == 0) {
				wochentag = 6;
			} else {
				wochentag = wochennummer - 1;
			}
		}

		// Tabeinrueckung fuer den Monat
		for (int i = 0; i < wochentag; i++) {
			String hilfe = "";
			monatsblatt += String.format("%7s", hilfe);
			zeilenumbruch++;
		}

		switch (modusFeiertage) {
		case -1:
			monatsblatt = getMonatOhneFeiertage(wochennummer, wochentag, jahr, monat, monatsblatt);
			break;
		case 1:
			monatsblatt = getMonatMitFeiertage(wochennummer, wochentag, jahr, monat, monatsblatt);
			break;
		}
		return monatsblatt;
	}

	/**
	 * Methode, welche das Monatsblatt ohne Feiertage zurueckgibt.
	 * 
	 * @param wochennummer
	 * @param wochentag
	 * @param jahr
	 * @param monat
	 * @param monatsblatt
	 * @return monatsblatt ohne Feiertage.
	 */
	private String getMonatOhneFeiertage(int wochennummer, int wochentag, int jahr, int monat, String monatsblatt) {

		monatsblatt = erweitereMonatsblatt(monat, jahr, monatsblatt, null, false, null);
		monatsblatt += System.lineSeparator();
		return monatsblatt;
	}

	/**
	 * Methode, welche das Monatsblatt mit Feiertage zurueckgibt.
	 * 
	 * @param wochennummer
	 * @param wochentag
	 * @param jahr
	 * @param monat
	 * @param monatsblatt
	 * @return monatsblatt mit Feiertage.
	 */
	private String getMonatMitFeiertage(int wochennummer, int wochentag, int jahr, int monat, String monatsblatt) {

		Map<String, Event> feiertageJahr = new Feiertage().getFeiertageJahr(jahr);
		ArrayList<String> feiertageMonat = new ArrayList<String>();
		monatsblatt = erweitereMonatsblatt(monat, jahr, monatsblatt, feiertageJahr, true, feiertageMonat);

		return addFeiertagsInformationen(monat, monatsblatt, feiertageMonat, feiertageJahr);
	}

	/**
	 * Methode die das Monatsblatt erweitert. Feiertage werden mit Sternchen
	 * versehen und der Zeilenumbruch wird berechnet.
	 * 
	 * @param monat
	 * @param jahr
	 * @param monatsblatt
	 * @param feiertageJahr
	 * @param mitFeiertagen
	 * @param feiertageMonat
	 * @return monatsblatt
	 */
	private String erweitereMonatsblatt(int monat, int jahr, String monatsblatt, Map<String, Event> feiertageJahr,
			boolean mitFeiertagen, ArrayList<String> feiertageMonat) {

		final DecimalFormat FORMAT1 = new DecimalFormat(" #00 ");
		final DecimalFormat FORMAT2 = new DecimalFormat("*#00*");

		for (int tag = 1; tag <= bestimmeMonatslaenge(monat); tag++) {

			boolean erweiternMitFeiertagen = (mitFeiertagen
					&& istFeiertag(jahr, monat, tag, feiertageJahr, feiertageMonat));

			monatsblatt += (erweiternMitFeiertagen) ? String.format("~%7s~", FORMAT2.format(tag))
					: String.format("%7s", FORMAT1.format(tag));

			if (zeilenumbruch % 7 == 0) {
				monatsblatt += System.lineSeparator();
			}
			zeilenumbruch++;
		}
		zeilenumbruch = 1;
		return monatsblatt;
	}

	/**
	 * Methode, in der der Vergleich zwischen dem aktuellem Datum und den Daten
	 * aus der Hash-Map stattfindet.
	 * 
	 * @param jahr
	 * @param monat
	 * @param tag
	 * @param feiertageJahr
	 * @param feiertageMonat
	 * @return boolean true: aktuelles Datum ist ein Feiertag; false: aktuelles
	 *         Datum ist kein Feiertag.
	 */
	private boolean istFeiertag(int jahr, int monat, int tag, Map<String, Event> feiertageJahr,
			ArrayList<String> feiertageMonat) {

		Calendar cal = GregorianCalendar.getInstance();
		cal.set(jahr, monat - 1, tag, 0, 0);
		Feiertage feier = new Feiertage();

		for (Map.Entry<String, Event> feiertag : feiertageJahr.entrySet()) {
			if (feier.vergleicheCalendar((GregorianCalendar) cal, feiertag.getValue().getDatum())) {
				feiertageMonat.add(feiertag.getValue().getDatumAsString());
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode, welche die Feiertagsinformation am Ende des Monatsblatts
	 * hinzufuegt.
	 * 
	 * @param monat
	 * @param monatsblatt
	 * @param feiertageMonat
	 * @param feiertageJahr
	 * @return monatsblatt
	 */
	private String addFeiertagsInformationen(int monat, String monatsblatt, ArrayList<String> feiertageMonat,
			Map<String, Event> feiertageJahr) {

		if (feiertageMonat.size() > 0) {// hat der Monat Feiertage

			monatsblatt += System.lineSeparator() + System.lineSeparator() + "\t" + "~Im " + MONATSNAME[monat - 1]
					+ " gibt es folgende Feiertage: " + System.lineSeparator() + System.lineSeparator();

			for (String feiertag : feiertageMonat) {
				Event e = feiertageJahr.get(feiertag);
				monatsblatt += "\t" + e.getDatumAsString() + ": " + e.getName();
				// if (e.hasIntervall()) {
				// monatsblatt += ", " + e.getIntervall().name();
				// }
				monatsblatt += System.lineSeparator();
			}
		}
		return monatsblatt + System.lineSeparator() + "~";
	}

	/**
	 * Erzeugt die Kopfzeile fuer das Monatsblatt.
	 * 
	 * @param jahr
	 * @param monat
	 * @return kopfzeile
	 */
	public String getKopfzeileMonatsblatt(int jahr, int monat) {

		String kopfzeile = " ******************** " + MONATSNAME[monat - 1] + " " + jahr + " ********************"
				+ System.lineSeparator();

		// amerikanisches Kalenderformat oder deutsches Kalenderformat
		kopfzeile = (modusWochentag == 0) ? formatberechnung(kopfzeile, 0, 1) : formatberechnung(kopfzeile, 1, 0);

		kopfzeile += System.lineSeparator();
		return kopfzeile;
	}

	/**
	 * Methode, welche das Format der Kopfzeile erstellt.
	 * 
	 * @param kopfzeile
	 * @param versatz1
	 * @param versatz2
	 * @return kopfzeile
	 */
	private String formatberechnung(String kopfzeile, int versatz1, int versatz2) {
		for (int tag = versatz1; tag < WOCHENTAGNAME.length - versatz2; tag++) {
			String hilfe = String.format(" %-3s", WOCHENTAGNAME[tag]);
			kopfzeile += String.format("%7s", hilfe);
		}
		return kopfzeile;
	}

	/**
	 * Setzt den Modus dafuer, ob der Kalender mit oder ohne Feiertage
	 * ausgegeben werden soll.
	 * 
	 * @param modusFeiertage
	 */
	public void setModusFeiertage(int modusFeiertage) {
		this.modusFeiertage = modusFeiertage;
	}

	/**
	 * Wechselt zwischen dem deutschen und amerikanischen Kalenderformat.
	 */
	public void setzteModusWochentag() {
		this.modusWochentag = modus(this.modusWochentag);
	}

	/**
	 * Methode welche den Modus wechselt.
	 * 
	 * @param modus.
	 * @return modus.
	 */
	public int modus(int modus) {
		if (modus == 0) {
			modus = 1;
		} else if (modus == 1) {
			modus = 0;
		}
		return modus;
	}

	/**
	 * Gibt die Monatslaenge zurueck
	 * 
	 * @return monatslaenge
	 */
	public int[] getMonatslaenge() {
		return monatslaenge;
	}

	/**
	 * Die Monatslaenge wird fuer den Februar auf 29 Tage erhoeht, sofern das
	 * Jahr ein Schaltjahr ist.
	 * 
	 * @param jahr
	 */
	public void istSchaltjahr(int jahr) {

		if (KalenderFunktionen.istSchaltjahr(jahr) == true) {
			this.monatslaenge[1] = 29;
		}
	}

	/**
	 * Die Monatslaenge eines bestimmten Monats wird berechnet.
	 * 
	 * @param monat
	 * @return monatslaenge
	 */
	public int bestimmeMonatslaenge(int monat) {
		int monatslaenge = getMonatslaenge()[monat - 1];
		return monatslaenge;
	}

	/**
	 * Methode, welche das Monatsblatt als String (fuer den Stream) zurueckgibt.
	 * 
	 * 
	 * @param jahr
	 * @return monatsblatt.
	 */
	public String getJahresblatt(int jahr) {
		String monatsblatt = "";
		for (int monat = 1; monat <= 12; monat++) {
			monatsblatt += getMonatsblatt(jahr, monat);
		}
		return monatsblatt;
	}
}