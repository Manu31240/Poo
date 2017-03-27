package com.valtech.monopoly.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.valtech.monopoly.modele.De;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDe {

	@Test
	public void test01_constructor() {
		De de = new De();
		assertNotNull(de);

		System.out.println(" par défaut de la face : "
				+ de.getFace());
		// Tant qu'il n'y a pas de constructeur dans la classe la valeur par
		// défaut de la face est 0
	}

	@Test
	public void test02_defaultConstructor() {
		De de = new De();
		assertNotNull(de);
		assertTrue(de.getFace() >= 1 && de.getFace() <= 6);
	}

	@Test
	public void test03_constructorWithFields() {
		De de = new De(25);
		assertNotNull(de);
		assertTrue(de.getFace() == 25);
	}

	@Test
	public void test04_lancer() {
		De de = new De();
		assertNotNull(de);

		de.lancer();
		assertTrue(de.getFace() >= 1 && de.getFace() <= 6);

	}

}
