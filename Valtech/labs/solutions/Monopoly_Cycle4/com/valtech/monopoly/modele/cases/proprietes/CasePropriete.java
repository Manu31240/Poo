package com.valtech.monopoly.modele.cases.proprietes;

import com.valtech.monopoly.metiers.exception.JeSuisFaucheException;
import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.Case;

public abstract class CasePropriete extends Case {
	private final int prixAchat;
	private Joueur proprietaire = null;

	public CasePropriete(String nom, int prixAchat) {
		super(nom);
		this.prixAchat = prixAchat;
	}

	@Override
	public void arreterSur(Joueur joueur) throws JeSuisFaucheException {
		super.arreterSur(joueur);
		// Il n'y a pas de proprietaire
		if (proprietaire == null) {
			// Le joueur a assez d'argent
			if (joueur.getSolde() >= prixAchat) {
				// Devient le proprietaire
				joueur.debiter(prixAchat);
				proprietaire = joueur;
				System.out.println(joueur.getPion() + " achète " + getNom() + " pour " + prixAchat + "€");
			}
		} else {
			// Il y a un proprietaire et ce n'est pas le joueur
			if (!proprietaire.equals(joueur)) {
				// calcul du loyer
				int loyer = calculerLoyer();
				joueur.debiter(loyer);
				proprietaire.crediter(loyer);
				System.out.println(
						joueur.getPion() + " paie à " + proprietaire.getPion() + " un loyer de " + loyer + "€");
			}
		}

	}

	/**
	 * Méthode abstrat à redéfinir dans toutes les classes filles car spécifique
	 * 
	 * @return le loyer des propriétés
	 */
	public abstract int calculerLoyer();

	public int getPrixAchat() {
		return prixAchat;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	@Override
	public void initProprietaire(Joueur jo) {
		if (jo.equals(proprietaire)) {
			proprietaire = null;
			System.out.println(jo.getPion() + " rend à la banque " + getNom());
		}
	}

}
