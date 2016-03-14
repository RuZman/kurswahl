package de.ruzman.kurswahl11;

/**
 * Startklasse für das Kurswahlprogramm.
 * Dient allein zur Übersicht.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Main
{

    /**
     * Startet die Kurswahlanwendung.
     * @param ars Es weden Argumente aus der Konsole berücksichtigt!
     */
    public static void main(String[] ars)
    {
        // Führt die Anwendung in einen eigenen Thread aus:
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                // Ruft das Kurswahlfenster auf und macht es sichtbar:
                new de.ruzman.gui11.Kurswahlfenster().setVisible(true);
            }
        });
    }
}
