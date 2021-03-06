package com.valtech.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.Case;
import com.valtech.monopoly.modele.utils.Gobelet;

public class TestJoueur {

	@Test
	public void testConstructor() {
		final String pion = "Pion";
		final Case depart = new Case("D�part");
		Joueur j = new Joueur(pion, depart);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(depart));
	}

	@Test
	public void testATonTour() {
		final String pion = "Pion";
		final Case depart = new Case("D�part");
		final Case suivante = new Case("Suivante");
		// Cha�nage de 2 cases
		depart.setSuivante(suivante);
		suivante.setSuivante(depart);

		Joueur j = new Joueur(pion, depart);
		
		j.aTonTour();

		assertNotNull(j.getPosition());
		if (Gobelet.getInstance().getFace() % 2 == 0)
			assertTrue(j.getPosition().equals(depart));
		else
			assertTrue(j.getPosition().equals(suivante));
	}
}
