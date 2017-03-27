public class Main {
	// "main" est le point de départ d’exécution dans un programme Java
	public static void main(String[] args) {
		// création d’un objet De
		De de1 = new De();
		// boucle 10 fois
		for (int i = 0; i < 10; i++) {
			// envoi du message “lancer”
			de1.lancer();
			int valeur = de1.getFace();
			// impression sur la console
			System.out.println("La face du dé est : " + valeur);
		}
	}
}
