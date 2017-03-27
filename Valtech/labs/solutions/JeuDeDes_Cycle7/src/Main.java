public class Main {
	// "main" est le point de départ d’exécution dans un programme Java
	public static void main(String[] args) {
		// NB_TOURS = 10
		final int NB_TOURS = 10;

		// Tableau de joueurs
		Joueur[] tabJoueurs = new Joueur[5];

		// Initialiser les instances des joueurs
		for (int i = 0; i < tabJoueurs.length; i++) {
			tabJoueurs[i] = new Joueur("Joueur" + (i + 1));
		}

		/**
		 * pour faire afficher le ou les gagnants il faut connaitre le score max
		 */
		int scoreMax = 0;

		// faire jouer 10 tours
		for (int i = 0; i < NB_TOURS; i++) {
			for (int j = 0; j < tabJoueurs.length; j++) {
				tabJoueurs[j].aTonTour();
				if (scoreMax < tabJoueurs[j].getScore())
					scoreMax = tabJoueurs[j].getScore();
			}
		}

		// Afficher le ou les vainqueurs
		System.out.println("Le(s) Vainqueur(s), avec un score de " + scoreMax
				+ ",sont :");
		for (int i = 0; i < tabJoueurs.length; i++) {
			if (tabJoueurs[i].getScore() == scoreMax) {
				System.out.println(tabJoueurs[i].getNom());
			}
		}
	}
}
