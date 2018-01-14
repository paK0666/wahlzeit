package org.wahlzeit.model;

public class Card {

	private CardType type;
	
	public Card(CardType ct) {
		this.type = ct;
	}
	
	public CardType getType() {
		return type;
	}
}
