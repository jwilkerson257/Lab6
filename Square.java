
public class Square extends Rectangle
{

	public Square(String id, double size)
	{
		/* The square constructor uses the rectangle constructor by making the two different sides 
		 * the same length and uses the methods of the rectangle class instead of overriding them 
		 */
		super(id, size, size);
	}
	
	@Override
	public String getShapeType()
	{
		return "Square";
	}
}
