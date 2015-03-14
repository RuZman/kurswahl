package de.ruzman.kurswahl;

import java.sql.*;

/**
 * Enthält Operationen, die im Zusamenhang mit der Jahrgangstufe stehen.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class DBJahrgang extends DBVerbindung
{
    private DBSchueler schueler;

    /**
     * Konstruktor der Klasse DBJahrgang.
     */
    public DBJahrgang()
    {
        initialisiere();
    }

    /**
     * Initialisierung von der Klasse DBJahrgang.
     */
    private void initialisiere()
    {
        schueler = new DBSchueler();
    }

    /**
     * Gibt alle Geburtsjahre der Schüler in absteigender Reihenfolge zurück.
     * Doppelte Einträge werden gelöscht.
     *
     * @return Geburtsjahre des Jahrgangs
     */
    public String[] gibJahre()
    {
        try
        {
            // SQL-Statment:
            rs = stmt.executeQuery("SELECT RIGHT(" + Konfig.SCHUELER_GEBDATUM +
                    ",4) FROM " + Konfig.SCHUELER_TABELLE + " GROUP BY RIGHT(" +
                    Konfig.SCHUELER_GEBDATUM + ",4)");

        }
        catch (SQLException ex)
        {
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
    public String[] gibKurse()
    {
        try
        {
            // SQL-Statment:
            rs = stmt.executeQuery("SELECT " + Konfig.SCHUELER_KLASSE + " FROM " +
                    Konfig.SCHUELER_TABELLE + " GROUP BY " + Konfig.SCHUELER_KLASSE +
                    " ORDER BY " + Konfig.SCHUELER_KLASSE);

        }
        catch (SQLException ex)
        {
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
    public String[] gibNamen()
    {
        ResultSet rs = null;
        try
        {
            //SQL-Statment:
            rs = stmt.executeQuery("SELECT " + Konfig.SCHUELER_NAME + " FROM " +
                    Konfig.SCHUELER_TABELLE + " WHERE " + Konfig.SCHUELER_KLASSE +
                    " LIKE '%" + schueler.gibKurs() +"%'" + " GROUP BY " +
                    Konfig.SCHUELER_NAME + " ORDER BY 1");

        }
        catch (SQLException ex)
        {
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
    public DBSchueler gibSchueler()
    {
        return schueler;
    }

    /**
     * Gibt die Sportkurse eines Jahrgangs zurück.
     *
     * @return Sportkurse des Jahrgangs
     */
    public String[] gibSportkurse()
    {
        return Konfig.INHALT_SPORT.toString().split(",");
    }
}
