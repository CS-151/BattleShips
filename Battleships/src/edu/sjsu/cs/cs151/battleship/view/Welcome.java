package edu.sjsu.cs.cs151.battleship.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Welcome 
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
		frame = new JFrame("Battleships");
		frame.getContentPane().setLayout(null);
		frame.setBounds(0, 0, 500, 500);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/cannonball.png")));
		
		//Clouds animated
		JPanel TOP = new JPanel();
		TOP.setBounds(0, 0, 484, 100);
		frame.getContentPane().add(TOP);
		TOP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		final Moveable cloud= new ImgShape(0, 0, "/cloud.png");
		ShapeIcon icon1 = new ShapeIcon(cloud, 500, 100);
		final JLabel l1 = new JLabel(icon1);
		TOP.add(l1);
		frame.getContentPane().add(TOP);
		
		JPanel CENTER = new JPanel();
		CENTER.setBounds(0, 99, 484, 208);
		frame.getContentPane().add(CENTER);
		CENTER.setLayout(null);
		
		JLabel lblWelcomeToBattleship = new JLabel("Welcome to Battleship!");
		lblWelcomeToBattleship.setBounds(84, 5, 315, 31);
		lblWelcomeToBattleship.setForeground(new Color(0, 102, 204));
		lblWelcomeToBattleship.setFont(new Font("Magneto", Font.PLAIN, 25));
		CENTER.add(lblWelcomeToBattleship);
		
		start = new JButton("start");
		start.setForeground(new Color(255, 102, 51));
		start.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		start.setBounds(192, 45, 100, 25);
		CENTER.add(start);

		about = new JButton("About");
		about.setForeground(new Color(255, 102, 51));
		about.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		about.setBounds(192, 75, 100, 25);
		CENTER.add(about);

		tutorial = new JButton("Tutorial");
		tutorial.setForeground(new Color(255, 102, 51));
		tutorial.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		tutorial.setBounds(192, 105, 100, 25);
		CENTER.add(tutorial);

		exit = new JButton("Exit");
		exit.setForeground(new Color(255, 102, 51));
		exit.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		exit.setBounds(192, 135, 100, 25);
		CENTER.add(exit);
		
		JPanel LSHIP = new JPanel();
		LSHIP.setBounds(0, 307, 115, 83);
		frame.getContentPane().add(LSHIP);
		JLabel shipL = new JLabel("");
		Image img4 = new ImageIcon(shipL.getClass().getResource("/shipL.png")).getImage();
		shipL.setIcon(new ImageIcon(img4));
		LSHIP.add(shipL);		
		
		//Cannonball animated
		JPanel CANNONS = new JPanel();
		CANNONS.setBounds(115, 307, 236, 83);
		frame.getContentPane().add(CANNONS);
		CANNONS.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		final Moveable ball = new ImgShape(0, 0, "/cannonball.png");
		ShapeIcon icon2 = new ShapeIcon(ball, 500, 100);
		final JLabel l2 = new JLabel(icon2);
		CANNONS.add(l2);
		frame.getContentPane().add(CANNONS);
		
		JPanel RSHIP = new JPanel();
		RSHIP.setBounds(351, 307, 133, 83);
		frame.getContentPane().add(RSHIP);
		JLabel shipR = new JLabel("");
		shipR.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img5 = new ImageIcon(shipR.getClass().getResource("/shipR.png")).getImage();
		shipR.setIcon(new ImageIcon(img5));
		RSHIP.add(shipR);
		
		JPanel BOTTOM = new JPanel();
		BOTTOM.setBounds(0, 391, 484, 70);
		BOTTOM.setBackground(new Color(0, 102, 204));
		frame.getContentPane().add(BOTTOM);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Cloud timer
		final int DELAY = 50;
		Timer t = new Timer(DELAY, event ->{
			cloud.move();
			l1.repaint();
		});
		t.start();
		
		//Cannonball timer
		final int DELAY2 = 1;
		Timer t2 = new Timer(DELAY2, event ->{
			ball.move();
			l2.repaint();
		});
		t2.start();
	}
	
	public static void main(String[] args) 
	{
		Welcome window = new Welcome();
		window.frame.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JButton getStartButton()
	{
		return start;
	}
	public JButton getAboutButton()
	{
		return about;
	}public JButton getTutorialButton()
	{
		return tutorial;
	}public JButton getExitButton()
	{
		return exit;
	}
	
	public JButton start;
	public JButton about;
	public JButton tutorial;
	public JButton exit;
	private JFrame frame;
}
