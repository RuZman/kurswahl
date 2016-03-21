package de.ruzman.kurswahl13;

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
	public static void main(String[] args) {
		// FIXME: Workaround to set konfig
		Konfiguration.gibInstanz(args.length > 0 ? args[0] : "konfig13.ini");
		// Führt die Anwendung in einen eigenen Thread aus:
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Ruft das Kurswahlfenster auf und macht es sichtbar:
				new de.ruzman.gui13.Kurswahlfenster13().setVisible(true);
			}
		});
	}
}
