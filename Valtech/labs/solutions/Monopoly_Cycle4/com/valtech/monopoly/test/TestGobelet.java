package com.valtech.monopoly.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.valtech.monopoly.modele.utils.Gobelet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGobelet {

	@Test
	public void test01_lancer() {
		assertNotNull(Gobelet.getInstance());

		Gobelet.getInstance().lancer();
		assertTrue(Gobelet.getInstance().getFace() >= 2 && Gobelet.getInstance().getFace() <= 12);

	}

}
