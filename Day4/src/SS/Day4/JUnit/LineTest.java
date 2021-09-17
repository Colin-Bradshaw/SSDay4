package SS.Day4.JUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class LineTest {
	
	Line l1 = new Line(1.0, 1.0, 1.0, 1.0);
	
	// slope of 1
	Line l2 = new Line(1.0, 1.0, 3.0, 3.0);
	//slope of -1
	Line l3 = new Line(3.0, 3.0, 1.0, 1.0);
	
	// line parallel to l2
	Line l4 = new Line(2.0, 2.0, 3.0, 3.0);
	
	// perpendicular line to l2
	Line l5 = new Line(1.0, 3.0, 3.0, 1.0);

	protected void setUp() {
		//            X0   Y0   X1   Y1
		// line is a point
		l1 = new Line(1.0, 1.0, 1.0, 1.0);
		
		// slope of 1
		l2 = new Line(1.0, 1.0, 3.0, 3.0);
		
		// 2,3,4 triangle for testing distance
		l3 = new Line(1.0, 1.0, 3.0, 4.0);
		
		// line parallel to l2
		l4 = new Line(2.0, 2.0, 3.0, 3.0);
		
		// perpendicular line to l2
		l5 = new Line(1.0, 3.0, 3.0, 1.0);
	}
	
	@Test
	public void testGetSlope() {
		double slope = l2.getSlope();
		assertTrue(slope - 1 < 0.0001);
		
		// should throw  Arithmetic Exception, how do I assert that so the test is passed?
		// slope = l1.getSlope();
	}
	
	@Test
	public void testGetDistance() {
		double distance = l2.getDistance();
		assertTrue(distance - 4.0 < 0.0001);
	}
	
	@Test
	public void testParallellTo() {
		assertTrue(l2.parallelTo(l4));
		assertFalse(l2.parallelTo(l5));
	}


}
