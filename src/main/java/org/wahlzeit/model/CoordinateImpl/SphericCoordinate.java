package org.wahlzeit.model.CoordinateImpl;

import org.wahlzeit.model.Coordinate;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate(double latitude, double longitude, double radius) {
		if ((latitude < -90.0) || (latitude > 90.0) ||
				(longitude < -180.0) || (longitude > 180) ||
				(radius < 0.0)) {
			throw new IllegalArgumentException();
		}
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		assertClassInvariants();
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		return new CartesianCoordinate(
				radius * Math.sin(latitude) * Math.cos(longitude),
				radius * Math.sin(latitude) * Math.sin(longitude),
				radius * Math.cos(latitude));
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		
		assertClassInvariants();
		return asCartesianCoordinate().getCartesianDistance(c);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		
		double cDistance = getCartesianDistance(c);
		double centralAngle = 2 * Math.asin(Math.toRadians(cDistance / 2));
		assertClassInvariants();
		return this.radius * centralAngle;
	}
	
	void assertClassInvariants() {
		assert ((latitude >= -90.0) && (latitude <= 90.0));
		assert ((longitude >= -180.0) && (longitude <= 180.0));
		assert (radius >= 0.0);
	}
}
