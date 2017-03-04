class Client {
	private String nom;
	private String ville;
	private Compte c1;
	private Compte c2;
	private boolean masculin;

	public Client(String nomClient, String villeClient, double taux1, double soldeEpargne, double taux2,
			double soldePrive, boolean masculin) {
		nom = nomClient;
		ville = villeClient;
		this.masculin = masculin;
		c1 = new Compte(taux1, soldeEpargne);
		c2 = new Compte(taux2, soldePrive);

	}

	public void afficher() {
		if (masculin) {
			System.out.print(" Client ");
		} else {
			System.out.print(" Cliente ");
		}
		System.out.println(nom + " de " + ville);
		System.out.println("   Compte prive :     " + c1.getSolde());
		System.out.println("   Compte d epargne : " + c2.getSolde());
	}

	public void boucler() {
		c1.boucler();
		c2.boucler();
	}

}

class Compte {
	private double solde;
	private double taux;

	public Compte(double taux, double solde) {
		this.taux = taux;
		this.solde = solde;
	}

	//getter solde
	public double getSolde() {
		return solde;
	}

	public void boucler() {
		double interets = taux * solde;
		solde = solde + interets;
	}
}

class Banque {
	public static void main(String[] args) {
		double taux1 = 0.01;
		double taux2 = 0.02;
		System.out.println("Donnees avant le bouclement des comptes:");
		Client c1 = new Client("Pedro", "Geneve", taux1, 1000.0, taux2, 2000.0, true);
		Client c2 = new Client("Alexandra", "Lausanne", taux1, 3000.0, taux2, 4000.0, false);
		c1.afficher();
		c2.afficher();
		System.out.println("Donnees apres le bouclement des comptes:");
		c1.boucler();
		c2.boucler();
		c1.afficher();
		c2.afficher();

	}
}
