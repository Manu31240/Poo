package com.valtech.monopoly.modele.cases;

import com.valtech.monopoly.metiers.exception.JeSuisFaucheException;
import com.valtech.monopoly.modele.Joueur;

public final class CaseTaxeDeLuxe extends Case {
	private final int TAXE = 75;

	public CaseTaxeDeLuxe(String nom) {
		super(nom);
	}

	@Override
	public void arreterSur(Joueur joueur) throws JeSuisFaucheException {
		joueur.debiter(TAXE);
		System.out.println(joueur.getPion() + " atterrit sur " + getNom()
				+ " et paie 75€");
	}
}
