package kalender;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Map;

/**
 * Klasse, welche den Jahresplaner beinhaltet.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class Jahresplaner {

	private LinkedList<LinkedList<String>> planliste = new LinkedList<>();
	private int jahr;
	private Kalender kal = Kalender.getInstance();

	/**
	 * Konstruktor, welcher das Jahr des Jahresplaners beinhaltet.
	 * 
	 * @param jahr
	 */
	public Jahresplaner(int jahr) {
		this.jahr = jahr;
	}

	/**
	 * Der angegebene Monat fuer den Jahresplan wird zusammengebaut. Jede Zeile
	 * wird als String in einer LinkedList<String> abgespeichert.
	 * 
	 * @param monat
	 * @param modusJP
	 *            Der Modus des Jahresplaners.
	 * 
	 * @return LinkedList<String> der Monatsplan - Container mit allen Zeilen
	 *         des Monats.
	 */
	public LinkedList<String> baueMonat(int monat, int modusJP) {

		Feiertage feier = new Feiertage();
		LinkedList<String> monatsplaner = new LinkedList<String>();
		int tag = 1;
		final DecimalFormat FORMAT1 = new DecimalFormat("|##|00");

		kal.istSchaltjahr(jahr);

		String kopfzeile1 = String.format("~%s %s~", kal.MONATSNAME[monat - 1], jahr);
		String kopfzeile = String.format("%-37s", kopfzeile1);
		monatsplaner.add(kopfzeile);
		for (; tag <= kal.bestimmeMonatslaenge(monat); tag++) {
			int tagesnummer = KalenderFunktionen.tagesnummer(tag, monat, jahr);
			int wochennummer = KalenderFunktionen.wochennummer(jahr, tagesnummer);
			String feiertag = "";
			if (modusJP == 0) {
				GregorianCalendar zuPruefendesDatum = new GregorianCalendar(jahr, monat - 1, tag);
				Map<String, Event> feiertageDesJahres = new Feiertage().getFeiertageJahr(jahr);
				try {
					Event e = feiertageDesJahres.get(feier.format(zuPruefendesDatum));
					feiertag = e.getName();
				} catch (NullPointerException g) {
				}
			}

			String zeilen = String.format("%s%s%-28s%s", kal.WOCHENTAGNAME[wochennummer], FORMAT1.format(tag), feiertag,
					FORMAT1.format(tagesnummer));
			monatsplaner.add(zeilen);
		}
		return monatsplaner;
	}

	/**
	 * Der Jahresplan fuer die angegebenen Monate wird als String zurueck
	 * gegeben.
	 *
	 * @param von
	 *            monat
	 * @param bis
	 *            monat
	 * @param modusJP
	 *            Der Modus des Jahresplaners.
	 * @return String der Jahresplan.
	 */
	public String gibJahresplan(int von, int bis, int modusJP) {

		String jahresplaner = "";
		int aktuellerMonat = von;
		int index = 0;

		for (int tag = 0; tag <= 31; tag++) {
			for (; aktuellerMonat <= bis; aktuellerMonat++) {
				planliste.add(baueMonat(aktuellerMonat, modusJP));
				int monatslaenge = kal.bestimmeMonatslaenge(aktuellerMonat);
				if (tag <= monatslaenge) {
					jahresplaner += String.format("%s\t", planliste.get(index).get(tag));
				} else {
					String hilfe = "";
					jahresplaner += String.format("%-41s", hilfe);
				}
				index++;
			}
			aktuellerMonat = von;
			index = 0;
			jahresplaner += System.lineSeparator();
		}
		return jahresplaner;
	}
}