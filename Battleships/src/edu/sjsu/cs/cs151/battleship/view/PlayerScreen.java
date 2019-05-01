package edu.sjsu.cs.cs151.battleship.view;

/*
	PlayerScreen 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
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
		
		//Player places ships onto player grid
		JPanel West = new JPanel(); // West panel of screen
		West.setPreferredSize(new Dimension(240, 240));
		West.setLayout(new GridLayout(10, 10));// 10 X 10 Grid
		
		//List to store buttons
		buttonList = new ArrayList<JButton>(); 
		buttonGrid = new JButton[10][10];
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				JButton button = new JButton(); // Instance of Button	
				
				//Button object added to West panel of screen
				West.add(button);
				
				//Add button to list
				buttonList.add(button);
				buttonGrid[i][j] = button;

				///Add ActionListener event that places "X" on grids
				// on buttons that have been clicked
				button.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent arg0)
					{
						System.out.println("Coordinate: " + buttonList.indexOf(button) );
						System.out.println("ShipLength: " + shipLength );
						
						//Checks whether the alignment the user clicked was 
						// Horizontal 
						if(alignment == HORIZONTAL)
						{
							//Checks if there is space for the selected option
							if(isSpace(shipLength, button) && !isOutOfBounds(shipLength, button))
							{
								//Since there is space, the block of buttons would marked
								// as placed Horizontally
								for( int index  = 0 ; index < shipLength; index++)
								{
									System.out.println("Index: " +(buttonList.indexOf(button) +index));
										
										buttonList.get(buttonList.indexOf(button) + index);
										buttonList.get((buttonList.indexOf(button) + index)).setText("X");
								}
							}
						}
						else
						{
							// User did not select Horizontal, therefore it is 
							// Vertical
							if(isSpace(shipLength, button))
							{
								//Adds ships vertically
								for( int index  = 0 ; index < shipLength*10; index = index + 10)
								{
									System.out.println("Index: " +(buttonList.indexOf(button) +index));
									System.out.println("alighnment: " + alignment);
										buttonList.get(buttonList.indexOf(button) + index);
										buttonList.get((buttonList.indexOf(button) + index)).setText("X");
								}
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
		
		JButton extButton = new JButton("EXIT");
		extButton.setBounds(377, 40, 117, 29);
		South.add(extButton);
		extButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JDialog dialog = new JDialog(playerFrame,"EXIT" );
			JLabel extLabel = new JLabel("Are you sure you want to exit the game?");
			dialog.setBounds(200, 200, 100, 100);
			dialog.add(extLabel);
			dialog.setSize(100, 100);
			dialog.setVisible(true);
			
		//	JButton yesBtn = new JButton("Yes");
			//yesBtn.setBounds(377, 40, 117, 29);
		//	JButton noBtn = new JButton("No");
		//	noBtn.setBounds(370, 40, 117, 29);
		//	dialog.add(yesBtn);
			
		//	dialog.add(noBtn);
			}
		});
		
		
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

	public ArrayList<JButton> getbuttonList()
	{
		return buttonList;
	}
	
	public JButton[][] getJButtonGrid()
	{
		return buttonGrid;
	}
	
	/*
	 * Helper method that check whether the given ship would fit on to the 
	 * selected JButton 
	 * @param shipLength the length of the ship
	 * @param button the first button that is clicked (the head of the ship)
	 * @result true/false boolean output determining whether there is space
	 */
	public boolean isSpace(int shipLength, JButton button)
	{
		if(alignment == HORIZONTAL)
		{
			for( int index  = 0 ; index < shipLength; index++)
			{
					if(buttonList.get((buttonList.indexOf(button) + index)).getText().equals("X"))
					{
						return false;
					}					
			}
			return true;
		}
		else
		{
			for( int index  = 0 ; index < shipLength*10; index = index + 10)
			{
					if(buttonList.get((buttonList.indexOf(button) + index)).getText().equals("X"))
					{
						return false;
					}
			}
		return true;
			
		}
	}
	
	/*
	 * Helper method that check whether the given ship would go 
	 * out of bounds from the grid
	 * @param shipLength the length of the ship
	 * @param button the first button that is clicked (the head of the ship)
	 * @result true/false boolean output determining whether the ship would be out of bounds.
	 */
	public boolean isOutOfBounds(int shipLength, JButton button)
	{
		for( int index  = 0 ; index < shipLength-1; index++)
		{
				if(((buttonList.indexOf(button) + index)%10 == 9))
				{
					return true;
				}					
		}
		return false;
	}
	
	
	private ArrayList<Integer> shipCheck;
	private JButton[][] buttonGrid;
	public static JFrame playerFrame;
	private Integer scoreNum = 0;
	private int row = 0;
	private int col = 0;
	private int shipLeft = 0;
	private int shipLength = 0;
	private int alignment = 0;
	private static final int HORIZONTAL  = 0;
	private static final int VERTICAL = -1;
	private ArrayList<JButton> buttonList;
}
