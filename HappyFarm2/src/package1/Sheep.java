package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Sheep extends JComponent implements Animal
{
	private int sheepx;
	private int sheepy;
	private int marginRight;
    private int marginLeft;
    private int marginTop;
    private int marginBottom;
    private boolean isDragging;
    
	public Sheep(int x,int y)
	{
		this.sheepx = x;
		this.sheepy = y;
		//find the margins here
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.gray);
	      Rectangle sheeplegs = new Rectangle(170,290,5,20);
	      g2.draw(sheeplegs);
	      g2.fill(sheeplegs);
	      
	      Rectangle sheeplegs2 = new Rectangle(190,290,5,20);
	      g2.draw(sheeplegs2);
	      g2.fill(sheeplegs2);
	            
	      g2.setColor(Color.black);
	      Rectangle sheepfoot = new Rectangle(170,305,6,5);
	      g2.draw(sheepfoot);
	      g2.fill(sheepfoot);
	      
	      Rectangle sheepfoot2 = new Rectangle(190,305,6,5);
	      g2.draw(sheepfoot2);
	      g2.fill(sheepfoot2);
	      
	      Ellipse2D.Double sheepbody = new Ellipse2D.Double(150,250,70,50);
	      g2.draw(sheepbody);
	      g2.setColor(Color.white);
	      g2.fill(sheepbody);
	      
	      g2.setColor(Color.black);
	      Ellipse2D.Double sheepheadhair = new Ellipse2D.Double(200,250,30,30);
	      g2.draw(sheepheadhair);
	      g2.setColor(Color.white);
	      g2.fill(sheepheadhair);
	      
	      g2.setColor(Color.gray);
	      Ellipse2D.Double sheephead = new Ellipse2D.Double(210,255,25,20);
	      g2.draw(sheephead);
	      g2.fill(sheephead);
	      
	      Ellipse2D.Double sheepear = new Ellipse2D.Double(215,250,5,10);
	      g2.draw(sheepear);
	      g2.fill(sheepear);
	      
	      g2.setColor(Color.black);
	      Ellipse2D.Double sheepeyes = new Ellipse2D.Double(225,260,5,5);
	      g2.draw(sheepeyes);
	      g2.fill(sheepeyes);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String identify()
	{
		return "Sheep";
	}

	@Override
	public void position(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDraggable(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
