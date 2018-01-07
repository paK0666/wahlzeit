package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/*
@PatternInstance(
	patternName = "Concrete Factory"
	participants = {"Abstract Factory", "Concrete Factory"}
	usage = "Instantiated concrete factory, based on the abstract factory, for creating the photo type
		specific to this wahlzeit instance"
)

@PatternInstance(
	patternName = "Singleton"
	participants = "Singleton"
	usage = "Instantiated concrete factory, only one can exist at any time"
)
*/
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
		CardPhotoFactory f = getInstance(); // drops result due to getInstance() side-effects
		PhotoFactory.setInstance(f);
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
