import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 4, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);
		Shape e = new Rectangle("test5", 12, 1);
		Shape f = new Rectangle("test6", 6, 2);
		Shape g = new Circle("test7", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.addShape(e);
		sorter.addShape(f);
		sorter.addShape(g);
		sorter.sortShapes();
		
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(0), b);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(1), d);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(2), g);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(3), c);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(4), a);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(5), f);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(6), e);
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();
		ShapeAreaComparator temp = new ShapeAreaComparator();
		Shape a = new Rectangle("test", 4, 3);
		Shape b = new Rectangle("test2", 5,7);
		Shape c = new Square("test3", 3);
		Shape d = new Square("test4", 1.5);
		Shape e = new Rectangle("test5", 1.5, 1.5);
		Shape f = new Trapezoid("test6", 5, 5, 7, 7);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.addShape(e);
		sorter.addShape(f);
		// Sorts the ArrayList using the method compare method in the ShapeAreaComparator class
		sorter.sortShapes(temp);
		
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(0), d);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(1), e);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(3), a);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(4), b);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(5), f);
		
		Assert.assertTrue("ShapeAreaComparator should find shapes equal", temp.equals(d, e));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", temp.equals(a, e));
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 4, 3);             // 14
		Shape b = new Rectangle("test2", 5,7);             // 24
		Shape c = new Square("test3", 3);                  // 12
		Shape d = new Square("test4", 1.5);                // 6
		Shape e = new Trapezoid("test5", 5, 5, 7, 7);      // 24
		Shape f = new Ellipse("test6", 8, 12);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.addShape(e);
		sorter.addShape(f);
		// Sorts the ArrayList using the method compare method in the ShapePerimeterComparator class
		sorter.sortShapes(new ShapePerimeterComparator());
		
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(0), d);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(1), c);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(2), a);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(3), b);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(4), e);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(5), f);
		
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal", new ShapePerimeterComparator().equals(b, e));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", new ShapePerimeterComparator().equals(a, e));
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();
		String strg = "";
		
		Shape a = new Rectangle("test1", 4, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);
		Shape e = new Ellipse("test5", 8, 12);
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.addShape(e);
		sorter.sortShapes();
		
		for(int k = 0; k < sorter.shapes.size(); k++)
		{
			strg += sorter.shapes.get(k).toString() + "\n";
		}
		
		Assert.assertEquals("ShapeSorter toString is incorrect.", strg, sorter.toString());
	}
}
