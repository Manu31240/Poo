package com.valtech.monopoly.modele;

import java.util.ArrayList;
import java.util.List;

import com.valtech.monopoly.modele.cases.Case;
import com.valtech.monopoly.modele.cases.Plateau;

public final class Monopoly {

	private List<Joueur> joueurs;
	private final int nbTours;
	private final int nbJoueurs;

	private final String[] pions = new String[] { "Cheval", "Voiture", "Chien", "Fer à repasser", "Navire", "Canon",
			"Haut de forme", "Chaussure", };

	public Monopoly(int nbJoueurs, int nbTours) {
		this.nbTours = nbTours;
		this.nbJoueurs = nbJoueurs;
		Plateau plateau = new Plateau();
		Case caseDepart = plateau.getCaseDepart();
		this.joueurs = new ArrayList<>();

		// Initialisation du tableau de joueurs
		for (int i = 0; i < this.nbJoueurs; i++) {
			joueurs.add(new Joueur(pions[i], caseDepart));
		}
	}

	public void jouer() {
		for (int t = 0; t < nbTours; t++) {
			for (Joueur jo : joueurs) {
				jo.aTonTour();
			}
			System.out.println();
		}
	}
}
