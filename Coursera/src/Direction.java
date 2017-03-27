import java.util.Calendar;
import java.util.ArrayList;

/**
 * Classe principale
   */
class Direction {
    public static void main(String[] args) {
        Ecole epfl = new Ecole();
        epfl.add(new EtudiantRegulier("Gaston Peutimide", 2013, "SSC", 6.0));
        epfl.add(new EtudiantRegulier("Yvan Rattrapeur", 2011, "SSC", 2.5));
        epfl.add(new EtudiantEchange("Bjorn Borgue", 2012, "Informatique", "KTH"));
        epfl.add(new Enseignant("Mathieu Matheu", 1998, "LMEP", 10000, "Physique"));
        epfl.add(new Secretaire("Sophie Scribona", 2005, "LMT", 5000));
        epfl.afficherStatistiques();
        epfl.afficherEPFLiens();
    }

}

/**
 * La direction
 */

class Ecole {
    private ArrayList<EPFLien> gens;

    public Ecole() {
        gens = new ArrayList<EPFLien>();
    }

    public void add(EPFLien personne) {
        if (personne != null) {
            gens.add(personne);
        }
    }

    /**
     * Cette méthode affiche l'ancienneté moyenne des personnes fréquentant  l'école
     * et le nombre d'étudiants parmi eux
     */
    public void afficherStatistiques() {
        int anneeCourante = Calendar.getInstance().get(Calendar.YEAR);
        int nbAnneesTotal = 0;
        int nbEtudiants = 0;
        for (EPFLien epflien : gens) {
            nbAnneesTotal = nbAnneesTotal + (anneeCourante - epflien.getAnnee());
            if (epflien.estEtudiant()) {
                ++nbEtudiants;
            }
        }
        System.out.println("Parmi les " + gens.size() + " EPFLiens, " + nbEtudiants + " sont des etudiants.");
        double moyen = nbAnneesTotal;
        moyen /= gens.size();
        System.out.println("Ils sont ici depuis en moyenne " + moyen + " ans");
    }

    // Cette méthode affiche les caractéristiques des personnes fréquentant  l'école
    public void afficherEPFLiens() {
        System.out.println("Liste des EPFLiens: ");
        for (EPFLien epflien : gens)
            epflien.afficher();
    }
}

/**
  * Les personnes fréquentant l'EPFL
  */
class EPFLien {
    private String nom;
    private int annee;

    public EPFLien(String nom, int annee) {
        this.nom = nom;
        this.annee = annee;
    }

    //Cette méthode affiche les caractéristiques générales d'un EPFLien
    public void afficher() {
        System.out.println("   Nom : " + getNom());
        System.out.println("   Annee : " + getAnnee());
    }

    public String getNom() {
        return nom;
    }

    public int getAnnee() {
        return annee;
    }

    public boolean estEtudiant() {
        return false;
    }

}

/**
  * Les étudiants
  */
class Etudiant extends EPFLien {
    private String section;

    public Etudiant(String nom, int annee, String section) {
        super(nom, annee);
        this.section = section;
    }

    public void afficher() {
        super.afficher();
        System.out.println("   Section : " + getSection());
    }

    public String getSection() {
        return section;
    }

    public boolean estEtudiant() {
        return true;
    }

}

/**
  * Les étudiants régulier
  */
class EtudiantRegulier extends Etudiant {
    private double moyenne;

    public EtudiantRegulier(String nom, int annee, String section, double moyenne) {
        super(nom, annee, section);
        this.moyenne = moyenne;
    }

    public void afficher() {
        System.out.println("Etudiant regulier:");
        super.afficher();
        System.out.println("   Moyenne : " + moyenne);
    }
}

/**
  * Les étudiants  d'échange
  */
class EtudiantEchange extends Etudiant {
    private String uniOrigine;

    public EtudiantEchange(String nom, int annee, String section, String uniOrigine) {
        super(nom, annee, section);
        this.uniOrigine = uniOrigine;
    }

    public void afficher() {
        System.out.println("Etudiant d'echange:");
        super.afficher();
        System.out.println("   Uni d'origine : " + getUniOrigine());
    }

    public String getUniOrigine() {
        return uniOrigine;
    }
}

/**
  * Le personnel de l'EPFL
  */
class Personnel extends EPFLien {
    private String labo;
    private int salaire;

    public Personnel(String nom, int annee, String labo, int salaire) {
        super(nom, annee);
        this.labo = labo;
        this.salaire = salaire;
    }

    public void afficher() {
        super.afficher();
        System.out.println("   Laboratoire : " + getLabo());
        System.out.println("   Salaire : " + getSalaire());
    }

    public String getLabo() {
        return labo;
    }

    public int getSalaire() {
        return salaire;
    }
}

class Enseignant extends Personnel {
    private String section;

    public Enseignant(String nom, int annee, String labo, int salaire, String section) {
        super(nom, annee, labo, salaire);
        this.section = section;
    }

    public void afficher() {
        System.out.println("Enseignant:");
        super.afficher();
        System.out.println("   Section d'enseignement : " + getSection());
    }

    public String getSection() {
        return section;
    }
}

class Secretaire extends Personnel {
    public Secretaire(String nom, int annee, String labo, int salaire) {
        super(nom, annee, labo, salaire);
    }

    public void afficher() {
        System.out.println("Secretaire:");
        super.afficher();
    }
}
