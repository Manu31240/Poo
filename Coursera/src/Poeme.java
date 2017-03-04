class Fleur {
    private String fl1;
    private String fl2;

    public Fleur(String fleur1, String fleur2) {
        fl1 = fleur1;
        fl2 = fleur2;
        System.out.println(fl1 + " fraichement cueillie");
        System.out.printf("Fragile corolle taillee ");

    }

    public Fleur(Fleur autrefleur) {
        fl2 = autrefleur.fl2;

    }

    public void eclore() {
        System.out.println("veine de " + fl2);
    };

    public String toString() {
        return "qu'un simple souffle";
    }
}

class Poeme {
    public static void main(String[] args) {
        Fleur f1 = new Fleur("Violette", "bleu");
        Fleur f2 = new Fleur(f1);
        System.out.print("dans un cristal ");
        f2.eclore();
        System.out.print("ne laissant plus ");
        System.out.println(f1);
        System.out.println(f2);
    }
}