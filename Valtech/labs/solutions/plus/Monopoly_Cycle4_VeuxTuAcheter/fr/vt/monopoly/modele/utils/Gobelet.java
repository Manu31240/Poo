package fr.vt.monopoly.modele.utils;

import fr.vt.monopoly.metiers.Lancable;
import fr.vt.monopoly.modele.De;

/**
 * Intégration du Design Pattern Singleton
 * 
 * Une unique instance de la classe
 */
public final class Gobelet implements Lancable {
	// attribut statique, partagé par toutes les instances
	private static Lancable instance;

	private Lancable de1, de2;

	// Constructeur privé
	// --> empêche de créer une instance depuis l'extérieur
	private Gobelet() {
		de1 = new De();
		de2 = new De();
	}

	@Override
	public void lancer() {
		de1.lancer();
		de2.lancer();
	}

	@Override
	public int getValeurFace() {
		return de1.getValeurFace() + de2.getValeurFace();
	}

	public boolean isDouble() {
		return de1.getValeurFace() == de2.getValeurFace();
	}

	// Accesseur statique -- méthode appartient à la classe
	public static Lancable getInstance() {
		// Test si l'instance existe
		if (instance == null) {
			// créer l'instance unique
			instance = new Gobelet();
		}
		return instance;
	}

}
