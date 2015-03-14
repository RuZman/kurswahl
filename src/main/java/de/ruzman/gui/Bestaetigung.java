package de.ruzman.gui;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Bestätigt die Kurswahl, indem es dem Benutzer eine Nachricht ausgibt.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Bestaetigung extends javax.swing.JPanel implements Erneuerbar {
	private Kurswahlfenster fenster;

	/**
	 * Konstruktor der Klasse Bestaetigung.
	 */
	public Bestaetigung() {
		initComponents();
		setSize(new Dimension(350, 87));
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

		jPanel1 = new javax.swing.JPanel();
		laErfolgreich = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		laErfolgreich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		laErfolgreich.setText(" Die Kurswahl war erfolgreich! Viel Glück im nächsten Jahr.");
		add(laErfolgreich, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 380, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE));

		add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 70));
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Um mit dem Kurswahlfenster interagieren zu können.
	 *
	 * @param fenster
	 *            Referenz zum Kurswahlfenster.
	 */
	public void setzeFenster(Kurswahlfenster fenster) {
		this.fenster = fenster;
	}

	/**
	 * Das Bestätigungspanel wird in den Ausgangszustand zurückversetzt.
	 */
	public void zuruecksetzen() {
		// Falls die Kurswahl nicht gespeichert werden konnte:
		if (!Kurswahlfenster.gibDBJahrgang().gibSchueler().istGespeichert()) {
			laErfolgreich.setText("<html>Kurswahl konnte <b>NICHT</b> gespeichert werden.</html>");
		} else {
			laErfolgreich
					.setText("<html>Die Kurswahl war erfolgreich. Viel Glück!<br>Der nächste Schüler kann nun wählen.</html>");
		}
		// 4 Sekunden warten, damit der Benutzer die Nachricht lesen kann:
		Timer time = new Timer();
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				// Nächstes Panel wählen:
				setVisible(false);
				fenster.naechstesPanel();
			}
		}, 5000);
	}

	/**
	 * Gibt den Titel für das Panels zurück.
	 *
	 * @return Titel für das Panel
	 */
	@Override
	public String toString() {
		return "Kurswahl11 - Bestätigung";
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel laErfolgreich;
	// End of variables declaration//GEN-END:variables
}
