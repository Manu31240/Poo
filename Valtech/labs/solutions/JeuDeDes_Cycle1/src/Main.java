public class Main {
	// "main" est le point de d�part d�ex�cution dans un programme Java
	public static void main(String[] args) {
		// cr�ation d�un objet De
		De de1 = new De();
		// boucle 10 fois
		for (int i = 0; i < 10; i++) {
			// envoi du message �lancer�
			de1.lancer();
			int valeur = de1.getFace();
			// impression sur la console
			System.out.println("La face du d� est : " + valeur);
		}
	}
}
