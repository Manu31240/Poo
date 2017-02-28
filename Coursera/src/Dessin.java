class Exemple {
    public static void main (String[] args)
    {
        Rectangle rect1 = new Rectangle();
        rect1.setHauteur(3.0);
        rect1.setLargeur(4.0);

        System.out.println("Surface:" + rect1.surface());
    }
}
class Rectangle {
    private double largeur;  
    private double hauteur;
    public double surface(){
            return largeur * hauteur;
        }
    public double getHauteur() {
        return hauteur;
    }
    public double getLargeur(){
        return largeur;
    }
    public void setHauteur(double h){
        hauteur=h;
    }
    public void setLargeur(double l){
        largeur=l;
    }
}