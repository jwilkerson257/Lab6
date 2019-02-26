
public class Rectangle extends Polygon
{
	private double height;
	private double width;
	
	public Rectangle(String id, double height, double width)
	{
		super(id);
		this.height = height;
		this.width = width;
		// Adds the length and width to the sideLengths ArrayList
		sideLengths.add(height);
		sideLengths.add(width);
	}

	@Override
	public double getArea()
	{
		// Calculates the Area of the rectangle
		return height * width;
	}

	@Override
	public String getShapeType()
	{
		return "Rectangle";
	}

}
