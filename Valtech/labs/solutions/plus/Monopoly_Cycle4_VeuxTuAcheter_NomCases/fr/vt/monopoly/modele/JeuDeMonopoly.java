package fr.vt.monopoly.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.cases.Case;

public final class JeuDeMonopoly {

	private List<Joueur> joueurs;
	private final int nbTours;
	private final int nbJoueurs;
	private final Plateau plateau;

	private final String[] pions = new String[] { "Cheval", "Voiture", "Chien",
			"Fer à repasser", "Navire", "Canon", "Haut de forme", "Chaussure", };

	public JeuDeMonopoly(int nbJoueurs, int nbTours) {
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

	/**
	 * Modification de la méthode jouer pour considérer le comportement de
	 * JeSuisFaucheException
	 */
	public void jouer() {
		for (int t = 0; t < nbTours; t++) {
			Iterator<Joueur> it = joueurs.iterator();
			while (it.hasNext()) {
				Joueur j = null;
				try {
					j = it.next();
					j.aTonTour();

				} catch (JeSuisFaucheException e) {
					// Un joueur a perdu
					e.printStackTrace();
					// Afficher un message pour le perdant
					System.out.println("---- FAUCHE ---- " + j.getPion());

					// Supprime ses propriétés
					plateau.initProprietaire(j);
					
					// supprimer le joueur
					it.remove();

					// vérifier le nombre de joueur restant
					if (joueurs.size() == 1) {
						// Vainqueur
						System.out.println("**** VAINQUEUR **** "
								+ joueurs.get(0).getPion());
						return;
					}
				}
			}
			System.out.println();
		}
	}
	
	
}
