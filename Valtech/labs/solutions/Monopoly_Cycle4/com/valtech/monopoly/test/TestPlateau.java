package com.valtech.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.cases.Case;
import com.valtech.monopoly.modele.cases.Plateau;

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
