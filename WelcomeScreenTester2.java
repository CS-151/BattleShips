import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

class WelcomeScreenTester2 extends JPanel implements ActionListener {
	private  JFrame frame;
	Timer tm = new Timer(1,this);
	int x = 240, velX = 25;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2;
		//g.drawRect(95, 95, 50, 50);
		super.paintComponent(g);
		//Ocean
		g.setColor(Color.BLUE);
		g.drawArc(0, 625, 80, 100, 0, -180);
		g.drawArc(80, 625, 120, 100, 0, -180);
		g.drawArc(200, 625, 130, 100, 0, -180);
		g.drawArc(330, 625, 60, 100, 0, -180);
		g.drawArc(390, 625, 90, 100, 0, -180);
		g.drawArc(480, 625, 50, 100, 0, -180);
		g.drawArc(530, 625, 120, 100, 0, -180);
		g.drawArc(650, 625, 100, 100, 0, -180);
		g.drawArc(750, 625, 50, 100, 0, -180);
		g.drawArc(800, 625, 130, 100, 0, -180);
		g.drawArc(930, 625, 70, 100, 0, -180);
		//g.setColor(Color.BLUE);
		//g.fillRect(0, 700, 1000, 750);
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
		tm.start();
		

	}

	
	public static void main(String args[]) {
		JFrame frame = new JFrame("GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		repaint();
	}
}
