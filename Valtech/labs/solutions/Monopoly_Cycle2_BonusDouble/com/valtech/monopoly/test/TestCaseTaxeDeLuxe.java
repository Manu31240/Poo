package com.valtech.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.CaseTaxeDeLuxe;

public class TestCaseTaxeDeLuxe {

	@Test
	public void testConstructor() {
		CaseTaxeDeLuxe taxeDeLuxe = new CaseTaxeDeLuxe("Taxe de Luxe");
		assertNotNull(taxeDeLuxe);
		assertNotNull(taxeDeLuxe.getNom());
		assertTrue(taxeDeLuxe.getNom().equals("Taxe de Luxe"));
		assertTrue(taxeDeLuxe.getSuivante() == null);

	}

	@Test
	public void testArreterSur() {
		final String pion = "Pion";
		final CaseTaxeDeLuxe taxeDeLuxe = new CaseTaxeDeLuxe("Taxe de Luxe");
		Joueur j = new Joueur(pion, taxeDeLuxe);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(taxeDeLuxe));

		double defaultSolde = j.getSolde();
		assertTrue(defaultSolde == 1500d);
		taxeDeLuxe.arreterSur(j);
		assertTrue(j.getSolde() == (defaultSolde - 75));
	}

}
