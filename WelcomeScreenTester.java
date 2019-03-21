import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.sjsu.cs.cs151.model.MoveableShape;
import edu.sjsu.cs.cs151.view.ShapeIcon;
import edu.sjsu.cs.cs151.view.ShipShape;

/**
 * This program implements an animation that moves a car shape.
 */
public class WelcomeScreenTester
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final MoveableShape shape = new ShipShape(0, 0, SHIP_WIDTH);

		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);

		final JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int DELAY = 100;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, event ->
		{
			shape.move();
			label.repaint();
		});
		t.start();
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int SHIP_WIDTH = 100;
}
