package org.wahlzeit.model;

public class Coordinate {
	public double x;
	public double y;
	public double z;
	
	public Coordinate(double x, double y, double z)	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getDistance(Coordinate other) {
		if (other == null) {
			return -1;
		}
		
		double xDiff = this.x - other.x;
		double yDiff = this.y - other.y;
		double zDiff = this.z - other.z;
		
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
	}
	
	public boolean isEqual(Coordinate other) {
		if(other == null) {
			return false;
		}
		
		return this.getDistance(other) == 0.0;
	}
	
	public boolean equals(Coordinate other) {
		return this.isEqual(other);
	}
}
