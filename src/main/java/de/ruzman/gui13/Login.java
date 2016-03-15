package de.ruzman.gui13;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;

import de.ruzman.DBJahrgang;

/**
 * Das Login-Panel enthält alle Elemente, die für eine Anmeldung eines Schülers
 * nötig sind. Dazu wird aber eine Datenbankverbindung vorrausgesetzt.
 * 
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Login extends javax.swing.JPanel implements Erneuerbar {
	// Zur Kommunikation mit der Tabelle für die Jahrgangstufe:
	private DBJahrgang jahrgang;
	// Zur Kommunikation mit dem Frame:
	private Kurswahlfenster fenster;

	/**
	 * Konstruktor der Klasse Login.
	 */
	public Login() {
		// Komponenten des Fensters initialisieren:
		initComponents();
		initialisiere();
	}

	/**
	 * Initialisiert die Klasse Login.
	 */
	private void initialisiere() {
		// Zur Kommunikation mit der Tabelle für die Jahrgangstufe:
		this.jahrgang = Kurswahlfenster.gibDBJahrgang();

		// Initialisiert die JCombobox für die Kurse:
		Kurswahlfenster.loescheUndSetzeComboBox(cbKurs, "-Auswählen-", jahrgang.gibKurse(), false);

		// Initialisiert die JCombobox für die Jahrgänge:
		Kurswahlfenster.loescheUndSetzeComboBox(cbJahre, jahrgang.gibJahre());
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

		cbTage = new javax.swing.JComboBox();
		cbName = new javax.swing.JComboBox();
		laGeburtsdatum = new javax.swing.JLabel();
		cbJahre = new javax.swing.JComboBox();
		laName = new javax.swing.JLabel();
		laGeburtsort = new javax.swing.JLabel();
		cbMonat = new javax.swing.JComboBox();
		laKurs = new javax.swing.JLabel();
		cbKurs = new javax.swing.JComboBox();
		buLogin = new javax.swing.JButton();
		tfGeburtsort = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();

		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		cbTage.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		cbTage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));
		cbTage.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbTageItemStateChanged(evt);
			}
		});
		cbTage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTageActionPerformed(evt);
			}
		});
		add(cbTage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 67, 48, -1));

		cbName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		cbName.setEnabled(false);
		cbName.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbNameItemStateChanged(evt);
			}
		});
		add(cbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 39, 266, -1));

		laGeburtsdatum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		laGeburtsdatum.setText("Ihr Geburtsdatum:");
		add(laGeburtsdatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

		cbJahre.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		cbJahre.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbJahreItemStateChanged(evt);
			}
		});
		cbJahre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbJahreActionPerformed(evt);
			}
		});
		add(cbJahre, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 67, 159, -1));

		laName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		laName.setText(" Ihr Name:");
		add(laName, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 42, -1, -1));

		laGeburtsort.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		laGeburtsort
				.setText("<html><center>Ihr Geburtsort:</center><font size=\"2\">(Nur erste 3 Zeichen)</font></html>");
		add(laGeburtsort, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 98, -1, -1));

		cbMonat.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		cbMonat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12" }));
		cbMonat.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbMonatItemStateChanged(evt);
			}
		});
		add(cbMonat, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 67, -1, -1));

		laKurs.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		laKurs.setText("Ihre Klasse:");
		add(laKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 14, -1, -1));

		cbKurs.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		cbKurs.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbKursItemStateChanged(evt);
			}
		});
		add(cbKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 11, 266, -1));

		buLogin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		buLogin.setText("Anmelden");
		buLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buLoginActionPerformed(evt);
			}
		});
		add(buLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 133, -1, -1));

		tfGeburtsort.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		tfGeburtsort.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				tfGeburtsortKeyPressed(evt);
			}
		});
		add(tfGeburtsort, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 95, 266, -1));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 420, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 190, Short.MAX_VALUE));

		add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 190));
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Wird aufgerufen, sobald bei der JCombobox "cbKurse" ein anderes Item
	 * selectiert wird.
	 *
	 * @param evt
	 *            Ausgelöstes ItemEvent.
	 */
	private void cbKursItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbKursItemStateChanged
		laKurs.setForeground(Color.black);

		// Falls der Benutzer einen Kurs ausgewählt hat:
		if (cbKurs.getSelectedItem() != null && !istJComboBoxGesetzt(cbKurs)) {
			// Ausgewählten Kurs setzen:
			jahrgang.gibSchueler().setzeKurs((String) cbKurs.getSelectedItem());
			// Setzt cbName und enabled es:
			Kurswahlfenster.loescheUndSetzeComboBox(cbName, "-Auswählen-", jahrgang.gibNamen(), false);
			cbName.setEnabled(true);
		} else {
			// Wenn der Benutzer wieder "-Auswählen-" klickt -> zurücksetzen:
			// cbName zurücksetzen:
			setzeCbNameZurueck();
		}
	}// GEN-LAST:event_cbKursItemStateChanged

	/**
	 * Wird aufgerufen, sobald bei der JCombobox "cbName" ein anderes Item
	 * selectiert wird.
	 *
	 * @param evt
	 *            Ausgelöstes ItemEvent.
	 */
	private void cbNameItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbNameItemStateChanged
		laName.setForeground(Color.black);

		if (cbName.getSelectedItem() != null && !istJComboBoxGesetzt(cbName)) {
			// Ausgewählten Namen setzen:
			jahrgang.gibSchueler().setzeName(((String) cbName.getSelectedItem()));
		}
	}// GEN-LAST:event_cbNameItemStateChanged

	/**
	 * Wird aufgerufen, sobald der Benutzer auf das Button buLogin klickt oder
	 * im Textfield die Entertaste gedrückt wird.
	 *
	 * @param evt
	 *            Ausgelöstes ActionEvent.
	 */
	private void buLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buLoginActionPerformed
		if (istLoginErfolgteich()) {
			jahrgang.gibSchueler().setzeFachrichtung();
			this.setVisible(false);
			fenster.naechstesPanel();
		}
	}// GEN-LAST:event_buLoginActionPerformed

	/**
	 * Wird ausgeführt, sobald in tfGeburtsort ENTER gedrückt wird.
	 * 
	 * @param evt
	 *            Ausgelöstes KeyEvent.
	 */
	private void tfGeburtsortKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tfGeburtsortKeyPressed
		laGeburtsort.setForeground(Color.black);
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			buLoginActionPerformed(null);
		}
	}// GEN-LAST:event_tfGeburtsortKeyPressed

	/**
	 * Wird aufgerufen, sobald bei der JCombobox "cbMonate" ein anderes Item
	 * selectiert wird.
	 *
	 * @param evt
	 *            Ausgelöstes ItemEvent.
	 */
	private void cbMonatItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbMonatItemStateChanged
		laGeburtsdatum.setForeground(Color.black);
	}// GEN-LAST:event_cbMonatItemStateChanged

	/**
	 * Wird aufgerufen, sobald bei der JCombobox "cbTage" ein anderes Item
	 * selectiert wird.
	 *
	 * @param evt
	 *            Ausgelöstes ItemEvent.
	 */
	private void cbTageItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbTageItemStateChanged
		laGeburtsdatum.setForeground(Color.black);
	}// GEN-LAST:event_cbTageItemStateChanged

	/**
	 * Wird aufgerufen, sobald bei der JCombobox "cbJahre" ein anderes Item
	 * selectiert wird.
	 *
	 * @param evt
	 *            Ausgelöstes ItemEvent.
	 */
	private void cbJahreItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbJahreItemStateChanged
		laGeburtsdatum.setForeground(Color.black);
	}// GEN-LAST:event_cbJahreItemStateChanged

	private void cbJahreActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbJahreActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cbJahreActionPerformed

	private void cbTageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbTageActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cbTageActionPerformed

	/**
	 * Zeigt, ob der Benutzer bei einer bestimmten JComboBox einen Eintrag
	 * ausgewählt hat.
	 *
	 * @param cb
	 *            JComboBox, die überprüft werden soll.
	 * @return [True] Der Benutzer hat etwas ausgewählt.
	 */
	private boolean istJComboBoxGesetzt(JComboBox cb) {
		return ((String) cb.getSelectedItem()).equals("-Auswählen-");
	}

	/**
	 * Prüft, ob die Daten des Benuters korrekt sind.
	 *
	 * @return True, wenn die Daten korrekt sind.
	 */
	private boolean istLoginErfolgteich() {
		boolean erfolgreich = true;

		// Kurs gesetzt?:
		if (istJComboBoxGesetzt(cbKurs)) {
			laKurs.setForeground(Color.red);
			erfolgreich = false;
		}
		// Name gesetzt?:
		else if (istJComboBoxGesetzt(cbName)) {
			laName.setForeground(Color.red);
			erfolgreich = false;
		} else {
			// Aufgrund von Name + Kurs -> Geburtsort überprüfen:
			if (!jahrgang.gibSchueler().istGeburtsort(tfGeburtsort.getText())) {
				laGeburtsort.setForeground(Color.red);
				erfolgreich = false;
			}

			// Aufgrund von Name + Kurs -> Geburtsdatum überprüfen:
			String gebDatum = (String) cbTage.getSelectedItem() + "." + (String) cbMonat.getSelectedItem() + "."
					+ (String) cbJahre.getSelectedItem();
			if (!jahrgang.gibSchueler().istGeburtsdatum(gebDatum)) {
				laGeburtsdatum.setForeground(Color.red);
				erfolgreich = false;
			}
		}

		return erfolgreich;
	}

	/**
	 * Setzt die JComboBox "cbName" zurück.
	 */
	private void setzeCbNameZurueck() {
		laName.setForeground(Color.black);
		cbName.setEnabled(false);
		cbName.removeAllItems();
		cbName.addItem("-Auswählen-");
	}

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
	 * Gibt den Titel für das Panels zurück.
	 *
	 * @return Titel für das Panel
	 */
	@Override
	public String toString() {
		return "Kurswahl13 - Login";
	}

	/**
	 * Das Loginfenster wird in den Ausgangszustand zurückversetzt.
	 */
	@Override
	public void zuruecksetzen() {
		// Kurs zurücksetzen:
		cbKurs.setSelectedIndex(0);

		// JComboboxen werden zurückgesetz:
		setzeCbNameZurueck();

		// Tag, Monat und Jahr zurücksetzen:
		cbTage.setSelectedIndex(0);
		cbMonat.setSelectedIndex(0);
		cbJahre.setSelectedIndex(0);

		// Geburtsort leeren:
		tfGeburtsort.setText("");
	}

	@Override
	public int getHeight() {
		return super.getPreferredSize().height;
	}

	@Override
	public int getWidth() {
		return super.getPreferredSize().width;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buLogin;
	private javax.swing.JComboBox cbJahre;
	public javax.swing.JComboBox cbKurs;
	private javax.swing.JComboBox cbMonat;
	public javax.swing.JComboBox cbName;
	private javax.swing.JComboBox cbTage;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel laGeburtsdatum;
	private javax.swing.JLabel laGeburtsort;
	private javax.swing.JLabel laKurs;
	private javax.swing.JLabel laName;
	private javax.swing.JTextField tfGeburtsort;
	// End of variables declaration//GEN-END:variables
}