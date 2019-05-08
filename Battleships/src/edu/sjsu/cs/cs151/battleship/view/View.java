package edu.sjsu.cs.cs151.battleship.view;

/*
	PlayerScreen 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class View extends Thread{

	/**
	 * Constructor.
	 */
	public View(int playerNumber)
	{
		this.playerNumber = playerNumber;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		/**
		 * Creates the frame.
		 */
		playerFrame = new JFrame("Battleships");
		playerFrame.setBounds(0, 0, 550, 550);
		playerFrame.setLocationRelativeTo(null);
		playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		playerFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(playerFrame.getClass().getResource("/cannonball.png")));
		
		/**
		 * Creates the North Panel.
		 */
		JPanel North = new JPanel();
		North.setBackground(Color.GRAY);
		North.setPreferredSize(new Dimension(500, 150));
		playerFrame.getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(null);

		/**
		 * Creates a button for the Next Player.
		 */
		nextPlayerButton = new JButton("NEXT PLAYER");
		nextPlayerButton.setBounds(413, 22, 112, 23);
		nextPlayerButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		nextPlayerButton.setForeground(new Color(255, 102, 51));
		North.add(nextPlayerButton);

		/**
		 * Creates a label for Score. 
		 * Will display score stats.
		 */
		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		scoreLabel.setBounds(20, 56, 33, 14);
		North.add(scoreLabel);

		/**
		 * Creates a label for Player.
		 */
		JLabel playerLabel = new JLabel("PLAYER: " + playerNumber);
		playerLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		playerLabel.setBounds(10, 31, 97, 14);
		North.add(playerLabel);

		/**
		 * Creates a label for Ships Left.
		 * Will display the number of ships left.
		 */
		JLabel shipsLeftLabel = new JLabel("Ships Left:");
		shipsLeftLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		shipsLeftLabel.setBounds(20, 81, 60, 14);
		North.add(shipsLeftLabel);

		/**
		 * Creates a label for Ships Hit.
		 * Will display the number of ships hit.
		 */
		JLabel lblShipsHit = new JLabel("Ships Hit:");
		lblShipsHit.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		lblShipsHit.setBounds(124, 81, 55, 14);
		North.add(lblShipsHit);

		/**
		 * Creates a label for the Player's grid.
		 */
		JLabel lblPlayer_1 = new JLabel("PLAYER");
		lblPlayer_1.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setBounds(88, 125, 91, 14);
		North.add(lblPlayer_1);

		/**
		 * Creates a label for the Opponent's grid.
		 */
		JLabel lblOpponent = new JLabel("OPPONENT");
		lblOpponent.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		lblOpponent.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent.setBounds(339, 125, 106, 14);
		North.add(lblOpponent);

		/**
		 * Creates a label for the score count.
		 */
		scoreCount = new JLabel("0");
		scoreCount.setBounds(60, 54, 21, 16);
		North.add(scoreCount);

		/**
		 * Creates a label for the ship left count.
		 */
		shipLeftCount = new JLabel("0");
		shipLeftCount.setBounds(86, 79, 21, 16);
		North.add(shipLeftCount);

		/**
		 * Creates a label for the ships hit count.
		 */
		JLabel shipsHitCount = new JLabel("0");
		shipsHitCount.setBounds(182, 79, 21, 16);
		North.add(shipsHitCount);
		
		/**
		 * Creates a label for the image of the sky.
		 */
		JLabel skyLabel = new JLabel("");
		skyLabel.setBounds(0, 0, 550, 150);
		skyLabel.setIcon(new ImageIcon(getClass().getResource("/sky.jpg")));
		North.add(skyLabel);
		
		
		//-----------------------------PlayerGrid-------------------------//

		//Player places ships onto player grid
		this.West = new JPanel(); // West panel of screen
		West.setBackground(new Color(70, 130, 180));
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


			}
		}
		playerFrame.getContentPane().add(West, BorderLayout.WEST);
		

	


		//-----------------------------OpponentGrid-------------------------//

		//Opponent Grid 
		JPanel East = new JPanel();
		East.setBackground(new Color(70, 130, 180));
		East.setPreferredSize(new Dimension(240, 240));
		East.setLayout(new GridLayout(10, 10));

		opponentButtonList = new ArrayList<JButton>();
		opponentButtonGrid = new JButton[10][10];
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{

				JButton b = new JButton();
				East.add(b);
				opponentButtonList.add(b);
				opponentButtonGrid[i][j] = b;
			}
		}
		playerFrame.getContentPane().add(East, BorderLayout.EAST);

		/**
		 * Creates the South panel.
		 */
		JPanel South = new JPanel();
		South.setBackground(new Color(70, 130, 180));
		South.setPreferredSize(new Dimension(500, 70));
		playerFrame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(null);
		
		//JLabel seaLabel = new JLabel("");
		
		/**
		 * H and V radio buttons for ship placement.
		 */
		JRadioButton carrierH = new JRadioButton("H");	
		carrierH.setBounds(74, 6, 50, 23);
		carrierH.setOpaque(false);
		carrierH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});


		carrierH.setBounds(76, 6, 50, 23);

		South.add(carrierH);

		JRadioButton battleshipH = new JRadioButton("H");
		battleshipH.setBounds(252, 6, 47, 23);
		battleshipH.setOpaque(false);
		battleshipH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});


		battleshipH.setBounds(242, 6, 50, 23);


		South.add(battleshipH);
		JRadioButton cruiserH = new JRadioButton("H");

		battleshipH.setBounds(242, 6, 50, 23);
		
		South.add(battleshipH);

		cruiserH.setBounds(76, 41, 50, 23);

