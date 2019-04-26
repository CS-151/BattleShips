package edu.sjsu.cs.cs151.battleship.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.sjsu.cs.cs151.battleship.model.Grid;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PlayerScreen {

	/**
	 * Constructor.
	 */
	public PlayerScreen()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		playerFrame = new JFrame();
		playerFrame.setBounds(0, 0, 500, 500);
		playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel North = new JPanel();
		North.setPreferredSize(new Dimension(500, 150));
		playerFrame.getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(null);

		JButton btnNextPlayer = new JButton("NEXT PLAYER...");
		btnNextPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerFrame.dispose();
				//WelcomeScreenTester2 w = new WelcomeScreenTester2();
				//Transition t = new Transition();
				//t.setVisible(true);
			}
		});
		btnNextPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnNextPlayer.setBounds(363, 17, 112, 23);
		North.add(btnNextPlayer);

		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		scoreLabel.setBounds(20, 56, 33, 14);
		North.add(scoreLabel);

		JLabel playerLabel = new JLabel("PLAYER 1");
		playerLabel.setBounds(10, 31, 97, 14);
		North.add(playerLabel);

		JLabel shipsLeftLabel = new JLabel("Ships Left:");
		shipsLeftLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		shipsLeftLabel.setBounds(20, 81, 60, 14);
		North.add(shipsLeftLabel);

		JLabel lblShipsHit = new JLabel("Ships Hit:");
		lblShipsHit.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblShipsHit.setBounds(124, 81, 55, 14);
		North.add(lblShipsHit);

		JLabel lblPlayer_1 = new JLabel("PLAYER");
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setBounds(88, 125, 91, 14);
		North.add(lblPlayer_1);

		JLabel lblOpponent = new JLabel("OPPONENT");
		lblOpponent.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent.setBounds(339, 125, 106, 14);
		North.add(lblOpponent);
		
		JLabel scoreCount = new JLabel("0");
		scoreCount.setBounds(60, 54, 21, 16);
		North.add(scoreCount);
		
		JLabel shipLeftCount = new JLabel("0");
		shipLeftCount.setBounds(86, 79, 21, 16);
		North.add(shipLeftCount);
		
		JLabel shipsHitCount = new JLabel("0");
		shipsHitCount.setBounds(182, 79, 21, 16);
		North.add(shipsHitCount);

		
		//PlayerGrid
		JPanel West = new JPanel();
		West.setPreferredSize(new Dimension(240, 240));
		West.setLayout(new GridLayout(10, 10));
		ArrayList<JButton> buttonList = new ArrayList<JButton>();
		JButton[][] buttonGrid = new JButton[10][10];
		for (int i = 0; i < 10; i++)
		{
			row = i;
			for (int j = 0; j < 10; j++)
			{
				col = j;
				JButton b = new JButton();				
				West.add(b);
				buttonList.add(b);
				buttonGrid[i][j] = b;
				System.out.println("alighnment: " + alignment);

				///Listener event that places "X" on grids
				// that have been clicked
				b.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent arg0)
					{
						System.out.println("Coordinate: " + buttonList.indexOf(b) );
						System.out.println("ShipLength: " + shipLength );
						int temp = buttonList.indexOf(b);
						if(alignment == HORIZONTAL)
						{
							for( int index  = 0 ; index < shipLength; index++)
							{
								System.out.println("Index: " +(buttonList.indexOf(b) +index));
								
								System.out.println("alighnment: " + alignment);

									buttonList.get(buttonList.indexOf(b) + index);
									buttonList.get((buttonList.indexOf(b) + index)).setText("X");
							}
						}
						else
						{
							for( int index  = 0 ; index < shipLength*10; index = index + 10)
							{
								System.out.println("Index: " +(buttonList.indexOf(b) +index));
								System.out.println("alighnment: " + alignment);
									buttonList.get(buttonList.indexOf(b) + index);
									buttonList.get((buttonList.indexOf(b) + index)).setText("X");
							}
						}
					System.out.println("========");
					}
				});
			}
		}
		playerFrame.getContentPane().add(West, BorderLayout.WEST);

		
		//Opponent Grid 
		JPanel East = new JPanel();
		East.setPreferredSize(new Dimension(240, 240));
		East.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				
				JButton b = new JButton();
				East.add(b);
				
				
				///Listener event that places "X" on grids
				// that have been clicked
				b.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						if(!b.getText().equals("X"))
						{
							//Prevents from counting double clicks
							scoreNum++;
						}
						b.setText("X");
						String score = scoreNum.toString();
						scoreCount.setText(score);
					}
				});
			}
		}
		playerFrame.getContentPane().add(East, BorderLayout.EAST);

		JPanel South = new JPanel();
		South.setPreferredSize(new Dimension(500, 70));
		playerFrame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(null);
		
		
		JRadioButton carrierH = new JRadioButton("H");		
		carrierH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = HORIZONTAL;
			}
		});
		
		carrierH.setBounds(64, 6, 47, 23);
		South.add(carrierH);
		
		JRadioButton battleshipH = new JRadioButton("H");
		battleshipH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = HORIZONTAL;
			}
		});
		battleshipH.setBounds(229, 6, 47, 23);
		South.add(battleshipH);
		
		JRadioButton cruiserH = new JRadioButton("H");
		cruiserH.setBounds(64, 41, 47, 23);
		South.add(cruiserH);
		cruiserH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
			}
		});
		
		JRadioButton destroyerH = new JRadioButton("H");
		destroyerH.setBounds(229, 41, 42, 23);
		South.add(destroyerH);
		destroyerH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = HORIZONTAL;
			}
		});
		
		JRadioButton submarineH = new JRadioButton("H");
		submarineH.setBounds(404, 6, 47, 23);
		South.add(submarineH);
		submarineH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
			}
		});
		
		JLabel carrierLabel = new JLabel("Carrier(5)");
		carrierLabel.setBounds(6, 10, 63, 16);
		South.add(carrierLabel);
		
		JRadioButton carrierV = new JRadioButton("V");
		carrierV.setBounds(101, 6, 47, 23);
		South.add(carrierV);
		carrierV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = VERTICAL;
			}
		});
		
		JLabel lblNewLabel = new JLabel("BattleShip(4)");
		lblNewLabel.setBounds(149, 10, 85, 16);
		South.add(lblNewLabel);
		
		JRadioButton battleShipV = new JRadioButton("V");
		battleShipV.setBounds(268, 6, 47, 23);
		South.add(battleShipV);
		battleShipV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = VERTICAL;
			}
		});
		
		JLabel lblCruiser = new JLabel("Cruiser(3)");
		lblCruiser.setBounds(6, 45, 61, 16);
		South.add(lblCruiser);
		
		
		JRadioButton cruiserV = new JRadioButton("V");
		cruiserV.setBounds(101, 41, 47, 23);
		South.add(cruiserV);
		cruiserV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
			}
		});
		JLabel lblDestoryer = new JLabel("Destoryer(2)");
		lblDestoryer.setBounds(149, 45, 77, 16);
		South.add(lblDestoryer);
		
		JRadioButton destroyerV = new JRadioButton("V");
		destroyerV.setBounds(268, 41, 43, 23);
		South.add(destroyerV);
		destroyerV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = VERTICAL;
			}
		});
		
		JLabel lblSubmarine = new JLabel("Submarine(3)");
		lblSubmarine.setBounds(318, 10, 85, 16);
		South.add(lblSubmarine);
		
		JRadioButton submarineV = new JRadioButton("V");
		submarineV.setBounds(442, 6, 40, 23);
		South.add(submarineV);
		submarineV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
			}
		});
		

	}

	/**
	 * Launch the application.
	 */
	public static void main(String args[])
	{
		PlayerScreen window = new PlayerScreen();
		window.playerFrame.setVisible(true);
	}

	public static JFrame playerFrame;
	private Integer scoreNum = 0;
	private int row = 0;
	private int col = 0;
	private int shipLeft = 0;
	private int shipLength = 0;
	private int alignment = 0;
	private static final int HORIZONTAL  = 0;
	private static final int VERTICAL = -1;
}
