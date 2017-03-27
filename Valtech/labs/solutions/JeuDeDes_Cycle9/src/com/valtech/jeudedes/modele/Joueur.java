package com.valtech.jeudedes.modele;
public final class Joueur {
	private final String nom;
	private int score;
	private final int MIN_GAGNANT = 7;

	public Joueur(final String nom) {
		this.nom = nom;
		score = 0;
	}

	public void aTonTour(De d1, De d2) {
		d1.lancer();
		d2.lancer();
		if (d1.getFace() + d2.getFace() >= MIN_GAGNANT) {
			incrementerScore();
		}
	}

	private void incrementerScore() {
		score++;
	}

	public String getNom() {
		return nom;
	}

	public int getScore() {
		return score;
	}

}
