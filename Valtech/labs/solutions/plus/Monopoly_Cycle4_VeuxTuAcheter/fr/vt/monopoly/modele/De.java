package fr.vt.monopoly.modele;

import fr.vt.monopoly.metiers.Lancable;

public final class De implements Lancable{
	// Attribut
	private int valeurFace;
	private final int MAX_LANCER = 6;

	// Constructeurs
	public De() {
		this.lancer();
	}

	public De(int valeurFace) {
		this.valeurFace = valeurFace;
	}

	/**
	 * @return la valeur de la face du d�
	 */
	public int getValeurFace() {
		return valeurFace;
	}

	/**
	 * Effectue un tirage all�atoire entre 1 et 6 et affecte cette valeur �
	 * l'attribut valeurFace
	 */
	public void lancer() {
		valeurFace = (int) (Math.random() * MAX_LANCER) + 1;
	}
}
