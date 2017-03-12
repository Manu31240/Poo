class FiguresGeometriques {
    public static void main(String[] args) {

        RectangleColore r = new RectangleColore(4.3, 12.5, 4);
        System.out.println(r.getLargeur());

    }
}

class Rectangle {
    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

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
        largeur = l;
    }

    public void setLongueur(double l) {
        longueur = l;
    }
}

class Cercle {
    // abscisse du centre
    private double x;
    // ordonnée du centre
    private double y;
    private double rayon;

    public Cercle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        rayon = r;
    }

    public void affiche() {
        System.out.println("centre = (" + x + ", " + y + ")");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setCentre(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double surface() {
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double x, double y) {
        return (((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y)) <= rayon * rayon);
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double r) {
        if (r < 0.0)
            r = 0.0;
        rayon = r;
    }
}

class RectangleColore extends Rectangle {
    private int couleur;

    public RectangleColore(double larg, double longueur, int c) {
        super(larg, longueur);
        couleur = c;
    }
}
class Figure {
    private int x;
    private int y;
    public void affiche(){
        System.out.println(x, y);
    }
}
