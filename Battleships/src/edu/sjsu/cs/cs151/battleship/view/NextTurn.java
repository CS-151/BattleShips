package edu.sjsu.cs.cs151.battleship.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnl_Center = new JPanel();
		frame.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(null);

		JLabel cannon = new JLabel("");
		cannon.setBounds(55, 130, 60, 50);
		//Image img = new ImageIcon(cannon.getClass().getResource("/cannonball.png")).getImage();
		//cannon.setIcon(new ImageIcon(img));
		pnl_Center.add(cannon);

		JLabel cannon1 = new JLabel("");
		cannon1.setBounds(369, 130, 60, 50);
		//Image img1 = new ImageIcon(cannon.getClass().getResource("/cannonball.png")).getImage();
		//cannon1.setIcon(new ImageIcon(img1));
		pnl_Center.add(cannon1);

		JLabel cannon2 = new JLabel("");
		cannon2.setBounds(212, 130, 60, 50);
		//Image img2 = new ImageIcon(cannon.getClass().getResource("/cannonball.png")).getImage();
		//cannon2.setIcon(new ImageIcon(img2));
		pnl_Center.add(cannon2);

		JLabel NextPlayer = new JLabel("Next Player's Turn");
		NextPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		NextPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 35));
		NextPlayer.setBounds(87, 211, 309, 43);
		pnl_Center.add(NextPlayer);

	    startButton = new JButton("Start");
		startButton.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		startButton.setBounds(197, 294, 89, 23);
		startButton.setForeground(new Color(255, 102, 51));
		pnl_Center.add(startButton);

	}
	
	public static void main(String[] args) 
	{
		NextTurn window = new NextTurn();
		window.frame.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JButton getStartButton()
	{
		return startButton;
	}
	
	public JButton startButton;
	private JFrame frame;
}
