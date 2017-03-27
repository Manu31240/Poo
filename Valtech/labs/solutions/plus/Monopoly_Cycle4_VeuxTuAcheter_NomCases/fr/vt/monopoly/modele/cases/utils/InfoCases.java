package fr.vt.monopoly.modele.cases.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public final class InfoCases {

	private String nom;
	private int indice;
	private int prixAchat;
	private int loyer;
	private String couleur;

	private static void readFile(String file) {
		configs = new HashMap<Integer, InfoCases>();
		try {
			// Read information from "Monopoly.txt"
			BufferedReader in = new BufferedReader(new FileReader(
					"Monopoly.txt"));

			String line = null;
			while ((line = in.readLine()) != null) {
				InfoCases conf = new InfoCases();
				conf.cut(line);
				configs.put(new Integer(conf.indice - 1), conf);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cut(String line) {
		String[] splits = line.split(";");
		nom = splits[0];
		indice = Integer.parseInt(splits[1]);
		prixAchat = Integer.parseInt(splits[2]);

		try {
			loyer = Integer.parseInt(splits[3]);
		} catch (Exception e) {
			loyer = 0;
		}
		
		couleur = splits[4];
	}

	private static Map<Integer, InfoCases> configs;

	public static Map<Integer, InfoCases> getConfigs() {
		if (configs == null) {
			System.out.println("Lecture du fichier Monopoly.tx");
			InfoCases.readFile("Monopoly.txt");
		}
		return configs;
	}

	public String getNom() {
		return nom;
	}

	public int getIndice() {
		return indice;
	}

	public int getPrixAchat() {
		return prixAchat;
	}

	public int getLoyer() {
		return loyer;
	}

	public String getCouleur() {
		return couleur;
	}

}
