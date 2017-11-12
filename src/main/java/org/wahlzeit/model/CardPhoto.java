package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CardPhoto extends Photo {

	public CardPhoto() {
		id = PhotoId.getNextId();
		incWriteCount();
	}

	/**
	 * @methodtype constructor
	 */
	public CardPhoto(PhotoId myId) {
		id = myId;
		incWriteCount();
	}

}
