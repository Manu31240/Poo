package fr.vt.monopoly.modele.cases.proprietes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.Joueur;
import fr.vt.monopoly.modele.cases.Case;

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
				if (willYouBuy()) {
					// Devient le proprietaire
					joueur.debiter(prixAchat);
					proprietaire = joueur;
					System.out.println(joueur.getPion() + " achète " + getNom()
							+ " pour " + prixAchat + "€");
				}
			}
		} else {
			// Il y a un proprietaire et ce n'est pas le joueur
			if (!proprietaire.equals(joueur)) {
				// calcul du loyer
				int loyer = calculerLoyer();
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
	 * Plus besoin de paramètre pour le calcul du loyer de la classe
	 * CaseCompagnie
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

	/**
	 * Pour gérer le polymorphisme Permet de réinitialiser le proprietaire quand
	 * le joueur j à perdu
	 * 
	 * @param j
	 */
	@Override
	public void initProprietaire(Joueur j) {
		if (j.equals(proprietaire))
			proprietaire = null;
	}

	/**
	 * Veux tu acheter?
	 */
	private boolean willYouBuy() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("Voulez vous acheter " + getNom() + " pour "
					+ getPrixAchat() + "€ ?");

			String response = br.readLine();

			if (response.equalsIgnoreCase("o"))
				return true;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

}
