package fr.vt.monopoly.modele.cases;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.Joueur;

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
