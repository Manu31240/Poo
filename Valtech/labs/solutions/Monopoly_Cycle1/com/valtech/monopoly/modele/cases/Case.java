package com.valtech.monopoly.modele.cases;

public class Case {

	private String nom;
	private Case suivante;

	public Case(String nom) {
		this.nom = nom;
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
