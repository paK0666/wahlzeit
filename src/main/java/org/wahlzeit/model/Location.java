package org.wahlzeit.model;

public class Location {
	public Coordinate coordinate;
	
	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public boolean equals(Location other) {
		return this.coordinate.isEqual(other.coordinate);
	}
}
