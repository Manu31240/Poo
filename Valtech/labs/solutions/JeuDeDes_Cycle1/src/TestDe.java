import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDe {

	@Test
	public void test01_lancer() {
		De de = new De();
		assertNotNull(de);

		de.lancer();
		assertTrue(de.getFace() >= 1 && de.getFace() <= 6);

	}

}
