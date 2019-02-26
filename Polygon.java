import java.util.ArrayList;

/**
 * Abstract shape class to define a polygon.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public abstract class Polygon extends Shape
{
    /**
     * A list of the lengths of the sides of the polygons.
     */
    protected ArrayList<Double> sideLengths;

    /**
     * Initializes the sideLengths arraylist and sets the Shape's ID.
     *
     * @param id The created shape's name id.
     */
    public Polygon(String id)
    {
        super(id);
	// Initializes the sideLengths arrayList for classes that inherit the Polygon class
        sideLengths = new ArrayList<Double>();
    }

    /**
     * Calculates the perimeter of a polygon. That is, the sum of its side lengths.
     *
     * @return The perimeter of the polygon.
     */
    @Override
	public double getPerimeter()
    {
    	// TODO: complete this...
    	double perimeter = 0.0;
	//calculates the perimeter based on the type of polygon it is from the getShapeType method
    	if(this.getShapeType().equalsIgnoreCase("EquilateralTriangle"))
    	{
    		for(int k = 0; k < 3; k++)
    		{
    			perimeter += this.sideLengths.get(k);
    		}
    	}
    	if(this.getShapeType().equalsIgnoreCase("Trapezoid"))
    	{
    		for(int k = 0; k < 4; k++)
    		{
    			perimeter += this.sideLengths.get(k);
    		}
    	}
    	if(this.getShapeType().equalsIgnoreCase("Rectangle") || this.getShapeType().equalsIgnoreCase("Square"))
    	{
    		for(int k = 0; k < 2; k++)
    		{
    			perimeter += this.sideLengths.get(k) * 2;
    		}
    	}
    	return perimeter;
    }
}
