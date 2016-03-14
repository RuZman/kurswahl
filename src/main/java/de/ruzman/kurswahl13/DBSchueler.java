package de.ruzman.kurswahl13;

import static de.ruzman.kurswahl13.Konfig.ERGENIS_TABELLE;
import static de.ruzman.kurswahl13.Konfig.KURS_FACHBEZEICHNUNG;
import static de.ruzman.kurswahl13.Konfig.KURS_KLASSENNAMEN;
import static de.ruzman.kurswahl13.Konfig.KURS_KURSSTUNDEN;
import static de.ruzman.kurswahl13.Konfig.KURS_LEHRER;
import static de.ruzman.kurswahl13.Konfig.KURS_SCHULERNAMEN;
import static de.ruzman.kurswahl13.Konfig.KURS_SCHULFORMEN;
import static de.ruzman.kurswahl13.Konfig.KURS_TABELLE;

import java.sql.SQLException;

import de.ruzman.DBVerbindung;

/**
 * Enthält Operationen, die im Zusamenhang mit einem einzelnen Schüler stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBSchueler extends DBVerbindung {
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

	private String kurs;
	private String name;
	private String fachrichtung;

	// Ob der letzte SQL-Update erfolgreich verlief:
	private boolean gespeichert;

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
	 * Überprüft, ob das letze SQL-Update gespeichert wurde.
	 *
	 * @return True, falls das letze Update gespeichert wurde.
	 */
	public boolean istGespeichert() {
		return gespeichert;
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
			System.out.println("3: " + ex);
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
			System.out.println("7: " + ex);
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
	 * Generiert eine SQL-Anweisung für den Update.
	 *
	 * @param updates
	 *            String-Array mit {[Spaltenname], [Inhalt]}
	 * @return True, wenn das Update geglückt ist.
	 */
	private boolean update(String[][] updates) {
		try {
			try {
				// Versucht einen Schüler anzulegen:
				stmt = con.prepareStatement("INSERT INTO " + ERGENIS_TABELLE + " (Name, Kurs) VALUES (?, ?)");
				stmt.setString(1, name);
				stmt.setString(2, kurs);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// Nicht schlimm, da ein Benutzer schon angelegt ist!
			}
			// +------------- Anfang: Generiert Update Anweisung
			// ----------------
			String update = "";
			for (int i = 0; i < updates.length; i++) {
				if (i == 0) {
					update = update + updates[i][0] + "='" + updates[i][1] + "'";
				} else {
					update += ", " + updates[i][0] + "='" + updates[i][1] + "'";
				}
			}
			stmt = con.prepareStatement("UPDATE " + Konfig.ERGENIS_TABELLE + " SET " + update
					+ " WHERE Name=? AND Kurs=?");
			stmt.setString(1, name);
			stmt.setString(2, kurs);
			stmt.executeUpdate();
			// +------------- Ende: Generiert Update Anweisung
			// ------------------
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	/**
	 * Updateanweisung, um alle Fächer gleichzeitig zu ergänzen. Damit wird
	 * vermieden, dass Daten nur teilweise ankommen und somit nicht erkannt
	 * wird, ob das Update geglückt ist.
	 *
	 * @param powi
	 *            Ob das Fach Politik und Wirtschaft belegt wird
	 * @param powi_bili
	 *            Ob das Fach Politik und Wirtschaft Bilingual belegt wird
	 * @param rewe
	 *            Ob das Fach Rechnungswesen belegt wird
	 * @param daten
	 *            Ob das Fach Datenverarbeitung belegt wird
	 * @param gesch2
	 *            Ob das Fach Geschichte zweistündig belegt wird
	 * @param gesch3
	 *            Ob das Fach Geschichte dreistündig belegt wird
	 * @param powi2
	 *            Ob das Fach Politik und Wirtschaft zweistündig belegt wird
	 * @param powi3
	 *            Ob das Fach Politik und Wirtschaft dreistündig belegt wird
	 * @param reli_kath
	 *            Ob das Fach kath. Religion belegt wird
	 * @param reli_evang
	 *            Ob das Fach eveng. Relegion belegt wird
	 * @param sport1
	 *            Erstwahl: Sportkurs, der belegt wird
	 * @param sport2
	 *            Zweitwahl: Sprtkurs, der belegt wird
	 * @param stern
	 *            Ob der Sternchenkurs schon erfüllt wurde
	 * @param reli_auswahl
	 *            Welche Relegion gewählt wurde
	 * @param zusatzKurs
	 *            Welcher zusätzlicher Kurs gewählt wurde
	 * @param abwahlKurs
	 *            Welcher zusätzlicher Kurs abgewählt wurde
	 * @param fs12
	 *            Ob in der 12. Klasse eine Fremdsprache belgt wurde
	 * @param fs13
	 *            Ob in der 13. Klasse eine Fremdschprache belegt wurde
	 * @return
	 */
	public boolean update(boolean powi, boolean powi_bili, String wahlkurs, boolean rewe, boolean daten,
			boolean gesch2, boolean gesch3, boolean powi2, boolean powi3, boolean reli_kath, boolean reli_evang,
			String sport1, String sport2, boolean keinWahlkurs, String reli_auswahl, String zusatzKurs,
			String abwahlKurs, boolean fs12, boolean fs13) {
		// "0" bedeutet in Access kein Haken beim CheckBox-Typ:
		String intPowi = "0";
		String intPowi_bili = "0";

		String intRewe = "0";
		String intDaten = "0";

		String intGesch2 = "0";
		String intGesch3 = "0";
		String intPowi2 = "0";
		String intPowi3 = "0";

		String intReli_12 = "0";
		String intReli_13 = "0";

		String intFS12 = "0";
		String intFS13 = "0";

		String intWahlkurs = "0";

		String intSchuleVerlassen = "0";
		String intKlasseWiederholen = "0";

		// "-1" bedeutet, dass die Kurse in Acces ausgewählt wurden:
		// Zusätzliche Kurse:
		if (powi)
			intPowi = "-1";
		if (powi_bili)
			intPowi_bili = "-1";

		// Wirtschaft:
		if (rewe)
			intRewe = "-1";
		if (daten)
			intDaten = "-1";

		// Umwahl:
		if (gesch2)
			intGesch2 = "-1";
		if (gesch3)
			intGesch3 = "-1";
		if (powi2)
			intPowi2 = "-1";
		if (powi3)
			intPowi3 = "-1";

		// Sprachen:
		if (fs12)
			intFS12 = "-1";
		if (fs13)
			intFS13 = "-1";

		// Sternchenkurs:
		if (keinWahlkurs)
			intWahlkurs = "-1";

		// Ermittelt, wie viele Stunden PoWi belegt wurde:
		if (powi || powi_bili) {
			if ((gibStunden("Politik und Wirtschaft") == 2 || powi2) && !powi3 || powi_bili) {
				intPowi2 = "-1";
				intPowi3 = "0";
			} else {
				intPowi3 = "-1";
			}
		}

		// Ermittelt, ob Religion in der 13. Klasse belegt wird:
		if (belegtFach("%kath%") || belegtFach("%evang%") || belegtFach("%ethik%")) {
			intReli_12 = "-1";
			if (reli_kath || reli_evang)
				intReli_13 = "0";
			else
				intReli_13 = "-1";
		}

		// Update Anweisung:
		if (update(new String[][] {
				// Schülerdaten:
				{ "Name", name },
				{ "Fachrichtung", fachrichtung },
				{ "Kurs", kurs },
				{ "LK", gibLeistungskurs() },

				// Sternchenkurs:
				{ "Will_KeinWahlpflichtkurs", intWahlkurs },
				{ "Wahlpflichtkurs", wahlkurs },

				// Politik:
				{ "powi_l", gibLehrer("Politik und Wirtschaft") }, { "powi_k", gibKurs("Politik und Wirtschaft") },
				{ "PoWi", intPowi },
				{ "PoWi_bili", intPowi_bili },
				{ "Will_PoWi2", intPowi2 },
				{ "Will_PoWi3", intPowi3 },

				// Geschichte:
				{ "gesch_l", gibLehrer("Geschichte") }, { "gesch_k", gibKurs("Geschichte") },
				{ "Will_Geschichte2", intGesch2 },
				{ "Will_Geschichte3", intGesch3 },

				// Rechungswesen:
				{ "rewe_l", gibLehrer("Rechnungswesen") }, { "rewe_k", gibKurs("Rechnungswesen") },
				{ "Rewe", intRewe },

				// Datenverarbeitung:
				{ "daten_l", gibLehrer("Datenverarbeitung") }, { "daten_k", gibKurs("Datenverarbeitung") },
				{ "Daten", intDaten },

				// Religion:
				{ "Reli_12", intReli_12 }, { "Reli_13", intReli_13 },

				// Sprachen:
				{ "Hat_FS_12", intFS12 }, { "Hat_FS_13", intFS13 },

				// Sportkurse:
				{ "Sport1", sport1 }, { "Sport2", sport2 },

				// Zusatz:
				{ "ZusatzWahl", zusatzKurs }, { "ZusatzAbwahl", abwahlKurs },

				// Sonstiges:
				{ "klasseWiederholen", "0" }, { "schuleVerlassen", "0" } })) {
			// Update gelungen:
			gespeichert = true;
		} else {
			// Update fehlgeschlagen:
			gespeichert = false;
		}

		return true;
	}

	public void wiederholen() {
		if (update(new String[][] {
				// Schülerdaten:
				{ "Name", name.replace("_", "’") }, { "Fachrichtung", fachrichtung }, { "Kurs", kurs },
				{ "LK", gibLeistungskurs() },

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
				{ "Name", name }, { "Fachrichtung", fachrichtung }, { "Kurs", kurs }, { "LK", gibLeistungskurs() },

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