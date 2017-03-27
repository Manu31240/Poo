package fr.vt.monopoly.modele;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.cases.Case;
import fr.vt.monopoly.modele.utils.Gobelet;

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

	public void aTonTour() throws JeSuisFaucheException {
		Gobelet.getInstance().lancer();
		int deplace = Gobelet.getInstance().getValeurFace();
		/**
		 * Modification du déplacement du joueur pour prendre en considération
		 * les notions de passerPar et arreterSur
		 */
		System.out.println(pion + " a fait "
				+ (Gobelet.getInstance().getValeurFace()));

		for (int i = 0; i < deplace - 1; i++) {
			position = position.getSuivante();
			position.passerPar(this);
		}
		position = position.getSuivante();
		/**
		 * Modification pour prendre en considération le calcul du loyer de
		 * CaseCompagnie
		 */
		position.arreterSur(this);

		System.out.println(pion + " a un solde de " + solde + "€");

		/**
		 * Gérer les doubles directement dans joueur pour le moment
		 */
		if (((Gobelet) Gobelet.getInstance()).isDouble()) {
			int faceDouble = Gobelet.getInstance().getValeurFace() / 2;
			System.out.println(pion + " a fait un double (" + faceDouble + "/"
					+ faceDouble + ") - il rejoue !!");
			aTonTour();
		}
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

	public void debiter(double mnt) throws JeSuisFaucheException {
		solde -= mnt;
		if (solde < 0)
			throw new JeSuisFaucheException();
	}

}
