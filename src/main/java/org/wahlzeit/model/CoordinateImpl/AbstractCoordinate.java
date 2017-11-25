package org.wahlzeit.model.CoordinateImpl;

import org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {
	
	public double getDistance(Coordinate c) {
		return getCartesianDistance(c);
	}

	public boolean isEqual(Coordinate c) {
		if (c == null) {
			return false;
		}
		
		return getDistance(c) < 2;
	}
	
	public boolean equals(Coordinate other) {
		return this.isEqual(other);
	}
}
