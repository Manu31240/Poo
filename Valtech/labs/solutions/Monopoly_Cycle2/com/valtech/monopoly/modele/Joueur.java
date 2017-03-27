package com.valtech.monopoly.modele;

import com.valtech.monopoly.modele.cases.Case;

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

	public void aTonTour(De d1, De d2) {
		d1.lancer();
		d2.lancer();
		int deplace = d1.getFace() + d2.getFace();
		/**
		 * Modification du déplacement du joueur pour prendre en considération
		 * les notions de passerPar et arreterSur
		 */
		System.out.println(pion + " a fait "
				+ (d1.getFace() + d2.getFace()));

		for (int i = 0; i < deplace - 1; i++) {
			position = position.getSuivante();
			position.passerPar(this);
		}
		position = position.getSuivante();
		position.arreterSur(this);

		System.out.println(pion + " a un solde de " + solde + "€");
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
