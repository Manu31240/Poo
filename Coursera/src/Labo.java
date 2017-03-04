class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private String couleur;
    private int age;
    private int esperanceVie;
    private boolean clonee;

    //constructeur par defaut
    public Souris() {
        age = 0;
        esperanceVie = ESPERANCE_VIE_DEFAUT;
        System.out.println("Une nouvelle souris ! ");
    }

    //constructeur 4 arguments
    public Souris(int poids, String couleur, int age, int esperanceVie) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = esperanceVie;
        System.out.println("Une nouvelle souris ! ");
    }

    //constructeur 3 arguments
    public Souris(int poids, String couleur, int age) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        System.out.println("Une nouvelle souris ! ");
    }

    //constructeur 2 arguments
    public Souris(int poids, String couleur) {
        this.poids = poids;
        this.couleur = couleur;

        System.out.println("Une nouvelle souris ! ");
    }

    //constructeur de copie
    public Souris(Souris cloneSouris) {
        this.poids = cloneSouris.poids;
        this.couleur = cloneSouris.couleur;
        this.age = age;
        this.esperanceVie = esperanceVie * 4 / 5;

    }

    public String toString() {
        return "Une souris " + couleur + ", " + clonee + ", de " + age + " mois et pesant " + poids + " grammes";
    }

    public void evolue() {
    }

}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
