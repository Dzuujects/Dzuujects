package package1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class AnimalActions extends JComponent implements MouseMotionListener, MouseListener
{
	ArrayList<Animal> animals2 = new ArrayList<Animal>();
	private boolean dragged = false;
	
	public void paintComponent(Graphics g)
	{
		for(int i = 0; i < animals2.size(); i++)
		{
			animals2.get(i).draw(g);
		}
	}
	
	public void setXYI(int x, int y, int index) {
		animals2.get(index).position(x, y);
		repaint();
	}
	
	public void update(ArrayList<Animal> list)
	{
		this.animals2 = list;
		repaint();
	}

	int count = 0;
	@Override
	public void mouseDragged(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		if(animals2.size() < count+1)
		{
			count = 0;
		}
		else if(animals2.get(count).isDraggable(x, y) || dragged)
		{
			if(animals2.get(count).identify().equals("Chicken"))
			{
				dragged = true;
				animals2.get(count).position(x-37, y-35);
				repaint();
			}
			else if(animals2.get(count).identify().equals("Cow"))
			{
				dragged = true;
				animals2.get(count).position(x-85, y-27);
				repaint();
			}
			else if(animals2.get(count).identify().equals("Horse"))
			{
				dragged = true;
				animals2.get(count).position(x-120, y-230); //the number u minus the x and y by are half of the total width and half the total height of the rawing
				repaint();
			}
			else if(animals2.get(count).identify().equals("Sheep"))
			{
				dragged = true;
				animals2.get(count).position(x-120, y-230); //change the x and y according to sheep class
				repaint();
			}
		}
		else count++;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		dragged = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
}
