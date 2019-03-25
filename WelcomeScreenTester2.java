import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WelcomeScreenTester2 extends JPanel implements ActionListener {
	private  JFrame frame;
	Timer tm = new Timer(1,this);
	int x = 240, velX = 20;

	public void paintComponent(Graphics g)
	{
		//g.drawRect(95, 95, 50, 50);
		super.paintComponent(g);
		//Ocean
		g.setColor(new Color(30,144,255));
		g.fillRect(0, 400, 1000, 750);
		//First Ship
		g.setColor(Color.BLACK);
		g.drawLine(40, 300, 90, 400); //left base
		g.drawLine(90, 400, 190, 400); //bottom base
		g.drawLine(190, 400, 240, 300); // right base 
		g.drawLine(40, 300, 240, 300); // top base
		g.drawRect(90, 260, 100, 40); // top rectangle
		g.drawRect(190, 270, 50, 20); // cannon
		//g.drawRect(20, 300, 100, 50);
		//g.drawRect(405, 300, 75, 50);
		
		
		// Second Ship
		g.drawLine(760,300,810,400); //left base
		g.drawLine(810,400,910,400); //bottom base
		g.drawLine(910,400,960,300); // right base 
		g.drawLine(760,300,960,300); // top base
		g.drawRect(820,260, 100, 40); // top rectangle
		g.drawRect(765, 270, 55, 20); // cannon
				
		g.setColor(Color.RED);
		g.fillOval(x, 270, 20, 20);	//240,570,20,20
		tm.start();
		

	}

	
	public static void main(String args[]) {
		JFrame frame = new JFrame("GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		WelcomeScreenTester2 g = new WelcomeScreenTester2();
		
		JPanel panel = new JPanel();
		JLabel battleShip = new JLabel("Welcome to BattleShip");
		battleShip.setAlignmentX(0);
		battleShip.setAlignmentY(0);
		battleShip.setFont(new Font("Copperplate", Font.PLAIN, 35));
		
//		JButton start = new JButton("Start");
//		start.setBounds(500, 200, 50, 50);
		
		panel.add(battleShip);
		panel.add(g);
		//panel.add(start);
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
