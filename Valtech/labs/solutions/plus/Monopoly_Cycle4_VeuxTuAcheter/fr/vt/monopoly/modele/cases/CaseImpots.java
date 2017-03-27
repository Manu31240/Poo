package fr.vt.monopoly.modele.cases;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.Joueur;

public final class CaseImpots extends Case {
	private final double PCT = 10d / 100d;
	private final int IMPOT = 200;

	public CaseImpots(String nom) {
		super(nom);
	}

	@Override
	public void arreterSur(Joueur joueur)  throws JeSuisFaucheException {
		double mnt = joueur.getSolde() * PCT;
		joueur.debiter(Math.max(IMPOT, mnt));
		System.out.println(joueur.getPion() + " atterrit sur " + getNom()
				+ " et paie " + mnt + "€");
	}
}
