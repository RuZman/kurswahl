package de.ruzman.gui11;

import static de.ruzman.Konfig.INHALT_FREMDSPRACHEN;
import static de.ruzman.Konfig.INHALT_RELIGION;
import static de.ruzman.Konfig.INHALT_SPORT;
import static de.ruzman.Konfig.INHALT_WAHLPFLICHT;
import de.ruzman.gui.Erneuerbar;
import de.ruzman.kurswahl11.DBSchueler11;

/**
 * Das Kurswahlfenster enthält alle Elemente, die ein Schüler benötigt, um seine
 * Kurse wählen zu können. Für die Kurswahl wird eine Datenbankverbindung
 * vorrausgesetzt.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Kurswahl extends javax.swing.JPanel implements Erneuerbar {
	private Kurswahlfenster11 fenster;
	private de.ruzman.kurswahl11.DBSchueler11 schueler;

	/**
	 * Konstruktor der Klasse Kurswahl.
	 */
	public Kurswahl() {
		initComponents();
		setSize(480, 650);
		initialisiere();
	}

	/**
	 * Initialisierung des Kurswahlpanels.
	 */
	private void initialisiere() {
		schueler = (DBSchueler11) Kurswahlfenster11.gibDBJahrgang().gibSchueler();
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

		laName = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		chbGeschichte = new javax.swing.JCheckBox();
		chbPoWi = new javax.swing.JCheckBox();
		jPanel2 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		cbSportwahl = new javax.swing.JComboBox();
		cbReligion = new javax.swing.JComboBox();
		cbWahlpflicht = new javax.swing.JComboBox();
		jPanel3 = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		cbFremdsprache = new javax.swing.JComboBox();
		chbPoWi_bili = new javax.swing.JCheckBox();
		jLabel14 = new javax.swing.JLabel();
		chbGeschi_bili = new javax.swing.JCheckBox();
		jPanel4 = new javax.swing.JPanel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		cbLeistungskurs = new javax.swing.JComboBox();
		txtZufallszahl = new javax.swing.JTextField();
		cbNatKurs = new javax.swing.JComboBox();
		jPanel5 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		buAbbrechen = new javax.swing.JButton();
		buSpeichern = new javax.swing.JButton();

		setRequestFocusEnabled(false);
		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		laName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		laName.setText("Name:");
		add(laName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

		jLabel1.setText("v1.2.1");
		add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Erweiterte Kurse",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12),
				java.awt.Color.black)); // NOI18N
		jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel4.setText("<html><center>3-stündige Kurse:<br>(freiwillig)</center></html>");
		jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chbGeschichte.setText("Geschichte");
		chbGeschichte.setToolTipText("");
		chbGeschichte.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbGeschichteActionPerformed(evt);
			}
		});
		jPanel1.add(chbGeschichte, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

		chbPoWi.setText("PoWi");
		chbPoWi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbPoWiActionPerformed(evt);
			}
		});
		jPanel1.add(chbPoWi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

		add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 460, 80));

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weitere Angebote",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12),
				java.awt.Color.black)); // NOI18N
		jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel6.setText("Religionsunterricht:");
		jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel7.setText("<html><center>Gewünschter Sportkurs:<br>(Nur eine Vorwahl)</center></html>");
		jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel8.setText("Wahlpflichtkurs:");
		jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

		cbSportwahl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		cbSportwahl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbSportwahlActionPerformed(evt);
			}
		});
		jPanel2.add(cbSportwahl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 210, -1));

		cbReligion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jPanel2.add(cbReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 210, -1));

		cbWahlpflicht.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jPanel2.add(cbWahlpflicht, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 210, -1));

		add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 460, 130));

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sprachkurse",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12),
				java.awt.Color.black)); // NOI18N

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel9.setText("<html>PoWi Bilingual:</html>");

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel10.setText("2. Fremdsprache:");

		cbFremdsprache.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		cbFremdsprache.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nicht teilnehmen" }));

		chbPoWi_bili.setText("Teilnehmen");
		chbPoWi_bili.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbPoWi_biliActionPerformed(evt);
			}
		});

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel14.setText("<html>Geschichte Bilingual:</html>");

		chbGeschi_bili.setText("Teilnehmen");
		chbGeschi_bili.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbGeschi_biliActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel10)
														.addGroup(
																jPanel3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel14,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																								79, Short.MAX_VALUE))
																		.addGroup(
																				jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel9,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(111, 111, 111))))
										.addGap(7, 7, 7)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(chbGeschi_bili)
																		.addComponent(
																				chbPoWi_bili,
																				javax.swing.GroupLayout.Alignment.LEADING))
														.addComponent(cbFremdsprache,
																javax.swing.GroupLayout.PREFERRED_SIZE, 210,
																javax.swing.GroupLayout.PREFERRED_SIZE))));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel3Layout
								.createSequentialGroup()
								.addGap(3, 3, 3)
								.addGroup(
										jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel10)
												.addComponent(cbFremdsprache, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(6, 6, 6)
								.addGroup(
										jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(chbPoWi_bili))
								.addGap(3, 3, 3)
								.addGroup(
										jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(chbGeschi_bili)).addContainerGap(27, Short.MAX_VALUE)));

		add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 460, 130));

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kurswahl",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12),
				java.awt.Color.black)); // NOI18N
		jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel11.setText("<html><center>6-stellige Zufallszahl:<br>(freiwillig)</center></html>");
		jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel12.setText("1. Leistungsfach:");
		jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel13.setText("Naturwissenschaftlicher Kurs:");
		jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

		cbLeistungskurs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		cbLeistungskurs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Auswählen-", "Deutsch",
				"Englisch", "Mathe" }));
		cbLeistungskurs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbLeistungskursActionPerformed(evt);
			}
		});
		jPanel4.add(cbLeistungskurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 210, -1));

		txtZufallszahl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jPanel4.add(txtZufallszahl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 50, -1));

		cbNatKurs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jPanel4.add(cbNatKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 210, -1));

		add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 460, 120));

		jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		jButton2.setText("Klasse wiederholen");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton1.setText("Schule verlassen");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel5Layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jButton2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton1)
								.addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel5Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton2).addComponent(jButton1))
								.addContainerGap(14, Short.MAX_VALUE)));

		add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 260, 50));

		buAbbrechen.setText("Abbrechen");
		buAbbrechen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buAbbrechenActionPerformed(evt);
			}
		});

		buSpeichern.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		buSpeichern.setText("Speichern");
		buSpeichern.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buSpeichernActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(buAbbrechen)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buSpeichern).addContainerGap()));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel6Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(buAbbrechen).addComponent(buSpeichern))
								.addContainerGap(16, Short.MAX_VALUE)));

		add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, 50));
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Springt zum Loginpanel zurück.
	 *
	 * @param evt
	 *            Eingehendes Event bei buAbbrechenAction
	 */
	private void buAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buAbbrechenActionPerformed
		this.setVisible(false);
		fenster.vorherigesPanel();
	}// GEN-LAST:event_buAbbrechenActionPerformed

	/**
	 * Deselektiert die Auswahl chbGeschichte3z2, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbGeschichte2zu3
	 */
	private void chbGeschichteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbGeschichteActionPerformed
	}// GEN-LAST:event_chbGeschichteActionPerformed

	/**
	 * Deselektiert die Auswahl chbPoWi3zu2A, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbPoWi2z3
	 */
	private void chbPoWiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbPoWiActionPerformed
	}// GEN-LAST:event_chbPoWiActionPerformed

	/**
	 * Speichern der Kurswahl und führt automaitsch zum nächsten Panel.
	 *
	 * @param evt
	 *            Eingehendes Event bei buSpeichern
	 */
	private void buSpeichernActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buSpeichernActionPerformed
		// Überprüft, ob ein Sternchenkurs schon belegt oder grade gewählt
		// wurde:
		if (!(((String) cbNatKurs.getSelectedItem()).equals("-Auswählen-") && cbNatKurs.isEnabled())
				&& !(((String) cbLeistungskurs.getSelectedItem()).equals("-Auswählen-"))
				&& !(((String) cbSportwahl.getSelectedItem()).equals("-Auswählen-"))) {
			schueler.update((String) cbLeistungskurs.getSelectedItem(), txtZufallszahl.getText(),
					(String) cbNatKurs.getSelectedItem(), (String) cbFremdsprache.getSelectedItem(),
					chbPoWi_bili.isSelected(), chbGeschichte.isSelected(), chbPoWi.isSelected(),
					(String) cbSportwahl.getSelectedItem(), (String) cbReligion.getSelectedItem(),
					(String) cbWahlpflicht.getSelectedItem(), !cbNatKurs.isEnabled(), chbGeschi_bili.isSelected());
			// Nächstes Panel:
			this.setVisible(false);
			fenster.naechstesPanel();
		}
	}// GEN-LAST:event_buSpeichernActionPerformed

	/**
	 * Befüllt die Combobox cdZweitwahl neu, um eine doppelte Sportwahl zu
	 * verhindern. Zudem enabled sie die Combobox cdZweitwahl.
	 *
	 * @param evtEingehendes
	 *            Event bei cbErstwahl
	 */
	private void cbSportwahlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbSportwahlActionPerformed

	}// GEN-LAST:event_cbSportwahlActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		schueler.verlassen();
		this.setVisible(false);
		fenster.naechstesPanel();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		schueler.wiederholen();
		this.setVisible(false);
		fenster.naechstesPanel();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void chbPoWi_biliActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbPoWi_biliActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_chbPoWi_biliActionPerformed

	private void cbLeistungskursActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbLeistungskursActionPerformed
		if (cbLeistungskurs.getSelectedItem() != null) {
			if (cbLeistungskurs.getSelectedItem().equals("Physik")
					|| cbLeistungskurs.getSelectedItem().equals("Chemie")
					|| cbLeistungskurs.getSelectedItem().equals("Biologie")) {
				cbNatKurs.setEnabled(false);
				cbNatKurs.setSelectedIndex(0);
			} else {
				cbNatKurs.setEnabled(true);
			}
		}
	}// GEN-LAST:event_cbLeistungskursActionPerformed

	private void chbGeschi_biliActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbGeschi_biliActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_chbGeschi_biliActionPerformed

	/**
	 * Um mit dem Kurswahlfenster interagieren zu können.
	 *
	 * @param fenster
	 *            Referenz zum Kurswahlfenster.
	 */
	public void setzeFenster(Kurswahlfenster11 fenster) {
		this.fenster = fenster;
	}

	/**
	 * Das Kurswahlpanel wird in den Ausgangszustand versetzt.
	 */
	public void zuruecksetzen() {
		// Legt den Inhalt für die Combobox ErstwahlSport fest:
		Kurswahlfenster11.loescheUndSetzeComboBox(cbSportwahl, INHALT_SPORT.toString().split(","));

		Kurswahlfenster11.loescheUndSetzeComboBox(cbReligion, INHALT_RELIGION.toString().split(","));

		Kurswahlfenster11.loescheUndSetzeComboBox(cbFremdsprache, INHALT_FREMDSPRACHEN.toString().split(","));

		Kurswahlfenster11.loescheUndSetzeComboBox(cbLeistungskurs, "-Auswählen-", "Deutsch,Englisch,Mathe".split(","),
				true);

		Kurswahlfenster11.loescheUndSetzeComboBox(cbNatKurs, "-Auswählen-", new String[0], true);

		Kurswahlfenster11.loescheUndSetzeComboBox(cbWahlpflicht, INHALT_WAHLPFLICHT.toString().split(","));

		// Neuen Namen anzeigen:
		laName.setText("Name: " + schueler.gibName());

		// Deselektierung der einzelnen Checkboxen:
		chbPoWi_bili.setSelected(false);
		chbGeschi_bili.setSelected(false);
		chbGeschichte.setSelected(false);
		chbPoWi.setSelected(false);

		if (schueler.belegtFach("Physik")) {
			cbLeistungskurs.addItem("Physik");
			cbNatKurs.addItem("Physik");
		}
		if (schueler.belegtFach("Chemie")) {
			cbLeistungskurs.addItem("Chemie");
			cbNatKurs.addItem("Chemie");
		}
		if (schueler.belegtFach("Biologie")) {
			cbLeistungskurs.addItem("Biologie");
			cbNatKurs.addItem("Biologie");
		}

		txtZufallszahl.setText("");
	}

	/**
	 * Gibt den Titel für das Panels zurück.
	 *
	 * @return Titel für das Panel
	 */
	@Override
	public String toString() {
		return "Kurswahl11 - Kurswahl";
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buAbbrechen;
	private javax.swing.JButton buSpeichern;
	private javax.swing.JComboBox cbFremdsprache;
	private javax.swing.JComboBox cbLeistungskurs;
	private javax.swing.JComboBox cbNatKurs;
	private javax.swing.JComboBox cbReligion;
	private javax.swing.JComboBox cbSportwahl;
	private javax.swing.JComboBox cbWahlpflicht;
	private javax.swing.JCheckBox chbGeschi_bili;
	private javax.swing.JCheckBox chbGeschichte;
	private javax.swing.JCheckBox chbPoWi;
	private javax.swing.JCheckBox chbPoWi_bili;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JLabel laName;
	private javax.swing.JTextField txtZufallszahl;
	// End of variables declaration//GEN-END:variables
}
