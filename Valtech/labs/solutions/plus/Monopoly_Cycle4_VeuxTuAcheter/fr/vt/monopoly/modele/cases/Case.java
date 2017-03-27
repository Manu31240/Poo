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
	 * Pour gérer le polymorphisme
	 * 
	 * @param joueur
	 * 
	 *            Plus besoin de paramètre pour le calcul du loyer de la classe
	 *            CaseCompagnie
	 */
	public void arreterSur(Joueur joueur) throws JeSuisFaucheException {
		System.out.println(joueur.getPion() + " atterrit sur " + getNom());
	}

	/**
	 * Pour gérer le polymorphisme
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
	 * Pour gérer le polymorphisme Permet de réinitialiser le proprietaire quand
	 * le joueur j à perdu
	 * 
	 * @param j
	 */
	public void initProprietaire(Joueur j) {

	}

}
