package edu.sjsu.cs.cs151.battleship.view;

import java.awt.*;
import javax.swing.*;

/**
 * An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{
	/**
	 * Class constructor.
	 * @param s the Moveable shape
	 * @param w width of the shape
	 * @param h height of the shape
	 */
	public ShapeIcon(Moveable s, int w, int h)
	{
		shape = s;
		width = w;
		height = h;
	}

	/**
	 * Gets the width of the icon.
	 */
	public int getIconWidth()
	{
		return width;
	}

	/**
	 * Gets the height of the icon.
	 */
	public int getIconHeight()
	{
		return height;
	}

	/**
	 * Paints the icon.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}

	private int width;
	private int height;
	private Moveable shape;
}
