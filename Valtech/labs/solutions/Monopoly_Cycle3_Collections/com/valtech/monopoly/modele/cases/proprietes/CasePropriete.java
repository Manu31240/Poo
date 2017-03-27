package com.valtech.monopoly.modele.cases.proprietes;

import com.valtech.monopoly.modele.De;
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
	public void arreterSur(Joueur joueur, De d1, De d2) {
		super.arreterSur(joueur, d1, d2);
		// Il n'y a pas de proprietaire
		if (proprietaire == null) {
			// Le joueur a assez d'argent
			if (joueur.getSolde() >= prixAchat) {
				// Devient le proprietaire
				joueur.debiter(prixAchat);
				proprietaire = joueur;
				System.out.println(joueur.getPion() + " achète " + getNom()
						+ " pour " + prixAchat + "€");
			}
		} else {
			// Il y a un proprietaire et ce n'est pas le joueur
			if (!proprietaire.equals(joueur)) {
				// calcul du loyer
				int loyer = calculerLoyer(d1, d2);
				joueur.debiter(loyer);
				proprietaire.crediter(loyer);
				System.out.println(joueur.getPion() + " paie à "
						+ proprietaire.getPion() + " un loyer de " + loyer
						+ "€");
			}
		}

	}

	/**
	 * Méthode abstrat à redéfinir dans toutes les classes filles car spécifique
	 * 
	 * @param d1
	 * @param d2
	 * @return le loyer des propriétés
	 */
	public abstract int calculerLoyer(De d1, De d2);

	public int getPrixAchat() {
		return prixAchat;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

}
