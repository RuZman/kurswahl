package de.ruzman.kurswahl11;

import de.ruzman.Konfiguration;

/**
 * Startklasse für das Kurswahlprogramm. Dient allein zur Übersicht.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Main {

	/**
	 * Startet die Kurswahlanwendung.
	 * 
	 * @param ars
	 *            Es weden Argumente aus der Konsole berücksichtigt!
	 */
	public static void main(String[] ars) {
		// FIXME: Workaround to set konfig
		Konfiguration.gibInstanz("konfig11.ini");

		// Führt die Anwendung in einen eigenen Thread aus:
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Ruft das Kurswahlfenster auf und macht es sichtbar:
				new de.ruzman.gui11.Kurswahlfenster11().setVisible(true);
			}
		});
	}
}
