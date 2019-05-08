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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import edu.sjsu.cs.cs151.battleship.model.Grid;
import javax.swing.JTextField;
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
		playerFrame = new JFrame("Battleships");
		playerFrame.setBounds(0, 0, 500, 500);
		playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		playerFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(playerFrame.getClass().getResource("/cannonball.png")));

		JPanel North = new JPanel();
		North.setBackground(Color.GRAY);
		North.setPreferredSize(new Dimension(500, 150));
		playerFrame.getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(null);

		nextPlayerButton = new JButton("NEXT PLAYER");
		nextPlayerButton.setBounds(363, 17, 112, 23);
		nextPlayerButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		nextPlayerButton.setForeground(new Color(255, 102, 51));
		North.add(nextPlayerButton);

		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		scoreLabel.setBounds(20, 56, 33, 14);
		North.add(scoreLabel);

		JLabel playerLabel = new JLabel("PLAYER: " + playerNumber);
		playerLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		playerLabel.setBounds(10, 31, 97, 14);
		North.add(playerLabel);

		JLabel shipsLeftLabel = new JLabel("Ships Left:");
		shipsLeftLabel.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		shipsLeftLabel.setBounds(20, 81, 60, 14);
		North.add(shipsLeftLabel);

		JLabel lblShipsHit = new JLabel("Ships Hit:");
		lblShipsHit.setFont(new Font("Iowan Old Style", Font.PLAIN, 11));
		lblShipsHit.setBounds(124, 81, 55, 14);
		North.add(lblShipsHit);

		JLabel lblPlayer_1 = new JLabel("PLAYER");
		lblPlayer_1.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setBounds(88, 125, 91, 14);
		North.add(lblPlayer_1);

		JLabel lblOpponent = new JLabel("OPPONENT");
		lblOpponent.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		lblOpponent.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent.setBounds(339, 125, 106, 14);
		North.add(lblOpponent);

		scoreCount = new JLabel("0");
		scoreCount.setBounds(60, 54, 21, 16);
		North.add(scoreCount);


		shipLeftCount = new JLabel("0");
		shipLeftCount.setBounds(86, 79, 21, 16);
		North.add(shipLeftCount);

		JLabel shipsHitCount = new JLabel("0");
		shipsHitCount.setBounds(182, 79, 21, 16);
		North.add(shipsHitCount);
		
		JLabel skyLabel = new JLabel("");
		skyLabel.setBounds(0, 0, 500, 150);
		skyLabel.setIcon(new ImageIcon(getClass().getResource("/sky.jpg")));
		North.add(skyLabel);
		
		
		//-----------------------------PlayerGrid-------------------------//

		//Player places ships onto player grid
		this.West = new JPanel(); // West panel of screen
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

		JPanel South = new JPanel();
		South.setBackground(new Color(70, 130, 180));
		South.setPreferredSize(new Dimension(500, 70));
		playerFrame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(null);
		
		//JLabel seaLabel = new JLabel("");
		
	
		JRadioButton carrierH = new JRadioButton("H");		
		carrierH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});

		carrierH.setBounds(64, 6, 47, 23);
		South.add(carrierH);

		JRadioButton battleshipH = new JRadioButton("H");
		battleshipH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = HORIZONTAL;
				isSubmarine = false;
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
				isSubmarine = false;
			}
		});

		JRadioButton destroyerH = new JRadioButton("H");
		destroyerH.setBounds(229, 41, 42, 23);
		South.add(destroyerH);
		destroyerH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = HORIZONTAL;
				isSubmarine = false;
			}
		});

		JRadioButton submarineH = new JRadioButton("H");
		submarineH.setBounds(404, 6, 47, 23);
		South.add(submarineH);
		submarineH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = HORIZONTAL;
				isSubmarine = true;
			}
		});

		JLabel carrierLabel = new JLabel("5");
		carrierLabel.setIcon(new ImageIcon(getClass().getResource("/shiplabel.png")));
		//carrierLabel.setIcon(new ImageIcon("/Users/maryammostafavi/Downloads/battleship (1).png"));
		carrierLabel.setSize(10, 10);
		carrierLabel.setBounds(6, 10, 63, 16);
		South.add(carrierLabel);

		JRadioButton carrierV = new JRadioButton("V");
		carrierV.setBounds(101, 6, 47, 23);
		South.add(carrierV);
		carrierV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 5;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});

		JLabel battleShipLabel = new JLabel("4");
		battleShipLabel.setIcon(new ImageIcon(getClass().getResource("/shiplabel.png")));
		battleShipLabel.setBounds(149, 10, 85, 16);
		South.add(battleShipLabel);

		JRadioButton battleShipV = new JRadioButton("V");
		battleShipV.setBounds(268, 6, 47, 23);
		South.add(battleShipV);
		battleShipV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 4;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});

		JLabel lblCruiser = new JLabel("3");
		lblCruiser.setIcon(new ImageIcon(getClass().getResource("/shiplabel.png")));
		lblCruiser.setBounds(6, 45, 61, 16);
		South.add(lblCruiser);


		JRadioButton cruiserV = new JRadioButton("V");
		cruiserV.setBounds(101, 41, 47, 23);
		South.add(cruiserV);
		cruiserV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 3;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});
		JLabel lblDestoryer = new JLabel("2");
		lblDestoryer.setIcon(new ImageIcon(getClass().getResource("/shiplabel.png")));
		lblDestoryer.setBounds(149, 45, 77, 16);
		South.add(lblDestoryer);

		JRadioButton destroyerV = new JRadioButton("V");
		destroyerV.setBounds(268, 41, 43, 23);
		South.add(destroyerV);
		destroyerV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shipLength = 2;
				alignment = VERTICAL;
				isSubmarine = false;
			}
		});

		JLabel lblSubmarine = new JLabel("3");
		lblSubmarine.setIcon(new ImageIcon(getClass().getResource("/shiplabel.png")));
		lblSubmarine.setBounds(318, 10, 85, 16);
		South.add(lblSubmarine);

		JRadioButton submarineV = new JRadioButton("V");
		submarineV.setBounds(442, 6, 40, 23);
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
		extButton.setBounds(363, 35, 112, 23);
		extButton.setForeground(Color.RED);
		extButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		South.add(extButton);
		
		JLabel seaLabel = new JLabel("");
		seaLabel.setBounds(-11, 0, 511, 81);
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
	};

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

