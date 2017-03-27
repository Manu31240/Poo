public class JeuDeDes {
	// NB_TOURS = 10
	private final int NB_TOURS = 10;
	private De de1, de2;
	private Joueur[] joueurs;

	public JeuDeDes(int nbJoueurs) {
		joueurs = new Joueur[nbJoueurs];
		// init joueur
		for (int i = 0; i < joueurs.length; i++) {
			joueurs[i] = new Joueur("Joueur" + (i + 1));
		}
		de1 = new De();
		de2 = new De();
	}

	public void jouer() {
		int scoreMax = 0;

		// Faire jouer
		for (int t = 0; t < NB_TOURS; t++) {
			for (int i = 0; i < joueurs.length; i++) {
				joueurs[i].aTonTour(de1, de2);
				if (scoreMax < joueurs[i].getScore())
					scoreMax = joueurs[i].getScore();
			}
		}

		// Afficher le ou les vainqueurs
		System.out.println("Le(s) Vainqueur(s), avec un score de " + scoreMax
				+ ",sont :");
		for (int i = 0; i < joueurs.length; i++) {
			if (scoreMax == joueurs[i].getScore())
				System.out.println(joueurs[i].getNom());
		}
	}
}
