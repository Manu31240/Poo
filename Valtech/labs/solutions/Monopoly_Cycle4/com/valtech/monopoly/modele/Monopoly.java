package com.valtech.monopoly.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.valtech.monopoly.metiers.exception.JeSuisFaucheException;
import com.valtech.monopoly.modele.cases.Case;
import com.valtech.monopoly.modele.cases.Plateau;

public final class Monopoly {

	private List<Joueur> joueurs;
	private final int nbTours;
	private final int nbJoueurs;

	private final String[] pions = new String[] { "Cheval", "Voiture", "Chien", "Fer à repasser", "Navire", "Canon",
			"Haut de forme", "Chaussure", };
	private Plateau plateau;

	public Monopoly(int nbJoueurs, int nbTours) {
		this.nbTours = nbTours;
		this.nbJoueurs = nbJoueurs;
		plateau = new Plateau();
		Case caseDepart = plateau.getCaseDepart();
		this.joueurs = new ArrayList<>();

		// Initialisation du tableau de joueurs
		for (int i = 0; i < this.nbJoueurs; i++) {
			joueurs.add(new Joueur(pions[i], caseDepart));
		}
	}

	public void jouer() {
		for (int t = 0; t < nbTours; t++) {
			Iterator<Joueur> it = joueurs.iterator();
			while (it.hasNext()) {
				Joueur jo = null;
				try {
					jo = it.next();
					jo.aTonTour();

				} catch (JeSuisFaucheException e) {
					// Un joueur a perdu
					//e.printStackTrace();
					System.err.println(e.getMessage());

					// Supprime ses propriétés
					plateau.initProprietaire(jo);

					// supprimer le joueur
					it.remove();

					// vérifier le nombre de joueur restant
					if (joueurs.size() == 1) {
						// Vainqueur
						Joueur gagnant = joueurs.get(0);
						System.out.println("**** VAINQUEUR **** " + gagnant.getPion() + " avec un solde de "
								+ gagnant.getSolde() + "€");
						return;
					}
				}
			}
			System.out.println();
		}
	}
}
