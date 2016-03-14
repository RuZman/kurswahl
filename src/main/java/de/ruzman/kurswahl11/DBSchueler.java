package de.ruzman.kurswahl11;

import java.sql.SQLException;

/**
 * Enthält Operationen, die im Zusamenhang mit einem einzelnen Schüler stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBSchueler extends DBVerbindung {
	private String kurs;
	private String name;
	private String fachrichtung;

	// Ob der letzte SQL-Update erfolgreich verlief:
	private boolean gespeichert;

	/**
	 * Konstruktor der Klasse DBSchueler.
	 */
	public DBSchueler() {
		super();
		initialisiere();
	}

	/**
	 * Initialisierung von der Klasse DBSchueler.
	 */
	private void initialisiere() {
		// Darf nicht null sein:
		kurs = "";
		name = "";
		fachrichtung = "";
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
			// SQL-Statement:
			rs = stmt.executeQuery("SELECT Count(" + Konfig.KURS_FACHBEZEICHNUNG + ") FROM " + Konfig.KURS_TABELLE
					+ " WHERE " + Konfig.KURS_SCHULERNAMEN + " LIKE '" + name.trim() + "' AND "
					+ Konfig.KURS_KLASSENNAMEN + " LIKE '%" + kurs + "%' AND " + Konfig.KURS_FACHBEZEICHNUNG
					+ " LIKE '" + fach + "'");
			rs.next();
			// Wenn das Fach dem Schüler 1x in der Datenbank zugewiesen wurde:
			return rs.getInt(1) == 1;
		} catch (SQLException ex) {
			System.out.println("" + ex);
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
			// SQL-Statement:
			rs = stmt.executeQuery("SELECT " + Konfig.KURS_SCHULFORMEN + " FROM " + Konfig.KURS_TABELLE + " WHERE "
					+ Konfig.KURS_SCHULERNAMEN + " LIKE '" + name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN
					+ " LIKE '%" + kurs + "%'");
			rs.next();
			// Bezeichnung:
			return rs.getString(1);
		} catch (SQLException ex) {
			System.out.println("" + ex);
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
			// SQL-Statement
			rs = stmt.executeQuery("SELECT " + Konfig.KURS_LEHRER + " FROM " + Konfig.KURS_TABELLE + " WHERE "
					+ Konfig.KURS_SCHULERNAMEN + " LIKE '" + name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN
					+ " LIKE '%" + kurs + "%' " + "AND " + Konfig.KURS_FACHBEZEICHNUNG + " LIKE '" + fach + "'");
			rs.next();
			// Lehrer Kürzel:
			return rs.getString(1).replace("'", "");
		} catch (SQLException ex) {
			System.out.println("" + ex);
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
			rs = stmt.executeQuery("SELECT Kursstunden FROM " + Konfig.KURS_TABELLE
					+ " WHERE Kursart='L' AND Fachbezeichnung='Mathematik' GROUP BY" + " Kursstunden");
			rs.next();
			int stunden = rs.getInt(1);
			// SQL-Statment, um durch die Stundenanzahl den LK herauszufinden:
			rs = stmt.executeQuery("SELECT Fachbezeichnung FROM Kurs WHERE Kursstunden = " + stunden + " AND "
					+ Konfig.KURS_SCHULERNAMEN + " LIKE '" + name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN
					+ " LIKE '%" + kurs + "%' " + " GROUP BY Fachbezeichnung");
			rs.next();
			// Leistungskurs:
			return rs.getString(1);
		} catch (SQLException ex) {
			System.out.println("" + ex);
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
			// SQL-Statement:
			rs = stmt.executeQuery("SELECT Kursbezeichnung FROM " + Konfig.KURS_TABELLE + " WHERE "
					+ Konfig.KURS_SCHULERNAMEN + " LIKE '" + name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN
					+ " LIKE '%" + kurs + "%' " + "AND Fachbezeichnung LIKE '" + fach + "'");
			rs.next();
			// Kursbezeichnung:
			return rs.getString(1).replace("'", "");
		} catch (SQLException ex2) {
			System.out.println("" + ex2);
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
			// SQL-Statement:
			rs = stmt.executeQuery("SELECT " + Konfig.KURS_KURSSTUNDEN + " FROM " + Konfig.KURS_TABELLE + " WHERE "
					+ Konfig.KURS_SCHULERNAMEN + " LIKE '" + name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN
					+ " LIKE '%" + kurs + "%' AND " + Konfig.KURS_FACHBEZEICHNUNG + "='" + fach + "'");
			rs.next();
			// Kursstunden:
			return rs.getInt(1);
		} catch (SQLException ex) {
			System.out.println("" + ex);
		}
		return -1;
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
			// SQL-Statement:
			rs = stmt.executeQuery("SELECT Count(" + Konfig.SCHUELER_GEBDATUM + ") FROM " + Konfig.SCHUELER_TABELLE
					+ " WHERE " + Konfig.SCHUELER_NAME + " LIKE '" + name + "' AND " + Konfig.SCHUELER_KLASSE
					+ " LIKE '%" + kurs + "%' AND " + Konfig.SCHUELER_GEBDATUM + " ='" + gebDatum + "'");
			rs.next();
			// Wenn die Anzahl der gefundenen Treffer gleich 1 ist, ist das
			// Geburtsdatum korrekt:
			return rs.getInt(1) == 1;
		} catch (SQLException ex) {
			System.out.println("" + ex);
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
				// SQL-Statement
				rs = stmt.executeQuery("SELECT Count(" + Konfig.SCHUELER_GEBORT + ") FROM " + Konfig.SCHUELER_TABELLE
						+ " WHERE " + Konfig.SCHUELER_NAME + " LIKE '" + name + "' AND " + Konfig.SCHUELER_KLASSE
						+ " LIKE '%" + kurs + "%' AND (LOWER(" + Konfig.SCHUELER_GEBORT + ") LIKE LOWER('" + gebOrt
						+ "%') OR LOWER(" + Konfig.SCHUELER_GEBORT + ") = LOWER('" + gebOrt + "'))");
				rs.next();
				// Wenn die Anzahl der gefundenen Treffer gleich 1 ist, dann
				// stimmen die ersten 3 Zeichen des Geburtortes überein:
				return rs.getInt(1) == 1;
			}
		} catch (SQLException ex) {
			System.out.println("GebOrt stimmt nicht überein" + ex);
		}
		return false;
	}

	/**
	 * Fachrichtung des Schülers wird ermittelt und gespeichert.
	 */
	public void setzeFachrichtung() {
		try {
			// SQL-Statement, um zu überprüfen, ob der Schüler in einer Klasse
			// mit
			// zwei Fachrichtungen ist:
			rs = stmt.executeQuery("SELECT Fachrichtung FROM Fachrichtung, Kurs WHERE "
					+ "Fachrichtung.Kurs = Kurs.Kursbezeichnung AND " + Konfig.KURS_SCHULERNAMEN + " LIKE '"
					+ name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN + " LIKE '%" + kurs
					+ "%' GROUP BY Fachrichtung");
			rs.next();
			// Fachrichtung:
			fachrichtung = rs.getString(1);
		} catch (SQLException ex) {
			try {
				// SQL-Statement, gibt die Fachrichtung des Schüles zurück, wenn
				// dieser nicht in einer Klasse mit 2 Fachrichtungen ist:
				rs = stmt.executeQuery("SELECT Fachrichtung FROM Fachrichtung,"
						+ " Kurs WHERE Fachrichtung.Schulform = Kurs.USFBKSchueler AND " + Konfig.KURS_SCHULERNAMEN
						+ " LIKE '" + name.trim() + "' AND " + Konfig.KURS_KLASSENNAMEN + " LIKE '%" + kurs
						+ "%' GROUP BY Fachrichtung");
				rs.next();
				// Fachrichtung:
				fachrichtung = rs.getString(1);
			} catch (SQLException ex2) {
				System.out.println("" + ex2);
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
				stmt.executeUpdate("INSERT INTO " + Konfig.ERGENIS_TABELLE + " (Name, Kurs) VALUES ('"
						+ name.replace("_", "’") + "','" + kurs + "')");
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
			stmt.executeUpdate("UPDATE " + Konfig.ERGENIS_TABELLE + " SET " + update + " WHERE Name='"
					+ name.replace("_", "’") + "' AND Kurs='" + kurs + "'");
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
	 */
	public boolean update(String lk, String zahl, String nat, String fremd, boolean powi_bili, boolean gesch,
			boolean powi, String sport, String reli, String wahlpflicht, boolean hatLKNW, boolean gesch_bili) {
		// "0" bedeutet in Access kein Haken beim CheckBox-Typ:
		String intPowi = "0";
		String intGesch = "0";
		String intPowi_bili = "0";
		String intGesch_bili = "0";
		String intHatLKNW = "0";

		// "-1" bedeutet, dass die Kurse in Acces ausgewählt wurden:
		if (powi)
			intPowi = "-1";
		if (gesch)
			intGesch = "-1";
		if (powi_bili)
			intPowi_bili = "-1";
		if (gesch_bili)
			intGesch_bili = "-1";
		if (hatLKNW)
			intHatLKNW = "-1";

		String reli_k = gibLehrer("Reli%");
		String reli_l = "";

		if (!reli_k.equals("")) {
			reli_l = gibKurs("Reli%");
		} else {
			reli_k = gibLehrer("Ethik");
			reli_l = gibKurs("Ethik");
		}

		// Update Anweisung:
		if (update(new String[][] {
				// Schülerdaten:
				{ "Name", name.replace("_", "’") },
				{ "Kurs", kurs },
				{ "Fachrichtung", fachrichtung },

				{ "LK", lk },
				{ "Zufallszahl", zahl },

				// Naturwissenschaft:
				{ "Hat_LKNW", intHatLKNW },
				{ "Biologie", nat.equals("Biologie") ? "-1" : "0" },
				{ "Chemie", nat.equals("Chemie") ? "-1" : "0" },
				{ "Physik", nat.equals("Physik") ? "-1" : "0" },

				{ "Gesch3", intGesch },
				{ "PoWi3", intPowi },
				{ "PoWi_Bilingual", intPowi_bili },
				{ "Gesch_Bilingual", intGesch_bili },

				// Sprachen:
				{ "FranzA", fremd.equals("Französisch (Anfänger)") ? "-1" : "0" },
				{ "FranzF", fremd.equals("Französisch (Fortgesch.)") ? "-1" : "0" },
				{ "SpanischA", fremd.equals("Spanisch (Anfänger)") ? "-1" : "0" },
				{ "SpanischF", fremd.equals("Spanisch (Fortgesch.)") ? "-1" : "0" },
				{ "Hat_2Fremdsprachen", fremd.equals("Nicht teilnehmen") ? "0" : "-1" },

				// Religion:
				{ "kat_Religion", reli.equals("Kath. Religion") ? "-1" : "0" },
				{ "ev_Religion", reli.equals("Evang. Religion") ? "-1" : "0" },
				{ "ethik_Religion", reli.equals("Ethik") ? "-1" : "0" },
				{ "Hat_Religion", reli.equals("Nicht teilnehmen") ? "0" : "-1" }, { "reli_k", reli_k },
				{ "reli_l", reli_l },

				{ "Sportkurs", sport }, { "Wahlpflichtkurs", wahlpflicht }, { "klasseWiederholen", "0" },
				{ "schuleVerlassen", "0" } })) {
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