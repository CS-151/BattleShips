package edu.sjsu.cs.cs151.battleship.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/cannonball.png")));

		JMenu menu = new JMenu("Menu");
		menu.setBounds(0, 0, 107, 22);
		frame.add(menu);
		JMenuBar bar = new JMenuBar();

		m1 = new JMenuItem("About");
		m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					JOptionPane.showMessageDialog(frame, new ImageIcon("image/About.PNG"),"About", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});

		m2 = new JMenuItem("Tuturial");
		m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					JOptionPane.showMessageDialog(frame, new ImageIcon("image/Tutorial.PNG"),"Tutorial", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});

		m3 = new JMenuItem("Exit");
		m3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
				if (n == 0)
				{
					try
					{
						//Exits the game entirely.
						System.exit(0);
					} catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});

		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		bar.add(menu);
		frame.setJMenuBar(bar);

		//Clouds animated
		JPanel TOP = new JPanel();
		TOP.setBounds(0, 0, 484, 120);
		TOP.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		final Moveable cloud= new ImgShape(-50, -50, "/cloud.png");
		ShapeIcon icon1 = new ShapeIcon(cloud, 500, 100);
		final JLabel l1 = new JLabel(icon1);
		TOP.add(l1);
		frame.getContentPane().add(TOP);

		JPanel CENTER = new JPanel();
		CENTER.setBounds(0, 120, 484, 109);
		frame.getContentPane().add(CENTER);
		CENTER.setLayout(null);

		JLabel lblWelcomeToBattleship = new JLabel("Welcome to Battleship!");
		lblWelcomeToBattleship.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBattleship.setBounds(47, 0, 390, 53);
		lblWelcomeToBattleship.setForeground(new Color(0, 51, 102));
		lblWelcomeToBattleship.setFont(new Font("Magneto", Font.BOLD, 30));
		CENTER.add(lblWelcomeToBattleship);

		start = new JButton("Start");
		start.setForeground(new Color(255, 102, 51));
		start.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		start.setBounds(192, 54, 100, 25);
		CENTER.add(start);

		JPanel LSHIP = new JPanel();
		LSHIP.setBounds(0, 259, 115, 85);
		frame.getContentPane().add(LSHIP);
		JLabel shipL = new JLabel("");
		Image img4 = new ImageIcon(shipL.getClass().getResource("/shipL.png")).getImage();
		shipL.setIcon(new ImageIcon(img4));
		LSHIP.add(shipL);		

		//Cannonball animated
		JPanel CANNONS = new JPanel();
		CANNONS.setBounds(115, 259, 236, 85);
		frame.getContentPane().add(CANNONS);
		CANNONS.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		final Moveable ball = new ImgShape(0, 0, "/cannonball.png");
		ShapeIcon icon2 = new ShapeIcon(ball, 500, 100);
		final JLabel l2 = new JLabel(icon2);
		CANNONS.add(l2);
		frame.getContentPane().add(CANNONS);

		JPanel RSHIP = new JPanel();
		RSHIP.setBounds(351, 259, 133, 85);
		frame.getContentPane().add(RSHIP);
		JLabel shipR = new JLabel("");
		shipR.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img5 = new ImageIcon(shipR.getClass().getResource("/shipR.png")).getImage();
		shipR.setIcon(new ImageIcon(img5));
		RSHIP.add(shipR);

		JPanel BOTTOM = new JPanel();
		BOTTOM.setBounds(0, 345, 484, 100);
		BOTTOM.setBackground(new Color(0, 153, 204));
		//frame.getContentPane().add(TOP);
		BOTTOM.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		final Moveable fish= new ImgShape(10, 0, "/fish.png");
		ShapeIcon icon3 = new ShapeIcon(fish, 500, 100);
		final JLabel l3 = new JLabel(icon3);
		BOTTOM.add(l3);
		frame.getContentPane().add(BOTTOM);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		//Cloud and fish timer
		final int DELAY = 25;
		Timer t = new Timer(DELAY, event ->{
			cloud.move(1);
			l1.repaint();

			fish.move(0);
			l3.repaint();
		});
		t.start();

		//Cannonball timer
		final int DELAY2 = 1;
		Timer t2 = new Timer(DELAY2, event ->{			
			ball.move(1);
			l2.repaint();
		});
		t2.start();
	}

	public static void main(String[] args) 
	{
		Welcome window = new Welcome();
		window.frame.setVisible(true);
	}

	/**
	 * 
	 * @return
	 */
	public JFrame getFrame()
	{
		return frame;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getStartButton()
	{
		return start;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getAboutButton()
	{
		return about;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getTutorialButton()
	{
		return tutorial;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getExitButton()
	{
		return exit;
	}

	public JButton start;
	public JButton about;
	public JButton tutorial;
	public JButton exit;
	public JMenuItem m1, m2, m3;
	private JFrame frame;
}
