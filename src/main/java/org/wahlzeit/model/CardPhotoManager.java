package org.wahlzeit.model;

public class CardPhotoManager extends PhotoManager {
	
	public CardPhotoManager() {
		photoTagCollector = CardPhotoFactory.getInstance().createPhotoTagCollector();
	}

}
