package fr.vt.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.Joueur;
import fr.vt.monopoly.modele.cases.Case;
import fr.vt.monopoly.modele.utils.Gobelet;

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
		try {
			final String pion = "Pion";
			final Case depart = new Case("Départ");
			final Case suivante = new Case("Suivante");
			// Chaînage de 2 cases
			depart.setSuivante(suivante);
			suivante.setSuivante(depart);

			Joueur j = new Joueur(pion, depart);
			j.aTonTour();

			assertNotNull(j.getPosition());
			if ((Gobelet.getInstance().getValeurFace()) % 2 == 0)
				assertTrue(j.getPosition().equals(depart));
			else
				assertTrue(j.getPosition().equals(suivante));
		} catch (JeSuisFaucheException e) {
			fail();
		}
	}
}
