package fr.vt.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.Joueur;
import fr.vt.monopoly.modele.cases.CaseDepart;

public class TestCaseDepart {

	@Test
	public void testConstructor() {
		CaseDepart depart = new CaseDepart("Départ");
		assertNotNull(depart);
		assertNotNull(depart.getNom());
		assertTrue(depart.getNom().equals("Départ"));
		assertTrue(depart.getSuivante() == null);

	}

	@Test
	public void testArreterSur() {
		try {
			final String pion = "Pion";
			final CaseDepart depart = new CaseDepart("Départ");
			Joueur j = new Joueur(pion, depart);
			assertNotNull(j);
			assertNotNull(j.getPion());
			assertTrue(j.getPion().equals(pion));
			assertNotNull(j.getPosition());
			assertNotNull(j.getPosition().getNom());
			assertTrue(j.getPosition().equals(depart));

			double defaultSolde = j.getSolde();
			assertTrue(defaultSolde == 1500d);

			depart.arreterSur(j);

			assertTrue(j.getSolde() == (defaultSolde + 400d));
		} catch (JeSuisFaucheException e) {
			fail();
		}
	}

	@Test
	public void testPasserPar() {
		final String pion = "Pion";
		final CaseDepart depart = new CaseDepart("Départ");
		Joueur j = new Joueur(pion, depart);
		assertNotNull(j);
		assertNotNull(j.getPion());
		assertTrue(j.getPion().equals(pion));
		assertNotNull(j.getPosition());
		assertNotNull(j.getPosition().getNom());
		assertTrue(j.getPosition().equals(depart));

		double defaultSolde = j.getSolde();
		assertTrue(defaultSolde == 1500d);
		depart.passerPar(j);
		assertTrue(j.getSolde() == (defaultSolde + 200d));
	}
}
