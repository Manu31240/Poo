package com.valtech.monopoly.modele.cases.proprietes;

import com.valtech.monopoly.modele.De;

public final class CaseGare extends CasePropriete {
	private final int LOYER = 25;

	public CaseGare(String nom, int prix) {
		super(nom, prix);
	}

	@Override
	public int calculerLoyer(De d1, De d2) {
		return LOYER;
	}
}
