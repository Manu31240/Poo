package com.valtech.monopoly.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.valtech.monopoly.modele.cases.Case;

public class TestCase {

	@Test
	public void testConstructor() {
		Case c = new Case("case");
		assertNotNull(c);
		assertNotNull(c.getNom());
		assertTrue(c.getNom().equals("case"));
		assertTrue(c.getSuivante() == null);

	}

	@Test
	public void testSuivante() {
		Case c1 = new Case("case1");
		Case c2 = new Case("case2");
		assertNotNull(c1);
		assertNotNull(c1.getNom());
		assertTrue(c1.getNom().equals("case1"));
		assertNotNull(c2);
		assertNotNull(c2.getNom());
		assertTrue(c2.getNom().equals("case2"));

		c1.setSuivante(c2);
		c2.setSuivante(c1);
		assertNotNull(c1.getSuivante());
		assertTrue(c1.getSuivante().equals(c2));

		assertNotNull(c2.getSuivante());
		assertTrue(c2.getSuivante().equals(c1));

	}

}
