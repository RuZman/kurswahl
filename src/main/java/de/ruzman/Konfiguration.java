package de.ruzman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

/**
 * Liest die Konfigurationsdatei aus und speichert deren Inhalt in einer
 * ArrayList ab. Auf diese kann man über die Methoden zugreifen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Konfiguration {
	// Instanz der Klasse Konfiguration:
	private static Konfiguration instanz;
	private File JAR_DIR;

	// Enthält alle informativen Zeilen der Konfigurationsdatei:
	private ArrayList<String> txtKonf;

	/**
	 * Konstruktor der Klasse Konfiguration.
	 */
	private Konfiguration(String dateiName) {
		try {
			JAR_DIR = new File(URLDecoder.decode(Konfiguration.class.getProtectionDomain().getCodeSource()
					.getLocation().getPath(), "UTF-8"));
			initalisiere(dateiName);
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Initialisierung der Konfiguration.
	 */
	private void initalisiere(String dateiName) {
		txtKonf = new ArrayList<String>();

		try {
			// Stream öffnen:
			BufferedReader input = oeffneDatei(dateiName);

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
	public static Konfiguration gibInstanz(String dateiName) {
		// Wenn noch keine Instanz ezestiert, eine erzeugen:
		if (instanz == null) {
			instanz = new Konfiguration(dateiName);
		}
		return instanz;
	}

	public static Konfiguration gibInstanz() {
		if (instanz == null) {
			instanz = new Konfiguration("konfig.ini");
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
		return new BufferedReader(new InputStreamReader(new FileInputStream(getPathFromRoot("/" + dateiName))));
	}

	/**
	 * Sucht den Ordner der JAR-Datei und fügt dann den Parameter path hinzu.
	 * 
	 * @param path
	 *            Pfad, welcher hinzugefügt werden soll.
	 * @return Pfad, ausgehend von der JAR-Datei.
	 */
	public String getPathFromRoot(String path) {
		String url = null;

		try {
			url = URLDecoder.decode(JAR_DIR.getParentFile().getPath() + path, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}

		return url;
	}
}