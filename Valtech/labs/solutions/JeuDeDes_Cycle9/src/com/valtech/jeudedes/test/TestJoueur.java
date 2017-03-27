package com.valtech.jeudedes.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.valtech.jeudedes.modele.De;
import com.valtech.jeudedes.modele.Joueur;

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
		De d1 = new De(), d2 = new De();

		int faces = 0;

		while (faces < 7) {
			j.aTonTour(d1, d2);
			faces = d1.getFace() + d2.getFace();
			if (faces < 7)
				assertTrue(j.getScore() == 0);

		}
		assertTrue(j.getScore() == 1);
	}

}
