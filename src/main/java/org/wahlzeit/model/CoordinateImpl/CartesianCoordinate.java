package org.wahlzeit.model.CoordinateImpl;

import org.wahlzeit.model.Coordinate;

public class CartesianCoordinate extends AbstractCoordinate{
	private final double x;
	private final double y;
	private final double z;
	
	public CartesianCoordinate(double x, double y, double z)	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		if (c == null) {
			throw new IllegalArgumentException();
		}

		CartesianCoordinate other = c.asCartesianCoordinate();
		double xDiff = this.x - other.x;
		double yDiff = this.y - other.y;
		double zDiff = this.z - other.z;
			
		double retDistance =  Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
		assert(retDistance >= 0.0);
		return retDistance;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x * x + y * y + z * z);
		return new SphericCoordinate(Math.acos(Math.toRadians(radius / z)), Math.atan(Math.toRadians(y / x)), radius);
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		
		double cDistance = getCartesianDistance(c);
		double centralAngle = 2 * Math.asin(Math.toRadians(cDistance / 2));
		double retDistance =  this.asSphericCoordinate().getRadius() * centralAngle;
		assert(retDistance >= 0.0);
		return retDistance;
	}	
	
	void assertClassInvariants() {
		//no check, as the class can not be in an invalid state
	}
}
