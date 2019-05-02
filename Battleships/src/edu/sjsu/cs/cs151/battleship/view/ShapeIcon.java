package edu.sjsu.cs.cs151.battleship.view;

import java.awt.*;
import javax.swing.*;

public class ShapeIcon implements Icon
{
	public ShapeIcon(Moveable s, int w, int h)
	{
		shape = s;
		width = w;
		height = h;
	}
	
	public int getIconWidth()
	{
		return width;
	}
	
	public int getIconHeight()
	{
		return height;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}
	
	private int width;
	private int height;
	private Moveable shape;
}
