package com.valtech.monopoly.modele.utils;

import com.valtech.monopoly.modele.De;

/**
 * Intégration du Design Pattern Singleton
 * 
 * Une unique instance de la classe
 */
public final class Gobelet {
	// attribut statique, partagé par toutes les instances
	private static Gobelet instance;

	private De d1, d2;

	// Constructeur privé
	// --> empêche de créer une instance depuis l'extérieur
	private Gobelet() {
		d1 = new De();
		d2 = new De();
	}

	public void lancer() {
		d1.lancer();
		d2.lancer();
	}

	public int getFace() {
		return d1.getFace() + d2.getFace();
	}

	public boolean isDouble() {
		return d1.getFace() == d2.getFace();
	}

	public int getDouble() {
		return d1.getFace();
	}

	// Accesseur statique -- méthode appartient à la classe
	public static Gobelet getInstance() {
		// Test si l'instance existe
		if (instance == null) {
			// créer l'instance unique
			instance = new Gobelet();
		}
		return instance;
	}

}
