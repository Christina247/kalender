package dateiIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import kalender.Event;

/**
 * Liest Dateien ein und wandelt diese in einen String um.
 * 
 * @author Christina Bachhuber <s0560103@htw-berlin.de>
 * @version 1.8.0
 * @since 1.8.0
 */
public class Reader {

	/**
	 * Liest eine Datei ein und speichert die eingelesenen Spalten in eine
	 * ArrayListe des Typs Event.
	 * 
	 * @param dateiname
	 * @return ArrayListe mit Datum und Name.
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Event> reader(String dateiname) throws FileNotFoundException {

		ArrayList<Event> events = new ArrayList<Event>();
		File datei = new File(dateiname);
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(datei));
			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				String[] bestandteile = zeile.split(";");
				String datum = bestandteile[0];
				String name = bestandteile[1];
				SimpleDateFormat format = new SimpleDateFormat("dd." + "MM.yyyy");
				Date date = format.parse(datum);
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				Event event = new Event(name, calendar);
				events.add(event);
			}
			in.close();
		} catch (IOException | ParseException | IndexOutOfBoundsException e) {
			System.err.println("Datei konnte nicht gelesen werden.");
		}
		return events;
	}

	/**
	 * Wandelt die eingelesene ArrayListe in einen String um.
	 * 
	 * @param content
	 * @return String
	 */
	public static String wandleUm(ArrayList<Event> content) {
		String str = "";
		for (Event event : content) {
			str += event.getDatumAsString() + ": " + event.getName() + System.lineSeparator();
		}
		return str;
	}
}