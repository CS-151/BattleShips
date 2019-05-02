package edu.sjsu.cs.cs151.battleship.view;

import java.awt.*;
import javax.swing.ImageIcon;

public class ImgShape implements Moveable
{
	public ImgShape(int x, int y, String img)
	{
		this.x = x;
		this.y = y;
		image= img;
	}
	
	public void move()
	{
		x++;
		if (x == 480)
		{
			x = 0;
		}
	}
	
	public void draw(Graphics2D g2)
	{
		Image img = new ImageIcon(getClass().getResource(image)).getImage();
		g2.drawImage(img, x, y, null);
	}
	
	private int x;
	private int y;
	private String image;
}
