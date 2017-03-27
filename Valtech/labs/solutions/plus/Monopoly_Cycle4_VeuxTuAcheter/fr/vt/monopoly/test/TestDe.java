package fr.vt.monopoly.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.vt.monopoly.modele.De;

public class TestDe {

	@Test
	public void testConstructor() {
		De de = new De();
		assertNotNull(de);

		System.out.println("Valeur par défaut de la face : "
				+ de.getValeurFace());
		// Tant qu'il n'y a pas de constructeur dans la classe la valeur par
		// défaut de la face est 0
	}

	@Test
	public void testDefaultConstructor() {
		De de = new De();
		assertNotNull(de);
		assertTrue(de.getValeurFace() >= 1 && de.getValeurFace() <= 6);
	}

	@Test
	public void testConstructorWithFields() {
		De de = new De(25);
		assertNotNull(de);
		assertTrue(de.getValeurFace() == 25);
	}

	@Test
	public void testLancer() {
		De de = new De();
		assertNotNull(de);

		de.lancer();
		assertTrue(de.getValeurFace() >= 1 && de.getValeurFace() <= 6);

	}

}
