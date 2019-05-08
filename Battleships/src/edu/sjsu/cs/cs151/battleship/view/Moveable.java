package edu.sjsu.cs.cs151.battleship.view;

import java.awt.*;

/**
 * A shape that can be moved around.
 */
public interface Moveable 
{
	/**
	 * Draws the shape.
	 * @param g2 the graphics context.
	 */
	void draw(Graphics2D g2);
	
	/**
	 * Moves the shape.
	 * It is up to the shape to move itself.
	 * @param n object moves to the right if equals 1, left otherwise
	 */
	void move(int n);
}
