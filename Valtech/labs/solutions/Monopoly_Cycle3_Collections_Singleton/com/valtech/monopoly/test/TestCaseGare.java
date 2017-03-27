package com.valtech.monopoly.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.proprietes.CaseGare;

public class TestCaseGare {

	@Test
	public void testConstructor() {
		final CaseGare gare = new CaseGare("gare", 200);
		assertNotNull(gare);
		assertNotNull(gare.getNom());
		assertTrue(gare.getNom().equals("gare"));
		assertTrue(gare.getPrixAchat() == 200);
		assertTrue(gare.getSuivante() == null);

	}

	@Test
	public void testArreterSur() {
		final String pion = "Pion";
		final CaseGare gare = new CaseGare("gare", 200);
		Joueur j = new Joueur(pion, gare);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(gare));

		double defaultSolde = j.getSolde();
		assertTrue(defaultSolde == 1500d);

		gare.arreterSur(j);

		assertTrue(j.getSolde() == (defaultSolde - 200d));
		assertTrue(j.equals(gare.getProprietaire()));
	}

	@Test
	public void testLoyer() {
		final String pion1 = "Pion1";
		final String pion2 = "Pion2";
		final CaseGare gare = new CaseGare("gare", 200);
		Joueur j1 = new Joueur(pion1, gare);
		assertNotNull(j1);
		assertNotNull(j1.getPion());
		assertTrue(j1.getPion().equals(pion1));
		assertNotNull(j1.getPosition());
		assertNotNull(j1.getPosition().getNom());
		assertTrue(j1.getPosition().equals(gare));

		double defaultSolde = j1.getSolde();
		assertTrue(defaultSolde == 1500d);

		gare.arreterSur(j1);

		assertTrue(j1.getSolde() == (defaultSolde - 200d));
		assertTrue(j1.equals(gare.getProprietaire()));

		Joueur j2 = new Joueur(pion2, gare);
		assertNotNull(j2);
		assertNotNull(j2.getPion());
		assertTrue(j2.getPion().equals(pion2));
		assertNotNull(j2.getPosition());
		assertNotNull(j2.getPosition().getNom());
		assertTrue(j2.getPosition().equals(gare));

		gare.arreterSur(j2);
		int loyer = gare.calculerLoyer();
		assertTrue(j2.getSolde() == (defaultSolde - loyer));
		assertFalse(j2.equals(gare.getProprietaire()));
	}
}
