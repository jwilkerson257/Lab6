import org.junit.Assert;

import org.junit.Test;
/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
		Shape rec = new Rectangle("Rectangle1", 4.0, 2.0);
		Assert.assertEquals("Rectangle area incorrect.", 8.0, rec.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 12.0, rec.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rec.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
		double area = 5.0 * 5.0 * (Math.sqrt(3) / 4);
		Shape tri = new EquilateralTriangle("Triangle1", 5.0);
		Assert.assertEquals("Triangle area incorrect.", area, tri.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 15.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Triangle1", tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		// Calculates the area of a trapezoid in order to test the getArea method in the Trapezoid class
		double a = 10.0;
		double b = 6.0;
		double c = 5.0;
		double d = 4.0;
		double e = (a + b) / 2;
		double f = Math.pow(b - a, 2) + Math.pow(c, 2) - Math.pow(d, 2);
		double g = 2 * c * (b - a);
		double area = e * c * Math.sqrt(1 - Math.pow(f/g, 2));
		
		Shape trap = new Trapezoid("Trapezoid1", 5.0, 4.0, 6.0, 10.0);
		Assert.assertEquals("Trapezoid area incorrect.", area, trap.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 25.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trap.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trap.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
		double area = 36.0 * Math.PI;
		double perimeter = 12.0 * Math.PI;
		Shape cir = new Circle("Circle1", 6.0);
		Assert.assertEquals("Circle area incorrect.", area, cir.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", perimeter, cir.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", cir.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", cir.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape temp = new Rectangle("Rectangle5", 5.0, 7.0);
		String strg = String.format("%s\t ID = %s\t area = %.3f\t perimeter = %.3f\n", temp.getShapeType(), temp.getId(), temp.getArea(), temp.getPerimeter());
		Assert.assertEquals("Shape toString incorrect.", strg, temp.toString());
		
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		Shape sqr2 = new Square("S2", 5.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		
		// Test equal perimeter
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test unequal perimeter
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// TODO: complete this...
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		Shape rect2 = new Rectangle("R2", 1.0, 9.0);
		Shape sqr2 = new Square("S2", 5.0);
		
		// Test equal shapes
		Assert.assertEquals("compareTo should find shapes equal.", 0, rect.compareTo(sqr));
		
		// Test unequal shapes
		Assert.assertEquals("compareTo gave incorrect ordering.", 1, sqr2.compareTo(rect));
        Assert.assertEquals("compareTo gave incorrect ordering.", -1, rect.compareTo(sqr2));
        
        // Test unequal perimeter and area
        Assert.assertEquals("compareTo gave incorrect ordering.", 1, sqr2.compareTo(rect2));
        Assert.assertEquals("compareTo gave incorrect ordering.", -1, rect2.compareTo(sqr2));
    }
}
