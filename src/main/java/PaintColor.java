import javafx.scene.paint.Color;


public class PaintColor extends Paint
{

	Color c;

	public PaintColor(Color c)
	{
		this.c = c;
	}



	@Override
	public Color getColor()
	{
		return c;
	}

}
