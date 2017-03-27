package com.valtech.jeudedes.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.valtech.jeudedes.modele.utils.DePipe;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDePipe {

	@Test
	public void test01_lancer() {
		DePipe dp = new DePipe();
		assertNotNull(dp);
		dp.setFacePipee(9);

		do {
			dp.lancer();
			System.out.println(dp.getFace());
		} while (dp.getFace() >= 1 && dp.getFace() <= 6);

		assertTrue(dp.getFace() == 9);

	}

}
