package de.ruzman;

import static de.ruzman.kurswahl13.Konfig.ERGENIS_TABELLE;
import static de.ruzman.kurswahl13.Konfig.KURS_FACHBEZEICHNUNG;
import static de.ruzman.kurswahl13.Konfig.KURS_KLASSENNAMEN;
import static de.ruzman.kurswahl13.Konfig.KURS_KURSSTUNDEN;
import static de.ruzman.kurswahl13.Konfig.KURS_LEHRER;
import static de.ruzman.kurswahl13.Konfig.KURS_SCHULERNAMEN;
import static de.ruzman.kurswahl13.Konfig.KURS_SCHULFORMEN;
import static de.ruzman.kurswahl13.Konfig.KURS_TABELLE;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_GEBDATUM;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_GEBORT;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_KLASSE;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_NAME;
import static de.ruzman.kurswahl13.Konfig.SCHUELER_TABELLE;

import java.sql.SQLException;

import de.ruzman.kurswahl13.Konfig;

/**
 * Enthält Operationen, die im Zusamenhang mit einem einzelnen Schüler stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public abstract class DBSchueler extends DBVerbindung {
	private static final String SELECT_GEBURTSDATUM = "SELECT Count(" + SCHUELER_GEBDATUM + ") FROM "
			+ SCHUELER_TABELLE + " WHERE " + SCHUELER_NAME + " LIKE ? AND " + SCHUELER_KLASSE + " LIKE ? AND "
			+ SCHUELER_GEBDATUM + " = ?";
	private static final String SELECT_GEBURTSORT = "SELECT Count(" + SCHUELER_GEBORT + ") FROM " + SCHUELER_TABELLE
			+ " WHERE " + SCHUELER_NAME + " LIKE ? AND " + SCHUELER_KLASSE + " LIKE ? AND (UPPER(" + SCHUELER_GEBORT
			+ ") LIKE UPPER(?) OR UPPER(" + SCHUELER_GEBORT + ") = UPPER(?) )";
	private static final String SELECT_FACH = "SELECT Count(" + KURS_FACHBEZEICHNUNG + ") FROM " + Konfig.KURS_TABELLE
			+ " WHERE " + KURS_SCHULERNAMEN + " LIKE ? AND " + KURS_KLASSENNAMEN + " LIKE ? AND "
			+ KURS_FACHBEZEICHNUNG + " LIKE ?";
	private static final String SELECT_BEZEICHNUNG = "SELECT " + KURS_SCHULFORMEN + " FROM " + KURS_TABELLE + " WHERE "
			+ KURS_SCHULERNAMEN + " LIKE ?" + " AND " + KURS_KLASSENNAMEN + " LIKE ?";
	private static final String SELECT_LEHRER = "SELECT " + KURS_LEHRER + " FROM " + KURS_TABELLE + " WHERE "
			+ KURS_SCHULERNAMEN + " LIKE ? AND " + KURS_KLASSENNAMEN + " LIKE ? " + "AND " + KURS_FACHBEZEICHNUNG
			+ " LIKE ?";
	private static final String SELECT_MATHE_LK_STUNDEN = "SELECT Kursstunden FROM " + KURS_TABELLE
			+ " WHERE Kursart='L' AND Fachbezeichnung" + "='Mathematik' GROUP BY Kursstunden";
	private static final String SELECT_LK_STUNDEN = "SELECT Fachbezeichnung FROM Kurs WHERE Kursstunden = ?" + " AND "
			+ KURS_SCHULERNAMEN + " LIKE ? AND " + KURS_KLASSENNAMEN + " LIKE ? GROUP BY Fachbezeichnung";
	private static final String SELECT_KURS = "SELECT Kursbezeichnung FROM " + KURS_TABELLE + " WHERE "
			+ KURS_SCHULERNAMEN + " LIKE ? AND " + KURS_KLASSENNAMEN + " LIKE ? " + "AND Fachbezeichnung LIKE ?";
	private static final String SELECT_STUNDEN = "SELECT " + KURS_KURSSTUNDEN + " FROM " + Konfig.KURS_TABELLE
			+ " WHERE " + KURS_SCHULERNAMEN + " LIKE ? AND " + KURS_KLASSENNAMEN + " LIKE ? AND "
			+ KURS_FACHBEZEICHNUNG + "=?";
	private static final String SELECT_FACHRICHTUNG1 = "SELECT Fachrichtung FROM Fachrichtung, Kurs WHERE "
			+ "Fachrichtung.Kurs = Kurs.Kursbezeichnung AND " + KURS_SCHULERNAMEN + " LIKE ? AND " + KURS_KLASSENNAMEN
			+ " LIKE ? GROUP BY Fachrichtung";
	private static final String SELECT_FACHRICHTUNG2 = "SELECT Fachrichtung FROM Fachrichtung,"
			+ " Kurs WHERE Fachrichtung.Schulform = Kurs.USFBKSchueler AND " + KURS_SCHULERNAMEN + " LIKE ? AND "
			+ KURS_KLASSENNAMEN + " LIKE ? GROUP BY Fachrichtung";

	protected String kurs;
	protected String name;
	protected String fachrichtung;

	// Ob der letzte SQL-Update erfolgreich verlief:
	protected boolean gespeichert;

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
			stmt.setString(1, name);
			stmt.setString(2, "%" + kurs + "%");
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
				stmt.setString(1, name);
				stmt.setString(2, "%" + kurs + "%");
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

	/**
	 * Prüft nach, ob der Schüler ein bestimmtes Fach belegt hat.
	 *
	 * @param fach
	 *            Zu überprüfendes Fach
	 * @return True, wenn er das Fach belegt hat
	 */
	public boolean belegtFach(String fach) {
		try {
			stmt = con.prepareStatement(SELECT_FACH);
			stmt.setString(1, name.trim());
			stmt.setString(2, "%" + kurs + "%");
			stmt.setString(3, fach);
			rs = stmt.executeQuery();
			rs.next();
			// Wenn das Fach dem Schüler 1x in der Datenbank zugewiesen wurde:
			return rs.getInt(1) == 1;
		} catch (SQLException ex) {
			System.out.println("1: " + ex);
		}
		return false;
	}

	/**
	 * Gibt die Bezeichnung des Schülers zurück. Diese ist in der Regel die
	 * Schulform im Format: "BGYM/WIRT/---".
	 *
	 * @return Bezeichnung des Schülers
	 */
	public String gibBezeichung() {
		try {
			stmt = con.prepareStatement(SELECT_BEZEICHNUNG);
			stmt.setString(1, name.trim());
			stmt.setString(2, "%" + kurs + "%");
			rs = stmt.executeQuery();
			rs.next();
			// Bezeichnung:
			return rs.getString(1);
		} catch (SQLException ex) {
			System.out.println("2: " + ex);
		}
		return "";
	}

	/**
	 * Gibt die Fachrichtung des Schülers zurück.
	 *
	 * @return Fachrichtung des Schülers.
	 */
	public String gibFachrichtung() {
		return fachrichtung;
	}

	/**
	 * Gibt den Kurs/die Klasse des Schülers zurück, in der er sich befindet.
	 *
	 * @return Kurs des Schülers
	 */
	public String gibKurs() {
		return kurs;
	}

	/**
	 * Gibt das Kürzel eines Lehrers zurück, von einem speziellen Fach, welches
	 * der Schüler besucht.
	 *
	 * @param fach
	 *            Fach, wo der Lehrer zu ermitteln ist
	 * @return Kürzel des Lehrers
	 */
	public String gibLehrer(String fach) {
		try {
			stmt = con.prepareStatement(SELECT_LEHRER);
			stmt.setString(1, name.trim());
			stmt.setString(2, "%" + kurs + "%");
			stmt.setString(3, fach);
			rs = stmt.executeQuery();
			rs.next();
			// Lehrer Kürzel:
			return rs.getString(1).replace("'", "");
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		return "";
	}

	/**
	 * Gibt den 1. Leistungskurs (Mathe, Deutsch, etc.) zurück.
	 * 
	 * @return 1. Leistungskurs der Schüelers
	 */
	public String gibLeistungskurs() {
		try {
			// SQL-Statement, um die Anzahl der Stunden für MatheLK
			// herrauszufinden:
			// (Mathe wird es immer als Leistungskurs geben)
			stmt = con.prepareStatement(SELECT_MATHE_LK_STUNDEN);
			rs = stmt.executeQuery();
			rs.next();
			int stunden = rs.getInt(1);
			// SQL-Statment, um durch die Stundenanzahl den LK herauszufinden:
			stmt = con.prepareStatement(SELECT_LK_STUNDEN);
			stmt.setInt(1, stunden);
			stmt.setString(2, name.trim());
			stmt.setString(3, "%" + kurs + "%");
			rs = stmt.executeQuery();
			rs.next();
			// Leistungskurs:
			return rs.getString(1);
		} catch (SQLException ex) {
			System.out.println("4: " + ex);
		}
		return "";
	}

	/**
	 * Gibt die Kursbezeichnung eines bestimmten Faches zurück.
	 * 
	 * @param fach
	 *            Fach, dessen Kursbezeichnung gesucht wird
	 * @return Kursbezeichnung eines Faches
	 */
	public String gibKurs(String fach) {
		try {
			stmt = con.prepareStatement(SELECT_KURS);
			stmt.setString(1, name.trim());
			stmt.setString(2, "%" + kurs + "%");
			stmt.setString(3, fach);
			rs = stmt.executeQuery();
			rs.next();
			// Kursbezeichnung:
			return rs.getString(1).replace("'", "");
		} catch (SQLException ex) {
			// FIXME: Gibt Probleme bei Leuten ohne Rechnungswesen
			// ex.printStackTrace();
		}
		return "";
	}

	/**
	 * Gibt den Namen eines Schülers zurück im Format: "Nachname, Vorname"
	 * 
	 * @return Name des Schülers
	 */
	public String gibName() {
		return name.replace("_", "'");
	}

	/**
	 * Gibt die Kurstunden eines bestimmten Faches zurück.
	 * 
	 * @param fach
	 *            Fach, dessen Kursstunden herrausgefunden werden sollen
	 * @return Kursstunden eines Faches
	 */
	public int gibStunden(String fach) {
		try {
			stmt = con.prepareStatement(SELECT_STUNDEN);
			stmt.setString(1, name.trim());
			stmt.setString(2, "%" + kurs + "%");
			stmt.setString(3, fach);
			rs = stmt.executeQuery();
			rs.next();
			// Kursstunden:
			return rs.getInt(1);
		} catch (SQLException ex) {
			System.out.println("5: " + ex);
		}
		return -1;
	}

	/**
	 * Fachrichtung des Schülers wird ermittelt und gespeichert.
	 */
	public void setzeFachrichtung() {
		try {
			// SQL-Statement, um zu überprüfen, ob der Schüler in einer Klasse
			// mit
			// zwei Fachrichtungen ist:
			stmt = con.prepareStatement(SELECT_FACHRICHTUNG1);
			stmt.setString(1, name.trim());
			stmt.setString(2, "%" + kurs + "%");
			rs = stmt.executeQuery();
			rs.next();
			// Fachrichtung:
			fachrichtung = rs.getString(1);
		} catch (SQLException ex) {
			try {
				// SQL-Statement, gibt die Fachrichtung des Schüles zurück, wenn
				// dieser nicht in einer Klasse mit 2 Fachrichtungen ist:
				stmt = con.prepareStatement(SELECT_FACHRICHTUNG2);
				stmt.setString(1, name.trim());
				stmt.setString(2, "%" + kurs + "%");
				rs = stmt.executeQuery();
				rs.next();
				// Fachrichtung:
				fachrichtung = rs.getString(1);
			} catch (SQLException ex2) {
				System.out.println("8: " + ex2);
			}
		}
	}

	/**
	 * Setzt den Kurs, in dem sich der Schüler befindet.
	 *
	 * @param kurs
	 *            Kurs, in dem sich der Schüler befindet
	 */
	public void setzeKurs(String kurs) {
		this.kurs = kurs;
	}

	/**
	 * Setzt den Namen des Schülers.
	 *
	 * @param name
	 *            Name des Schülers.
	 */
	public void setzeName(String name) {
		this.name = name.replace("'", "_");
	}

	/**
	 * Überprüft, ob das letze SQL-Update gespeichert wurde.
	 *
	 * @return True, falls das letze Update gespeichert wurde.
	 */
	public boolean istGespeichert() {
		return gespeichert;
	}

	/**
	 * Generiert eine SQL-Anweisung für den Update.
	 *
	 * @param updates
	 *            String-Array mit {[Spaltenname], [Inhalt]}
	 * @return True, wenn das Update geglückt ist.
	 */
	protected boolean update(String[][] updates) {
		try {
			stmt = con.prepareStatement("SELECT * FROM Ergebnis WHERE Name like ? and Kurs like ?");
			stmt.setString(1, name);
			stmt.setString(2, kurs);
			rs = stmt.executeQuery();

			// Schueler anlegen, falls es noch keinen gibt
			if (!rs.next()) {
				stmt = con.prepareStatement("INSERT INTO " + ERGENIS_TABELLE + " (Name, Kurs) VALUES (?, ?)");
				stmt.setString(1, name);
				stmt.setString(2, kurs);
				stmt.executeUpdate();
			}

			// Anfang: Generiert Update Anweisung
			String update = "";
			for (int i = 0; i < updates.length; i++) {
				if (i == 0) {
					update = update + updates[i][0] + "='" + updates[i][1] + "'";
				} else {
					if (updates[i][1].equals("0") || updates[i][1].equals("-1")) {
						update += ", " + updates[i][0] + "=" + updates[i][1] + "";
					} else {
						update += ", " + updates[i][0] + "='" + updates[i][1] + "'";
					}
				}
			}

			stmt = con.prepareStatement("UPDATE " + Konfig.ERGENIS_TABELLE + " SET " + update
					+ " WHERE Name=? AND Kurs=?");
			stmt.setString(1, name);
			stmt.setString(2, kurs);
			stmt.executeUpdate();
			// Ende: Generiert Update Anweisung
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void wiederholen() {
		if (update(new String[][] {
				// Schülerdaten:
				{ "Name", name.replace("_", "’") }, { "Fachrichtung", fachrichtung }, { "Kurs", kurs },

				// Klasse wiederholen:
				{ "klasseWiederholen", "-1" }, { "schuleVerlassen", "0" } })) {
			// Update gelungen:
			gespeichert = true;
		} else {
			// Update fehlgeschlagen:
			gespeichert = false;
		}
	}

	public void verlassen() {
		if (update(new String[][] {
				// Schülerdaten:
				{ "Name", name.replace("_", "’") }, { "Fachrichtung", fachrichtung }, { "Kurs", kurs },

				// Schule verlassen:
				{ "klasseWiederholen", "0" }, { "schuleVerlassen", "-1" } })) {
			// Update gelungen:
			gespeichert = true;
		} else {
			// Update fehlgeschlagen:
			gespeichert = false;
		}
	}
}