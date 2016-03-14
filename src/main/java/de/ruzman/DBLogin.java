package de.ruzman;

import static de.ruzman.kurswahl13.Konfig.SCHUELER_GEBDATUM;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_GEBORT;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_KLASSE;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_NAME;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_TABELLE;

import java.sql.SQLException;

import de.ruzman.kurswahl13.DBSchueler;

public class DBLogin extends DBVerbindung {
	private static final String SELECT_GEBURTSDATUM = "SELECT Count(" + SCHUELER_GEBDATUM + ") FROM "
			+ SCHUELER_TABELLE + " WHERE " + SCHUELER_NAME + " LIKE ? AND " + SCHUELER_KLASSE + " LIKE ? AND "
			+ SCHUELER_GEBDATUM + " = ?";
	private static final String SELECT_GEBURTSORT = "SELECT Count(" + SCHUELER_GEBORT + ") FROM " + SCHUELER_TABELLE
			+ " WHERE " + SCHUELER_NAME + " LIKE ? AND " + SCHUELER_KLASSE + " LIKE ? AND (" + SCHUELER_GEBORT
			+ " LIKE ? OR " + SCHUELER_GEBORT + " = ? )";

	private DBSchueler schueler;

	public DBLogin(DBSchueler schueler2) {
		this.schueler = schueler2;
	}

	/**
	 * Gibt zurück, ob das übergebene Geburtsdatum mit dem in der Datenbank
	 * übereinstimmt.
	 * 
	 * @param gebDatum
	 *            Geburtsdatum, des überprüft werden soll.
	 * @return True, das Geburtsdatum stimmt überein.
	 */
	public boolean istGeburtsdatum(String gebDatum) {
		try {
			stmt = con.prepareStatement(SELECT_GEBURTSDATUM);
			stmt.setString(1, schueler.gibName());
			stmt.setString(2, "%" + schueler.gibKurs() + "%");
			stmt.setString(3, gebDatum);
			rs = stmt.executeQuery();
			rs.next();
			// Wenn die Anzahl der gefundenen Treffer gleich 1 ist, ist das
			// Geburtsdatum korrekt:
			return rs.getInt(1) == 1;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * Gibt zurück, ob die ersten 3 Zeichen des übergebenen Geburtortes mit dem
	 * in der Datenbank übereinstimmen.
	 * 
	 * @param gebOrt
	 *            Geburtsort, des überprüft werden soll.
	 * @return True, wenn die ersten 3 Zeichen des Geburtortes übereinstimmen
	 */
	public boolean istGeburtsort(String gebOrt) {
		try {
			// Überprüft, ob mindestens 3 Zeichen eingeben werden.
			if (gebOrt.length() > 2) {
				stmt = con.prepareStatement(SELECT_GEBURTSORT);
				stmt.setString(1, schueler.gibName());
				stmt.setString(2, "%" + schueler.gibKurs() + "%");
				stmt.setString(3, gebOrt + "%");
				stmt.setString(4, gebOrt);
				rs = stmt.executeQuery();
				rs.next();
				// Wenn die Anzahl der gefundenen Treffer gleich 1 ist, dann
				// stimmen die ersten 3 Zeichen des Geburtortes überein:
				return rs.getInt(1) == 1;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
