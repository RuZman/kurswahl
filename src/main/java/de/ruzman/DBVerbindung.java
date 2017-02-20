package de.ruzman;

import static de.ruzman.Konfig.DATENBANK_PFAD;
import static net.ucanaccess.jdbc.UcanaccessDriver.URL_PREFIX;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Zur Datenbankanbindung mittels UCanAccess.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBVerbindung {
	protected Connection con;
	protected ResultSet rs;
	protected PreparedStatement stmt;

	/**
	 * Konstruktor der Klasse DBVerbindung.
	 */
	public DBVerbindung() {
		oeffneVerbindung();
	}

	/**
	 * Beendet die Verbindung beim zerstören des Objektes.
	 * 
	 * @throws Throwable
	 *             Falls das Objekt nicht zerstört werden kann.
	 */
	@Override
	@SuppressWarnings("FinalizeDeclaration")
	protected void finalize() throws Throwable {
		schliesseVerbindung();
		super.finalize();
	}

	public String[] gibAusgewaehlteSpalte(ResultSet rs) {
		try {
			rs = stmt.executeQuery();
			ArrayList<String> puffer = new ArrayList<String>();
			// Ergebnisse der Select-Anweisung in ArrayList laden:
			for (int i = 0; rs.next(); i++) {
				puffer.add(rs.getString(1));
			}
			// ArrayList in einen String[] casten:
			return (String[]) puffer.toArray(new String[puffer.size()]);
		} catch (SQLException ex) {
			// Ein null-Wert KANN NICHT vorkommen!
			System.out.println("Beim filtern einer Spalte ist ein Fehler" + "aufgetreten:\n" + ex);
			return null;
		}
	}
	
	public String[] ohneLeerzeilen(String[] array) {
		ArrayList<String> buffer = new ArrayList<>(array.length);
		
		for(String element: array) {
			if(element == null || element.isEmpty() || element.equals("''")) {
				continue;
			}
			
			buffer.add(element);
		}
		
		return (String[]) buffer.toArray(new String[buffer.size()]); 
	}

	/**
	 * Öffnet eine Verbindung zu einer bestimmten Datenbank.
	 */
	private void oeffneVerbindung() {
		try {
			File dbFile = new File(DATENBANK_PFAD.toString());
			con = DriverManager.getConnection(URL_PREFIX + dbFile.getAbsolutePath(), "", "1234");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Es konnte keine Verbindung zur Datenbank" + " (" + DATENBANK_PFAD
					+ ") hergestellt werden.");
		}
	}

	/**
	 * Schließt die Verbindung mit der Datenbank.
	 */
	private void schliesseVerbindung() {
		try {
			// Verbindung schließen:
			con.close();
		} catch (Exception ex) {
			System.out.println("Die Verbindung zur Datenbank konnte" + " nicht geschlossen werden.");
		}
	}
}