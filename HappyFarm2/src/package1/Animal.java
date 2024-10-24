package package1;

import java.awt.Graphics;

public interface Animal
{
	public static final int i  = 0;
	
	public void draw(Graphics g);
	
	public void move();
	
	public String identify();
	
	public void position(int x, int y);
	
	public boolean isDraggable(int x, int y);
}
