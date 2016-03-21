package de.ruzman.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import de.ruzman.DBJahrgang;

public class Kurswahlfenster extends JFrame {
	// Zur Kommunikation mit einer Datenbank:
	// Darf während einer Kurswahl nicht geändert werden! -> final
	protected static DBJahrgang jahrgang;

	protected JLayeredPane jLayeredPane;
	// Zähler für den nächsten JPanel, die angezeigt werden soll:
	protected int panelZeahler;

	/**
	 * Rückt das nächste Panel in den Vordergrund.
	 */
	public void naechstesPanel() {
		Component component = jLayeredPane.getComponent(++panelZeahler % 3);
		// Titel setzen:
		setTitle(component.toString());
		// Größe des Fensters an der neuen JPanel anpassen:
		setSize(component.getWidth(), component.getHeight());
		zentriereFenster();
		// In den Ausgangszustand versetzen:
		((Erneuerbar) component).zuruecksetzen();
		// JPanel in den Vordergrund stellen:
		component.setVisible(true);
	}

	/**
	 * Zentriert das Fenster auf dem Bildschirm.
	 */
	private void zentriereFenster() {
		// Bildschirmauflösung herrausfinden:
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		// Kurswahlfenster zentrieren:
		setLocation((int) (screenDimension.getWidth() - getWidth()) / 2,
				(int) (screenDimension.getHeight() - getHeight()) / 2);
	}

	/**
	 * Rückt das nächste Panel in den Vordergrund.
	 */
	public void vorherigesPanel() {
		Component component = jLayeredPane.getComponent(--panelZeahler % 3);
		// Titel setzen:
		setTitle(component.toString());
		// Größe des Fensters an der neuen JPanel anpassen:
		setSize(component.getWidth(), component.getHeight());
		zentriereFenster();
		// In den Ausgangszustand versetzen:
		((Erneuerbar) component).zuruecksetzen();
		// JPanel in den Vordergrund stellen:
		component.setVisible(true);
	}

	/**
	 * Füllt eine JCombobox mit einer bestimmten Liste. Der erste Eintrag ist
	 * frei wählbar.
	 *
	 * @param auswahl
	 *            JCombobox, die geändert werden soll.
	 * @param name
	 *            Erstes Element für die JCombobox.
	 * @param items
	 *            Die neuen Elemente der JCombobox.
	 */
	public static void loescheUndSetzeComboBox(JComboBox auswahl, String name, String[] items, boolean trim) {
		// Löscht alle Einträge aus der JCombobox:
		auswahl.removeAllItems();

		// Falls das erste Item gesondert benannt werden soll:
		auswahl.addItem(name);
		for (String s : items) {
			/*
			 * Formatierungsfehler, die bei der Datenbank enstehen nicht
			 * anzeigen. Zum Beispiel wird aus "'12DV2'" -> "12DV2".
			 */
			if (s.startsWith("'")) {
				s = s.substring(1);
			}
			if (s.endsWith("'")) {
				s = s.substring(0, s.length() - 1);
			}
			if (trim) {
				auswahl.addItem(s.trim());
			} else {
				auswahl.addItem(s);
			}
		}
	}

	/**
	 * Füllt eine JCombobox mit einer bestimmten Liste.
	 *
	 * @param auswahl
	 *            JCombobox, die geändert werden soll.
	 * @param items
	 *            Die neuen Elemente der JCombobox.
	 */
	public static void loescheUndSetzeComboBox(JComboBox auswahl, String[] items) {
		// Löscht alle Einträge aus der JCombobox:
		auswahl.removeAllItems();

		for (String s : items) {
			/*
			 * Formatierungsfehler, die bei der Datenbank enstehen nicht
			 * anzeigen. Zum Beispiel wird aus "'12DV2'" -> "12DV2".
			 */
			if (s.startsWith("'")) {
				s = s.substring(1);
			}
			if (s.endsWith("'")) {
				s = s.substring(0, s.length() - 1);
			}
			auswahl.addItem(s);
		}
	}

	public static de.ruzman.DBJahrgang gibDBJahrgang() {
		return jahrgang;
	}
}
