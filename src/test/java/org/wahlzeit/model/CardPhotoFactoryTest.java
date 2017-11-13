package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardPhotoFactoryTest {

	@Test
	public void initializeTest() {
		try {
			CardPhotoFactory.initialize();
		} catch (IllegalStateException ex) {
			//already initialized
		}
		
		PhotoFactory i = CardPhotoFactory.getInstance();
		PhotoFactory i2 = PhotoFactory.getInstance();
		assertTrue(i == i2);
	}
	

}
