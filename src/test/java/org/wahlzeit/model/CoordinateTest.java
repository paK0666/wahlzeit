package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Coordinate;
import org.wahlzeit.model.CoordinateImpl.CartesianCoordinate;
import org.wahlzeit.model.CoordinateImpl.SphericCoordinate;

public class CoordinateTest {

	private CartesianCoordinate cNullCoord;
	private CartesianCoordinate cOneCoord;
	private CartesianCoordinate cTwoCoord;
	
	private SphericCoordinate sNullCoord;
	private SphericCoordinate sOneCoord;
	private SphericCoordinate sTwoCoord;
	
	@Before
	public void setUp() {
		this.cNullCoord = null;
		this.cOneCoord = new CartesianCoordinate(1, 1, 1);
		this.cTwoCoord = new CartesianCoordinate(3, 3, 3);
		this.sNullCoord = null;
		this.sOneCoord = new SphericCoordinate(1, 1, 1);
		this.sTwoCoord = new SphericCoordinate(3, 3, 3);
	}
	
	@Test
	public void equalsTest() {
		assertFalse(cOneCoord.isEqual(cNullCoord));
		assertFalse(cOneCoord.equals(cNullCoord));
		assertTrue(cOneCoord.isEqual(cOneCoord));
		assertTrue(cOneCoord.equals(cOneCoord));
		assertFalse(cOneCoord.isEqual(cTwoCoord));
		assertFalse(cOneCoord.equals(cTwoCoord));
		assertFalse(sOneCoord.isEqual(sNullCoord));
		assertFalse(sOneCoord.equals(sNullCoord));
		assertTrue(sOneCoord.isEqual(sOneCoord));
		assertTrue(sOneCoord.equals(sOneCoord));
		assertFalse(sOneCoord.isEqual(sTwoCoord));
		assertFalse(sOneCoord.equals(sTwoCoord));
	}

	@Test
	public void conversionTest() {
		assertTrue(cOneCoord.asCartesianCoordinate().isEqual(cOneCoord));
		assertTrue(sOneCoord.asSphericCoordinate().isEqual(sOneCoord));
		assertTrue(cOneCoord.asSphericCoordinate().isEqual(cOneCoord));
		assertTrue(cOneCoord.asSphericCoordinate().asCartesianCoordinate().isEqual(cOneCoord));
		assertTrue(sOneCoord.asCartesianCoordinate().isEqual(sOneCoord));
		assertTrue(sOneCoord.asCartesianCoordinate().asSphericCoordinate().isEqual(sOneCoord));	
	}
	
	@Test
	public void distanceTest() {
		assertTrue(cOneCoord.getDistance(cNullCoord) == -1);
		assertEquals(cOneCoord.getDistance(cTwoCoord),  3.46, 0.01);
		assertTrue(sOneCoord.getDistance(sNullCoord) == -1);
		assertEquals(sOneCoord.getDistance(sTwoCoord),  3.67, 0.01);
	}
	
}
