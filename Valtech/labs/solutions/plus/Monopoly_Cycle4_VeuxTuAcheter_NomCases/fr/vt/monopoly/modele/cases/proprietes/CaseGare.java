package fr.vt.monopoly.modele.cases.proprietes;

public final class CaseGare extends CasePropriete {
	private final int LOYER = 25;

	public CaseGare(String nom, int prix) {
		super(nom, prix);
	}

	@Override
	public int calculerLoyer() {
		return LOYER;
	}
}
