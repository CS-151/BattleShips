package edu.sjsu.cs.cs151.battleship.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class NextTurn 
{
	/**
	 * Constructor.
	 */
	public NextTurn()
	{
		initialize();
	}

	/**
	 * Creates the frame.
	 */
	public void initialize()
	{
		frame = new JFrame("Battleships");
		frame.getContentPane().setLayout(null);
		frame.setBounds(0, 0, 500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/cannonball.png")));

		//Animates cannonball
		JPanel CannonPanel = new JPanel();
		CannonPanel.setBounds(0, 137, 500, 70);
		CannonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		final Moveable shape= new ImgShape(0, 0, "/cannonball.png");
		ShapeIcon icon = new ShapeIcon(shape, 500, 100);
		final JLabel label = new JLabel(icon);
		CannonPanel.add(label);
		frame.getContentPane().add(CannonPanel);

		JLabel NextPlayer = new JLabel("Next Player's Turn");
		NextPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		NextPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 35));
		NextPlayer.setBounds(87, 211, 309, 43);
		frame.getContentPane().add(NextPlayer);

		startButton = new JButton("Start");
		startButton.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		startButton.setBounds(197, 294, 89, 23);
		startButton.setForeground(new Color(255, 102, 51));
		frame.getContentPane().add(startButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Timer for cannonball
		final int DELAY = 10;
		Timer t = new Timer(DELAY, event ->{
			shape.move(1);
			label.repaint();
		});

		t.start();
	}

	/**
	 * Gets the frame.
	 * @return frame the frame
	 */
	public JFrame getFrame()
	{
		return frame;
	}

	/**
	 * Gets the startButton.
	 * @return startButton the startButton
	 */
	public JButton getStartButton()
	{
		return startButton;
	}

	public JButton startButton;
	private JFrame frame;
}
