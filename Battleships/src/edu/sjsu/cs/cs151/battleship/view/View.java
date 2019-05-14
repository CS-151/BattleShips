package edu.sjsu.cs.cs151.battleship.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
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
		playerFrame.setSize(500, 500);
		playerFrame.setLocationRelativeTo(null);
		playerFrame.setResizable(false);
		playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		playerFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(playerFrame.getClass().getResource("/cannonball.png")));

		/**
		 * Creates the North Panel.
		 */
		JPanel North = new JPanel();
		North.setBackground(Color.GRAY);
		North.setPreferredSize(new Dimension(500, 120));
		playerFrame.getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(null);

		/**
		 * Creates a label for Player.
		 */
		JLabel playerLabel = new JLabel("PLAYER: " + playerNumber);
		playerLabel.setFont(new Font("Iowan Old Style", Font.BOLD, 13));
		playerLabel.setForeground(new Color(246, 214, 124));
		playerLabel.setBounds(20, 20, 95, 15);
		North.add(playerLabel);

		/**
		 * Creates a label for Score. 
		 * Will display score stats.
		 */
		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		scoreLabel.setForeground(new Color(246, 214, 124));
		scoreLabel.setBounds(20, 40, 35, 15);
		North.add(scoreLabel);

		/**
		 * Creates a label for the Player's grid.
		 */
		JLabel player = new JLabel("PLAYER");
		player.setFont(new Font("Iowan Old Style", Font.BOLD, 13));
		player.setForeground(new Color(246, 214, 124));
		player.setHorizontalAlignment(SwingConstants.CENTER);
		player.setBounds(75, 95, 91, 15);
		North.add(player);

		/**
		 * Creates a label for the Opponent's grid.
		 */
		JLabel opponent = new JLabel("OPPONENT");
		opponent.setFont(new Font("Iowan Old Style", Font.BOLD, 13));
		opponent.setForeground(new Color(246, 214, 124));
		opponent.setHorizontalAlignment(SwingConstants.CENTER);
		opponent.setBounds(310, 95, 106, 15);
		North.add(opponent);

		/**
		 * Creates a label for the score count.
		 */
		scoreCount = new JLabel("0");
		scoreCount.setForeground(new Color(246, 214, 124));
		scoreCount.setBounds(60, 40, 21, 16);
		North.add(scoreCount);

		/**
		 * Creates a label for the image of the sky.
		 */
		JLabel skyLabel = new JLabel("");
		skyLabel.setBounds(0, 0, 500, 150);
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
				button.setMargin(new Insets(0, 0, 0, 0));
				West.add(button);		//Button object added to West panel of screen
				buttonList.add(button);	//Add button to list
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
				b.setMargin(new Insets(0, 0, 0, 0));
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
		South.setPreferredSize(new Dimension(500, 100));
		playerFrame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(null);

		/**
		 * CARRIER 5
		 */
		JLabel carrierLabel = new JLabel("5");
		carrierLabel.setForeground(Color.WHITE);
		carrierLabel.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon.png")));
		carrierLabel.setBounds(5, 10, 75, 15);
		South.add(carrierLabel);

		JRadioButton carrierH = new JRadioButton("H");	
		carrierH.setForeground(Color.WHITE);
		carrierH.setBounds(80, 8, 50, 20);
		carrierH.setOpaque(false);
		carrierH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});
		South.add(carrierH);

		JRadioButton carrierV = new JRadioButton("V");
		carrierV.setForeground(Color.WHITE);
		carrierV.setBounds(130, 8, 50, 20);
		carrierV.setOpaque(false);
		carrierV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});
		South.add(carrierV);

		/**
		 * BATTLESHIP 4
		 */
		JLabel battleShipLabel = new JLabel("   4");
		battleShipLabel.setForeground(Color.WHITE);
		battleShipLabel.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon4.png")));
		battleShipLabel.setBounds(180, 10, 75, 15);
		South.add(battleShipLabel);

		JRadioButton battleshipH = new JRadioButton("H");
		battleshipH.setForeground(Color.WHITE);
		battleshipH.setBounds(255, 10, 50, 20);
		battleshipH.setOpaque(false);
		battleshipH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});
		South.add(battleshipH);

		JRadioButton battleShipV = new JRadioButton("V");
		battleShipV.setForeground(Color.WHITE);
		battleShipV.setBounds(305, 10, 50, 20);
		battleShipV.setOpaque(false);
		battleShipV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});
		South.add(battleShipV);

		/**
		 * CRUISER 3
		 */
		JLabel lblCruiser = new JLabel("3");
		lblCruiser.setForeground(Color.WHITE);
		lblCruiser.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon2.png")));
		lblCruiser.setBounds(5, 40, 75, 15);
		South.add(lblCruiser);

		JRadioButton cruiserH = new JRadioButton("H");
		cruiserH.setForeground(Color.WHITE);
		cruiserH.setBounds(80, 40, 50, 20);
		cruiserH.setOpaque(false);
		cruiserH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});
		South.add(cruiserH);

		JRadioButton cruiserV = new JRadioButton("V");
		cruiserV.setForeground(Color.WHITE);
		cruiserV.setBounds(130, 40, 50, 20);
		cruiserV.setOpaque(false);
		cruiserV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});
		South.add(cruiserV);

		/**
		 * SUBMARINE 3
		 */
		JLabel lblSubmarine = new JLabel("3");
		lblSubmarine.setForeground(Color.WHITE);
		lblSubmarine.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon2.png")));
		lblSubmarine.setBounds(180, 40, 75, 15);
		South.add(lblSubmarine);

		JRadioButton submarineH = new JRadioButton("H");
		submarineH.setForeground(Color.WHITE);
		submarineH.setBounds(255, 40, 50, 20);
		submarineH.setOpaque(false);
		submarineH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
				isSubmarine = true;
			}
		});
		South.add(submarineH);

		JRadioButton submarineV = new JRadioButton("V");
		submarineV.setForeground(Color.WHITE);
		submarineV.setBounds(305, 40, 50, 20);
		submarineV.setOpaque(false);
		submarineV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
				isSubmarine = true;
			}
		});
		South.add(submarineV);

		/**
		 * DESTROYER 2
		 */
		JLabel lblDestoryer = new JLabel("   2");
		lblDestoryer.setForeground(Color.WHITE);
		lblDestoryer.setIcon(new ImageIcon(getClass().getResource("/battleshipIcon3.png")));
		lblDestoryer.setBounds(5, 70, 75, 15);
		South.add(lblDestoryer);

		JRadioButton destroyerH = new JRadioButton("H");
		destroyerH.setForeground(Color.WHITE);
		destroyerH.setBounds(80, 70, 50, 20);
		destroyerH.setOpaque(false);
		destroyerH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});
		South.add(destroyerH);

		JRadioButton destroyerV = new JRadioButton("V");
		destroyerV.setForeground(Color.WHITE);
		destroyerV.setBounds(130, 70, 50, 20);
		destroyerV.setOpaque(false);
		destroyerV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});
		South.add(destroyerV);

		JLabel seaLabel = new JLabel("");
		seaLabel.setBounds(0, 0, 500, 100);
		seaLabel.setIcon(new ImageIcon(getClass().getResource("/sea1.jpg")));
		South.add(seaLabel);

		JLabel middleSea = new JLabel("");
		middleSea.setIcon(null);
		middleSea.setIcon(new ImageIcon(getClass().getResource("/sea1.jpg")));
		playerFrame.getContentPane().add(middleSea, BorderLayout.CENTER);

		//Button gives player the option to exit the game.
		JButton extButton = new JButton("EXIT");
		extButton.setBounds(370, 60, 110, 25);
		extButton.setForeground(Color.RED);
		extButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		South.add(extButton);

		seaLabel.setBounds(0, 0, 500, 100);
		seaLabel.setIcon(new ImageIcon(getClass().getResource("/sea1.jpg")));
		South.add(seaLabel);

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
	};
	/**
	 * gets the exit button
	 * @return exit button 
	 */
	public JButton getExitButton()
	{
		return exitButton;
	}
	/**
	 * Gets the list of buttons
	 * @return buttonList
	 */
	public ArrayList<JButton> getbuttonList()
	{
		return buttonList;
	}
	/**
	 * Gets the buttons grid
	 * @return buttonGrid 
	 */
	public JButton[][] getJButtonGrid()
	{
		return buttonGrid;
	}

	/**
	 * returns the west panel
	 * @return West
	 */
	public JPanel getWestPanel()
	{
		return West;
	}
	/**
	 * gets the the player grid 
	 * @return West
	 */
	public JPanel getPlayerGrid()
	{
		return this.West;
	}


	/**
	 * gets the button grid
	 * @return buttonGrid
	 */
	public JButton[][] getButtonGrid()
	{
		return buttonGrid;
	}
	/**
	 * gets the buttons list
	 * @return buttonList
	 */
	public ArrayList<JButton> getJButtonList()
	{
		return buttonList;
	}
	/**
	 * gets the alignment 
	 * @return alignment
	 */
	public int getAlignment()
	{
		return alignment;
	}
	/**
	 * Determines whether it is a submarine or not
	 * @return isSubmarine
	 */
	public boolean getIsSubmarine()
	{
		return isSubmarine;
	}
	/**
	 * gets the ship length
	 * @return shipLength
	 */
	public int getShipLength()
	{
		return shipLength;
	}
	/**
	 * gets the next player button
	 * @return nextPlayerButton 
	 */

	public JButton getNextPlayerButton()
	{
		return nextPlayerButton;
	}
	/**
	 * Determines wheter it has a ship
	 * @return shipCheck
	 */
	public boolean[] getshipCheck()
	{
		return shipCheck;
	}
	/**
	 * Determines whether a ship is there 
	 * @param i
	 * @return true or false
	 */
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
	/**
	 * updates the ship counter 
	 */
	public void updateShipCounter()
	{
		shipLeftCounter++;
	}
	/**
	 * gets the ship counter
	 * @return shipLeftCounter
	 */
	public Integer getShipCounter()
	{
		return shipLeftCounter;
	}
	/**
	 * gets the player number
	 * @return playerNumber 
	 */
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	/**
	 * gets the row
	 * @return row 
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * gets the column 
	 * @return col
	 */
	public int getCol()
	{
		return col;
	}
	/**
	 * sets a ship
	 * @param newShipCheck
	 */
	public void setShipCheck(boolean[] newShipCheck)
	{
		shipCheck = newShipCheck;
	}
	/**
	 * gets the opponent's button list 
	 * @return opponentButtonList
	 */
	public ArrayList<JButton> getOpponentButtonList()
	{
		return opponentButtonList;
	}
	/**
	 * gets the opponent grid 
	 * @return opponentButtonGrid
	 */
	public JButton[][] getOpponentGrid()
	{
		return opponentButtonGrid;
	}
	/**
	 * gets the score number
	 * @return scoreNum
	 */
	public Integer getScoreNum()
	{
		return scoreNum;
	}
	/**
	 * updates the score number 
	 * 
	 */
	public void updateScoreNum()
	{
		scoreNum++;
	}
	/**
	 * gets the score count 
	 * @return scoreCount
	 */
	public JLabel getScoreCount()
	{
		return scoreCount;
	}
	/**
	 * player screen bounds 
	 * @param player1
	 */
	public static void player1Screen(View player1)
	{
		player1.playerFrame.setBounds(0, 0, 550, 550);
	}
	/**
	 * determines whether the next player is ready to guess
	 * @return isReadyToGuess
	 */
	public boolean getIsReadyToGuess()
	{
		return isReadyToGuess;
	}
	/**
	 * sets the guess
	 * @param isReady
	 */
	public void setToGuess(boolean isReady)
	{
		isReadyToGuess = isReady;
	}
	/**
	 * Private instances 
	 */
	public  JFrame playerFrame;
	private ArrayList<JButton> buttonList;
	private ArrayList<JButton> opponentButtonList;
	private JButton[][] buttonGrid, opponentButtonGrid;
	private Integer shipLeftCounter = 0, scoreNum = 0;
	private int playerNumber, shipLength = 0, alignment = 0, row = 0, col = 0;
	private static final int HORIZONTAL  = 0;
	private static final int VERTICAL = -1;
	private boolean isSubmarine  = false;
	private JPanel West;
	private JButton nextPlayerButton, exitButton;
	public View player2;	
	private boolean [] shipCheck = new boolean[8];
	private JLabel scoreCount;
	private boolean isReadyToGuess = false;
}
