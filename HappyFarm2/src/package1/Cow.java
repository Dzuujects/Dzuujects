package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Cow extends JComponent implements Animal
{
	int cowx;
    int cowy;
    //the most right x position of the drawing
    private int marginRight;
    //the most left x position of the drawing
    private int marginLeft;
    //the most high y position of the drawing
    private int marginTop;
    //the most low y position of the drawing
    private int marginBottom;
    private boolean isDragging;

    public Cow(int x,int y)
    {
    	this.cowx = x;
    	this.cowy = y;
    	//get these numbers from the cow drawing to see how much the edges are
    	this.marginTop = cowy + 5;
    	this.marginBottom = cowy + 55;
    	this.marginLeft = cowx + 5;
    	this.marginRight = cowx + 170;
    }
    
	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
        Graphics2D g1 = (Graphics2D) g;
        this.setBackground(Color.gray);
        
        //HEAD
        Rectangle CowHead = new Rectangle(cowx+10, cowy+10, 40, 40);
        Rectangle CowNose = new Rectangle(cowx+20, cowy+30, 20, 10);
        Rectangle CowNostril = new Rectangle(cowx+25, cowy+27, 10, 5);
        Rectangle LeftHorn = new Rectangle(cowx+5, cowy+5, 10, 15);
        Rectangle RightHorn = new Rectangle(cowx+45, cowy+5, 10, 15);
        Rectangle LeftEye = new Rectangle(cowx+15, cowy+20, 5, 5);
        Rectangle RightEyeBlack = new Rectangle(cowx+35, cowy+20, 5, 5);
        Rectangle LeftEyeBlack = new Rectangle(cowx+15, cowy+20, 10, 5);
        Rectangle RightEye = new Rectangle(cowx+35, cowy+20, 10, 5);
        //BODY
        Rectangle CowBody = new Rectangle(cowx+30, cowy+30, 140, 55);
        Rectangle CowLeg1 = new Rectangle(cowx+40, cowy+30, 15, 100);
        Rectangle CowLeg2 = new Rectangle(cowx+140, cowy+30, 15, 100);
        Rectangle CowLeg1B = new Rectangle(cowx+60, cowy+30, 15, 90);
        Rectangle CowLeg2B = new Rectangle(cowx+120, cowy+30, 15, 90);
        Arc2D.Double CowTail = new Arc2D.Double(cowx+100, cowy+45, 100, 100, 35, 90, Arc2D.OPEN);
        Ellipse2D.Double CowTailSolid = new Ellipse2D.Double(cowx+190, cowy+65, 20, 5);
        
        Arc2D.Double CowWhiteStuff = new Arc2D.Double(cowx+60, cowy+5, 50, 50, 180, 180, Arc2D.CHORD);
        Arc2D.Double CowWhiteStuffDown = new Arc2D.Double(cowx+90, cowy+60, 50, 50, -180, -180, Arc2D.CHORD);
        
        //SHADING BC OCD
        Rectangle CowLeg1Shade = new Rectangle(cowx+40, cowy+30, 15, 70);
        Rectangle CowLeg2Shade = new Rectangle(cowx+120, cowy+30, 15, 65);
        Rectangle CowLeg1BShade = new Rectangle(cowx+60, cowy+30, 15, 65);
        Rectangle CowLeg2BShade = new Rectangle(cowx+140, cowy+30, 15, 70);

Rectangle CowHeadShading = new Rectangle(cowx+30, cowy+30, 25, 25);
        
        //OUTLINES
        g2.setColor(Color.BLACK);
        
        //HEAD OUTLINES
        g2.draw(CowHead);
        g2.draw(CowNostril);
        g2.draw(CowNose);
        g2.draw(LeftHorn);
        g2.draw(RightHorn);
        g2.draw(LeftEye);
        g2.draw(RightEye);
        
        //BODY OUTLINES
        g2.draw(CowBody);
        g2.draw(CowLeg1);
        g2.draw(CowLeg2);
        g2.draw(CowLeg1B);
        g2.draw(CowLeg2B);
        g2.draw(CowTailSolid);
        g2.draw(CowWhiteStuff);
        g2.draw(CowWhiteStuffDown);
        g2.setColor(new Color(72, 60, 50));
        g2.draw(CowTail);
        
        
        //COLORS
        g2.setColor(new Color(72, 60, 50));
        g2.fill(CowLeg1);
        g2.fill(CowLeg2);
        g2.fill(CowLeg1B);
        g2.fill(CowLeg2B);
        
        g2.setColor(new Color(45, 37, 31));
        g2.fill(CowLeg2BShade);
        g2.fill(CowLeg1BShade);
        g2.fill(CowLeg1Shade);
        g2.fill(CowLeg2Shade);
        g2.fill(CowTailSolid);
        
        g2.setColor(new Color(72, 60, 50));
        g2.fill(CowBody);
       
        
        g2.setColor(new Color(45, 37, 31));
        g2.fill(CowHeadShading);
       
        g2.setColor(new Color(72, 60, 50));
        g2.fill(CowHead);
        
        g2.setColor(new Color(150, 121, 105));
        g2.fill(CowNose);
        
        g2.setColor(new Color(58, 58, 58));
        g2.fill(CowNostril);
        
        g2.setColor(new Color(157, 157, 157));
        g2.fill(CowWhiteStuff);
        g2.fill(CowWhiteStuffDown);
        
        g2.setColor(new Color(100, 100, 100));
        g2.fill(LeftHorn);
        g2.fill(RightHorn);
       

        g2.setColor(new Color(0, 0, 0));
        g2.fill(LeftEyeBlack);
        g2.fill(RightEyeBlack);
        
        g2.setColor(new Color(255, 255, 255));
      
        g2.fill(LeftEye);
        g2.fill(RightEye);
        
        g2.setColor(new Color(0, 0, 0));
        g2.fill(RightEyeBlack);
		
	}
//make sure u add these before the move method
	int x = 1;
	int y = 1;
	@Override
	public void move()
	{
		//just copy paste all of this changing the names of cowx an cowy to sheepx and sheepy
		if(cowx < 0)
		{
			x = 1;
		}
		
		else if(cowx > 1000)
		{
			x = -1;
		}
		
		if(cowy < 0)
		{
			y = 1;
		}
		
		else if(cowy > 800)
		{
			y = -1;
		}
		
		cowx = cowx + x;
		cowy = cowy + y;
	}

	@Override
	public String identify()
	{
		//i alrdy did this for u
		return "Cow";
	}

	@Override
	public void position(int x, int y)
	{
		this.cowx = x;
    	this.cowy = y;
    	marginTop = cowy + 5;
    	marginBottom = cowy + 55;
    	marginLeft = cowx + 5;
    	marginRight = cowx + 170;
	}

	@Override
	public boolean isDraggable(int x, int y)
	{
		//just copy this with different names and the according vaues of the edges of sheep
		int cowWidth = 170;
		int cowHeight = 55;
		int cowLeft = cowx;
		int cowTop = cowy;
		int cowRight = cowLeft + cowWidth;
		int cowBottom = cowTop + cowHeight;

		return (x >= cowLeft && x <= cowRight && y >= cowTop && y <= cowBottom);
	}
	//make sure u go to AnimalActions and change the thing i commented on

}
