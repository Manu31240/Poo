public class Main {
	// "main" est le point de d�part d�ex�cution dans un programme Java
	public static void main(String[] args) {
		Gobelet g1 = new Gobelet();
		for (int i = 0; i < 10; i++) {
			g1.lancer();
			int value = g1.getFace();
			System.out.println("La somme des d�s : " + value);
		}
	}

}
