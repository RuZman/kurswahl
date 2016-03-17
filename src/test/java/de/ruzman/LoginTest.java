package de.ruzman;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
	private DBJahrgang jahrgang;
	private DBSchueler schueler;

	@BeforeClass
	public static void initKonfig() {
		Konfiguration.gibInstanz("LoginTest.ini");
	}

	@Before
	public void init() {
		schueler = new DBSchueler() {
		};
		jahrgang = new DBJahrgang(schueler);

	}

	@Test
	public void gibJahreTest() {
		assertThat(Arrays.asList(jahrgang.gibJahre()), contains("1998", "1997", "1994"));
	}

	@Test
	public void gibKlassenTest() {
		assertThat(Arrays.asList(jahrgang.gibKurse()), contains("11DV1", "11W4", "12CH13"));
	}

	@Test
	public void gibNamenTest() {
		jahrgang.gibSchueler().setzeKurs("12CH13");
		assertThat(Arrays.asList(jahrgang.gibNamen()), contains("Apfel, Timo", "Mustermann, Max", "Zimt, Peter"));
	}

	@Test
	public void falscherGeburtsTagTest() {
		initDBSchueler();
		assertFalse(schueler.istGeburtsdatum("16.02.1994"));
	}

	@Test
	public void falscherGeburtsMonatTest() {
		initDBSchueler();
		assertFalse(schueler.istGeburtsdatum("17.03.1994"));
	}

	@Test
	public void falschesGeburtsJahrTest() {
		initDBSchueler();
		assertFalse(schueler.istGeburtsdatum("17.02.1995"));
	}

	@Test
	public void richtigesGeburtsdatumTest() {
		initDBSchueler();
		assertTrue(schueler.istGeburtsdatum("17.02.1994"));
	}

	@Test
	public void gekuerzterGeburtsortTest() {
		initDBSchueler();
		assertTrue(schueler.istGeburtsort("BÜR"));
	}

	@Test
	public void gekuerzterGeburtsortTest2() {
		initDBSchueler();
		assertTrue(schueler.istGeburtsort("bÜr"));
	}

	@Test
	public void geburtsortTest() {
		initDBSchueler();
		assertTrue(schueler.istGeburtsort("Bürstadt"));
	}

	@Test
	public void gekuerzterFalscherGeburtsortTest2() {
		initDBSchueler();
		assertFalse(schueler.istGeburtsort("BürFalsch"));
	}

	private void initDBSchueler() {
		schueler.setzeKurs("12CH13");
		schueler.setzeName("Apfel, Timo");
	}
}
