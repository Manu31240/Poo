package com.valtech.monopoly.modele;

import com.valtech.monopoly.modele.cases.Case;
import com.valtech.monopoly.modele.cases.Plateau;

public class Monopoly {

	private Joueur[] joueurs;
	private De d1, d2;
	private final int nbTours;
	private final int nbJoueurs;

	private final String[] pions = new String[] { "Cheval", "Voiture", "Chien", "Fer à repasser", "Navire", "Canon",
			"Haut de forme", "Chaussure", };

	public Monopoly(int nbJoueurs, int nbTours) {
		this.nbTours = nbTours;
		this.nbJoueurs = nbJoueurs;
		Plateau plateau = new Plateau();
		d1 = new De();
		d2 = new De();
		Case caseDepart = plateau.getCaseDepart();
		this.joueurs = new Joueur[this.nbJoueurs];

		// Initialisation du tableau de joueurs
		for (int i = 0; i < this.nbJoueurs; i++) {
			joueurs[i] = new Joueur(pions[i], caseDepart);
		}
	}

	public void jouer() {
		for (int t = 0; t < nbTours; t++) {
			for (int j = 0; j < nbJoueurs; j++) {
				joueurs[j].aTonTour(d1, d2);

				System.out.println(joueurs[j].getPion() + " a fait " + (d1.getFace() + d2.getFace()));
				System.out.println(joueurs[j].getPion() + " atterrit sur " + joueurs[j].getPosition().getNom());
			}
			System.out.println();
		}
	}
}
