package com.valtech.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.CaseImpots;

public class TestCaseImpot {

	@Test
	public void testConstructor() {
		CaseImpots impots = new CaseImpots("Impôts");
		assertNotNull(impots);
		assertNotNull(impots.getNom());
		assertTrue(impots.getNom().equals("Impôts"));
		assertTrue(impots.getSuivante() == null);

	}

	@Test
	public void testArreterSur() {
		final String pion = "Pion";
		final CaseImpots impots = new CaseImpots("Impôts");
		Joueur j = new Joueur(pion, impots);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(impots));

		double defaultSolde = j.getSolde();
		assertTrue(defaultSolde == 1500d);
		impots.arreterSur(j, null, null);
		double mntImpots = Math.max(200, j.getSolde() * 0.1);
		assertTrue(j.getSolde() == (defaultSolde - mntImpots));
	}

}
