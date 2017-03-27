package fr.vt.monopoly.modele.cases.proprietes;

public final class CaseLot extends CasePropriete {
	private int position;
	private final int LOYER_FIXE = 100;

	public CaseLot(String nom, int prix, int position) {
		super(nom, prix);
		this.position = position;
	}

	@Override
	public int calculerLoyer() {
		return position * LOYER_FIXE;
	}
}
