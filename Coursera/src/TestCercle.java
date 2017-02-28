/**
 * Cercle
 */
public class Cercle {

    private double rayon;
    private double x;
    private double y;
    public  void setCentre(double x, double y){
        this.x =x;
        this.y=y;
    }
    public void setRayon(double r){
        rayon = r;
    }
    public double surface(){
        return Math.PI*rayon*rayon;
    }
    public boolean estInterieur(double unx, double uny){
         return (((unX-x) * (unX-x) + (unY-y) * (unY-y))<= rayon * rayon);

    }
}
class TestCercle {
    public static void main (String[] args)
    {
        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle();
        Cercle c3 = new Cercle();
        c1.setCentre(3,4);
        c1.setRayon(2);
        System.out.println("Surface:" + c1.surface());
        System.out.println("estInterieur:" + c1.estInterieur(1,2);
        
    }
}
