package fr.vt.monopoly.modele.utils;

import fr.vt.monopoly.metiers.Lancable;
import fr.vt.monopoly.modele.De;

/**
 * Int�gration du Design Pattern Singleton
 * 
 * Une unique instance de la classe
 */
public final class Gobelet implements Lancable {
	// attribut statique, partag� par toutes les instances
	private static Lancable instance;

	private Lancable de1, de2;

	// Constructeur priv�
	// --> emp�che de cr�er une instance depuis l'ext�rieur
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

	// Accesseur statique -- m�thode appartient � la classe
	public static Lancable getInstance() {
		// Test si l'instance existe
		if (instance == null) {
			// cr�er l'instance unique
			instance = new Gobelet();
		}
		return instance;
	}

}
