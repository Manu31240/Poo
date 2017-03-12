import java.util.Calendar;
import java.util.ArrayList;

/**
 * Classe principale
   */
class Direction 
{
    public static void main(String[] args) {
        Ecole epfl = new Ecole();
        epfl.add(new EtudiantRegulier("Gaston Peutimide", 2013, "SSC", 6.0));
        epfl.add(new EtudiantRegulier("Yvan Rattrapeur", 2011, "SSC", 2.5));
        epfl.add(new EtudiantEchange("Bjorn Borgue", 2012, "Informatique", "KTH"));
        epfl.add(new Enseignant("Mathieu Matheu", 1998, "LMEP", 10000, "Physique"));
        epfl.add(new  Secretaire("Sophie Scribona", 2005, "LMT", 5000));
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

    public void add(EPFLien personne)
        {
            if (personne != null)
            {
                gens.add(personne);
            }
        }
    
        /**
         * Cette méthode affiche l'ancienneté moyenne des personnes fréquentant  l'école
         * et le nombre d'étudiants parmi eux
         */
=======
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

    public Ecole(int nbPersonnes) {
        gens = new ArrayList<EPFLien>();
    }

    public void add(EPFLien personne) {
        if (personne != null) {
            gens.add(personne);
        }
    }

    /**
    * Cette méthode affiche l'ancienneté moyenne des personnes fréquentant l'école
    * et le nombre d'étudiants parmi eux
    */
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
    public void afficherStatistiques() {
        int anneeCourante = Calendar.getInstance().get(Calendar.YEAR);
        int nbAnneesTotal = 0;
        int nbEtudiants = 0;
        for (EPFLien epflien : gens) {
            nbAnneesTotal = nbAnneesTotal + (anneeCourante - epflien.getAnnee());
<<<<<<< HEAD
            if (epflien.estEtudiant()){
                ++nbEtudiants;
            }
        }
        System.out.println("Parmi les " + gens.size() + " EPFLiens, " +
                nbEtudiants + " sont des etudiants.");
=======
            if (epflien.estEtudiant()) {
                ++nbEtudiants;
            }
        }
        System.out.println("Parmi les " + gens.size() + " EPFLiens, " + nbEtudiants + " sont des etudiants.");
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
        double moyen = nbAnneesTotal;
        moyen /= gens.size();
        System.out.println("Ils sont ici depuis en moyenne " + moyen + " ans");
    }

<<<<<<< HEAD

    // Cette méthode affiche les caractéristiques des personnes fréquentant  l'école
=======
    // Cette méthode affiche les caractéristiques des personnes fréquentant l'école
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
    public void afficherEPFLiens() {
        System.out.println("Liste des EPFLiens: ");
        for (EPFLien epflien : gens)
            epflien.afficher();
    }
}

/**
<<<<<<< HEAD
  * Les personnes fréquentant l'EPFL
  */
=======
* Les personnes fréquentant l'EPFL
*/
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
class EPFLien {
    private String nom;
    private int annee;

    public EPFLien(String nom, int annee) {
        this.nom = nom;
        this.annee = annee;
    }
<<<<<<< HEAD
    
   //Cette méthode affiche les caractéristiques générales d'un EPFLien
    public void afficher() {
        System.out.println("   Nom : " + getNom());
        System.out.println("   Annee : " + getAnnee());
=======

    //Cette méthode affiche les caractéristiques générales d'un EPFLien
    public void afficher() {
        System.out.println(" Nom : " + getNom());
        System.out.println(" Annee : " + getAnnee());
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
    }

    public String getNom() {
        return nom;
    }

    public int getAnnee() {
        return annee;
    }
<<<<<<< HEAD
    public boolean estEtudiant ()
        {
            return false;
        }

}

/**
  * Les étudiants
  */
=======

    public boolean estEtudiant() {
        return false;
    }
}

/**
* Les étudiants
*/
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
class Etudiant extends EPFLien {
    private String section;

    public Etudiant(String nom, int annee, String section) {
        super(nom, annee);
        this.section = section;
    }

    public void afficher() {
        super.afficher();
<<<<<<< HEAD
        System.out.println("   Section : " + getSection());
=======
        System.out.println(" Section : " + getSection());
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
    }

    public String getSection() {
        return section;
    }

<<<<<<< HEAD
    public boolean estEtudiant()
        {
            return true;
        }
    
}

/**
  * Les étudiants régulier
  */
=======
    public boolean estEtudiant() {
        return true;
    }
}

/**
* Les étudiants régulier
*/
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
class EtudiantRegulier extends Etudiant {
    private double moyenne;

    public EtudiantRegulier(String nom, int annee, String section, double moyenne) {
        super(nom, annee, section);
        this.moyenne = moyenne;
    }

    public void afficher() {
        System.out.println("Etudiant regulier:");
        super.afficher();
<<<<<<< HEAD
        System.out.println("   Moyenne : " + moyenne);
=======
        System.out.println(" Moyenne : " + moyenne);
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
    }
}

/**
<<<<<<< HEAD
  * Les étudiants  d'échange
  */
=======
* Les étudiants d'échange
*/
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
class EtudiantEchange extends Etudiant {
    private String uniOrigine;

    public EtudiantEchange(String nom, int annee, String section, String uniOrigine) {
        super(nom, annee, section);
        this.uniOrigine = uniOrigine;
    }

    public void afficher() {
        System.out.println("Etudiant d'echange:");
        super.afficher();
<<<<<<< HEAD
        System.out.println("   Uni d'origine : " + getUniOrigine());
=======
        System.out.println(" Uni d'origine : " + getUniOrigine());
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
    }

    public String getUniOrigine() {
        return uniOrigine;
    }
}

/**
<<<<<<< HEAD
  * Le personnel de l'EPFL
  */
=======
* Le personnel de l'EPFL
*/
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
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
<<<<<<< HEAD
        System.out.println("   Laboratoire : " + getLabo());
        System.out.println("   Salaire : " + getSalaire());
=======
        System.out.println(" Laboratoire : " + getLabo());
        System.out.println(" Salaire : " + getSalaire());
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
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
<<<<<<< HEAD
        System.out.println("   Section d'enseignement : " + getSection());
=======
        System.out.println(" Section d'enseignement : " + getSection());
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 20267e1d7eb62a5d2cb5d793bea58cec3f97d9b9
