package com.valtech.monopoly.modele;

import com.valtech.monopoly.modele.cases.Case;

public class Joueur {

	// Attributs
	private final String pion;
	private Case position;

	// Constructeur
	public Joueur(String pion, Case depart) {
		this.pion = pion;
		this.position = depart;
	}

	public void aTonTour(De d1, De d2) {
		d1.lancer();
		d2.lancer();
		int deplace = d1.getFace() + d2.getFace();
		for (int i = 0; i < deplace; i++) {
			position = position.getSuivante();
		}
	}
	
	public String getPion() {
		return pion;
	}
	
	public Case getPosition() {
		return position;
	}

}
