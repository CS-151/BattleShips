package edu.sjsu.cs.cs151.battleship.view;

import java.awt.*;
import javax.swing.*;

import edu.sjsu.cs.cs151.model.MoveableShape;

/**
 * An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{
	public ShapeIcon(MoveableShape shape, int width, int height)
	{
		this.shape = shape;
		this.width = width;
		this.height = height;
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
	private MoveableShape shape;
}