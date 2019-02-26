
public class Rectangle extends Polygon
{
	private double height;
	private double width;
	
	public Rectangle(String id, double height, double width)
	{
		super(id);
	}

	@Override
	public double getArea()
	{
		return height * width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}
	
	@Override
	public String getShapeType()
	{
		return "Rectangle";
	}

}
