public class De {
    private int face;

    public int getFace() {
        return face;
    }

//caste pour changer en int
    public void lancer() {
        face = (int) (Math.random() * 6) + 1;
    }

}

