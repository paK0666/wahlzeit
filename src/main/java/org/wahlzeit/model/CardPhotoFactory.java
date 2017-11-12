package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class CardPhotoFactory extends PhotoFactory {
	private static final Logger log = Logger.getLogger(CardPhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static CardPhotoFactory instance = null;
	
	
	protected CardPhotoFactory() {
		
	}
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized CardPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting CardPhotoFactory").toString());
			setInstance(new CardPhotoFactory());
		}

		return instance;
	}
	
	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(CardPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize CardPhotoFactory twice");
		}

		instance = photoFactory;
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new CardPhoto();
	}
	
	/**
	 * Creates a new cardphoto with the specified id
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return new CardPhoto(id);
	}

}
