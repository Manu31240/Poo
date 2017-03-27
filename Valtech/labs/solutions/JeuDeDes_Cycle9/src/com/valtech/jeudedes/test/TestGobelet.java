package com.valtech.jeudedes.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.valtech.jeudedes.modele.utils.Gobelet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGobelet {

	@Test
	public void test01_lancer() {
		Gobelet gob = new Gobelet();
		assertNotNull(gob);

		gob.lancer();
		assertTrue(gob.getFace() >= 2 && gob.getFace() <= 12);

	}

}
