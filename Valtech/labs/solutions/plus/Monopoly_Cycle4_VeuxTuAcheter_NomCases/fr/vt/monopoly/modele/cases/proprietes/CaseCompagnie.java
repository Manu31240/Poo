package fr.vt.monopoly.modele.cases.proprietes;

import fr.vt.monopoly.modele.utils.Gobelet;

public final class CaseCompagnie extends CasePropriete {
	private final int MULT = 4;

	public CaseCompagnie(String nom, int prix) {
		super(nom, prix);
	}

	@Override
	public int calculerLoyer() {
		return Gobelet.getInstance().getValeurFace() * MULT;
	}
}
