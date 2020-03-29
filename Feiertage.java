package kalender;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import kalender.Event.Intervall;

/**
 * Klasse mit Methoden, welche die Feiertage berechnen.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class Feiertage {

	/**
	 * Methode, welche das Datum von Weihnachten berechnet. Das Datum wird als
	 * Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das Weihnachten berechnet werden soll.
	 * @return Event.
	 */
	private Event getWeihnachten(int jahr) {
		final int MONAT = 12;
		final int TAG = 24;
		return new Event("Weihnachten", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Tags der Gerechtigkeit berechnet. Das Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Tag der Gerechtigkeit berechnet werden
	 *            soll.
	 * @return Event.
	 */
	private Event getTagDerGerechtigkeit(int jahr) {
		final int MONAT = 7;
		final int TAG = 17;
		return new Event("Tag der Gerechtigkeit", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Freundinnen Tags berechnet. Das Datum wird
	 * als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Freundinnen Tag berechnet werden soll.
	 * @return Event.
	 */
	private Event getFreundinnenTag(int jahr) {
		final int MONAT = 8;
		final int TAG = 1;
		return new Event("FreundinnenTag", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Tags der IT-Profis berechnet. Das Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Tag der IT-Profis berechnet werden soll.
	 * @return Event.
	 */
	private Event getTagDerITProfis(int jahr) {
		final int MONAT = 9;
		final int TAG = 20;
		return new Event("Tag der IT-Profis", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Pink-Tags berechnet. Das Datum wird als
	 * Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Pink-Tag berechnet werden soll.
	 * @return Event.
	 */
	private Event getPinkTag(int jahr) {
		final int MONAT = 6;
		final int TAG = 23;
		return new Event("Pink-Tag", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Super-Mario Tags berechnet. Das Datum wird
	 * als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Super-Mario-Tag berechnet werden soll.
	 * @return Event.
	 */
	private Event getSuperMarioTag(int jahr) {
		final int MONAT = 3;
		final int TAG = 10;
		return new Event("Super Mario Tag", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Tag des Bieres berechnet. Das Datum wird
	 * als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Tag des Bieres berechnet werden soll.
	 * @return Event.
	 */
	private Event getTagDesBieres(int jahr) {
		final int MONAT = 4;
		final int TAG = 23;
		return new Event("Tag des Bieres", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des ersten Weihnachtsfeiertag berechnet. Das
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der erste Weihnachtsfeiertag berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getErsterWeihnachtsfeiertag(int jahr) {
		final int MONAT = 12;
		final int TAG = 25;
		return new Event("Erster Weihnachtsfeiertag", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des zweiten Weihnachtsfeiertags berechnet. Das
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der zweite Weihnachtsfeiertag berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getZweiterWeihnachtsfeiertag(int jahr) {
		final int MONAT = 12;
		final int TAG = 26;
		return new Event("Zweiter Weihnachtsfeiertag", new GregorianCalendar(jahr, MONAT - 1, TAG),
				Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum von Sylvester berechnet. Das Datum wird als
	 * Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das Sylvester berechnet werden soll.
	 * @return Event.
	 */
	private Event getSylvester(int jahr) {
		final int MONAT = 12;
		final int TAG = 31;
		return new Event("Sylvester", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum vom Neujahr berechnet. Das Datum wird als Event
	 * Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das des Neujahr berechnet werden soll.
	 * @return Event.
	 */
	private Event getNeujahr(int jahr) {
		final int MONAT = 1;
		final int TAG = 1;
		return new Event("Neujahr", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Tag der deutschen Einheit berechnet. Das
	 * brechnete Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Tag der deutschen Einheit berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getTagDerDeutschenEinheit(int jahr) {
		final int MONAT = 10;
		final int TAG = 3;
		return new Event("Tag der deutschen Einheit", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Valentinstags berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das der Valentinstag berechnet werden soll.
	 * @return Event.
	 */
	private Event getValentinstag(int jahr) {
		final int MONAT = 2;
		final int TAG = 14;
		return new Event("Valentinstag", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum vom Tag der Arbeit berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum der Tag der deutschen Einheit
	 *            berechnet werden soll.
	 * @return Event.
	 */
	private Event getTagDerArbeit(int jahr) {
		final int MONAT = 5;
		final int TAG = 1;
		return new Event("Tag der Arbeit", new GregorianCalendar(jahr, MONAT - 1, TAG), Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche einen Versatz auf ein Ausgangsdatum rechnet, um ein
	 * gewuenschtes Datum zu erhalten. Zum Beispiel: Weihnachten + Versatz =
	 * BussUndBettag
	 * 
	 * @param ausgangsDatum
	 * @param versatz
	 * @return berechnetes Datum
	 */
	private GregorianCalendar versatz(GregorianCalendar ausgangsDatum, int versatz) {
		GregorianCalendar berechnetesDatum = new GregorianCalendar(ausgangsDatum.get(Calendar.YEAR),
				ausgangsDatum.get(Calendar.MONTH), (ausgangsDatum.get(Calendar.DATE) + versatz));
		return berechnetesDatum;
	}

	/**
	 * Methode, welche das Datum des Muttertags berechnet. Das brechnete Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des Muttertags berechnet werden
	 *            soll.
	 * @return Event.
	 */
	private Event getMuttertag(int jahr) {
		final int ERSTERMAITAG = 1;
		final int ERSTERMAIMONAT = 5;
		GregorianCalendar ersterMai = new GregorianCalendar(jahr, ERSTERMAIMONAT - 1, ERSTERMAITAG);
		GregorianCalendar muttertag = new GregorianCalendar();
		int wochennummerErsterMai = KalenderFunktionen.wochennummer(ersterMai.get(Calendar.YEAR),
				KalenderFunktionen.tagesnummer(ERSTERMAITAG, ERSTERMAIMONAT, ersterMai.get(Calendar.YEAR)));

		int versatz[] = { 7, 13, 12, 11, 10, 9, 8 };

		for (int i = 0; i <= 7; i++) {
			if (wochennummerErsterMai == i) {
				muttertag = versatz(ersterMai, versatz[i]);
			}
		}
		if (vergleicheCalendar(muttertag, getPfingstsonntag(getOstersonntag(jahr).getDatum()).getDatum())) {
			muttertag = new GregorianCalendar(muttertag.get(Calendar.YEAR), muttertag.get(Calendar.MONTH),
					(muttertag.get(Calendar.DATE) - 7));
		}
		return new Event("Muttertag", muttertag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Buss und Bettags berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des Buss und Bettags berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getBussUndBettag(GregorianCalendar weihnachten) {
		GregorianCalendar bussUndBettag = new GregorianCalendar();
		int wochennummerWeihnachten = wochennummerWeihnachten(weihnachten);

		int versatz[] = { -32, -33, -34, -35, -36, -37, -38 };

		for (int i = 0; i <= 7; i++) {
			if (wochennummerWeihnachten == i) {
				bussUndBettag = versatz(weihnachten, versatz[i]);
			}
		}
		return new Event("Buss und Bettag", bussUndBettag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche die Wochennumer von Weihanchten berechnet.
	 * 
	 * @param weihnachten
	 * @return wochennummerWeihnachten.
	 */
	private int wochennummerWeihnachten(GregorianCalendar weihnachten) {
		int wochennummerWeihnachten = KalenderFunktionen.wochennummer(weihnachten.get(Calendar.YEAR),
				KalenderFunktionen.tagesnummer(24, 12, weihnachten.get(Calendar.YEAR)));
		return wochennummerWeihnachten;
	}

	/**
	 * Methode, welche das Datum des ersten Advents berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des ersten Advents berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getErsterAdvent(GregorianCalendar weihnachten) {
		int wochennummerWeihnachten = wochennummerWeihnachten(weihnachten);
		GregorianCalendar ersterAdvent = new GregorianCalendar();

		int versatz[] = { -21, -22, -23, -24, -25, -26, -27 };

		for (int i = 0; i <= 7; i++) {
			if (wochennummerWeihnachten == i) {
				ersterAdvent = versatz(weihnachten, versatz[i]);
			}
		}
		return new Event("Erster Advent", ersterAdvent, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des zweiten Advents berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des zweiten Advents berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getZweiterAdvent(GregorianCalendar weihnachten) {
		int wochennummerWeihnachten = wochennummerWeihnachten(weihnachten);
		GregorianCalendar zweiterAdvent = new GregorianCalendar();

		int versatz[] = { -14, -15, -16, -17, -18, -19, -20 };

		for (int i = 0; i <= 7; i++) {
			if (wochennummerWeihnachten == i) {
				zweiterAdvent = versatz(weihnachten, versatz[i]);
			}
		}
		return new Event("Zweiter Advent", zweiterAdvent, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des dritten Advents berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des dritten Advents berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getDritterAdvent(GregorianCalendar weihnachten) {
		int wochennummerWeihnachten = wochennummerWeihnachten(weihnachten);
		GregorianCalendar dritterAdvent = new GregorianCalendar();

		int versatz[] = { -7, -8, -9, -10, -11, -12, -13 };

		for (int i = 0; i <= 7; i++) {
			if (wochennummerWeihnachten == i) {
				dritterAdvent = versatz(weihnachten, versatz[i]);
			}
		}
		return new Event("Dritter Advent", dritterAdvent, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des vierten Advents berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des vierten Advents berechnet
	 *            werden soll.
	 * @return Event.
	 */
	private Event getVierterAdvent(GregorianCalendar weihnachten) {
		int wochennummerWeihnachten = wochennummerWeihnachten(weihnachten);
		GregorianCalendar vierterAdvent = new GregorianCalendar();

		int versatz[] = { -0, -1, -2, -3, -4, -5, -6 };

		for (int i = 0; i <= 7; i++) {
			if (wochennummerWeihnachten == i) {
				vierterAdvent = versatz(weihnachten, versatz[i]);
			}
		}
		return new Event("Vierter Advent", vierterAdvent, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Ostersonntags berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das Jahr fuer das das Datum des Ostersonntags berechnet werden
	 *            soll.
	 * @return Event.
	 */
	private Event getOstersonntag(int jahr) {
		GregorianCalendar ostersonntag = KalenderFunktionen.getOstersonntag(jahr);

		return new Event("Ostersonntag", ostersonntag, Event.Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Ostermontags berechnet. Das brechnete Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Ostermontags berechnet werden soll.
	 * @return Event.
	 */
	private Event getOstermontag(GregorianCalendar ostersonntag) {
		GregorianCalendar ostermontag = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) + 1));
		return new Event("Ostermontag", ostermontag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Rosenmontags berechnet. Das brechnete Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Rosenmontags berechnet werden soll.
	 * @return Event.
	 */
	private Event getRosenmontag(GregorianCalendar ostersonntag) {
		GregorianCalendar rosenmontag = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) - 48));
		return new Event("Rosenmontag", rosenmontag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Aschermittwochs berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Aschermittwochs berechnet werden soll.
	 * @return Event.
	 */
	private Event getAschermittwoch(GregorianCalendar ostersonntag) {
		GregorianCalendar aschermittwoch = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) - 46));
		return new Event("Aschermittwoch", aschermittwoch, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Gruendonnerstags berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Gruendonnerstags berechnet werden soll.
	 * @return Event.
	 */
	private Event getGruendonnerstag(GregorianCalendar ostersonntag) {
		GregorianCalendar gruendonnerstag = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) - 3));
		return new Event("Gruendonnerstag", gruendonnerstag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Karfreitags berechnet. Das brechnete Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Karfreitags berechnet werden soll.
	 * @return Event.
	 */
	private Event getKarfreitag(GregorianCalendar ostersonntag) {
		GregorianCalendar karfreitag = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) - 2));
		return new Event("Karfreitag", karfreitag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum von Christi Himmelfahrt berechnet. Das
	 * brechnete Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum von Christi Himmelfahrt berechnet werden soll.
	 * @return Event.
	 */
	private Event getChristiHimmelfahrt(GregorianCalendar ostersonntag) {
		GregorianCalendar christiHimmelfahrt = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) + 39));
		return new Event("Christi Himmelfahrt", christiHimmelfahrt, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Pfingstsonntags berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Pfingstsonntags berechnet werden soll.
	 * @return Event.
	 */
	private Event getPfingstsonntag(GregorianCalendar ostersonntag) {
		GregorianCalendar pfingstsonntag = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) + 49));
		return new Event("Pfingstsonntag", pfingstsonntag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum des Pfingstmontags berechnet. Das brechnete
	 * Datum wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum des Pfingstmontags berechnet werden soll.
	 * @return Event.
	 */
	private Event getPfingstmontag(GregorianCalendar ostersonntag) {
		GregorianCalendar pfingstmontag = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) + 50));
		return new Event("Pfingstmontag", pfingstmontag, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche das Datum von Fronleichnam berechnet. Das brechnete Datum
	 * wird als Event Objekt berechnet.
	 * 
	 * @param jahr
	 *            Das gregorianische Datum des Ostersonntags im Jahr, fuer das
	 *            das Datum von Fronleichnam berechnet werden soll.
	 * @return Event.
	 */
	private Event getFronleichnam(GregorianCalendar ostersonntag) {
		GregorianCalendar fronleichnam = new GregorianCalendar(ostersonntag.get(Calendar.YEAR),
				ostersonntag.get(Calendar.MONTH), (ostersonntag.get(Calendar.DATE) + 60));
		return new Event("Fronleichnam", fronleichnam, Intervall.JAEHRLICH);
	}

	/**
	 * Methode, welche ein gregorianisches Datum in einen String umwandelt.
	 * 
	 * @param calendar
	 * @return formatiertes Datum.
	 */
	public String format(GregorianCalendar calendar) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		fmt.setCalendar(calendar);
		String dateFormatted = fmt.format(calendar.getTime());
		return dateFormatted;
	}

	/**
	 * Methode, welche zwei formatierte Daten vergleicht.
	 * 
	 * @param datum1
	 * @param datum2
	 * @return boolean true oder false.
	 */
	private boolean datumIstGleich(String datum1, String datum2) {
		return datum1.equals(datum2);
	}

	/**
	 * Methode, welche zwei gregorianische Daten vergleicht.
	 * 
	 * @param c1
	 * @param c2
	 * @return boolean true oder false.
	 */
	public boolean vergleicheCalendar(GregorianCalendar c1, GregorianCalendar c2) {
		return datumIstGleich(format(c1), format(c2));
	}

	/**
	 * Methode, welche die HashMap der berechneten Feiertage beinhaltet. Mit
	 * Key=Datum und Value=Event.
	 * 
	 * @param jahr.
	 * @return Map.
	 */
	public Map<String, Event> getFeiertageJahr(int jahr) {
		HashMap<String, Event> map = new HashMap<String, Event>();

		Event weihnachtenValue = getWeihnachten(jahr);
		String weihnachtenKey = format(weihnachtenValue.getDatum());
		map.put(weihnachtenKey, weihnachtenValue);

		Event pinkTagValue = getPinkTag(jahr);
		String pinkTagKey = format(pinkTagValue.getDatum());
		map.put(pinkTagKey, pinkTagValue);

		Event freundinnenTagValue = getFreundinnenTag(jahr);
		String freundinnenTagKey = format(freundinnenTagValue.getDatum());
		map.put(freundinnenTagKey, freundinnenTagValue);

		Event tagDerGerechtigkeitValue = getTagDerGerechtigkeit(jahr);
		String tagDerGerechtigkeitKey = format(tagDerGerechtigkeitValue.getDatum());
		map.put(tagDerGerechtigkeitKey, tagDerGerechtigkeitValue);

		Event tagDerITProfisValue = getTagDerITProfis(jahr);
		String tagDerITProfisKey = format(tagDerITProfisValue.getDatum());
		map.put(tagDerITProfisKey, tagDerITProfisValue);

		Event superMarioTagValue = getSuperMarioTag(jahr);
		String superMarioTagKey = format(superMarioTagValue.getDatum());
		map.put(superMarioTagKey, superMarioTagValue);

		Event tagDesBieresValue = getTagDesBieres(jahr);
		String tagDesBieresKey = format(tagDesBieresValue.getDatum());
		map.put(tagDesBieresKey, tagDesBieresValue);

		Event ersterWeihnachtsfeiertagValue = getErsterWeihnachtsfeiertag(jahr);
		String ersterWeihnachtsfeiertagKey = format(ersterWeihnachtsfeiertagValue.getDatum());
		map.put(ersterWeihnachtsfeiertagKey, ersterWeihnachtsfeiertagValue);

		Event zweiterWeihnachtsfeiertagValue = getZweiterWeihnachtsfeiertag(jahr);
		String zweiterWeihnachtsfeiertagKey = format(zweiterWeihnachtsfeiertagValue.getDatum());
		map.put(zweiterWeihnachtsfeiertagKey, zweiterWeihnachtsfeiertagValue);

		Event sylvesterValue = getSylvester(jahr);
		String sylvesterKey = format(sylvesterValue.getDatum());
		map.put(sylvesterKey, sylvesterValue);

		Event neujahrValue = getNeujahr(jahr);
		String neujahrKey = format(neujahrValue.getDatum());
		map.put(neujahrKey, neujahrValue);

		Event tagDerDeutschenEinheitValue = getTagDerDeutschenEinheit(jahr);
		String tagDerDeutschenEinheitKey = format(tagDerDeutschenEinheitValue.getDatum());
		map.put(tagDerDeutschenEinheitKey, tagDerDeutschenEinheitValue);

		Event valentinstagValue = getValentinstag(jahr);
		String valentinstagKey = format(valentinstagValue.getDatum());
		map.put(valentinstagKey, valentinstagValue);

		Event tagDerArbeitValue = getTagDerArbeit(jahr);
		String tagDerArbeitKey = format(tagDerArbeitValue.getDatum());
		map.put(tagDerArbeitKey, tagDerArbeitValue);

		Event muttertagValue = getMuttertag(jahr);
		String muttertagKey = format(muttertagValue.getDatum());
		map.put(muttertagKey, muttertagValue);

		Event bussUndBettagValue = getBussUndBettag(getWeihnachten(jahr).getDatum());
		String bussUndBettagKey = format(bussUndBettagValue.getDatum());
		map.put(bussUndBettagKey, bussUndBettagValue);

		Event ersterAdventValue = getErsterAdvent(weihnachtenValue.getDatum());
		String ersterAdventKey = format(ersterAdventValue.getDatum());
		map.put(ersterAdventKey, ersterAdventValue);

		Event zweiterAdventValue = getZweiterAdvent(weihnachtenValue.getDatum());
		String zweiterAdventKey = format(zweiterAdventValue.getDatum());
		map.put(zweiterAdventKey, zweiterAdventValue);

		Event dritterAdventValue = getDritterAdvent(weihnachtenValue.getDatum());
		String dritterAdventKey = format(dritterAdventValue.getDatum());
		map.put(dritterAdventKey, dritterAdventValue);

		Event vierAdventValue = getVierterAdvent(weihnachtenValue.getDatum());
		String vierterAdventKey = format(vierAdventValue.getDatum());
		map.put(vierterAdventKey, vierAdventValue);

		Event ostersonntagValue = getOstersonntag(jahr);
		String ostersonntagKey = format(ostersonntagValue.getDatum());
		map.put(ostersonntagKey, ostersonntagValue);

		Event ostermontagValue = getOstermontag(ostersonntagValue.getDatum());
		String ostermonatgKey = format(ostermontagValue.getDatum());
		map.put(ostermonatgKey, ostermontagValue);

		Event rosenmontagValue = getRosenmontag(ostersonntagValue.getDatum());
		String rosenmontagKey = format(rosenmontagValue.getDatum());
		map.put(rosenmontagKey, rosenmontagValue);

		Event aschermittwochValue = getAschermittwoch(ostersonntagValue.getDatum());
		String aschermittwochKey = format(aschermittwochValue.getDatum());
		map.put(aschermittwochKey, aschermittwochValue);

		Event gruendonnerstagValue = getGruendonnerstag(ostersonntagValue.getDatum());
		String gruendonnerstagKey = format(gruendonnerstagValue.getDatum());
		map.put(gruendonnerstagKey, gruendonnerstagValue);

		Event karfreitagValue = getKarfreitag(ostersonntagValue.getDatum());
		String karfreitagKey = format(karfreitagValue.getDatum());
		map.put(karfreitagKey, karfreitagValue);

		Event christiHimmelfahrtValue = getChristiHimmelfahrt(ostersonntagValue.getDatum());
		String christiHimmelfahrtKey = format(christiHimmelfahrtValue.getDatum());
		map.put(christiHimmelfahrtKey, christiHimmelfahrtValue);

		Event pfingstsonntagValue = getPfingstsonntag(ostersonntagValue.getDatum());
		String pfingstsonntagKey = format(pfingstsonntagValue.getDatum());
		map.put(pfingstsonntagKey, pfingstsonntagValue);

		Event pfingstmontagValue = getPfingstmontag(ostersonntagValue.getDatum());
		String pfingstmontagKey = format(pfingstmontagValue.getDatum());
		map.put(pfingstmontagKey, pfingstmontagValue);

		Event fronleichnamValue = getFronleichnam(ostersonntagValue.getDatum());
		String fronleichnamKey = format(fronleichnamValue.getDatum());
		map.put(fronleichnamKey, fronleichnamValue);

		return map;
	}
}