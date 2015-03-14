package de.ruzman.kurswahl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Liest die Konfigurationsdatei aus und speichert deren Inhalt in einer
 * ArrayList ab. Auf diese kann man über die Methoden zugreifen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Konfiguration {
	// Name der Konfigurationsdatei:
	private final String DATEI_NAME = "konfig.ini";
	// Instanz der Klasse Konfiguration:
	private static Konfiguration instanz;

	// Enthält alle informativen Zeilen der Konfigurationsdatei:
	private ArrayList<String> txtKonf;

	/**
	 * Konstruktor der Klasse Konfiguration.
	 */
	private Konfiguration() {
		initalisiere();
	}

	/**
	 * Initialisierung der Konfiguration.
	 */
	private void initalisiere() {
		txtKonf = new ArrayList<String>();

		try {
			// Stream öffnen:
			BufferedReader input = oeffneDatei(DATEI_NAME);

			// Stream in eine ArrayList packen:
			leseDateiEin(input);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	/**
	 * Gibt die Instanz der Klasse Konfiguration zurück. (Singelton).
	 *
	 * @return Instanz der Klasse Konfiguration.
	 */
	public static Konfiguration gibInstanz() {
		// Wenn noch keine Instanz ezestiert, eine erzeugen:
		if (instanz == null) {
			instanz = new Konfiguration();
		}
		return instanz;
	}

	/**
	 * Gibt eine Zeile aus der Konfigurationsdatei zurück.
	 *
	 * @param zeile
	 *            Zeile, die aus der konfig.ini ausgelesen werden soll.
	 * @return Ausgelesene Zeile.
	 */
	public String gibZeile(int zeile) {
		return txtKonf.get(zeile).split("\"")[1];
	}

	/**
	 * Liest die Konfigurationsdatei aus und speichert diese in einer ArrayList
	 * ab.
	 *
	 * @param input
	 *            Stream der Konfigurationsdatei
	 * @throws IOException
	 *             Falls beim Einlesen ein Fehler auftritt.
	 */
	private void leseDateiEin(BufferedReader input) throws IOException {
		String inputText;
		// Solange es einen Input gibt:
		while ((inputText = input.readLine()) != null) {
			/*
			 * Kommentar -> ";" oder Sektionszeilen -> "[", nach allgemeinen
			 * Umsetzung für INI-Dateien:
			 */
			if (!inputText.startsWith("[") && !inputText.equals("") && !inputText.equals(";")
					&& inputText.contains("\"")) {
				txtKonf.add(inputText);
			}
		}
		input.close();
	}

	/**
	 * Gibt die URL zur Konfigurationsdatei zurück.
	 *
	 * @param dateiName
	 *            Name der Datei, die eingelesen werden soll.
	 * @return URL zu der Konfigurationsdatei.
	 * @throws IOException
	 *             Falls die Datei nicht gefunden wird.
	 */
	private BufferedReader oeffneDatei(String dateiName) throws IOException {
		// Pfad zur Jar-Datei:
		java.net.URL url = Konfiguration.class.getResource(dateiName);
		String[] buffer = (url.toString()).split("/");
		buffer[buffer.length - 2] = "";
		String pfad = "";
		for (String s : buffer) {
			// Löscht die URL-Informationen aus dem Pfad
			pfad = pfad + (s.replace("jar:", "")).replace("file:", "") + "/";
		}
		// Öffnet einen Stream zur Datei (Zeichen in UTF-8):
		return new BufferedReader(new InputStreamReader(new FileInputStream(pfad.replace("/", "\\")), "UTF-8"));
	}
}