package com.valtech.jeudedes.modele;
public class De {
	/*
	 * Deux attributs pour la classe De 
	 * face -> la face du d� 
	 * MAX_LANCER -> constante pr�cisant le nombre de face maximum du d�
	 */
	private int face;
	private final int MAX_LANCER = 6;

	public De() {
		lancer();
	}

	/**
	 * @param valeur
	 *            -> face par d�faut du d�
	 */
	public De(int face) {
		this.face = face;
	}

	/**
	 * @author anne-lise.dubas
	 * @category comportement du lancer d'un d� � 6 faces
	 */
	public void lancer() {
		face = (int) (Math.random() * MAX_LANCER + 1);
	}

	// Accesseur de l'attribut valeurFace
	public int getFace() {
		return face;
	}

	protected void setFace(int valeurFace) {
		this.face = valeurFace;
	}

}
