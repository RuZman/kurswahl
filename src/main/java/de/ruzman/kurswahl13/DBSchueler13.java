package de.ruzman.kurswahl13;

import static de.ruzman.kurswahl13.Konfig.ERGENIS_TABELLE;

import java.sql.SQLException;

import de.ruzman.DBSchueler;

public class DBSchueler13 extends DBSchueler {

	/**
	 * Generiert eine SQL-Anweisung für den Update.
	 *
	 * @param updates
	 *            String-Array mit {[Spaltenname], [Inhalt]}
	 * @return True, wenn das Update geglückt ist.
	 */
	protected boolean update(String[][] updates) {
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
					if (updates[i][1].equals("0") || updates[i][1].equals("-1")) {
						update += ", " + updates[i][0] + "=" + updates[i][1] + "";
					} else {
						update += ", " + updates[i][0] + "='" + updates[i][1] + "'";
					}
				}
			}
			System.out.println(update);
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
		// Zusätzliche Kurse:
		String intPowi = powi ? "-1" : "0";
		String intPowi_bili = powi_bili ? "-1" : "0";

		// Wirtschaft:
		String intRewe = rewe ? "-1" : "0";
		String intDaten = daten ? "-1" : "0";

		// Umwahl:
		String intGesch2 = gesch2 ? "-1" : "0";
		String intGesch3 = gesch3 ? "-1" : "0";
		String intPowi2 = powi2 ? "-1" : "0";
		String intPowi3 = powi3 ? "-1" : "0";

		// Sprachen:
		String intFS12 = fs12 ? "-1" : "0";
		String intFS13 = fs13 ? "-1" : "0";

		// Sternchenkurs:
		String intWahlkurs = keinWahlkurs ? "-1" : "0";

		String intReli_12 = "0";
		String intReli_13 = "0";

		// Ermittelt, wie viele Stunden PoWi belegt wurde:
		if (powi || powi_bili) {
			if ((gibStunden("Politik und Wirtschaft") == 2 || powi2) && !powi3) {
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

				// Sternchenkurs
				{ "Will_KeinWahlpflichtkurs", intWahlkurs },
				{ "Wahlpflichtkurs", wahlkurs },

				// Politik
				{ "powi_l", gibLehrer("Politik und Wirtschaft") }, { "powi_k", gibKurs("Politik und Wirtschaft") },
				{ "PoWi", intPowi },
				{ "PoWi_bili", intPowi_bili },
				{ "Will_PoWi2", intPowi2 },
				{ "Will_PoWi3", intPowi3 },

				// Geschichte
				{ "gesch_l", gibLehrer("Geschichte") }, { "gesch_k", gibKurs("Geschichte") },
				{ "Will_Geschichte2", intGesch2 },
				{ "Will_Geschichte3", intGesch3 },

				// Rechungswesen
				{ "rewe_l", gibLehrer("Rechnungswesen") }, { "rewe_k", gibKurs("Rechnungswesen") },
				{ "Rewe", intRewe },

				// Datenverarbeitung
				{ "daten_l", gibLehrer("Datenverarbeitung") }, { "daten_k", gibKurs("Datenverarbeitung") },
				{ "Daten", intDaten },

				// Sprachen
				{ "Hat_FS_12", intFS12 }, { "Hat_FS_13", intFS13 },

				// Sportkurse
				{ "Sport1", sport1 }, { "Sport2", sport2 },

				// Sonstiges
				{ "klasseWiederholen", "0" }, { "schuleVerlassen", "0" },

				// Religion
				{ "Reli_12", intReli_12 }, { "Reli_13", intReli_13 },

				// Zusatz
				{ "ZusatzWahl", zusatzKurs }, { "ZusatzAbwahl", abwahlKurs } })) {
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
