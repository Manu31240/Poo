import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJoueur {

	@Test
	public void test01_constructor() {
		final String name = "Anne-Lise";
		Joueur j = new Joueur(name);
		assertNotNull(j);
		assertNotNull(j.getNom());
		assertTrue(j.getNom().equals(name));
	}

	@Test
	public void test02_aTonTour() {
		final String name = "Anne-Lise";
		Joueur j = new Joueur(name);

		j.aTonTour();
		assertTrue(j.getScore() >= 0 && j.getScore() <= 1);
	}

	@Test
	public void test04_n_aTonTour() {
		final String name = "Anne-Lise";
		Joueur j = new Joueur(name);

		for (int i = 0; i < 10; i++) {
			j.aTonTour();
		}

		assertTrue(j.getScore() >= 0 && j.getScore() <= 10);
		System.out.println(j.getNom() + " a un score de " + j.getScore());
	}
}
