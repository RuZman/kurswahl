package de.ruzman;

import static de.ruzman.kurswahl13.Konfig.SCHUELER_GEBDATUM;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_KLASSE;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_NAME;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_TABELLE;

import java.sql.SQLException;

import de.ruzman.kurswahl13.DBSchueler;
import de.ruzman.kurswahl13.Konfig;

/**
 * Enthält Operationen, die im Zusamenhang mit der Jahrgangstufe stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBJahrgang extends DBVerbindung {
	private static final String SELECT_JAHRE = "SELECT RIGHT(" + SCHUELER_GEBDATUM + ",4) FROM " + SCHUELER_TABELLE
			+ " GROUP BY RIGHT(" + SCHUELER_GEBDATUM + ",4)";
	private static final String SELECT_KURSE = "SELECT " + SCHUELER_KLASSE + " FROM " + SCHUELER_TABELLE + " GROUP BY "
			+ SCHUELER_KLASSE + " ORDER BY " + SCHUELER_KLASSE;
	private static final String SELECT_NAMEN = "SELECT " + SCHUELER_NAME + " FROM " + SCHUELER_TABELLE + " WHERE "
			+ SCHUELER_KLASSE + " LIKE ?" + " GROUP BY " + SCHUELER_NAME + " ORDER BY 1";

	private DBSchueler schueler;
	private DBLogin login;

	/**
	 * Konstruktor der Klasse DBJahrgang.
	 */
	public DBJahrgang() {
		initialisiere();
	}

	/**
	 * Initialisierung von der Klasse DBJahrgang.
	 */
	private void initialisiere() {
		schueler = new DBSchueler();
		login = new DBLogin(schueler);
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
			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println("" + ex);
		}
		// Geburtsjahre:
		return gibAusgewaehlteSpalte(rs);
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
			rs = stmt.executeQuery();
		} catch (SQLException ex) {
			System.out.println("" + ex);
		}
		// Kurse:
		return gibAusgewaehlteSpalte(rs);
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
			rs = stmt.executeQuery();
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

	public DBLogin gibLogin() {
		return login;
	}

	/**
	 * Gibt die Sportkurse eines Jahrgangs zurück.
	 *
	 * @return Sportkurse des Jahrgangs
	 */
	public String[] gibSportkurse() {
		return Konfig.INHALT_SPORT.toString().split(",");
	}
}
