package de.ruzman;

import static de.ruzman.Konfig.INHALT_SPORT;
import static de.ruzman.Konfig.SCHUELER_GEBDATUM;
import static de.ruzman.Konfig.SCHUELER_KLASSE;
import static de.ruzman.Konfig.SCHUELER_NAME;
import static de.ruzman.Konfig.SCHUELER_TABELLE;

import java.sql.SQLException;

/**
 * Enthält Operationen, die im Zusamenhang mit der Jahrgangstufe stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBJahrgang extends DBVerbindung {
	private static final String SELECT_JAHRE = "SELECT DISTINCT RIGHT(" + SCHUELER_GEBDATUM + ",4) AS JAHR FROM "
			+ SCHUELER_TABELLE + " ORDER BY JAHR DESC";
	private static final String SELECT_KURSE = "SELECT DISTINCT " + SCHUELER_KLASSE + " FROM " + SCHUELER_TABELLE
			+ " ORDER BY " + SCHUELER_KLASSE;
	private static final String SELECT_NAMEN = "SELECT " + SCHUELER_NAME + " FROM " + SCHUELER_TABELLE + " WHERE "
			+ SCHUELER_KLASSE + " LIKE ?" + " ORDER BY 1";

	private DBSchueler schueler;

	/**
	 * Konstruktor der Klasse DBJahrgang.
	 */
	public DBJahrgang(DBSchueler schueler) {
		this.schueler = schueler;
	}

	/**
	 * Gibt alle Geburtsjahre der Schüler in absteigender Reihenfolge zurück.
	 * Doppelte Einträge werden gelöscht.
	 *
	 * @return Geburtsjahre des Jahrgangs
	 */
	public String[] gibJahre() {
		try {
			stmt = con.prepareStatement(SELECT_JAHRE);
		} catch (SQLException ex) {
			System.out.println("" + ex);
		}
		// Geburtsjahre:
		return ohneLeerzeilen(gibAusgewaehlteSpalte(rs));
	}

	/**
	 * Gibt alle Kurse in aphabethischer Reiherfolge zurück. Doppelte Einträge
	 * werden gelöscht.
	 *
	 * @return Kurse des Jahrgangs
	 */
	public String[] gibKurse() {
		try {
			stmt = con.prepareStatement(SELECT_KURSE);
		} catch (SQLException ex) {
			System.out.println("" + ex);
		}
		// Kurse:
		return ohneLeerzeilen(gibAusgewaehlteSpalte(rs));
	}

	/**
	 * Gibt die Namen eines gewählten Kurses zurück. Die Namen sind alphabetisch
	 * sotiert.
	 *
	 * @return Namen eines Kurses
	 */
	public String[] gibNamen() {
		try {
			// SQL-Statment:
			stmt = con.prepareStatement(SELECT_NAMEN);
			stmt.setString(1, "%" + schueler.gibKurs() + "%");
		} catch (SQLException ex) {
			System.out.println("" + ex);
		}
		// Namen:
		return gibAusgewaehlteSpalte(rs);
	}

	/**
	 * Gibt die Referenz zu einem beliebigen Schüler des Jahrgangs zurück.
	 *
	 * @return Schüler des Jahrgangs
	 */
	public DBSchueler gibSchueler() {
		return schueler;
	}

	/**
	 * Gibt die Sportkurse eines Jahrgangs zurück.
	 *
	 * @return Sportkurse des Jahrgangs
	 */
	public String[] gibSportkurse() {
		return INHALT_SPORT.toString().split(",");
	}
}
