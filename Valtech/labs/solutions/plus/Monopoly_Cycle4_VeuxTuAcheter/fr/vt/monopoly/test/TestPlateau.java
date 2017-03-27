package fr.vt.monopoly.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.vt.monopoly.modele.Plateau;
import fr.vt.monopoly.modele.cases.Case;

public class TestPlateau {

	@Test
	public void testConstructor() {
		Plateau plateau = new Plateau();
		assertNotNull(plateau);
	}

	@Test
	public void testGetCaseDepart() {
		Plateau plateau = new Plateau();
		assertNotNull(plateau);

		Case depart = plateau.getCaseDepart();
		assertNotNull(depart);

		assertNotNull(depart.getNom());
		assertTrue(depart.getNom().equals("Départ"));
	}

	@Test
	public void testChainage() {
		Plateau plateau = new Plateau();
		assertNotNull(plateau);

		Case depart = plateau.getCaseDepart();
		assertNotNull(depart);

		assertNotNull(depart.getNom());
		assertTrue(depart.getNom().equals("Départ"));

		Case suivante = depart;
		do {
			suivante = suivante.getSuivante();
			assertNotNull(suivante);
		} while (suivante != depart);

		assertTrue(suivante.equals(depart));
	}

}
