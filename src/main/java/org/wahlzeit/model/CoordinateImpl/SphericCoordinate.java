package org.wahlzeit.model.CoordinateImpl;

import org.wahlzeit.model.Coordinate;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(
				radius * Math.sin(latitude) * Math.cos(longitude),
				radius * Math.sin(latitude) * Math.sin(longitude),
				radius * Math.cos(latitude));
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		if (c == null) {
			return -1;
		}
		
		return asCartesianCoordinate().getCartesianDistance(c);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		if (c == null) {
			return -1;
		}
		
		double cDistance = getCartesianDistance(c);
		double centralAngle = 2 * Math.asin(Math.toRadians(cDistance / 2));
		return this.radius * centralAngle;
	}
}
