


public class Main {
// "main" est le point de départ d’exécution dans un programme Java
public static void main( String[] args ) {
// création d’un objet De
De d1 = new De();
// boucle 10 fois
for ( int i = 0; i < 10; i++ ) {
// envoi du message “lancer”
d1.lancer();
int valeur = d1.getFace();
// impression sur la console
System.out.println( valeur ); }
} }

