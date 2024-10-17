import javafx.scene.paint.Color;


public class PaintBrush
{


	Paint paint;


	enum BrushMode{
		paintMode,
		fillMode,
		pattern1Mode,
		pattern2Mode
	}

	BrushMode mode;

	Paint Gold = new PaintColor(Color.GOLD);
	Paint White = new PaintColor(Color.WHITE);


/**
set the "paint" for the paintbrush
*/
	public void setPaint(Paint paint)
	{
		this.paint = paint;

	}


/*
   gets the present paint on the paint brush
*/
	public Paint getPaint()
	{
		return this.paint;
	}


   /*
   makes the paint on the paint brush a brigter shade.
   */
	public void setBrighter()
	{
		Paint B = new PaintBrighter(this.paint);
		paint = B;
	}


   /*
      makes the paint on the paintbrush a darker shade
   */
	public void setDarker()
	{
		Paint D = new PaintDarker(this.paint);
		paint = D;
	}
	
	public void recfill(int x, int y, Paint[][] mesh)
	{
		Paint ogColor = mesh[x][y];
		//TODO
		//check directions
		recFill(x,y,mesh,ogColor);
	}
	
	private void recFill(int x, int y, Paint[][] mesh,Paint ogColor)
	{
		if (mesh[x][y]==ogColor)
		{
			mesh[x][y]=this.paint;
		}
		//TODO check Directions
	}

   /*
      paints the mesh, using the current paint and mode at point x,y
   */
	public void paint(int x, int y, Paint[][] mesh)
	{
		if(this.mode == BrushMode.paintMode)
		{
		mesh[x][y] = this.paint;
		}
		if(this.mode == BrushMode.fillMode)
		{
			// recursive fill.
		}
		if(this.mode == BrushMode.pattern1Mode)
		{
			// recursive fill but pattern.
		}
		
	}



/*
   set the drawing mode of the paint brush.
*/
	public void pointMode()
	{
		mode= BrushMode.paintMode;
	}

	public void fillMode()
	{
		mode = BrushMode.fillMode;
	}

	public void pattern1Mode()
	{
		mode = BrushMode.pattern1Mode;
	}

	public void pattern2Mode()
	{
		mode = BrushMode.pattern2Mode;
	}

}
