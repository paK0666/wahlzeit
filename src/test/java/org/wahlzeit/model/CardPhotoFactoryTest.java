package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardPhotoFactoryTest {

	@Test
	public void initializeTest() {
		CardPhotoFactory.initialize();
		CardPhotoFactory i = CardPhotoFactory.getInstance();
		assertNotNull(i);
	}
	
	@Test
	public void autoInitializeTest() {
		CardPhotoFactory i = CardPhotoFactory.getInstance();
		assertNotNull(i);
	}

}
