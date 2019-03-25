package edu.sjsu.cs.cs151.tester; 
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

class WelcomeScreenTester2 extends JPanel implements ActionListener {
//	private  JFrame frame;
	Timer tm1 = new Timer(200,this);
	//Timer tm2 = new Timer(300,this);
	int x = 240, velX = 25, waveY = 625, upWave = 20;
	
	public void paintComponent(Graphics g)
	{
		
		
		//g.drawRect(95, 95, 50, 50);
		super.paintComponent(g);
		//Ocean
		
		g.setColor(Color.BLUE);
		g.drawArc(0, waveY, 80, 100, 0, -180);
		g.drawArc(80, waveY, 120, 100, 0, -180);
		g.drawArc(200, waveY, 130, 100, 0, -180);
		g.drawArc(330, waveY, 60, 100, 0, -180);
		g.drawArc(390, waveY, 90, 100, 0, -180);
		g.drawArc(480, waveY, 50, 100, 0, -180);
		g.drawArc(530, waveY, 120, 100, 0, -180);
		g.drawArc(650, waveY, 100, 100, 0, -180);
		g.drawArc(750, waveY, 50, 100, 0, -180);
		g.drawArc(800, waveY, 130, 100, 0, -180);
		g.drawArc(930, waveY, 70, 100, 0, -180);
		//tm2.start();
		//g.setColor(Color.BLUE);
		//g.fillRect(0, 700, 1000, 750);
		
		//First Cloud
		g.setColor(Color.WHITE);
		g.fillArc(200, 200, 80, 100, 0, -180);
		g.fillArc(280, 200, 60, 100, 0, -180);
		g.fillArc(340, 200, 40, 100, 0, -180);
		g.fillArc(350, 190, 60, 60, -90, 180);
		g.fillArc(300, 140, 80, 100, 0, 180);
		g.fillArc(220, 140, 80, 100, 0, 180);
		g.fillArc(180, 190, 80, 60, 60, 180);
		g.fillRect(200, 190, 190, 60);
		
		//Second Cloud
		g.fillArc(600, 200, 80, 100, 0, -180);
		g.fillArc(680, 200, 60, 100, 0, -180);
		g.fillArc(740, 200, 40, 100, 0, -180);
		g.fillArc(750, 190, 60, 60, -90, 180);
		g.fillArc(700, 140, 80, 100, 0, 180);
		g.fillArc(620, 140, 80, 100, 0, 180);
		g.fillArc(580, 190, 80, 60, 60, 180);
		g.fillRect(600, 190, 190, 60);
		//First Ship
		g.setColor(Color.BLACK);
		g.drawLine(40, 600, 90, 700); //left base
		g.drawLine(90, 700, 190, 700); //bottom base
		g.drawLine(190, 700, 240, 600); // right base 
		g.drawLine(40, 600, 240, 600); // top base
		g.drawRect(90, 560, 100, 40); // top rectangle
		g.drawRect(190, 570, 50, 20); // cannon
		//g.drawRect(20, 300, 100, 50);
		//g.drawRect(405, 300, 75, 50);
		
		
		// Second Ship
		g.drawLine(760,600,810,700); //left base
		g.drawLine(810,700,910,700); //bottom base
		g.drawLine(910,700,960,600); // right base 
		g.drawLine(760,600,960,600); // top base
		g.drawRect(820,560, 100, 40); // top rectangle
		g.drawRect(765, 570, 55, 20); // cannon
				
		g.setColor(Color.RED);
		g.fillOval(x, 570, 20, 20);	//240,570,20,20
		tm1.start();
		

	}

	
	public static void main(String args[]) {
		JFrame frame = new JFrame("GUI");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground( Color.DARK_GRAY);
		frame.setSize(1000, 1000);
		WelcomeScreenTester2 g = new WelcomeScreenTester2();
			
		JPanel panel = new JPanel();
		
		JLabel battleShip = new JLabel("Welcome to BattleShip");
		battleShip.setAlignmentX(0);
		battleShip.setAlignmentY(0);
		battleShip.setFont(new Font("Copperplate", Font.PLAIN, 35));
		
		panel.add(battleShip);
		panel.add(g);
		frame.add(panel,BorderLayout.NORTH);
		//frame.getContentPane().setLayout(null);
			frame.add(g);
//		frame.setSize(1000,1000);
		frame.setVisible(true);
		//frame.add(battleShip);
		
		JButton loginButton = new JButton("Log in");
		panel.add(loginButton);
		panel.revalidate();
		panel.repaint();
		
		JButton signUpButton = new JButton("Sign Up");
		panel.add(signUpButton);
		panel.revalidate();
		panel.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x < 240 || x > 760)
		{
			velX = -velX;
		}
		x = x + velX;
		//repaint();
		
		if(waveY < 625 || waveY>615 )
		{
			upWave = -upWave;
		}
		waveY = waveY + upWave;
		repaint();
	}
}
