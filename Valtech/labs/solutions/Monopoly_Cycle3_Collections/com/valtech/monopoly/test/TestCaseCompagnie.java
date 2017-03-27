package com.valtech.monopoly.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.De;
import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.proprietes.CaseCompagnie;

public class TestCaseCompagnie {

	@Test
	public void testConstructor() {
		final CaseCompagnie compagnie = new CaseCompagnie("compagnie", 150);
		assertNotNull(compagnie);
		assertNotNull(compagnie.getNom());
		assertTrue(compagnie.getNom().equals("compagnie"));
		assertTrue(compagnie.getPrixAchat() == 150d);
		assertTrue(compagnie.getSuivante() == null);

	}

	@Test
	public void testArreterSur() {
		final String pion = "Pion";
		final CaseCompagnie compagnie = new CaseCompagnie("compagnie", 150);
		Joueur j = new Joueur(pion, compagnie);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(compagnie));

		double defaultSolde = j.getSolde();
		assertTrue(defaultSolde == 1500d);

		De de1 = new De(), de2 = new De();
		compagnie.arreterSur(j, de1, de2);

		assertTrue(j.getSolde() == (defaultSolde - 150d));
		assertTrue(j.equals(compagnie.getProprietaire()));
	}

	@Test
	public void testLoyer() {
		final String pion1 = "Pion1";
		final String pion2 = "Pion2";
		final CaseCompagnie compagnie = new CaseCompagnie("compagnie", 150);
		Joueur j1 = new Joueur(pion1, compagnie);
		assertNotNull(j1);
		assertNotNull(j1.getPion());
		assertTrue(j1.getPion().equals(pion1));
		assertNotNull(j1.getPosition());
		assertNotNull(j1.getPosition().getNom());
		assertTrue(j1.getPosition().equals(compagnie));

		double defaultSolde = j1.getSolde();
		assertTrue(defaultSolde == 1500d);

		De de1 = new De(), de2 = new De();
		compagnie.arreterSur(j1, de1, de2);

		assertTrue(j1.getSolde() == (defaultSolde - 150d));
		assertTrue(j1.equals(compagnie.getProprietaire()));

		Joueur j2 = new Joueur(pion2, compagnie);
		assertNotNull(j2);
		assertNotNull(j2.getPion());
		assertTrue(j2.getPion().equals(pion2));
		assertNotNull(j2.getPosition());
		assertNotNull(j2.getPosition().getNom());
		assertTrue(j2.getPosition().equals(compagnie));

		compagnie.arreterSur(j2, de1, de2);
		int loyer = compagnie.calculerLoyer(de1, de2);

		assertTrue(j2.getSolde() == (defaultSolde - loyer));
		assertFalse(j2.equals(compagnie.getProprietaire()));
	}
}
