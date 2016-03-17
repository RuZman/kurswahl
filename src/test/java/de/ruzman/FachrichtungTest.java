package de.ruzman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FachrichtungTest {
	private DBSchueler schueler;

	@BeforeClass
	public static void initKonfig() {
		Konfiguration.gibInstanz("LoginTest.ini");
	}

	@Before
	public void init() {
		schueler = new DBSchueler() {
		};
		new DBJahrgang(schueler);
	}

	@Test
	public void spezielleFachrichtungTest() {
		schueler.setzeKurs("12CH13");
		schueler.setzeName("Mustermann, Max");
		schueler.setzeFachrichtung();
		assertThat(schueler.gibFachrichtung(), is("Wirtschaft Bilingual"));
	}

	@Test
	public void simpleFachrichtungTest() {
		schueler.setzeKurs("12CH13");
		schueler.setzeName("Apfel, Timo");
		schueler.setzeFachrichtung();
		assertThat(schueler.gibFachrichtung(), is("Gesundheit"));
	}

	@Test
	public void doppeldeutigeFachrichtungTest() {
		schueler.setzeKurs("12CH13");
		schueler.setzeName("Zimt, Peter");
		schueler.setzeFachrichtung();
		assertThat(schueler.gibFachrichtung(), is("Wirtschaft"));
	}
}
