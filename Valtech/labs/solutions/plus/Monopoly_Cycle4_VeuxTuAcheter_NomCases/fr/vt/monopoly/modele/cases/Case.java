package fr.vt.monopoly.modele.cases;

import fr.vt.monopoly.metiers.exception.JeSuisFaucheException;
import fr.vt.monopoly.modele.Joueur;

public class Case {

	/**
	 * pour compter les instances de Case
	 */
	public static int nbInstance = 0;

	private String nom;
	private Case suivante;

	public Case(String nom) {
		this.nom = nom;
		nbInstance++;
	}

	/**
	 * Pour g�rer le polymorphisme
	 * 
	 * @param joueur
	 * 
	 *            Plus besoin de param�tre pour le calcul du loyer de la classe
	 *            CaseCompagnie
	 */
	public void arreterSur(Joueur joueur) throws JeSuisFaucheException {
		System.out.println(joueur.getPion() + " atterrit sur " + getNom());
	}

	/**
	 * Pour g�rer le polymorphisme
	 * 
	 * @param joueur
	 */
	public void passerPar(Joueur joueur) {

	}

	public Case getSuivante() {
		return suivante;
	}

	public void setSuivante(Case suivante) {
		this.suivante = suivante;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Pour g�rer le polymorphisme Permet de r�initialiser le proprietaire quand
	 * le joueur j � perdu
	 * 
	 * @param j
	 */
	public void initProprietaire(Joueur j) {

	}

}
