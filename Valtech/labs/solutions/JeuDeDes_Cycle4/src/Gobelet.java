public class Gobelet {
	private De d1 = new De(); // attribut
	private De d2 = new De(); // attribut

	public int getFace() { // m�thode
		return d1.getFace() + d2.getFace();
	}

	public void lancer() { // m�thode
		d1.lancer();
		d2.lancer();
	}
}
