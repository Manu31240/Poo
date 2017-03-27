public class Main {
	// "main" est le point de départ d’exécution dans un programme Java
	public static void main(String[] args) {
		Gobelet g1 = new Gobelet();
		for (int i = 0; i < 10; i++) {
			g1.lancer();
			int value = g1.getFace();
			System.out.println("La somme des dés : " + value);
		}
	}

}
