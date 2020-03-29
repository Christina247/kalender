package kalender;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Stellt ein Ereignis in Form eines Events dar. Zum Beispiel:
 * Event(name=Ostersonntag, datum=16-04-2017).
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class Event {

	public enum Intervall {
		JAEHRLICH, WOECHENTLICH, TAEGLICH
	};

	private String name;
	private GregorianCalendar datum;
	private Intervall zeitraum;

	/**
	 * Erzeugt ein sich wiederholendes (Intervall) Event mit Name und Datum.
	 * 
	 * @param name
	 *            Name des Events als String.
	 * @param datum
	 *            Datum des Events als GregorianCalendar.
	 * @param zeitraum
	 *            Das zyklische Intervall der Wiederholung des Events.
	 */
	public Event(String name, GregorianCalendar datum, Intervall zeitraum) {
		this.name = name;
		this.datum = datum;
		this.zeitraum = zeitraum;
	}

	/**
	 * Erzeugt ein sich nicht wiederholendes Event mit Namen und Datum.
	 * 
	 * @param name
	 *            Name des Events als String.
	 * @param datum
	 *            Datum des Events als GregorianCalendar.
	 */
	public Event(String name, GregorianCalendar datum) {
		this.name = name;
		this.datum = datum;
	}

	public Event() {
	}

	/**
	 * Gibt das Intervall zurueck.
	 * 
	 * @return zeitraum.
	 */
	public Intervall getZeitraum() {
		return zeitraum;
	}

	/**
	 * Gibt den Namen zurueck.
	 * 
	 * @return name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gibt das Datum zurueck.
	 * 
	 * @return datum
	 */
	public GregorianCalendar getDatum() {
		return datum;
	}

	/**
	 * Gibt das Eventdatum als String zurueck.
	 * 
	 * @return
	 */
	public String getDatumAsString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		fmt.setCalendar(datum);
		String dateFormatted = fmt.format(datum.getTime());
		return dateFormatted;
	}

	/**
	 * True: Feiertag besitzt Intervall, False: Feiertag besitzt kein Intervall.
	 * 
	 * @return true oder false.
	 */
	public boolean hasIntervall() {
		if (zeitraum != null) {
			return true;
		}
		return false;
	}
}