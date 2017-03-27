package com.valtech.monopoly.modele;

import com.valtech.monopoly.modele.cases.Case;
import com.valtech.monopoly.modele.utils.Gobelet;

public final class Joueur {
	private final int SOLDE = 1500;

	// Attributs
	private final String pion;
	private Case position;
	/**
	 * ajout du solde du joueur
	 */
	private double solde;

	// Constructeur
	public Joueur(String pion, Case depart) {
		this.pion = pion;
		this.position = depart;
		solde = SOLDE;
	}

	public void aTonTour() {
		Gobelet.getInstance().lancer();
		int deplace = Gobelet.getInstance().getFace();
		/**
		 * Modification du déplacement du joueur pour prendre en considération
		 * les notions de passerPar et arreterSur
		 */
		System.out.println(pion + " a fait " + deplace);

		for (int i = 0; i < deplace - 1; i++) {
			position = position.getSuivante();
			position.passerPar(this);
		}
		position = position.getSuivante();
		position.arreterSur(this);

		System.out.println(pion + " a un solde de " + solde + "€");

		/**
		 * Gérer les doubles directement dans joueur pour le moment
		 */
		if (Gobelet.getInstance().isDouble()) {
			System.out.println(pion + " a fait un double (" + Gobelet.getInstance().getDouble() + "/"
					+ Gobelet.getInstance().getDouble() + ") - il rejoue !!");
			aTonTour();
		}
	}

	public String getPion() {
		return pion;
	}

	public Case getPosition() {
		return position;
	}

	public double getSolde() {
		return solde;
	}

	/**
	 * Permettre de créditer et débiter le solde du joueur
	 */
	public void crediter(double mnt) {
		solde += mnt;
	}

	public void debiter(double mnt) {
		solde -= mnt;
	}

}
