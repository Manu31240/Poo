package com.valtech.monopoly.modele.cases.proprietes;

import com.valtech.monopoly.modele.De;

public final class CaseCompagnie extends CasePropriete {
	private final int MULT = 4;

	public CaseCompagnie(String nom, int prix) {
		super(nom, prix);
	}

	@Override
	public int calculerLoyer(De d1, De d2) {
		return (d1.getFace() + d2.getFace()) * MULT;
	}
}
