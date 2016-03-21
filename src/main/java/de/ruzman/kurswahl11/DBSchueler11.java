package de.ruzman.kurswahl11;

import de.ruzman.DBSchueler;

/**
 * Enthält Operationen, die im Zusamenhang mit einem einzelnen Schüler stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBSchueler11 extends DBSchueler {
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
				{ "Hat_LKNW", intHatLKNW }, { "Biologie", nat.equals("Biologie") ? "-1" : "0" },
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
				/*{ "kat_Religion", reli.equals("Kath. Religion") ? "-1" : "0" },
				{ "ev_Religion", reli.equals("Evang. Religion") ? "-1" : "0" },
				{ "ethik_Religion", reli.equals("Ethik") ? "-1" : "0" },
				{ "Hat_Religion", reli.equals("Nicht teilnehmen") ? "0" : "-1" }, { "reli_k", reli_k },
				{ "reli_l", reli_l },*/
				{ "reli_k", reli_k }, { "reli_l", reli_l }, { "Religion", reli },

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
}