package de.ruzman.gui11;

import javax.swing.UIManager;

import de.ruzman.DBJahrgang;
import de.ruzman.gui.Bestaetigung;
import de.ruzman.gui.Kurswahlfenster;
import de.ruzman.gui.Login;
import de.ruzman.kurswahl11.DBSchueler11;

/**
 * Das Kurswahlfenster enthält alle grafischen Komponenten, die für das
 * Kurswahlprogramm benötigt werden. Zudem befindet sich die Main-Methode in
 * dieser Klasse.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Kurswahlfenster11 extends Kurswahlfenster {
	private Login login1;
	private Kurswahl kurswahl1;
	private Bestaetigung bestaetigung1;

	static {
		jahrgang = new DBJahrgang(new DBSchueler11());
	}

	/**
	 * Konstruktor der Klasse Kurswahlfenster.
	 */
	public Kurswahlfenster11() {
		initialisiere();
	}

	/**
	 * Initialisierung des Kurswahlfensters.
	 */
	private void initialisiere() {

		// Windows Layout benutzen (Auch für andere Betriebsysteme):
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			/*
			 * Exception wird nicht behandelt, da bei einem Fehler das
			 * vorinstallierte LookAndFeel benutzt wird.
			 */
		}

		login1 = new Login("Kurswahl11 - Login");
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
	 * initialisiert alle grafischen Komponenten. WARNUNG: Ändern Sie diesen
	 * Code nicht ab! Die Methode wird von Netbeans automatisch generiert!
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLayeredPane = new javax.swing.JLayeredPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents
}