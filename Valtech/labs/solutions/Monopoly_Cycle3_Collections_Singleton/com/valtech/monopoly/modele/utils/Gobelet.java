package com.valtech.monopoly.modele.utils;

import com.valtech.monopoly.modele.De;

/**
 * Int�gration du Design Pattern Singleton
 * 
 * Une unique instance de la classe
 */
public final class Gobelet {
	// attribut statique, partag� par toutes les instances
	private static Gobelet instance;

	private De d1, d2;

	// Constructeur priv�
	// --> emp�che de cr�er une instance depuis l'ext�rieur
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

	// Accesseur statique -- m�thode appartient � la classe
	public static Gobelet getInstance() {
		// Test si l'instance existe
		if (instance == null) {
			// cr�er l'instance unique
			instance = new Gobelet();
		}
		return instance;
	}

}
