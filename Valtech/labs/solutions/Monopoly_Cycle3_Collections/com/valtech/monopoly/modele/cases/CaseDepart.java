package com.valtech.monopoly.modele.cases;

import com.valtech.monopoly.modele.De;
import com.valtech.monopoly.modele.Joueur;

public final class CaseDepart extends Case {

	public CaseDepart(String nom) {
		super(nom);
	}

	@Override
	public void arreterSur(Joueur joueur, De d1, De d2) {
		joueur.crediter(400);
		System.out.println(joueur.getPion() + " atterrit sur " + getNom()
				+ " et reçoit 400€");
	}

	@Override
	public void passerPar(Joueur joueur) {
		joueur.crediter(200);
		System.out.println(joueur.getPion() + " passe par " + getNom()
				+ " et reçoit 200€");

	}
}
