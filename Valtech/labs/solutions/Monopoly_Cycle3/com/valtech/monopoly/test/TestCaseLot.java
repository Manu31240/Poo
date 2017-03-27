package com.valtech.monopoly.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.De;
import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.proprietes.CaseLot;

public class TestCaseLot {

	@Test
	public void testConstructor() {
		final int prixAchat = 40 + 2 * 10;
		final CaseLot lot = new CaseLot("lot", prixAchat, 2);
		assertNotNull(lot);
		assertNotNull(lot.getNom());
		assertTrue(lot.getNom().equals("lot"));
		assertTrue(lot.getPrixAchat() == prixAchat);
		assertTrue(lot.getSuivante() == null);

	}

	@Test
	public void testArreterSur() {
		final String pion = "Pion";
		final int prixAchat = 40 + 2 * 10;
		final CaseLot lot = new CaseLot("lot", prixAchat, 2);
		Joueur j = new Joueur(pion, lot);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(lot));

		double defaultSolde = j.getSolde();
		assertTrue(defaultSolde == 1500d);

		De de1 = new De(), de2 = new De();
		lot.arreterSur(j, de1, de2);

		assertTrue(j.getSolde() == (defaultSolde - prixAchat));
		assertTrue(j.equals(lot.getProprietaire()));
	}

	@Test
	public void testLoyer() {
		final int prixAchat = 40 + 2 * 10;
		final String pion1 = "Pion1";
		final String pion2 = "Pion2";
		final CaseLot lot = new CaseLot("lot", prixAchat, 2);
		Joueur j1 = new Joueur(pion1, lot);
		assertNotNull(j1);
		assertNotNull(j1.getPion());
		assertTrue(j1.getPion().equals(pion1));
		assertNotNull(j1.getPosition());
		assertNotNull(j1.getPosition().getNom());
		assertTrue(j1.getPosition().equals(lot));

		double defaultSolde = j1.getSolde();
		assertTrue(defaultSolde == 1500d);

		De de1 = new De(), de2 = new De();
		lot.arreterSur(j1, de1, de2);

		assertTrue(j1.getSolde() == (defaultSolde - prixAchat));
		assertTrue(j1.equals(lot.getProprietaire()));

		Joueur j2 = new Joueur(pion2, lot);
		assertNotNull(j2);
		assertNotNull(j2.getPion());
		assertTrue(j2.getPion().equals(pion2));
		assertNotNull(j2.getPosition());
		assertNotNull(j2.getPosition().getNom());
		assertTrue(j2.getPosition().equals(lot));

		lot.arreterSur(j2, de1, de2);
		int loyer = lot.calculerLoyer(de1, de2);
		assertTrue(j2.getSolde() == (defaultSolde - loyer));
		assertFalse(j2.equals(lot.getProprietaire()));
	}
}
