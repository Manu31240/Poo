import java.util.ArrayList;

/******************************************** */
class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici
    private String nom;
    private boolean prime;

    //constructeur
    public Auteur(String nom, boolean prime) {
        this.nom = nom;
        this.prime = prime;
    }

    //getter getNom
    public String getNom() {
        return this.nom;
    }

    //getter getPrix
    public boolean getPrix() {
        return this.prime;
    }

}

/*********************************************** */
class Oeuvre {
    // Completer la classe Oeuvre ici
    private String titre;
    private Auteur auteur;
    private String langue;

    //constructeur 3 references
    public Oeuvre(String titre, Auteur auteur, String langue) {
        this.titre = titre;
        this.auteur = auteur;
        this.langue = langue;

    }

    //constructeur 2 references
    public Oeuvre(String titre, Auteur auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.langue = "Francais";

    }

    //getter getTitre
    public String getTitre() {
        return titre;
    }

    //getter getAuteur
    public Auteur getAuteur() {
        return auteur;
    }

    //getter getLangue
    public String getLangue() {
        return langue;
    }

    // methode afficher
    public void afficher() {
        System.out.println(this.titre + ", " + this.auteur.getNom() + ", en " + this.langue);
    }

}

// completer les autres classes ici
/********************************* */
class Exemplaire {
    private Oeuvre oeuvre;

    //constructeur
    public Exemplaire(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
        System.out.println("Nouvel exemplaire -> " + this.oeuvre.getTitre() + ", " + this.oeuvre.getAuteur().getNom() + ", en "
                + this.oeuvre.getLangue());
    }

    //constructeur de copie
    public Exemplaire(Exemplaire autreExemplaire) {
        this.oeuvre = autreExemplaire.oeuvre;
        System.out.println("Copie d’un exemplaire de -> " + this.oeuvre.getTitre() + ", " + this.oeuvre.getAuteur().getNom()
                + ", en " + this.oeuvre.getLangue());
    }

    //getter getOeuvre
    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    // methode afficher
    public void afficher() {
        System.out.println("Un exemplaire de " + this.oeuvre.getTitre() + ", " + this.oeuvre.getAuteur().getNom() + ", en "
                + this.oeuvre.getLangue());
    }

}

/********************************* */
class Bibliotheque {
    private String nom;
    private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    //constructeur
    public Bibliotheque(String nom) {
        this.nom = nom;
        System.out.println("La bibliothèque " + this.nom + " est ouverte ! ");
    }

    //getter getNom
    public String getNom() {
        return this.nom;
    }

    //getter getNbExemplaires
    public int getNbExemplaires() {
        return this.exemplaires.size();

    }

    public void stocker(Oeuvre oeuvre, int n) {
        for (int i = 0; i < n; i++) {
            Exemplaire ex = new Exemplaire(oeuvre);
            this.exemplaires.add(ex);
        }

    }

    public void stocker(Oeuvre oeuvre) {
        this.stocker(oeuvre, 1);
    }

    public ArrayList<Exemplaire> listerExemplaires(String langue) {
        ArrayList<Exemplaire> exLang = new ArrayList<Exemplaire>();
        for (int i = 0; i < this.exemplaires.size(); i++) {
            Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
            String inLang = exIn.getOeuvre().getLangue();
            if (langue.equals(inLang)) {
                exLang.add(exIn);
            }
        }
        return exLang;
    }

    public ArrayList<Exemplaire> listerExemplaires() {
        return this.exemplaires;
    }

    public int compterExemplaires(Oeuvre oeuvre) {
        int num = 0;
        for (int i = 0; i < this.exemplaires.size(); i++) {
            Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
            Oeuvre bookIn = exIn.getOeuvre();
            if (bookIn.equals(oeuvre)) {
                num++;
            }
        }
        return num;
    }

    public void afficherAuteur(boolean stockee) {
        for (int i = 0; i < this.exemplaires.size(); i++) {
            Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
            boolean award = exIn.getOeuvre().getAuteur().getPrix();
            if (stockee == award) {
                System.out.println(exIn.getOeuvre().getAuteur().getNom());
            }
        }
    }

    public void afficherAuteur() {
        afficherAuteur(true);
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
