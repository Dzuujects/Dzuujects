package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Horse extends JComponent implements Animal
{
	   int horsex;
       int horsey;
       private int marginRight;
       private int marginLeft;
       private int marginTop;
       private int marginBottom;
       private boolean isDragging;
       
       public Horse(int x, int y)
       {
    	   this.horsex = 300;
    	   this.horsey = 50;
    	   this.marginTop = horsey - 5;
    	   this.marginBottom = horsey + 460;
    	   this.marginLeft = horsex - 110;
    	   this.marginRight = horsex + 240;
       }
       
	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//Horse head
        Rectangle HorseHead = new Rectangle(horsex+200, horsey, 40, 20);
        Rectangle HorseNeck = new Rectangle(horsex+200, horsey+20, 25, 50);
        Rectangle HorseEye = new Rectangle(horsex+210, horsey+5, 5, 5);
        Rectangle HorseEar = new Rectangle(horsex+200, horsey-5, 10,10);
        Rectangle HorseMouth = new Rectangle(horsex+230, horsey, 10, 20);
        
        Arc2D.Double HorseNeckThing = new Arc2D.Double(horsex+188.8, horsey+10, 50, 50, 90, 180, Arc2D.CHORD);
                
        //Horse Body
        
        Rectangle HorseBody = new Rectangle (horsex-110, horsey+380, 100, 40);
        Rectangle HorseLeg1 = new Rectangle (horsex-30, horsey+390, 15, 70);
        Rectangle HorseLeg1B = new Rectangle (horsex-35, horsey+380, 15, 70);
        
        Rectangle HorseLeg2 = new Rectangle(horsex-100, horsey+390, 15, 70);
        Rectangle HorseLeg2B = new Rectangle(horsex-95, horsey+380, 15, 70);
        
        Arc2D.Double HorseTail = new Arc2D.Double(horsex-150, horsey+400, 100, 100, 55, 90, Arc2D.OPEN);
        Ellipse2D.Double HorseTailSolid = new Ellipse2D.Double(horsex-150, horsey+420, 20, 5);
        
        //SADDLE (FUCK U NADESH BLACK ASS BITCH)
        Arc2D.Double HorseSaddleOuter = new Arc2D.Double(horsex-90, horsey+350, 60, 60, 180, 180, Arc2D.CHORD);
        Arc2D.Double HorseSaddleInner = new Arc2D.Double(horsex-80, horsey+360, 40, 40, 180, 180, Arc2D.CHORD);
        
//Shading for OCD
        Rectangle HorseneckShading = new Rectangle(horsex+200, horsey+15, 25, 25);
        Rectangle HorseShadingLeg1Back = new Rectangle(horsex-35, horsey+380, 15,50);
        Rectangle HorseShadingLeg1 = new Rectangle(horsex-30, horsey+380, 15, 55);
        
        Rectangle HorseShadingLeg2Back = new Rectangle(horsex-95, horsey+380, 15,50);
        Rectangle HorseShadingLeg2 = new Rectangle(horsex-100, horsey+380, 15, 55);
        
        AffineTransform old = g2.getTransform();
        //Horse outlines WITH ROTATION
        g2.setColor(Color.BLACK);
        g2.rotate(Math.PI/4);
        g2.draw(HorseHead);
        g2.draw(HorseNeck);
        g2.draw(HorseEye);
        g2.draw(HorseNeckThing);
        g2.draw(HorseEar);
        g2.draw(HorseMouth);
        g2.draw(HorseSaddleOuter);
        g2.draw(HorseSaddleInner);
       
   
        
        //Horse FILLS WITH ROTATION
        
        g2.setColor(new Color(53, 53, 53));
        g2.fill(HorseNeckThing);
        
        g2.setColor(new Color(211, 211, 211));
        g2.fill(HorseNeck);
     
        g2.setColor(new Color(79, 79, 79));
        g2.fill(HorseneckShading);
        
        g2.setColor(new Color(211, 211, 211));
        g2.fill(HorseHead);
        g2.fill(HorseEar);
        
g2.setColor(new Color(53, 53, 53));
        g2.fill(HorseMouth);
       
      
        g2.setColor(Color.black);
        g2.fill(HorseEye);
        
        // Horse Outlines WITH ******NO***** ROTATION
        g2.setTransform(old);
        
        
        g2.setColor(Color.black);
        g2.draw(HorseBody);
        g2.draw(HorseLeg1B);
        g2.draw(HorseLeg1);
        g2.draw(HorseLeg2);
        g2.draw(HorseLeg2B);
        
        g2.draw(HorseTail);
        
        g2.setColor(new Color(211, 211, 211));
        g2.fill(HorseLeg1B);
        g2.fill(HorseLeg2B);
       
        
        
        
        g2.setColor(new Color(79, 79, 79));
        g2.fill(HorseShadingLeg1Back);
        g2.fill(HorseShadingLeg2Back);
        g2.fill(HorseTailSolid);
        
        g2.setColor(new Color(211, 211, 211));
        g2.fill(HorseLeg1);
        g2.fill(HorseLeg2);
        
        g2.setColor(new Color(79, 79, 79));
        g2.fill(HorseShadingLeg1);
        g2.fill(HorseShadingLeg2);
        
        g2.setColor(new Color(211, 211, 211));
        g2.fill(HorseBody);
        
        g2.setColor(new Color(128, 64, 11));
        g2.fill(HorseSaddleOuter);
        
        g2.setColor(new Color(201, 91, 12));
        g2.fill(HorseSaddleInner);
	}
	
	int x = 1;
	int y = 1;
	@Override
	public void move()
	{
		if(horsex < 0)
		{
			x = 1;
		}
		
		else if(horsex > 1000)
		{
			x = -1;
		}
		
		if(horsey < 0)
		{
			y = 1;
		}
		
		else if(horsey > 800)
		{
			y = -1;
		}
		
		horsex = horsex + x;
		horsey = horsey + y;
	}
	@Override
	public String identify()
	{
		return "Horse";
	}
	@Override
	public void position(int x, int y)
	{
		this.horsex = 300;
		this.horsey = 50;
		marginTop = horsey - 5;
		marginBottom = horsey + 460;
		marginLeft = horsex - 110;
		marginRight = horsex + 240;
		
	}
	@Override
	public boolean isDraggable(int x, int y)
	{
		int horseWidth = 240;
		int horseHeight = 460;
		int horseLeft = horsex;
		int horseTop = horsey;
		int horseRight = horseLeft + horseWidth;
		int horseBottom = horseTop + horseHeight;

		return (x >= horseLeft && x <= horseRight && y >= horseTop && y <= horseBottom);
	}
       
}
