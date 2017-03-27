package com.valtech.monopoly.modele.cases;

public class Plateau {
	private final int NB_CASES = 40;
	private final Case[] cases = new Case[NB_CASES];

	public Plateau() {
		// Initialisation du tableau de cases
		cases[0] = new Case("Départ");
		for (int i = 1; i < NB_CASES; i++) {
			cases[i] = new Case("Case" + i);
		}

		// Chainage des cases
		for (int i = 0; i < NB_CASES - 1; i++) {
			cases[i].setSuivante(cases[i + 1]);
		}
		cases[39].setSuivante(cases[0]);
	}

	public Case getCaseDepart() {
		return cases[0];
	}

}
