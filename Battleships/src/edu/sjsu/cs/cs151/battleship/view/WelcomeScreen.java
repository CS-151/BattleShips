package edu.sjsu.cs.cs151.battleship.view;
import javax.swing.*;

import edu.sjsu.cs.cs151.battleship.controller.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

class WelcomeScreen extends JPanel implements ActionListener {
	
	//
	Timer tm1 = new Timer(200/2,this);
	//Timer tm2 = new Timer(300,this);
	int x = 240/2, velX = 25/2, waveY = 625/2, upWave = 20/2;
	
	public void paintComponent(Graphics g)
	{
		
		
		//g.drawRect(95, 95, 50, 50);
		super.paintComponent(g);
		//Ocean
		
		g.setColor(Color.BLUE);
		g.drawArc(0, waveY, 80/2, 100/2, 0, -180);
		g.drawArc(80/2, waveY, 120/2, 100/2, 0, -180);
		g.drawArc(200/2, waveY, 130/2, 100/2, 0, -180);
		g.drawArc(330/2, waveY, 60/2, 100/2, 0, -180);
		g.drawArc(390/2, waveY, 90/2, 100/2, 0, -180);
		g.drawArc(480/2, waveY, 50/2, 100/2, 0, -180);
		g.drawArc(530/2, waveY, 120/2, 100/2, 0, -180);
		g.drawArc(650/2, waveY, 100/2, 100/2, 0, -180);
		g.drawArc(750/2, waveY, 50/2, 100/2, 0, -180);
		g.drawArc(800/2, waveY, 130/2, 100/2, 0, -180);
		g.drawArc(930/2, waveY, 70/2, 100/2, 0, -180);
		//tm2.start();
		//g.setColor(Color.BLUE);
		//g.fillRect(0, 700, 1000, 750);
		
		//First Cloud
		g.setColor(Color.WHITE);
		g.fillArc(200/2, 200/2, 80/2, 100/2, 0, -180);
		g.fillArc(280/2, 200/2, 60/2, 100/2, 0, -180);
		g.fillArc(340/2, 200/2, 40/2, 100/2, 0, -180);
		g.fillArc(350/2, 190/2, 60/2, 60/2, -90, 180);
		g.fillArc(300/2, 140/2, 80/2, 100/2, 0, 180);
		g.fillArc(220/2, 140/2, 80/2, 100/2, 0, 180);
		g.fillArc(180/2, 190/2, 80/2, 60/2, 60, 180);
		g.fillRect(200/2, 190/2, 190/2, 60/2);
		
		//Second Cloud
		g.fillArc(600/2, 200/2, 80/2, 100/2, 0, -180);
		g.fillArc(680/2, 200/2, 60/2, 100/2, 0, -180);
		g.fillArc(740/2, 200/2, 40/2, 100/2, 0, -180);
		g.fillArc(750/2, 190/2, 60/2, 60/2, -90, 180);
		g.fillArc(700/2, 140/2, 80/2, 100/2, 0, 180);
		g.fillArc(620/2, 140/2, 80/2, 100/2, 0, 180);
		g.fillArc(580/2, 190/2, 80/2, 60/2, 60, 180);
		g.fillRect(600/2, 190/2, 190/2, 60/2);
		
		//First Ship
		g.setColor(Color.BLACK);
		g.drawLine(40/2, 600/2, 90/2, 700/2); //left base
		g.drawLine(90/2, 700/2, 190/2, 700/2); //bottom base
		g.drawLine(190/2, 700/2, 240/2, 600/2); // right base 
		g.drawLine(40/2, 600/2, 240/2, 600/2); // top base
		g.drawRect(90/2, 560/2, 100/2, 40/2); // top rectangle
		g.drawRect(190/2, 570/2, 50/2, 20/2); // cannon
		//g.drawRect(20, 300, 100, 50);
		//g.drawRect(405, 300, 75, 50);
		
		
		// Second Ship
		g.drawLine(760/2,600/2,810/2,700/2); //left base
		g.drawLine(810/2,700/2,910/2,700/2); //bottom base
		g.drawLine(910/2,700/2,960/2,600/2); // right base 
		g.drawLine(760/2,600/2,960/2,600/2); // top base
		g.drawRect(820/2,560/2, 100/2, 40/2); // top rectangle
		g.drawRect(765/2, 570/2, 55/2, 20/2); // cannon
				
		g.setColor(Color.RED);
		g.fillOval(x, 570/2, 20/2, 20/2);	//240,570,20,20
		tm1.start();
		

	}

	
	public static void main(String args[]) {
		JFrame frame = new JFrame("GUI");
		frame.setLayout(new BorderLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground( Color.DARK_GRAY);
		frame.setSize(1000, 1000);
		WelcomeScreen g = new WelcomeScreen();
			
		JPanel panel = new JPanel();
		
		JLabel battleShip = new JLabel("Welcome to BattleShip");
		battleShip.setAlignmentX(0);
		battleShip.setAlignmentY(0);
		battleShip.setFont(new Font("Copperplate", Font.PLAIN, 35));
		
		panel.add(battleShip);
		panel.add(g);
		frame.add(panel,BorderLayout.NORTH);
		frame.add(g);
		frame.setSize(500,500);
		//frame.add(battleShip);
		
		JButton loginButton = new JButton("Start");
		panel.add(loginButton, BorderLayout.CENTER);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Controller view = new Controller();
				//view.playerFrame.setVisible(true);
			}
		});
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x < 240/2 || x > 760/2)
		{
			velX = -velX;
		}
		x = x + velX;
		//repaint();
		
		if(waveY < 625/2 || waveY>615/2 )
		{
			upWave = -upWave;
		}
		waveY = waveY + upWave;
		repaint();
	}
}
