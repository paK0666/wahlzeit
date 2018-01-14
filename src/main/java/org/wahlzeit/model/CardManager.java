package org.wahlzeit.model;

import java.util.HashMap;
import org.wahlzeit.services.ObjectManager;

public class CardManager extends ObjectManager {

	private static HashMap<String, Card> cards = new HashMap<String, Card>();
	private static final CardManager instance = new CardManager();
	
	
	public static CardManager getInstance() {
		return instance;
	}
	
	public static Card createCard(String cardName) {
		if (cardName == null || cardName.length() == 0)
			throw new IllegalArgumentException();
		
		if (cards.containsKey(cardName)) {
			return cards.get(cardName);
		}
		
		CardType ct = new CardType(cardName);
		Card res = ct.createInstance();
		cards.put(cardName, res);
		return res;
	}
	
}
