package de.ruzman.kurswahl;

import java.sql.*;
import java.util.ArrayList;

/**
 * Zur Datenbankanbindung über die ODBC-Bridge.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBVerbindung
{
    // Treiber für eine JDBC-ODBC Bridge:
    private final String CONNAME = "sun.jdbc.odbc.JdbcOdbcDriver";

    protected Connection con;
    protected ResultSet rs;
    protected Statement stmt;

    /**
     * Konstruktor der Klasse DBVerbindung.
     */
    public DBVerbindung()
    {
        initialisiere();
    }

    /**
     * Initialisierung von der Klasse DBVerbindung.
     */
    private void initialisiere()
    {
        oeffneVerbindung();

        try {
            // Neue Select-Anweisung vorbereiten:
            rs = null;
            stmt = con.createStatement();
        } catch (SQLException ex) {
            // Fehler ausgeschlossen.
            // Exception wird beim Verbindungsaufbau geworfen.
        }
    }

    /**
     * Beendet die Verbindung beim zerstören des Objektes.
     * @throws Throwable Falls das Objekt nicht zerstört werden kann.
     */
    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws Throwable
    {
        schliesseVerbindung();
        super.finalize();
    }

    public String[] gibAusgewaehlteSpalte(ResultSet rs) {
        try
        {
            ArrayList<String> puffer = new ArrayList<String>();
            // Ergebnisse der Select-Anweisung in ArrayList laden:
            for(int i = 0; rs.next(); i++)
            {
                puffer.add(rs.getString(1));
            }
            // ArrayList in einen String[] casten:
            return (String []) puffer.toArray(new String[puffer.size()]);
        }
        catch(SQLException ex)
        {
            // Ein null-Wert KANN NICHT vorkommen!
            System.out.println("Beim filtern einer Spalte ist ein Fehler"
                    + "aufgetreten:\n" + ex);
            return null;
        }
    }

    /**
     * Öffnet eine Verbindung zu einer bestimmten Datenbank.
     */
    private void oeffneVerbindung()
    {
        try
        {
            // JDBC-ODBC Treiber laden:
            Class.forName(CONNAME);
            // Mit Access-Datenbank verbinden:
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft"
                    + " Access Driver (*.mdb)};DBQ=" +
                    Konfig.DATENBANK_PFAD.toString());
        }
        catch(Exception ex)
        {
              System.out.println("Es konnte keine Verbindung zur Datenbank"
                      + " (" + Konfig.DATENBANK_PFAD.toString() +
                      ") hergestellt werden.");
        }
    }
    
    /**
     * Schließt die Verbindung mit der Datenbank.
     */
    private void schliesseVerbindung()
    {
        try
        {
            // Verbindung schließen:
            con.close();
        }
        catch(Exception ex)
        {
              System.out.println("Die Verbindung zur Datenbank konnte"
                      + " nicht geschlossen werden.");
        }
    }
}