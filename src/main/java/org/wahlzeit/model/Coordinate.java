package org.wahlzeit.model;

import org.wahlzeit.model.CoordinateImpl.CartesianCoordinate;
import org.wahlzeit.model.CoordinateImpl.SphericCoordinate;

public interface Coordinate {
	public CartesianCoordinate asCartesianCoordinate();
	public double getCartesianDistance(Coordinate c);
	public SphericCoordinate asSphericCoordinate();
	public double getSphericDistance(Coordinate c);
	public double getDistance(Coordinate c);
	public boolean isEqual(Coordinate c);
}
