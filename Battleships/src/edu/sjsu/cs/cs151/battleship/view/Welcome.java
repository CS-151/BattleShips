package edu.sjsu.cs.cs151.battleship.view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

class Welcome 
{
	/**
	 * Constructor.
	 */
	public Welcome()
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

		JPanel pnl_North = new JPanel();
		pnl_North.setPreferredSize(new Dimension(500, 120));
		frame.getContentPane().add(pnl_North, BorderLayout.NORTH);
		pnl_North.setLayout(null);

		JLabel cloud1 = new JLabel("");
		cloud1.setBounds(45, 24, 128, 69);
		Image img = new ImageIcon(cloud1.getClass().getResource("/cloud.png")).getImage();
		cloud1.setIcon(new ImageIcon(img));
		pnl_North.add(cloud1);

		JLabel cloud2 = new JLabel("");
		cloud2.setBounds(371, 11, 162, 69);
		Image img1 = new ImageIcon(cloud2.getClass().getResource("/cloud.png")).getImage();
		cloud2.setIcon(new ImageIcon(img1));
		pnl_North.add(cloud2);

		JLabel cloud3 = new JLabel("");
		cloud3.setBounds(234, 40, 127, 69);
		Image img2 = new ImageIcon(cloud3.getClass().getResource("/cloud.png")).getImage();
		cloud3.setIcon(new ImageIcon(img2));
		pnl_North.add(cloud3);

		JLabel cloud4 = new JLabel("");
		cloud4.setBounds(-20, -19, 128, 81);
		Image img3 = new ImageIcon(cloud4.getClass().getResource("/cloud.png")).getImage();
		cloud4.setIcon(new ImageIcon(img3));
		pnl_North.add(cloud4);

		JPanel pnl_Center = new JPanel();
		frame.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(null);

		JLabel lblWelcomeToBattleship = new JLabel("Welcome to Battleship!");
		lblWelcomeToBattleship.setBounds(81, 0, 321, 37);
		lblWelcomeToBattleship.setForeground(new Color(0, 102, 204));
		lblWelcomeToBattleship.setFont(new Font("Magneto", Font.PLAIN, 25));
		pnl_Center.add(lblWelcomeToBattleship);

		JLabel player1 = new JLabel("Player 1");
		player1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		player1.setBounds(120, 48, 41, 20);
		pnl_Center.add(player1);

		JTextField textField = new JTextField();
		textField.setBounds(167, 48, 150, 20);
		pnl_Center.add(textField);
		textField.setColumns(10);

		JLabel player2 = new JLabel("Player 2");
		player2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		player2.setBounds(120, 69, 41, 20);
		pnl_Center.add(player2);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 70, 150, 20);
		pnl_Center.add(textField_1);

		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setForeground(new Color(255, 102, 51));
		btnStartGame.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnStartGame.setBounds(184, 110, 115, 23);
		pnl_Center.add(btnStartGame);

		JLabel shipL = new JLabel("");
		shipL.setBounds(10, 175, 100, 66);
		shipL.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img4 = new ImageIcon(shipL.getClass().getResource("/shipL.png")).getImage();
		shipL.setIcon(new ImageIcon(img4));
		pnl_Center.add(shipL);		

		JLabel shipR = new JLabel("");
		shipR.setBounds(374, 175, 100, 66);
		shipR.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img5 = new ImageIcon(shipR.getClass().getResource("/shipR.png")).getImage();
		shipR.setIcon(new ImageIcon(img5));
		pnl_Center.add(shipR);		

		JLabel cannon = new JLabel("");
		cannon.setBounds(195, 149, 50, 42);
		Image img6 = new ImageIcon(cannon.getClass().getResource("/cannonball.png")).getImage();
		cannon.setIcon(new ImageIcon(img6));
		pnl_Center.add(cannon);

		JPanel pnl_South = new JPanel();
		pnl_South.setPreferredSize(new Dimension(500, 100));
		pnl_South.setBackground(new Color(0, 102, 204));
		frame.getContentPane().add(pnl_South, BorderLayout.SOUTH);
	}

	public static void main(String args[])
	{
		Welcome window = new Welcome();
		window.frame.setVisible(true);
	}
	
	private JFrame frame;
}
