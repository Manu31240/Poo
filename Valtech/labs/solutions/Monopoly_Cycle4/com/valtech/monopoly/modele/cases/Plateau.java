package com.valtech.monopoly.modele.cases;

import com.valtech.monopoly.modele.Joueur;
import com.valtech.monopoly.modele.cases.proprietes.CaseCompagnie;
import com.valtech.monopoly.modele.cases.proprietes.CaseGare;
import com.valtech.monopoly.modele.cases.proprietes.CaseLot;

public final class Plateau {
	private final int NB_CASES = 40;
	private final Case[] cases = new Case[NB_CASES];

	private final static int PRIX_ACHAT_LOT_MULT = 10;
	private final static int PRIX_ACHAT_LOT_MIN = 40;
	private final static int PRIX_ACHAT_GARE = 200;
	private final static int PRIX_ACHAT_COMPAGNIE = 150;

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
			case 5:
			case 15:
			case 25:
			case 35:
				cases[i] = new CaseGare("Gare" + i, PRIX_ACHAT_GARE);
				break;
			case 12:
			case 28:
				cases[i] = new CaseCompagnie("Compagnie" + i,
						PRIX_ACHAT_COMPAGNIE);
				break;
			case 1:
			case 3:
			case 6:
			case 8:
			case 9:
			case 11:
			case 13:
			case 14:
			case 16:
			case 18:
			case 19:
			case 21:
			case 23:
			case 24:
			case 26:
			case 27:
			case 29:
			case 31:
			case 32:
			case 34:
			case 37:
			case 39:
				cases[i] = new CaseLot("Lot" + i, PRIX_ACHAT_LOT_MIN + (i + 1)
						* PRIX_ACHAT_LOT_MULT, i + 1);
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
	
	public void initProprietaire(Joueur jo) {
		for(Case c : cases){
			c.initProprietaire(jo);
		}
	}

}
