package com.valtech.monopoly.modele.cases;

import com.valtech.monopoly.metiers.exception.JeSuisFaucheException;
import com.valtech.monopoly.modele.Joueur;

public class Case {

	private String nom;
	private Case suivante;

	public Case(String nom) {
		this.nom = nom;
	}

	/**
	 * Pour gérer le polymorphisme
	 * 
	 * @param joueur
	 * @throws JeSuisFaucheException
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

	public void initProprietaire(Joueur jo) {
	}

}
