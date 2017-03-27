package com.valtech.monopoly.modele.cases;

public final class Plateau {
	private final int NB_CASES = 40;
	private final Case[] cases = new Case[NB_CASES];

	public Plateau() {
		// Initialisation du tableau de cases
		for (int i = 0; i < NB_CASES; i++) {
			switch (i) {
			case 0:
				cases[i] = new CaseDepart("Départ");
				break;
			case 4:
				cases[i] = new CaseImpots("Impôts");
				break;
			case 38:
				cases[i] = new CaseTaxeDeLuxe("Taxe de Luxe");
				break;
			default:
				cases[i] = new Case("Case" + i);
				break;
			}
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
