public class De {

	private int face;

	public void lancer() {
		face = (int) (Math.random() * 6 + 1);
	}

	public int getFace() {
		return face;
	}
}
