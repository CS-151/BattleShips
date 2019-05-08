package edu.sjsu.cs.cs151.battleship.view;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 * An image that can be moved around.
 */
public class ImgShape implements Moveable
{
	/**
	 * Gets an image or icon.
	 * @param x the left of the bounding rectangle
	 * @param y the top of the bounding rectangle
	 * @param img the image
	 */
	public ImgShape(int x, int y, String img)
	{
		this.x = x;
		this.y = y;
		image= img;
	}

	/**
	 * Moves the image left or right given an integer.
	 */
	public void move(int n)
	{
		if (n == 1)
		{
			x++;
			if (x == 480)
			{
				x = 0;
			}
		}

		else
		{
			--x;
			if (x == 0)
			{

				x = 480;
			}

		}
	}

	/**
	 * Draws the image.
	 */
	public void draw(Graphics2D g2)
	{
		Image img = new ImageIcon(getClass().getResource(image)).getImage();
		g2.drawImage(img, x, y, null);
	}

	private int x;
	private int y;
	private String image;
}
