package de.ruzman.gui13;

import de.ruzman.gui.Erneuerbar;
import de.ruzman.kurswahl13.DBSchueler13;

/**
 * Das Kurswahlfenster enthält alle Elemente, die ein Schüler benötigt, um seine
 * Kurse wählen zu können. Für die Kurswahl wird eine Datenbankverbindung
 * vorrausgesetzt.
 *
 * @author Zoltan Ruzman
 * @version 1.0.0
 */
public class Kurswahl extends javax.swing.JPanel implements Erneuerbar {
	private Kurswahlfenster13 fenster;
	private DBSchueler13 schueler;

	/**
	 * Konstruktor der Klasse Kurswahl.
	 */
	public Kurswahl() {
		initComponents();
		setSize(711, 415);
		initialisiere();
	}

	/**
	 * Initialisierung des Kurswahlpanels.
	 */
	private void initialisiere() {
		schueler = (DBSchueler13) Kurswahlfenster13.gibDBJahrgang().gibSchueler();
		cbReligion.setSize(50, 15);

		// Legt den Inhalt für die Combobox ErstwahlSport fest:
		Kurswahlfenster13.loescheUndSetzeComboBox(cbErstwahl, "-Auswählen-", de.ruzman.kurswahl13.Konfig.INHALT_SPORT
				.toString().split(","), true);

		// Legt den Inhalt für die Combobox ZweitwahlSport fest:
		Kurswahlfenster13.loescheUndSetzeComboBox(cbZweitwahl, "-Auswählen-", de.ruzman.kurswahl13.Konfig.INHALT_SPORT
				.toString().split(","), true);

		// Legt den Inhalt für die Combobox ErstwahlSport fest:
		Kurswahlfenster13.loescheUndSetzeComboBox(cbWahlpflicht, "-Auswählen-",
				de.ruzman.kurswahl13.Konfig.INHALT_WAHLPFLICHT.toString().split(","), true);
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
		buAbbrechen = new javax.swing.JButton();
		buSpeichern = new javax.swing.JButton();
		jPanel8 = new javax.swing.JPanel();
		chbGeschichte3z2 = new javax.swing.JCheckBox();
		chbGeschichte2zu3 = new javax.swing.JCheckBox();
		chbPoWi3zu2 = new javax.swing.JCheckBox();
		chbPoWi2z3 = new javax.swing.JCheckBox();
		jPanel4 = new javax.swing.JPanel();
		cbZweitwahl = new javax.swing.JComboBox();
		laErstwahl = new javax.swing.JLabel();
		laZweitwahl = new javax.swing.JLabel();
		cbErstwahl = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jPanel11 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		laSportkurs1 = new javax.swing.JLabel();
		laSportkurs2 = new javax.swing.JLabel();
		laSprachen = new javax.swing.JLabel();
		laUmwahl = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		chbSpanisch = new javax.swing.JCheckBox();
		chbFranz = new javax.swing.JCheckBox();
		jPanel1 = new javax.swing.JPanel();
		laSternchenkurs = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		chbPoWi = new javax.swing.JCheckBox();
		chbPoWi_bili = new javax.swing.JCheckBox();
		chbRewe = new javax.swing.JCheckBox();
		chbDaten = new javax.swing.JCheckBox();
		jLabel3 = new javax.swing.JLabel();
		jPanel7 = new javax.swing.JPanel();
		cbWahlpflicht = new javax.swing.JComboBox();
		laSprachen1 = new javax.swing.JLabel();
		chbWahlpflicht = new javax.swing.JCheckBox();
		jLabel2 = new javax.swing.JLabel();
		laReligion = new javax.swing.JLabel();
		jPanel9 = new javax.swing.JPanel();
		chbReligion_kat = new javax.swing.JCheckBox();
		chbReligion_evang = new javax.swing.JCheckBox();
		chbReligion_ethik = new javax.swing.JCheckBox();
		tfAbwahlKurs = new javax.swing.JTextField();
		laAbwahlKurs = new javax.swing.JLabel();
		laZusatzKurs = new javax.swing.JLabel();
		tfZusatzKurs = new javax.swing.JTextField();
		cbReligion = new javax.swing.JComboBox();

		setRequestFocusEnabled(false);
		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		laName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		laName.setText("Name:");
		add(laName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

		buAbbrechen.setText("Abbrechen");
		buAbbrechen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buAbbrechenActionPerformed(evt);
			}
		});
		add(buAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, -1));

		buSpeichern.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		buSpeichern.setText("Speichern");
		buSpeichern.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buSpeichernActionPerformed(evt);
			}
		});
		add(buSpeichern, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

		jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		chbGeschichte3z2.setText("Geschichte 3-stündig zu 2-stündig");
		chbGeschichte3z2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbGeschichte3z2ActionPerformed(evt);
			}
		});

		chbGeschichte2zu3.setText("Geschichte 2-stündig zu 3-stündig");
		chbGeschichte2zu3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbGeschichte2zu3ActionPerformed(evt);
			}
		});

		chbPoWi3zu2.setText("PoWi 3-stündig zu 2-stündig");
		chbPoWi3zu2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbPoWi3zu2ActionPerformed(evt);
			}
		});

		chbPoWi2z3.setText("PoWi 2-stündig zu 3-stündig");
		chbPoWi2z3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbPoWi2z3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel8Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(chbGeschichte3z2).addComponent(chbGeschichte2zu3)
												.addComponent(chbPoWi3zu2).addComponent(chbPoWi2z3))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						jPanel8Layout.createSequentialGroup().addComponent(chbGeschichte3z2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbGeschichte2zu3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbPoWi3zu2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbPoWi2z3).addGap(0, 0, Short.MAX_VALUE)));

		add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 200, -1));

		jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		cbZweitwahl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbZweitwahlActionPerformed(evt);
			}
		});

		laErstwahl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		laErstwahl.setText("<html><b>Erstwahl:</b><html>");

		laZweitwahl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		laZweitwahl.setText("<html><b>Zweitwahl:</b><html>");

		cbErstwahl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbErstwahlActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(22, 22, 22)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(laZweitwahl,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(laErstwahl,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(cbErstwahl, 0, 214, Short.MAX_VALUE)
														.addComponent(cbZweitwahl, 0, 214, Short.MAX_VALUE))
										.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel4Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(cbErstwahl, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(laErstwahl, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(laZweitwahl, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cbZweitwahl, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 70));

		jLabel1.setText("v1.6.0");
		add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

		jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jButton1.setText("Schule verlassen");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel11.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

		jButton2.setText("Klasse wiederholen");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jPanel11.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

		add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 150, 70));

		laSportkurs1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laSportkurs1.setText("<html>Alternative:</html>");
		add(laSportkurs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

		laSportkurs2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laSportkurs2.setText("<html>Sportwahl (Vorabfrage):</html>");
		add(laSportkurs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

		laSprachen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laSprachen.setText("<html>Abwahl Sprachen:<br><font size=2>(Nur wenn zulässig und belegt)</font>");
		add(laSprachen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

		laUmwahl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laUmwahl.setText("<html>Umwahl:<br><font size=2>(Bitte nur bei Änderung ankreuzen)</font>");
		add(laUmwahl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

		jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		chbSpanisch.setText("Spanisch");
		chbSpanisch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbSpanischActionPerformed(evt);
			}
		});

		chbFranz.setText("Französisch");
		chbFranz.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbFranzActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel6Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(chbSpanisch).addComponent(chbFranz))
								.addContainerGap(111, Short.MAX_VALUE)));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel6Layout.createSequentialGroup().addComponent(chbSpanisch)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbFranz)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 200, 50));

		laSternchenkurs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laSternchenkurs.setText("<html>Ich belege zusätzlich zu den<br>Standardverpflichtungen:</html>");

		jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		chbPoWi.setText("Politik und Wirtschaft");
		chbPoWi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbPoWiActionPerformed(evt);
			}
		});

		chbPoWi_bili.setText("Politik und Wirtschaft (bilingual)");
		chbPoWi_bili.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbPoWi_biliActionPerformed(evt);
			}
		});

		chbRewe.setText("Rechnungswesen");

		chbDaten.setText("Datenverarbeitung");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(chbPoWi)
														.addComponent(chbPoWi_bili)
														.addComponent(chbDaten)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(chbRewe)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jLabel3)))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel2Layout
								.createSequentialGroup()
								.addComponent(chbPoWi)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbPoWi_bili)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(chbRewe))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbDaten).addContainerGap()));

		jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel7Layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(cbWahlpflicht, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel7Layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(cbWahlpflicht, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		laSprachen1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laSprachen1.setText("<html>Wahlpflichtkurs:</font>");

		chbWahlpflicht
				.setText("<html><b>Ich habe bereits den Wahlpflichtkurs<br> in der 12. Klasse belegt und möchte<br> keinen mehr.</b></html>");
		chbWahlpflicht.setActionCommand("");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(chbWahlpflicht, javax.swing.GroupLayout.PREFERRED_SIZE,
														242, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(laSternchenkurs,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jPanel2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(laSprachen1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jPanel7,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(laSternchenkurs, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(laSprachen1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(2, 2, 2)
								.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(chbWahlpflicht, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(9, Short.MAX_VALUE)));

		add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 280, 270));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setText("Wahl Religion:");
		add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

		laReligion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		laReligion.setText("<html><b>Abwahl Religion:<br><font size=2>(Nur wenn zulässig)</font>");
		add(laReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, 30));

		jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		chbReligion_kat.setText("Religion (Kath.)");
		chbReligion_kat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbReligion_katActionPerformed(evt);
			}
		});

		chbReligion_evang.setText("Religion (Evang.)");
		chbReligion_evang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chbReligion_evangActionPerformed(evt);
			}
		});

		chbReligion_ethik.setText("Ethik");

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout
				.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGroup(
												jPanel9Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(chbReligion_kat).addComponent(chbReligion_evang)
														.addComponent(chbReligion_ethik))
										.addContainerGap(91, Short.MAX_VALUE)));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel9Layout.createSequentialGroup().addComponent(chbReligion_kat)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbReligion_evang)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(chbReligion_ethik)));

		add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));
		add(tfAbwahlKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 200, -1));

		laAbwahlKurs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laAbwahlKurs.setText("Kurse abwählen:");
		add(laAbwahlKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

		laZusatzKurs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		laZusatzKurs.setText("Kurse zusätzlich belegen:");
		add(laZusatzKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 160, -1));
		add(tfZusatzKurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 200, -1));

		add(cbReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 200, -1));
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
	 * Deselektiert die Auswahl chbSpanisch_anf, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbSpanisch_fort
	 */
	private void chbSpanischActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbSpanischActionPerformed
	}// GEN-LAST:event_chbSpanischActionPerformed

	/**
	 * Deselektiert die Auswahl chbFranz_anf, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbFranz_fort
	 */
	private void chbFranzActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbFranzActionPerformed
	}// GEN-LAST:event_chbFranzActionPerformed

	/**
	 * Deselektiert die Auswahl chbGeschichte2zu3, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbGeschichte3z2
	 */
	private void chbGeschichte3z2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbGeschichte3z2ActionPerformed
		chbGeschichte2zu3.setSelected(false);
	}// GEN-LAST:event_chbGeschichte3z2ActionPerformed

	/**
	 * Deselektiert die Auswahl chbGeschichte3z2, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbGeschichte2zu3
	 */
	private void chbGeschichte2zu3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbGeschichte2zu3ActionPerformed
		chbGeschichte3z2.setSelected(false);
	}// GEN-LAST:event_chbGeschichte2zu3ActionPerformed

	/**
	 * Deselektiert die Auswahl chbPoWi2z3, da die gemeinsame Kombination nicht
	 * möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbPoWi3zu2A
	 */
	private void chbPoWi3zu2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbPoWi3zu2ActionPerformed
		chbPoWi2z3.setSelected(false);
	}// GEN-LAST:event_chbPoWi3zu2ActionPerformed

	/**
	 * Deselektiert die Auswahl chbPoWi3zu2A, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbPoWi2z3
	 */
	private void chbPoWi2z3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbPoWi2z3ActionPerformed
		chbPoWi3zu2.setSelected(false);
	}// GEN-LAST:event_chbPoWi2z3ActionPerformed

	/**
	 * Deselektiert die Auswahl chbReligion_evang, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbReligion_kat
	 */
	private void chbReligion_katActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbReligion_katActionPerformed
		chbReligion_evang.setSelected(false);
	}// GEN-LAST:event_chbReligion_katActionPerformed

	/**
	 * Deselektiert die Auswahl chbReligion_kat, da die gemeinsame Kombination
	 * nicht möglich ist.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbReligion_evang
	 */
	private void chbReligion_evangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbReligion_evangActionPerformed
		chbReligion_kat.setSelected(false);
	}// GEN-LAST:event_chbReligion_evangActionPerformed

	/**
	 * Deselektiert die Auswahl chbPoWi_bili, da die gemeinsame Kombination
	 * nicht möglich ist.Zudem wird dem Schüler eine Umwahl der Stunden
	 * freigeschalten.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbPoWi
	 */
	private void chbPoWiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbPoWiActionPerformed
		chbPoWi_bili.setSelected(false);
		if (chbPoWi.isSelected() || chbPoWi_bili.isSelected()) {
			chbPoWi2z3.setEnabled(true);
			chbPoWi3zu2.setEnabled(true);
		} else {
			chbPoWi2z3.setEnabled(false);
			chbPoWi3zu2.setEnabled(false);
		}
	}// GEN-LAST:event_chbPoWiActionPerformed

	/**
	 * Deselektiert die Auswahl chbPoWi, da die gemeinsame Kombination nicht
	 * möglich ist.Zudem wird dem Schüler eine Umwahl der Stunden
	 * freigeschalten.
	 *
	 * @param evt
	 *            Eingehendes Event bei chbPoWi_bili
	 */
	private void chbPoWi_biliActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbPoWi_biliActionPerformed
		chbPoWi.setSelected(false);
		if (chbPoWi.isSelected() || chbPoWi_bili.isSelected()) {
			chbPoWi2z3.setEnabled(true);
			chbPoWi3zu2.setEnabled(true);
		} else {
			chbPoWi2z3.setEnabled(false);
			chbPoWi3zu2.setEnabled(false);
		}
	}// GEN-LAST:event_chbPoWi_biliActionPerformed

	/**
	 * Speichern der Kurswahl und führt automaitsch zum nächsten Panel.
	 *
	 * @param evt
	 *            Eingehendes Event bei buSpeichern
	 */
	private void buSpeichernActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buSpeichernActionPerformed
		// Überprüft, ob ein Sternchenkurs schon belegt oder grade gewählt
		// wurde:
		if ((chbWahlpflicht.isSelected() || chbPoWi.isSelected() || chbPoWi_bili.isSelected() || chbRewe.isSelected()
				|| chbDaten.isSelected() || (chbWahlpflicht.isSelected()) || !"-Auswählen-".equals(cbWahlpflicht
				.getSelectedItem()))
				&& (!(((String) cbErstwahl.getSelectedItem()).equals("-Auswählen-"))
						&& !(((String) cbZweitwahl.getSelectedItem()).equals("-Auswählen-")) || !jPanel4.isVisible())) {
			// Ob 2. Fremssparache belegt ist:
			boolean hatFremdsprache = chbSpanisch.isVisible() || chbFranz.isVisible();
			// Ob 2. Fremdsprache abgewählt wird:
			boolean hatFremdspracheIn13 = hatFremdsprache && !(chbSpanisch.isSelected() || chbFranz.isSelected());

			// Update der Daten:
			schueler.update(chbPoWi.isSelected(), chbPoWi_bili.isSelected(), (String) cbWahlpflicht.getSelectedItem(),
					chbRewe.isSelected(), chbDaten.isSelected(), chbGeschichte3z2.isSelected(),
					chbGeschichte2zu3.isSelected(), chbPoWi3zu2.isSelected(), chbPoWi2z3.isSelected(),
					chbReligion_kat.isSelected(), chbReligion_evang.isSelected(),
					(String) cbErstwahl.getSelectedItem(), (String) cbZweitwahl.getSelectedItem(),
					chbWahlpflicht.isSelected(), (String) cbReligion.getSelectedItem(), tfZusatzKurs.getText(),
					tfAbwahlKurs.getText(), hatFremdsprache, hatFremdspracheIn13);
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
	private void cbErstwahlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbErstwahlActionPerformed
		if ((String) cbErstwahl.getItemAt(0) != null) {
			if (((String) cbErstwahl.getSelectedItem()).equals("-Auswählen-") && !cbZweitwahl.isEnabled()) {

			} else if (!(((String) cbErstwahl.getSelectedItem()).equals("-Auswählen-"))) {
				cbZweitwahl.removeAllItems();
				cbZweitwahl.addItem("-Auswählen-");
				for (String s : de.ruzman.kurswahl13.Konfig.INHALT_SPORT.toString().split(",")) {
					if (!s.equals((String) cbErstwahl.getSelectedItem())) {
						cbZweitwahl.addItem(s);
					}
				}
				cbZweitwahl.setEnabled(true);
			} else {
				cbZweitwahl.removeAllItems();
				cbZweitwahl.addItem("-Auswählen-");
				cbZweitwahl.setEnabled(false);
			}
		}
	}// GEN-LAST:event_cbErstwahlActionPerformed

	private void cbZweitwahlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbZweitwahlActionPerformed

	}// GEN-LAST:event_cbZweitwahlActionPerformed

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

	/**
	 * Um mit dem Kurswahlfenster interagieren zu können.
	 *
	 * @param fenster
	 *            Referenz zum Kurswahlfenster.
	 */
	public void setzeFenster(Kurswahlfenster13 fenster) {
		this.fenster = fenster;
	}

	/**
	 * Das Kurswahlpanel wird in den Ausgangszustand versetzt.
	 */
	public void zuruecksetzen() {
		// Neuen Namen anzeigen:
		laName.setText("Name: " + schueler.gibName());

		// Index für die Sportkurse ist 0:
		cbErstwahl.setSelectedIndex(0);
		cbZweitwahl.setSelectedIndex(0);

		cbWahlpflicht.setSelectedIndex(0);

		// Deselektierung der einzelnen Checkboxen:
		chbPoWi.setSelected(false);
		chbPoWi_bili.setSelected(false);
		chbRewe.setSelected(false);
		chbDaten.setSelected(false);
		chbWahlpflicht.setSelected(false);

		// Alle Wirtschafter haben auch die Möglichkeit
		// ReWe und Datenverarbeitung zu wählen:
		if (schueler.gibBezeichung().contains("WIRT")) {
			chbRewe.setVisible(true);
			chbDaten.setVisible(true);
		} else {
			chbRewe.setVisible(false);
			chbDaten.setVisible(false);
		}

		// Umwahl der Stunden bei PoWi sperren:
		chbPoWi2z3.setEnabled(false);
		chbPoWi3zu2.setEnabled(false);

		// Überprüft, welche Umwahl bei PoWi gemacht werden kann:
		int powiStunden = schueler.gibStunden("Politik und Wirtschaft");
		if (powiStunden == 2) {
			// 2 -> 3 anzeigen:
			chbPoWi3zu2.setVisible(false);
			chbPoWi2z3.setVisible(true);
		} else if (powiStunden == 3) {
			// 3 -> 2 anzeigen
			chbPoWi3zu2.setVisible(true);
			chbPoWi2z3.setVisible(false);
		}

		// Überprüft, welche Umwahl bei Geschichte gemacht werden kann:
		int geschiStunden = schueler.gibStunden("Geschichte");
		if (geschiStunden == 2) {
			// 2 -> 3 anzeigen:
			chbGeschichte3z2.setVisible(false);
			chbGeschichte2zu3.setVisible(true);
		} else if (geschiStunden == 3) {
			// 3 -> 2 anzeigen:
			chbGeschichte3z2.setVisible(true);
			chbGeschichte2zu3.setVisible(false);
		}

		// Deselektiert die Umwahlfelder:
		chbPoWi2z3.setSelected(false);
		chbPoWi3zu2.setSelected(false);
		chbGeschichte2zu3.setSelected(false);
		chbGeschichte3z2.setSelected(false);

		// Überprüfung, ob Spanisch belegt wird:
		if (schueler.belegtFach("Spanisch")) {
			// Anzeigen und entsperren:
			chbSpanisch.setVisible(true);
			chbSpanisch.setEnabled(true);
		} else {
			// Verstecken und Sperren:
			chbSpanisch.setVisible(false);
			chbSpanisch.setEnabled(false);
		}

		// Überprüfung, ob Französisch belegt wird:
		if (schueler.belegtFach("Französisch")) {
			// Anzeigen und entsperren:
			chbFranz.setVisible(true);
			chbFranz.setEnabled(true);
		} else {
			// Verstecken und Sperren:
			chbFranz.setVisible(false);
			chbFranz.setEnabled(false);
		}

		// Überprüft, ob überhaupt eine Sprache belegt wird:
		if (!chbFranz.isEnabled() && !chbSpanisch.isEnabled()) {
			// Versteckt die Abwahl der Sprachen:
			laSprachen.setVisible(false);
			jPanel6.setVisible(false);
		} else {
			// Zeigt die Abwahl der Sprachen an:
			laSprachen.setVisible(true);
			jPanel6.setVisible(true);
		}

		// Deselektiert die Sprach-Comboboxen:
		chbSpanisch.setSelected(false);
		chbFranz.setSelected(false);

		chbReligion_ethik.setVisible(false);

		// Falls die Abwahl der Religionen zugelassen ist:
		if ((de.ruzman.kurswahl13.Konfig.ZUSTAND_CHKRELIGION.toString()).equalsIgnoreCase("AN")) {
			// Prüft ob kath. Religion belegt wird:
			if (schueler.belegtFach("%kath%")) {
				chbReligion_kat.setVisible(true);
			} else {
				chbReligion_kat.setVisible(false);
			}

			// Prüft ob evangelische Religion belegt wird:
			if (schueler.belegtFach("%evang%")) {
				chbReligion_evang.setVisible(true);
			} else {
				chbReligion_evang.setVisible(false);
			}

			// Falls keine Religion belegt wird:
			if (!chbReligion_kat.isVisible() && !chbReligion_evang.isVisible()) {
				// Abwahl Religion verstecken:
				laReligion.setVisible(false);
				jPanel9.setVisible(false);
			} else {
				// Abwahl Religion anzeigen:
				laReligion.setVisible(true);
				jPanel9.setVisible(true);
			}
		} else {
			// Abwahl Religion verstecken:
			laReligion.setVisible(false);
			jPanel9.setVisible(false);
		}

		// Deselektiert alle Checkboxen bei der Abwahl von Religion:
		chbReligion_kat.setSelected(false);
		chbReligion_evang.setSelected(false);

		// Falls die Wahl der Religion erlaubt ist:
		if (de.ruzman.kurswahl13.Konfig.ZUSTAND_RELIGION.toString().equalsIgnoreCase("AN")) {
			// Combobox anzeigen:
			jLabel2.setVisible(true);
			cbReligion.setVisible(true);
			if (cbReligion.getSelectedItem() != null) {
				// Das erste Element selektieren:
				cbReligion.setSelectedIndex(0);
			}
			// Combobox befüllen:
			Kurswahlfenster13.loescheUndSetzeComboBox(cbReligion, de.ruzman.kurswahl13.Konfig.INHALT_RELIGION
					.toString().split(","));
		} else {
			// Combobox cbReligionen verstecken:
			jLabel2.setVisible(false);
			cbReligion.setVisible(false);
		}

		// Falls die zusätzliche Wahl erlaubt ist:
		if (de.ruzman.kurswahl13.Konfig.ZUSTAND_ZUSATZ1.toString().equalsIgnoreCase("AN")) {
			// Zusätzliche Wahl anzeigen/leeren:
			tfZusatzKurs.setText("");
			laZusatzKurs.setVisible(true);
			tfZusatzKurs.setVisible(true);
		} else {
			// Zusätzliche Wahl verstecken/leeren:
			tfZusatzKurs.setText("");
			laZusatzKurs.setVisible(false);
			tfZusatzKurs.setVisible(false);
		}

		// Falls die zusätzliche Abwahl erlaubt ist:
		if (de.ruzman.kurswahl13.Konfig.ZUSTAND_ZUSATZ2.toString().equalsIgnoreCase("AN")) {
			// Zusätzliche abwahl anzeigen/leeren:
			tfAbwahlKurs.setText("");
			laAbwahlKurs.setVisible(true);
			tfAbwahlKurs.setVisible(true);
		} else {
			// Zusätzliche abwahl verstecken/leeren:
			tfAbwahlKurs.setText("");
			laAbwahlKurs.setVisible(false);
			tfAbwahlKurs.setVisible(false);
		}

		boolean istSportkursAktiv = de.ruzman.kurswahl13.Konfig.ZUSTAND_SPORTWAHL.toString().equalsIgnoreCase("AN");
		laSportkurs2.setVisible(istSportkursAktiv);
		jPanel4.setVisible(istSportkursAktiv);
	}

	/**
	 * Gibt den Titel für das Panels zurück.
	 *
	 * @return Titel für das Panel
	 */
	@Override
	public String toString() {
		return "Kurswahl13 - Kurswahl";
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buAbbrechen;
	private javax.swing.JButton buSpeichern;
	private javax.swing.JComboBox cbErstwahl;
	private javax.swing.JComboBox cbReligion;
	private javax.swing.JComboBox cbWahlpflicht;
	private javax.swing.JComboBox cbZweitwahl;
	private javax.swing.JCheckBox chbDaten;
	private javax.swing.JCheckBox chbFranz;
	private javax.swing.JCheckBox chbGeschichte2zu3;
	private javax.swing.JCheckBox chbGeschichte3z2;
	private javax.swing.JCheckBox chbPoWi;
	private javax.swing.JCheckBox chbPoWi2z3;
	private javax.swing.JCheckBox chbPoWi3zu2;
	private javax.swing.JCheckBox chbPoWi_bili;
	private javax.swing.JCheckBox chbReligion_ethik;
	private javax.swing.JCheckBox chbReligion_evang;
	private javax.swing.JCheckBox chbReligion_kat;
	private javax.swing.JCheckBox chbRewe;
	private javax.swing.JCheckBox chbSpanisch;
	private javax.swing.JCheckBox chbWahlpflicht;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JLabel laAbwahlKurs;
	private javax.swing.JLabel laErstwahl;
	private javax.swing.JLabel laName;
	private javax.swing.JLabel laReligion;
	private javax.swing.JLabel laSportkurs1;
	private javax.swing.JLabel laSportkurs2;
	private javax.swing.JLabel laSprachen;
	private javax.swing.JLabel laSprachen1;
	private javax.swing.JLabel laSternchenkurs;
	private javax.swing.JLabel laUmwahl;
	private javax.swing.JLabel laZusatzKurs;
	private javax.swing.JLabel laZweitwahl;
	private javax.swing.JTextField tfAbwahlKurs;
	private javax.swing.JTextField tfZusatzKurs;
	// End of variables declaration//GEN-END:variables
}
