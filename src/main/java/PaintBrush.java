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
	
	
	private void recFill(int x, int y, Paint[][] mesh,Paint ogColor)
	{
		if(x<0||y<0||x>=mesh.length||y>=mesh[0].length)
		{
			return;
		}
		if(mesh[x][y].equals(ogColor))
		{
			mesh[x][y]=getPaint();
		recFill(x+1,y,mesh,ogColor);
		recFill(x-1,y,mesh,ogColor);
		recFill(x,y+1,mesh,ogColor);
		recFill(x,y-1,mesh,ogColor);
		}
	}
	
	private void patFill(int x, int y, Paint[][] mesh,Paint ogColor)
	{
		if(x<0||y<0||x>=mesh.length||y>=mesh[0].length)
		{
			return;
		}
		if(mesh[x][y].equals(ogColor))
		{
			if(x%2==0)
			{
				mesh[x][y]=Gold;
			}
			else
			{
				mesh[x][y]=White;
			}
			patFill(x+1,y,mesh,ogColor);
			patFill(x-1,y,mesh,ogColor);
			patFill(x,y+1,mesh,ogColor);
			patFill(x,y-1,mesh,ogColor);
		}
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
			Paint og = mesh[x][y];
			recFill(x,y,mesh,og);
		}
		if(this.mode == BrushMode.pattern1Mode)
		{
			Paint og = mesh[x][y];
			patFill(x,y,mesh,og);
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
