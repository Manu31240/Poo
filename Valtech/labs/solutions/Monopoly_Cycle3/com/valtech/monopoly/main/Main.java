package com.valtech.monopoly.main;

import com.valtech.monopoly.modele.Monopoly;

public class Main {

	public static void main(String[] args) {
		System.out.println("Démarrage du jeu de Monopoly\n");
		
		Monopoly jeu = new Monopoly(2, 20);
		jeu.jouer();
	}
	
}
