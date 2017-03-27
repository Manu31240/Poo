package fr.vt.monopoly.main;

import fr.vt.monopoly.modele.JeuDeMonopoly;
import fr.vt.monopoly.modele.cases.Case;

public class Main {

	public static void main(String[] args) {
		System.out.println("Démarrage du jeu de Monopoly\n");

		JeuDeMonopoly jeu = new JeuDeMonopoly(8, 100);
		jeu.jouer();

		System.out.println("Le nombre d'instances de la classe Case est "
				+ Case.nbInstance);
	}

}
