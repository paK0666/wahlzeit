package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CardPhoto extends Photo {

	public CardPhoto() {
		id = PhotoId.getNextId();
		if (id == null || id.isNullId() || id.asInt() < 1)
			throw new IllegalStateException("No more PhotoIds available");
		incWriteCount();
	}

	/**
	 * @methodtype constructor
	 */
	public CardPhoto(PhotoId myId) {
		if (myId == null || myId.isNullId() || id.asInt() < 1)
			throw new IllegalArgumentException();
		id = myId;
		incWriteCount();
	}

}
