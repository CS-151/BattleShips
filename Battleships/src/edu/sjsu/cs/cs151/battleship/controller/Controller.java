package edu.sjsu.cs.cs151.battleship.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import edu.sjsu.cs.cs151.battleship.model.Model;
import edu.sjsu.cs.cs151.battleship.view.NextTurn;
import edu.sjsu.cs.cs151.battleship.view.View;
import edu.sjsu.cs.cs151.battleship.view.Welcome;

public class Controller {

	/**
	 * Constructor for Controller
	 */
	public Controller()
	{
		model = new Model();
		this.player1 = new View(1);
		this.player2  = new View(2);
		nt = new NextTurn();
		nt2 = new NextTurn();	
		welcome = new Welcome();
		welcomeToGame();
	}
	
	/**
	 * Handles the event when player1 switches to player 2
	 */
	public void player1ToPlayer2()
	{
		//Retrieve player1's next player button
		player1.getNextPlayerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Once clicked, set hide player1's screen
				player1.playerFrame.setVisible(false);
				
				//Make next player screen visible
				nt.getFrame().setVisible(true);
				
				//Retrieve next player's start button 
				nt.getStartButton().addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						//Once clicked, hide next player's screen
						nt.getFrame().setVisible(false);
						
						//Make player2 screen visible
						player2.playerFrame.setVisible(true);
					}
				});
			}
		});

	}
	
	
	/**
	 * Handles the event when player2 switches to player1
	 */
	public void player2ToPlayer1()
	{
		//Retrieve player2's next player button
		player2.getNextPlayerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Once clicked, set hide player2's screen
				player2.playerFrame.setVisible(false);
				
				//Make next player screen visible
				nt2.getFrame().setVisible(true);
				
				//Retrieve next player's start button
				nt2.getStartButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Once clicked, hide next player's screen
						nt2.getFrame().setVisible(false);
						
						//Make player1 screen visible
						player1.playerFrame.setVisible(true);
					}
				});
			}
		});
	}
	
	
	/**
	 * Collection of methods needed to start the game
	 * @param welcome the Welcome Screen
	 */
	public void startGame(Welcome welcome)
	{
		welcome.getFrame().dispose();

		addShipToPlayerGrid(player1);
		guessOponentShip(this.player1, this.player2);
		player1.playerFrame.setVisible(true);
		
		addShipToPlayerGrid(player2);
		guessOponentShip(player2, player1);

		player1ToPlayer2();
		player2ToPlayer1();
		
		reset();
	}

	/**
	 * Adds action listener to welcome screen to transition from the welcome
	 * page to player 1 screen.
	 */
	public void welcomeToGame()
	{
		welcome.getFrame().setVisible(true);
		welcome.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame(welcome);
			}
		});
	}
	
	
	
	public void addShipToPlayerGrid(View player)
	{
		boolean[] shipCheckArray = player.getshipCheck();
		player.initializeArray(shipCheckArray);
		buttonGrid = player.getJButtonGrid();
		
		for(int i = 0; i < 10; i ++)
		{
			for(int j = 0; j < 10; j++)
			{	 

				JButton button = buttonGrid[i][j];
				///Add ActionListener event that places "X" on grids
				// on buttons that have been clicked
				button.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent arg0)
					{
						System.out.println("Coordinate: " + player.getJButtonList().indexOf(button) );
						System.out.println("ShipLength: " + player.getShipLength() );
						
						//Checks whether the alignment the user clicked was 
						// Horizontal 
						if(player.getAlignment() == HORIZONTAL)
						{
							//Checks if there is space for the selected option
							if((isSpace(player.getShipLength(), button,player) && !isOutOfBounds(player.getShipLength(), button,player)) && !doesShipExist(shipCheckArray,player.getShipLength(),player))
							{
								player.updateShipCounter();
								int temp = player.getShipCounter();
								println(temp);
								println(isReadyToGuess);
								if(player.getShipCounter() == 5)
								{
									player.setToGuess(true);
								}
								
								//Checks if it is player1
								println("Row is " + convertToRow(player.getJButtonList().indexOf(button)));
								println("Col is " + convertToCol(player.getJButtonList().indexOf(button)));
								int row = convertToRow(player.getJButtonList().indexOf(button));
								int col = convertToCol(player.getJButtonList().indexOf(button));
								
								if(player.getPlayerNumber() == 1)
								{
									model.getPlayer1().chooseShipLocation(player.getShipLength(), row, col, player.getAlignment());
								}
								else
								{
									model.getPlayer2().chooseShipLocation(player.getShipLength(), row, col, player.getAlignment());
								}
								
								//Since there is space, the block of buttons would marked
								// as placed Horizontally
								for( int index  = 0 ; index < player.getShipLength(); index++)
								{
									System.out.println("Index: " +(player.getJButtonList().indexOf(button) +index));
										
									//int row = buttonList.indexOf(button);
										player.getJButtonList().get((player.getJButtonList().indexOf(button) + index)).setText("X");
									//player.getJButtonList().get((player.getJButtonList().indexOf(button) + index)).setIcon(new ImageIcon(getClass().getResource("/battleshipIcon.png")));;
										//Checks if it is player1
//										if(player.getPlayerNumber() == 1)
//										{
//											model.getPlayer1().chooseShipLocation(player.getShipLength(), row, col, player.getAlignment());
//										}
//										else
//										{
//											model.getPlayer2().chooseShipLocation(player.getShipLength(), row, col, player.getAlignment());
//										}
										String shipLeftCounterString = player.getShipCounter().toString();
										player.getShipLeftCount().setText(shipLeftCounterString);
										
										if(player.getIsSubmarine())
										{
											shipCheckArray[7] = true;
										}
										else
										{
											shipCheckArray[player.getShipLength()] = true;
										}
								}
							}
						}
						else
						{
							// User did not select Horizontal, therefore it is 
							// Vertical
							if(isSpace(player.getShipLength(), button, player) && !doesShipExist(shipCheckArray,player.getShipLength(),player))
							{
								player.updateShipCounter();
								
								//Adds ships vertically
								for( int index  = 0 ; index < player.getShipLength()*10; index = index + 10)
								{
									System.out.println("Index: " +(player.getJButtonList().indexOf(button) +index));
									System.out.println("alighnment: " + player.getAlignment());
										player.getJButtonList().get(player.getJButtonList().indexOf(button) + index);
										player.getJButtonList().get((player.getJButtonList().indexOf(button) + index)).setText("X");
										
										String shipLeftCounterString = player.getShipCounter().toString();
										player.getShipLeftCount().setText(shipLeftCounterString);
										if(player.getIsSubmarine())
										{
											shipCheckArray[7] = true;
										}
										else
										{
											shipCheckArray[player.getShipLength()] = true;
										}
								}
							}
						}
					System.out.println("========");
					}
				});
			}
		}
		
	}
	
	public boolean doesShipExist(boolean[] shipCheck2, int shipLength, View player)
	{
		int temp = shipLength;
		boolean[] shipCheck = player.getshipCheck();
		if(player.getIsSubmarine())
		{
			if(shipCheck[7] == true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(shipCheck[temp] == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 * Helper method that check whether the given ship would go 
	 * out of bounds from the grid
	 * @param shipLength the length of the ship
	 * @param button the first button that is clicked (the head of the ship)
	 * @result true/false boolean output determining whether the ship would be out of bounds.
	 */
	public boolean isOutOfBounds(int shipLength, JButton button, View player)
	{
		for( int index  = 0 ; index < shipLength-1; index++)
		{
				if(((player.getbuttonList().indexOf(button) + index)%10 == 9))
				{
					return true;
				}					
		}
		return false;
	}
	
	/*
	 * Helper method that check whether the given ship would fit on to the 
	 * selected JButton 
	 * @param shipLength the length of the ship
	 * @param button the first button that is clicked (the head of the ship)
	 * @result true/false boolean output determining whether there is space
	 */
	public boolean isSpace(int shipLength, JButton button, View player)
	{
		if(player.getAlignment() == HORIZONTAL)
		{
			for( int index  = 0 ; index < shipLength; index++)
			{
					if(player.getbuttonList().get((player.getbuttonList().indexOf(button) + index)).getText().equals("X"))
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
					if(player.getbuttonList().get((player.getbuttonList().indexOf(button) + index)).getText().equals("X"))
					{
						return false;
					}
			}
		return true;
			
		}
	}

	private void initializeArray(boolean[] shipCheck2)
	{
		for (int i = 0; i <shipCheck2.length; i++)
		{
			shipCheck2[i] = false;
		}
	}


	public void guessOponentShip(View player1, View player2)
	{
		Integer scoreNum = player1.getScoreNum();
		
		ArrayList<JButton> buttonList = player1.getOpponentButtonList();
		opponentButtonGrid = player1.getOpponentGrid();
		JButton[][] player2PlayerGrid = player2.getButtonGrid();
		ArrayList<JButton> player2ButtonList = player2.getbuttonList();
		
		
		for(int i = 0; i < 10; i ++)
		{
			for(int j = 0; j < 10; j++)
			{	 
				JButton player1OpponentButton = opponentButtonGrid[i][j];
				JButton player2PlayerButton = player2PlayerGrid[i][j];
				///Listener event that places "X" on grids
				// that have been clicked
				
					player1OpponentButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent arg0)
						{
							String x = player2.getJButtonList().get((player2.getJButtonList().indexOf(player2PlayerButton))).getText();
							JButton button = player1.getOpponentButtonList().get((player1.getOpponentButtonList().indexOf(player1OpponentButton)));
							if(player1.getIsReadyToGuess())
							{
								if(x.equals("X"))
								{
									if(!button.getBackground().equals(Color.GREEN))
									{
										player1.updateScoreNum();
									}
									button.setBackground(Color.GREEN);
									//button.setText("H");
									button.setOpaque(true);
									button.setBorderPainted(false);
									player2.getJButtonList().get((player2.getJButtonList().indexOf(player2PlayerButton))).setText("-");
									if(player1.getScoreNum() == 17)
									{
										endOfGame = new JOptionPane();
										endOfGame = new JOptionPane();
										JOptionPane.showMessageDialog(player1OpponentButton.getParent(), 
												"Player " + player1.getPlayerNumber() + " has won the Game. Congratulations!!!!","Winner", JOptionPane.INFORMATION_MESSAGE);
									}

								}
								else
								{
									button.setBackground(Color.RED);
									
									//button.setText("M");
									button.setOpaque(true);
									button.setBorderPainted(false);
									player2.getJButtonList().get((player2.getJButtonList().indexOf(player2PlayerButton))).setText("O");
								}
								
									switchAfterGuess(player1, player2);	
							}						
													
							String score = player1.getScoreNum().toString();
							player1.getScoreCount().setText(score);
						}
					});
		}

	}
	}
	
	/*
	 * Switches screens after user guesses on opponent ship
	 * @param player1 screen
	 * @param player2 screen
	 */
	public void switchAfterGuess(View player1, View player2)
	{
		
		player1.playerFrame.dispose();
		if(player1.getPlayerNumber() ==1)
		{
			nt.getFrame().setVisible(true);
			nt.getStartButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nt.getFrame().setVisible(false);
					player2.playerFrame.setVisible(true);
				}
			});								
		}
		
		else
		{
			nt2.getFrame().setVisible(true);
			nt2.getStartButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							nt2.getFrame().setVisible(false);
							player2.playerFrame.setVisible(true);
			         
					
				}
			});
		}
		
	}
	public void nextPlayer(View player1, View player2, NextTurn nt)
	{
		player1.getNextPlayerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt.getFrame().setVisible(true);
				selectPlayer( player1,  player2,  nt);
			}
		});
	}
	public void selectPlayer(View player1, View player2, NextTurn nt)
	{
		player1.playerFrame.dispose();
		flipScreen(player2, nt);
	}
	public void flipScreen(View player1, NextTurn nt)
	{
		nt.startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt.getFrame().dispose();
				player1.playerFrame.setVisible(true);
			}
		});
	}
	
	public void coverScreen(View player, NextTurn nt)
	{
		player.getNextPlayerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.playerFrame.dispose();
				nt.getFrame().setVisible(true);
			}
		});
	}
	
	public void uncoverScreen(View player, NextTurn nt)
	{
		nt.startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt.getFrame().dispose();
				player.playerFrame.dispose();
			}
		});
	}
	
	public void player1Screen()
	{
		player1.getNextPlayerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1.playerFrame.dispose();
				nt.getFrame().setVisible(true);
				nt.startButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nt.getFrame().dispose();
						player1.playerFrame.setVisible(true);
					}
				});
			}
		});
	}
	
	public void player2Screen()
	{
		nt2.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nt2.getFrame().dispose();
				player2.playerFrame.setVisible(true);
				player2.getNextPlayerButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						player2.playerFrame.dispose();
						nt2.getFrame().setVisible(true);
					}
				});
			}
		});
	}
	public void reset1()
	{
			player1.getExitButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
					if (n == 0)
					{
						try
						{
							//Exits the game entirely.
							player2.playerFrame.dispose();
							player1.playerFrame.dispose();
							nt.getFrame().dispose();
							nt2.getFrame().dispose();
							new Controller();
						} catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, e);
						}
					}
				}
			});
	}
	
	public void reset2()
	{
		player2.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
				if (n == 0)
				{
					try
					{
						//Exits the game entirely.
						player2.playerFrame.dispose();
						player1.playerFrame.dispose();
						nt.getFrame().dispose();
						nt2.getFrame().dispose();
						new Controller();
					} catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
}

	public int convertToRow(Integer fullNumber)
	{
		if(fullNumber > 9)
		{
			int temp = fullNumber/10;
			return temp;
		}
		else
		{
			return 0;
		}
	}
	
	public int convertToCol(Integer fullNumber)
	{
		if(fullNumber > 9)
		{
			int temp = fullNumber%10;
			return temp;
		}
		else
		{
			return fullNumber;
		}
	}
	
	public void reset()
	{
		reset1();
		reset2();
	}
	
	//System.out.printn shortcut
	static void println(Object line) {
	    System.out.println(line);
	}
	private Model model;
	private View player1;
	private View player2;
	
	private JButton[][] buttonGrid;
	private JOptionPane endOfGame;
	private NextTurn nt ;
	private NextTurn nt2;
	private JButton[][] opponentButtonGrid;
	private boolean isReadyToGuess = false;
	private Welcome welcome;
	private static final int HORIZONTAL  = 0;
	private static final int VERTICAL = -1;
	
	
	public static void main(String[]args)
	{
		Controller c = new Controller();
		//c.player2.playerFrame.setVisible(true);
		//c.player1.playerFrame.setVisible(true);
//		c.player2.playerFrame.setVisible(true);
//		c.addShipToPlayerGrid(c.player2);
//		c.player2.playerFrame.setVisible(true);
//		c.addShipToPlayerGrid(c.player2);
		
	}



}
