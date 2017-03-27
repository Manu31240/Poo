package com.valtech.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.De;
import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.Case;

public class TestJoueur {

	@Test
	public void testConstructor() {
		final String pion = "Pion";
		final Case depart = new Case("Départ");
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
		final Case depart = new Case("Départ");
		final Case suivante = new Case("Suivante");
		// Chaînage de 2 cases
		depart.setSuivante(suivante);
		suivante.setSuivante(depart);

		Joueur j = new Joueur(pion, depart);
		De de1 = new De(), de2 = new De();
		assertNotNull(de1);
		assertNotNull(de2);
		j.aTonTour(de1, de2);

		assertNotNull(j.getPosition());
		if ((de1.getFace() + de2.getFace()) % 2 == 0)
			assertTrue(j.getPosition().equals(depart));
		else
			assertTrue(j.getPosition().equals(suivante));
	}
}
