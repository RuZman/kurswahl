package de.ruzman.kurswahl13;

import de.ruzman.Konfiguration;

/**
 * Das Enum Konfig weist den einzelnen Zeilen aus der konfig.ini Variablen zu.
 * Dazu sind aber ensprechende Richtlinien zu beachten, siehe Dokumunetation.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public enum Konfig {
	// Pfad zur Datenbank
	DATENBANK_PFAD,

	// Inforamtionen zur Tabelle "Schueler":
	SCHUELER_TABELLE, SCHUELER_KLASSE, SCHUELER_GEBDATUM, SCHUELER_GEBORT, SCHUELER_SCHULFORM, SCHUELER_NAME,

	// Informationen zur Tabelle "Kurs":
	KURS_TABELLE, KURS_LEHRER, KURS_KURSBEZEICHNUNG, KURS_KURSART, KURS_FACHBEZEICHNUNG, KURS_KURSSTUNDEN, KURS_KLASSENNAMEN, KURS_SCHULERNAMEN, KURS_SCHULFORMEN,

	// Tabelle mit den gewählten Kursen:
	ERGENIS_TABELLE,

	// Zustandsoptionen:
	INHALT_WAHLPFLICHT, INHALT_SPORT, ZUSTAND_CHKRELIGION, ZUSTAND_RELIGION, INHALT_RELIGION, ZUSTAND_ZUSATZ1, ZUSTAND_ZUSATZ2, ZUSTAND_SPORTWAHL;

	// Konfiguration, die gesetzt wurde:
	private String einstellung;

	/**
	 * Konstruktor der Klasse Konfig.
	 */
	private Konfig() {
		initalisiere();
	}

	/**
	 * Initalisierung vom Konfig Enum.
	 */
	public void initalisiere() {
		/*
		 * Die Zeilen in der konfig.ini sind entsprechend des Konfig-Enums
		 * sotiert. D.h. Zeile in konfig.ini = Konfig.BEZEICHNER.oridnal().
		 */
		einstellung = Konfiguration.gibInstanz().gibZeile(this.ordinal());
	}

	/**
	 * Gibt die gesetzte Konfiguration zurück.
	 * 
	 * @return Die gesetzte Konfiguration.
	 */
	@Override
	public String toString() {
		return einstellung;
	}
}