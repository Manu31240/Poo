public class Main {
	// "main" est le point de d�part d�ex�cution dans un programme Java
	public static void main(String[] args) {
		Joueur j = new Joueur("Anne-Lise");
		for (int i = 0; i < 10; i++) {
			j.aTonTour();
			System.out.println(j.getNom() + " a un score de  " + j.getScore());
		}
	}
}
