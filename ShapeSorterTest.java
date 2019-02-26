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

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.sortShapes();
		
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(0), b);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(1), d);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(3), a);
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 4, 3);
		Shape b = new Rectangle("test2", 5,7);
		Shape c = new Square("test3", 3);
		Shape d = new Square("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.sortShapes(new ShapeAreaComparator());
		
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(0), d);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(1), c);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(2), a);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(3), b);
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 4, 3); //14
		Shape b = new Rectangle("test2", 5,7); //24
		Shape c = new Square("test3", 3);      //12
		Shape d = new Square("test4", 1.5);    //6

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.sortShapes(new ShapePerimeterComparator());
		
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(0), d);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(1), c);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(2), a);
		Assert.assertEquals("Shapes ordered incorrectly...", sorter.shapes.get(3), b);
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
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.sortShapes();
		
		for(int k = 0; k < sorter.shapes.size(); k++)
		{
			strg += sorter.shapes.get(k).toString();
		}
		
		Assert.assertEquals("ShapeSorter toString is incorrect.", strg, sorter.toString());
	}
}
