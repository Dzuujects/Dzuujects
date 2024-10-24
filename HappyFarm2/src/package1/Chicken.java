package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Chicken extends JComponent implements Animal
{
	private int chickenx;
    private int chickeny;
    private int marginRight;
    private int marginLeft;
    private int marginTop;
    private int marginBottom;
    private boolean isDragging;
    
    public Chicken(int x, int y)
    {
    	this.chickenx = x;
        this.chickeny = y;
        this.marginTop = chickeny - 15;
        this.marginRight = chickenx + 75;
        this.marginLeft = chickenx;
        this.marginBottom = chickeny + 45;
    }
    
	public void draw(Graphics g)
	{
		Rectangle chickbody = new Rectangle(chickenx,chickeny,45,30);
        Rectangle chicklegs = new Rectangle(chickenx+10,chickeny+30,10,15);
        Rectangle chickfoot = new Rectangle(chickenx+20,chickeny+40,7,5);
        Rectangle chickhead = new Rectangle(chickenx+45,chickeny-10,20,25);
        Rectangle chickbeak = new Rectangle(chickenx+65,chickeny,10,5);
        Rectangle chickhair = new Rectangle(chickenx+51,chickeny-15,10,5);
        Ellipse2D.Double chickeyes = new Ellipse2D.Double(chickenx+56,chickeny-5,3,3);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.draw(chickbody);
        g2.setColor(Color.white);
        g2.fill(chickbody);

        g2.setColor(Color.yellow);
        g2.draw(chicklegs);
        g2.fill(chicklegs);


        g2.draw(chickfoot);
        g2.fill(chickfoot);
        g2.setColor(Color.black);
        g2.setColor(Color.white);
        g2.draw(chickhead);
        g2.fill(chickhead);

        g2.setColor(Color.black);
        g2.draw(chickeyes);
        g2.fill(chickeyes);
        
        g2.setColor(Color.orange);
        g2.draw(chickbeak);
        g2.fill(chickbeak);

        g2.setColor(Color.red);
        g2.draw(chickhair);
        g2.fill(chickhair);
	}

	int x = 1;
	int y = 1;
	@Override
	public void move()
	{
		if(chickenx < 0)
		{
			x = 1;
		}
		
		else if(chickenx > 1000)
		{
			x = -1;
		}
		
		if(chickeny < 0)
		{
			y = 1;
		}
		
		else if(chickeny > 800)
		{
			y = -1;
		}
		
		chickenx = chickenx + x;
		chickeny = chickeny + y;
	}

	@Override
	public String identify()
	{
		return "Chicken";
	}

	@Override
	public void position(int x, int y)
	{
		this.chickenx = x;
		this.chickeny = y;
		marginTop = chickeny - 15;
		marginRight = chickenx + 75;
		marginLeft = chickenx;
		marginBottom = chickeny + 45;
	}

	@Override
	public boolean isDraggable(int x, int y)
	{
		int chickenWidth = 75;
		int chickenHeight = 45;
		int chickenLeft = chickenx;
		int chickenTop = chickeny;
		int chickenRight = chickenLeft + chickenWidth;
		int chickenBottom = chickenTop + chickenHeight;

		return (x >= chickenLeft && x <= chickenRight && y >= chickenTop && y <= chickenBottom);
	}
}