<<<<<<< HEAD
		
		JRadioButton cruiserH = new JRadioButton("H");
		cruiserH.setBounds(96, 41, 50, 23);
=======
		cruiserH.setBounds(64, 41, 40, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		cruiserH.setOpaque(false);

		South.add(cruiserH);
		cruiserH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});

		JRadioButton destroyerH = new JRadioButton("H");
<<<<<<< HEAD
		destroyerH.setBounds(280, 41, 50, 23);
=======

		destroyerH.setBounds(242, 41, 50, 23);

		destroyerH.setBounds(229, 41, 40, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		destroyerH.setOpaque(false);

		South.add(destroyerH);
		destroyerH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});

		JRadioButton submarineH = new JRadioButton("H");
<<<<<<< HEAD
		submarineH.setBounds(442, 6, 50, 23);
=======

		submarineH.setBounds(413, 6, 50, 23);

		submarineH.setBounds(404, 6, 40, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		submarineH.setOpaque(false);

		South.add(submarineH);
		submarineH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
				isSubmarine = true;
			}
		});

		JLabel carrierLabel = new JLabel("5");
		carrierLabel.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon.png")));
		//carrierLabel.setIcon(new ImageIcon("/Users/maryammostafavi/Downloads/battleship (1).png"));
		carrierLabel.setSize(10, 10);
		carrierLabel.setBounds(6, 10, 77, 16);
		South.add(carrierLabel);

		JRadioButton carrierV = new JRadioButton("V");

		carrierV.setBounds(118, 6, 47, 23);

		carrierV.setBounds(101, 6, 47, 23);
		carrierV.setOpaque(false);

		South.add(carrierV);
		carrierV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});

		JLabel battleShipLabel = new JLabel("4");
		battleShipLabel.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon4.png")));
		battleShipLabel.setBounds(170, 10, 85, 16);
		South.add(battleShipLabel);

		JRadioButton battleShipV = new JRadioButton("V");
<<<<<<< HEAD
		battleShipV.setBounds(292, 6, 47, 23);
		//battleShipV.setBounds(268, 6, 47, 23);
=======

		battleShipV.setBounds(293, 6, 47, 23);

		battleShipV.setBounds(268, 6, 47, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		battleShipV.setOpaque(false);

		South.add(battleShipV);
		battleShipV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});

		JLabel lblCruiser = new JLabel("3");
		lblCruiser.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon2.png")));
		lblCruiser.setBounds(6, 45, 85, 16);
		South.add(lblCruiser);


		JRadioButton cruiserV = new JRadioButton("V");
<<<<<<< HEAD
		cruiserV.setBounds(139, 41, 47, 23);
		//cruiserV.setBounds(101, 41, 47, 23);
=======

		cruiserV.setBounds(118, 41, 47, 23);

		cruiserV.setBounds(101, 41, 47, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		cruiserV.setOpaque(false);

		South.add(cruiserV);
		cruiserV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});
		JLabel lblDestoryer = new JLabel("2");
		lblDestoryer.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon3.png")));
		lblDestoryer.setBounds(198, 45, 77, 16);
		South.add(lblDestoryer);

		JRadioButton destroyerV = new JRadioButton("V");
<<<<<<< HEAD
		destroyerV.setBounds(329, 41, 50, 23);
		//destroyerV.setBounds(268, 41, 43, 23);
=======

		destroyerV.setBounds(293, 41, 43, 23);

		destroyerV.setBounds(268, 41, 43, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		destroyerV.setOpaque(false);

		South.add(destroyerV);
		destroyerV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});

		JLabel lblSubmarine = new JLabel("3");
		lblSubmarine.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon2.png")));
		lblSubmarine.setBounds(363, 10, 77, 16);
		South.add(lblSubmarine);

		JRadioButton submarineV = new JRadioButton("V");

