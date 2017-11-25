package org.wahlzeit.model.CoordinateImpl;

import org.wahlzeit.model.Coordinate;

public class CartesianCoordinate extends AbstractCoordinate{
	private double x;
	private double y;
	private double z;
	
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
			return -1;
		}

		CartesianCoordinate other = c.asCartesianCoordinate();
		double xDiff = this.x - other.x;
		double yDiff = this.y - other.y;
		double zDiff = this.z - other.z;
			
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x * x + y * y + z * z);
		return new SphericCoordinate(Math.acos(Math.toRadians(radius / z)), Math.atan(Math.toRadians(y / x)), radius);
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		
		double cDistance = getCartesianDistance(c);
		double centralAngle = 2 * Math.asin(Math.toRadians(cDistance / 2));
		return this.asSphericCoordinate().getRadius() * centralAngle;
	}	
}
