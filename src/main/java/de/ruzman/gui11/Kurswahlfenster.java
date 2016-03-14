package de.ruzman.gui11;

import java.awt.*;
import javax.swing.*;

/**
 * Das Kurswahlfenster enthält alle grafischen Komponenten, die für das
 * Kurswahlprogramm benötigt werden. Zudem befindet sich die Main-Methode in
 * dieser Klasse.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Kurswahlfenster extends JFrame
{
    // Zur Kommunikation mit einer Datenbank:
    // Darf während einer Kurswahl nicht geändert werden! -> final
    private static final de.ruzman.kurswahl11.DBJahrgang jahrgang =
            new de.ruzman.kurswahl11.DBJahrgang();
    private static final de.ruzman.kurswahl11.DBSchueler schueler =
            jahrgang.gibSchueler();

    // Zähler für den nächsten JPanel, die angezeigt werden soll:
    private int panelZeahler;
    
    private Login login1;
    private Kurswahl kurswahl1;
    private Bestaetigung bestaetigung1;

    /**
     * Konstruktor der Klasse Kurswahlfenster.
     */
    public Kurswahlfenster()
    {   
        initialisiere();
    }
    
    /**
     * Initialisierung des Kurswahlfensters.
     */
    private void initialisiere()
    {
        
        // Windows Layout benutzen (Auch für andere Betriebsysteme):
        try
        {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex)
        {
            /* Exception wird nicht behandelt, da bei einem Fehler das
               vorinstallierte LookAndFeel benutzt wird. */
        }
        
        login1 = new Login();
        kurswahl1 = new Kurswahl();
        bestaetigung1 = new Bestaetigung();
        
        // Komponenten des Fensters initialisieren:
        initComponents();
        
        login1.setBounds(0, 0, 600, 400);
        kurswahl1.setBounds(0, 0, 480, 620);
        jLayeredPane.add(login1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(kurswahl1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(bestaetigung1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        // Übergibt seine Instanz an die JPanels:
          login1.setzeFenster(this);
          kurswahl1.setzeFenster(this);
          bestaetigung1.setzeFenster(this);

        // Alle ausblenden:
          login1.setVisible(false);
          kurswahl1.setVisible(false);
          bestaetigung1.setVisible(false);

        // Panel setzen:
        panelZeahler = -1;
        naechstesPanel();
    }
    
    public Login getLogin() {
        return login1;
    }

    /**
     * Diese Methode wird von der Methode initaliesiere() aufgerufen. Sie
     * initialisiert alle grafischen Komponenten.
     * WARNUNG: Ändern Sie diesen Code nicht ab! Die Methode wird von Netbeans
     * automatisch generiert!
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static de.ruzman.kurswahl11.DBJahrgang gibDBJahrgang()
    {
        return jahrgang;
    }

    public static de.ruzman.kurswahl11.DBSchueler gibDBSchueler()
    {
        return schueler;
    }
    
    /**
     * Füllt eine JCombobox mit einer bestimmten Liste. Der erste Eintrag ist
     * frei wählbar.
     *
     * @param auswahl JCombobox, die geändert werden soll.
     * @param name Erstes Element für die JCombobox.
     * @param items Die neuen Elemente der JCombobox.
     */
    public static void loescheUndSetzeComboBox(JComboBox auswahl,
                                        String name, String[] items, boolean trim)
    {
        // Löscht alle Einträge aus der JCombobox:
        auswahl.removeAllItems();

        // Falls das erste Item gesondert benannt werden soll:
        auswahl.addItem(name);
        for (String s : items)
        {
            /*
             * Formatierungsfehler, die bei der Datenbank enstehen nicht
             * anzeigen. Zum Beispiel wird aus "'12DV2'" -> "12DV2".
             */
            if(s.startsWith("'"))
            {
                s = s.substring(1);
            }
            if(s.endsWith("'"))
            {
                s = s.substring(0, s.length()-1);
            }
            if(trim)
            {
                auswahl.addItem(s.trim());
            }
            else
            {
                auswahl.addItem(s);
            }
        }
    }

    /**
     * Füllt eine JCombobox mit einer bestimmten Liste.
     *
     * @param auswahl JCombobox, die geändert werden soll.
     * @param items Die neuen Elemente der JCombobox.
     */
    public static void loescheUndSetzeComboBox(JComboBox auswahl,
                                        String[] items)
    {
        // Löscht alle Einträge aus der JCombobox:
        auswahl.removeAllItems();

        for (String s : items)
        {
            /*
             * Formatierungsfehler, die bei der Datenbank enstehen nicht
             * anzeigen. Zum Beispiel wird aus "'12DV2'" -> "12DV2".
             */
            if(s.startsWith("'"))
            {
                s = s.substring(1);
            }
            if(s.endsWith("'"))
            {
                s = s.substring(0, s.length()-1);
            }
            auswahl.addItem(s);
        }
    }

    /**
     * Rückt das nächste Panel in den Vordergrund.
     */
    public void naechstesPanel()
    {
        Component component = jLayeredPane.getComponent(++panelZeahler%3);
        // Titel setzen:
        setTitle(component.toString());
        // Größe des Fensters an der neuen JPanel anpassen:
        setSize(component.getWidth(), component.getHeight());
        zentriereFenster();
        // In den Ausgangszustand versetzen:
        ((Erneuerbar)component).zuruecksetzen();
        // JPanel in den Vordergrund stellen:
        component.setVisible(true);
    }

    /**
     * Rückt das nächste Panel in den Vordergrund.
     */
    public void vorherigesPanel()
    {
        Component component = jLayeredPane.getComponent(--panelZeahler%3);
        // Titel setzen:
        setTitle(component.toString());
        // Größe des Fensters an der neuen JPanel anpassen:
        setSize(component.getWidth(), component.getHeight());
        zentriereFenster();
        // In den Ausgangszustand versetzen:
        ((Erneuerbar)component).zuruecksetzen();
        // JPanel in den Vordergrund stellen:
        component.setVisible(true);
    }

    /**
     * Zentriert das Fenster auf dem Bildschirm.
     */
    private void zentriereFenster()
    {
        // Bildschirmauflösung herrausfinden:
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        // Kurswahlfenster zentrieren:
        setLocation((int)(screenDimension.getWidth()-getWidth())/2,
                    (int)(screenDimension.getHeight()-getHeight())/2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane;
    // End of variables declaration//GEN-END:variables
}