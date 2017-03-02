class Rectangle {
    private double largeur;
    private double longueur;

    //Le constructeur
    public Rectangle(double uneLargeur, double uneLongueur) {
        // largeur et longueur sont les attributs de la classe
        largeur = uneLargeur;
        longueur = uneLongueur;
    }

    // La methode pour le calcul de la surface
    public double surface() {
        return largeur * longueur;
    }

    public double getLongueur() {
        return longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double l) {
        if (l < 0) {
            l = -l;
        }
        largeur = l;
    }

    public void setLongueur(double l) {
        if (l < 0) {
            l = -l;
        }
        longueur = l;
    }
}

class ManipRectangle {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(1.5, 12.8);
        System.out.println("Surface : " + rect.surface());
        rect.setLargeur(3.2);
        rect.setLongueur(6.9);
        System.out.println("Surface : " + rect.surface());
    }
}