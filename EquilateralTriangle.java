/**
 * Lab 6
 *
 * Class representing an equilateral Triangle.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class EquilateralTriangle extends Polygon
{
    /**
     * Lenght of the sides of the equilateral triangle.
     */
    private double sideLength;

	/**
	 * Constructor for the equilateral triangle. Sets sideLength member variable and sets
	 * all side length in Polygon sidelengths array.
	 *
	 * @param sidelength The length of the triangle sides.
	 */
	public EquilateralTriangle(String id, double sideLength)
	{
		// TODO: complete this...
		super(id);
		this.sideLength = sideLength;
		// Adds the side length to the sideLengths array 3 times for 3 side of the triangle
		sideLengths.add(sideLength);
		sideLengths.add(sideLength);
		sideLengths.add(sideLength);
	}

	/**
	 * Gets the area of the triangle.
	 *
	 * @return The area of the triangle (b*h/2 = sidelength*sidelength*root(3)/4)
	 */
	@Override
	public double getArea()
	{
		// Calculates the area of the equilateral triangle
		return sideLength * sideLength * (Math.sqrt(3) / 4);
	}

	/**
	 * Gets the shape type of the triangle.
	 *
	 * @return The string "EquilateralTriangle"
	 */
	@Override
	public String getShapeType()
	{
		// TODO: complete this...
		return "EquilateralTriangle";
	}
}
