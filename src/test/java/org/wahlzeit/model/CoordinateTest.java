package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private Coordinate nullCoord;
	private Coordinate oneCoord;
	private Coordinate twoCoord;
	
	@Before
	public void setUp() {
		this.nullCoord = null;
		this.oneCoord = new Coordinate(1, 1, 1);
		this.twoCoord = new Coordinate(2, 2, 2);
	}
	
	@Test
	public void distanceTest() {
		assertTrue(oneCoord.getDistance(nullCoord) == -1);
		assertTrue(oneCoord.getDistance(twoCoord) >= 1.72);
		assertTrue(oneCoord.getDistance(twoCoord) <= 1.74);
	}
	
	@Test
	public void equalsTest() {
		assertFalse(oneCoord.isEqual(nullCoord));
		assertFalse(oneCoord.equals(nullCoord));
		assertTrue(oneCoord.isEqual(oneCoord));
		assertTrue(oneCoord.equals(oneCoord));
		assertFalse(oneCoord.isEqual(twoCoord));
		assertFalse(oneCoord.equals(twoCoord));
	}

}
