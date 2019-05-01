package edu.sjsu.cs.cs151.battleship.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class Grid {

	/**
	 * Constructor.
	 */
	public Grid()
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize()
	{
		frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));


		
		
		JPanel North = new JPanel();
		North.setPreferredSize(new Dimension(500, 150));
		frame.getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(null);
		
		JButton btnNextPlayer = new JButton("NEXT PLAYER...");
		btnNextPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnNextPlayer.setBounds(362, 11, 112, 23);
		North.add(btnNextPlayer);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblScore.setBounds(20, 56, 50, 14);
		North.add(lblScore);

		JLabel lblNewLabel = new JLabel("PLAYER 1");
		lblNewLabel.setBounds(10, 31, 55, 14);
		North.add(lblNewLabel);

		JLabel lblPlayer = new JLabel("PLAYER 2");
		lblPlayer.setBounds(254, 31, 55, 14);
		North.add(lblPlayer);

		JLabel lblNewLabel_1 = new JLabel("Ships Left:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(20, 81, 60, 14);
		North.add(lblNewLabel_1);

		JLabel lblShipsHit = new JLabel("Ships Hit:");
		lblShipsHit.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblShipsHit.setBounds(124, 81, 55, 14);
		North.add(lblShipsHit);

		JLabel lblPlayer_1 = new JLabel("PLAYER");
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setBounds(88, 125, 60, 14);
		North.add(lblPlayer_1);

		JLabel lblOpponent = new JLabel("OPPONENT");
		lblOpponent.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent.setBounds(339, 125, 65, 14);
		North.add(lblOpponent);
		
		

		JPanel West = new JPanel();
		West.setPreferredSize(new Dimension(240, 240));
		West.setLayout(new GridLayout(10, 10));
		
		JLabel westLabel = new JLabel();
		westLabel.setPreferredSize(new Dimension(240,240));
		West.add(westLabel);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/sea.jpeg"));
		westLabel.setIcon(img);
		
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				JButton b = new JButton();
				West.add(b);
				

			}
		}
		frame.getContentPane().add(West, BorderLayout.WEST);

		JPanel East = new JPanel();
		East.setPreferredSize(new Dimension(240, 240));
		East.setLayout(new GridLayout(10, 10));
		
		JLabel eastLabel = new JLabel();
		eastLabel.setBounds(0, 0, 240, 240);
		East.add(eastLabel);
	//	eastLabel.setIcon(img);
		
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				JButton b = new JButton();
				East.add(b);
			
			}
		}
		frame.getContentPane().add(East, BorderLayout.EAST);

		JPanel South = new JPanel();
		South.setPreferredSize(new Dimension(500, 70));
		frame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(null);

		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnExit.setBounds(364, 11, 112, 23);
		South.add(btnExit);
		//btnExit.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e){  
	        //    exitMessage.setText("Are you sure you want exit the game? ");  
		//	}
	//	});
		
		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}

	/**
	 * Launch the application.
	 */
	public static void main(String args[])
	{
		Grid window = new Grid();
		window.frame.setVisible(true);
	}
	
	

	private JFrame frame;
}