<<<<<<< HEAD
		submarineV.setBounds(504, 6, 40, 23);
		//submarineV.setBounds(442, 6, 40, 23);
=======

		submarineV.setBounds(454, 6, 40, 23);

		submarineV.setBounds(442, 6, 40, 23);
>>>>>>> ee300e4fe630b912f079f2cdb53f596ca342d362
		submarineV.setOpaque(false);

		South.add(submarineV);
		submarineV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
				isSubmarine = true;
			}
		});

		//Button gives player the option to exit the game.


		JButton extButton = new JButton("EXIT");
		extButton.setBounds(438, 43, 112, 23);
		extButton.setForeground(Color.RED);
		extButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		South.add(extButton);
		
		JLabel seaLabel = new JLabel("");
		seaLabel.setBounds(0, 0, 550, 70);
		seaLabel.setIcon(new ImageIcon(getClass().getResource("/sea1.jpg")));
		South.add(seaLabel);
		
		JLabel middleSea = new JLabel("");
		middleSea.setIcon(null);
		middleSea.setIcon(new ImageIcon(getClass().getResource("/sea1.jpg")));
		playerFrame.getContentPane().add(middleSea, BorderLayout.CENTER);
		extButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
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

		exitButton = new JButton("EXIT");
		exitButton.setBounds(363, 35, 112, 23);
		exitButton.setForeground(Color.RED);
		exitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));


		South.add(exitButton);
	


		South.add(exitButton);	

	};

	public JButton getExitButton()
	{
		return exitButton;
	}
	
	public ArrayList<JButton> getbuttonList()
	{
		return buttonList;
	}

	public JButton[][] getJButtonGrid()
	{
		return buttonGrid;
	}


	public JPanel getWestPanel()
	{
		return West;
	}

	public JPanel getPlayerGrid()
	{
		return this.West;
	}


	public JButton[][] getButtonGrid()
	{
		return buttonGrid;
	}

	public ArrayList<JButton> getJButtonList()
	{
		return buttonList;
	}
	private static void makeFrameFullSize(JFrame aFrame)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
	}

	public int getAlignment()
	{
		return alignment;
	}

	public boolean getIsSubmarine()
	{
		return isSubmarine;
	}

	public int getShipLength()
	{
		return shipLength;
	}

	public JLabel getShipLeftCount()
	{
		return shipLeftCount;
	}

	public JButton getNextPlayerButton()
	{
		return nextPlayerButton;
	}

	public boolean[] getshipCheck()
	{
		return shipCheck;
	}

	public boolean isShipThere(int i)
	{
		return shipCheck[i]== true;
	}
	public void initializeArray(boolean[] shipCheck2)
	{
		for (int i = 0; i <shipCheck2.length; i++)
		{
			shipCheck2[i] = false;
		}
	}

	public void updateShipCounter()
	{
		shipLeftCounter++;
	}

	public Integer getShipCounter()
	{
		return shipLeftCounter;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	public void setShipCheck(boolean[] newShipCheck)
	{
		shipCheck = newShipCheck;
	}

	public ArrayList<JButton> getOpponentButtonList()
	{
		return opponentButtonList;
	}
	public JButton[][] getOpponentGrid()
	{
		return opponentButtonGrid;
	}

	public Integer getScoreNum()
	{
		return scoreNum;
	}

	public void updateScoreNum()
	{
		scoreNum++;
	}
	public JLabel getScoreCount()
	{
		return scoreCount;
	}
	
	public int getScreenWidth1()
	{
		return screenWidth;
	}
	
	public int getScreenHeight()
	{
		return screenHeight;
	}
	public static void player1Screen(View player1)
	{
		player1.playerFrame.setBounds(0, 0, 500, 500);
	}
	private ArrayList<JButton> opponentButtonList;
	private JButton[][] opponentButtonGrid;
	private Integer  shipLeftCounter = 0;;
	private JButton[][] buttonGrid;
	public  JFrame playerFrame;
	private Integer scoreNum = 0;
	private int shipLeft = 0;
	private int shipLength = 0;
	private int alignment = 0;
	private static final int HORIZONTAL  = 0;
	private static final int VERTICAL = -1;
	private ArrayList<JButton> buttonList;
	private boolean isSubmarine  = false;
	private int playerNumber;
	private JPanel West;
	private JLabel shipLeftCount;
	private JButton nextPlayerButton;
	public View player2;	
	private boolean [] shipCheck = new boolean[8];
	private int row = 0; 
	private int col = 0;
	private JLabel scoreCount;
	private JButton exitButton;
	
	private int screenWidth;
	private int screenHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String args[])
	{

		View player1 = new View(1);
		System.out.print(player1.playerNumber);
		player1.playerFrame.setVisible(true);
		View player2 = new View(2);

	}
}

