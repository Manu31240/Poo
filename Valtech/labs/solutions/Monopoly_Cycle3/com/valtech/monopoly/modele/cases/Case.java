package com.valtech.monopoly.modele.cases;

import com.valtech.monopoly.modele.De;
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
	 */
	public void arreterSur(Joueur joueur, De d1, De d2) {
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

}
