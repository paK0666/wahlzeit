package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class CardType extends DataObject{
	
	private String name;
	private CardType superType = null;
	private Set<CardType> subTypes = new HashSet<CardType>();
	
	private void setSuperType(CardType ct) {
		superType = ct;
	}
	
	public CardType(String cardName) {
		if (cardName == null || cardName.length() == 0)
			throw new IllegalArgumentException();
		
		this.name = cardName;
	}
	
	public Card createInstance() {
		return new Card(this);
	}
	
	public CardType getSuperType() {
		return superType;
	}
	
	public Iterator<CardType> getSubTypeIterator() {
		return subTypes.iterator();
	}
	
	public void addSubType(CardType ct) {
		if (ct == null)
			throw new IllegalArgumentException();
		
		ct.setSuperType(this);
		subTypes.add(ct);
	}
}
