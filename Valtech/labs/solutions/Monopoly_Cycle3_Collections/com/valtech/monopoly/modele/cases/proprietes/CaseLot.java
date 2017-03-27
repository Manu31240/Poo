package com.valtech.monopoly.modele.cases.proprietes;

import com.valtech.monopoly.modele.De;

public final class CaseLot extends CasePropriete {
	private int position;
	private final int LOYER_FIXE = 100;

	public CaseLot(String nom, int prix, int position) {
		super(nom, prix);
		this.position = position;
	}

	@Override
	public int calculerLoyer(De d1, De d2) {
		return position * LOYER_FIXE;
	}
}
