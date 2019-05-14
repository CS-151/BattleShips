package edu.sjsu.cs.cs151.battleship.controller;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import edu.sjsu.cs.cs151.battleship.model.Coordinates;
import edu.sjsu.cs.cs151.battleship.model.Grid;
import edu.sjsu.cs.cs151.battleship.controller.Valve.ValveResponse;
=======
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
>>>>>>> 57fca2ed93f56dc01fc99b16b544b259b77226e7
import edu.sjsu.cs.cs151.battleship.model.Model;
import edu.sjsu.cs.cs151.battleship.view.View;
import edu.sjsu.cs.cs151.battleship.view.Welcome;
import edu.sjsu.cs.cs151.battleship.view.setUpView;;

public class Controller {

	/**
	 * Constructor for Controller.
	 * @param view the View
	 * @param model the Model
	 * @param queue stores Valves to be processed
	 */
	public Controller(View view, Model model, BlockingQueue<Message> queue)
	{
		this.view = view;
		this.model = model;
		messageQueue = queue;
		this.valves.add(new NewGameValve());
		new setUpView();
	}
<<<<<<< HEAD

=======
	
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
	
>>>>>>> 57fca2ed93f56dc01fc99b16b544b259b77226e7
	/**
	 * The main loop of the game.
	 * @throws Exception
	 */
	public void mainLoop() throws Exception
	{ 
		ValveResponse response = ValveResponse.EXECUTED; 
		Message message = null; 
		while(response != ValveResponse.FINISH)
		{ 
			try 
			{ 
				message = (Message) messageQueue.take(); 
			} catch(InterruptedException e)
			{ 
				e.printStackTrace(); 
			} 
		}

		for(Valve valve: valves)
		{
			response = valve.execute(message);
			if (response != ValveResponse.MISS)
			{
				break;
			}
		}
	}

	/**
	 * Updates the game info.
	 */
	public void updateGameInfo()
	{
		//Coordinates[][] currGrid = model.getGrid().getCoordinate();
		int r = model.getRow();
		int c = model.getColumn();
		if (model.getStatus())
		{
			for (int i = 0; i < r; i++)
			{
				for (int j = 0; j < c; j++)
				{
//					if (!currGrid[i][j].isHit())
//					{
//						gameInfo.gameInfoUpdate(i, j, gameInfo.getNumOfCellsLeft());
//					}
				}
			}
		}
		gameInfo.updateNumofCellsLeft(model.getNumofCells());
	}

	/**
	 * Method handles the NewGameMessage.
	 */
	private class NewGameValve implements Valve
	{
		@Override
		public ValveResponse execute(Message message)
		{
			if (message.getClass() != NewGameMessage.class) 
			{
				return ValveResponse.MISS;
			}
			Welcome screen = new Welcome();
			messageQueue.clear();
			model = model.newGame();
			gameInfo = new GameInfo(model);
			//view.change(gameInfo);
			return ValveResponse.EXECUTED;
		}
	}

	/**
	 * Method handles the CellClickedMessage.
	 */
	private class CellClickedValve implements Valve
	{
		@Override
		public ValveResponse execute(Message message)
		{
			if (message.getClass() != CellClickedMessage.class) 
			{
				return ValveResponse.MISS;
			}

			CellClickedMessage cellClicked = (CellClickedMessage) message;
			model.clickedCell(cellClicked.getRow(), cellClicked.getColumn());
			updateGameInfo();

			if (model.getStatus())
			{
				if (!model.isWinner())
				{
					//view.change(gameInfo);
				}
				else
				{
					//model.gameWin();	//Used to debug. Implement in Model.
					gameInfo.setWin();
					//view.change(gameInfo);
				}
			}
			else
			{
				//model.gameOver();		//Used to debug. Implement in Model.
				//view.change(gameInfo);
			}
			return ValveResponse.EXECUTED;
		}

		/**
		 * Gets the gameInfo.
		 * @return gameInfo the current gameInfo
		 */
		public GameInfo getGameInfo()
		{
			return gameInfo;
		}
	}

	private static View view;
	private static Model model;
	private GameInfo gameInfo;
	private BlockingQueue<Message> messageQueue;
	private List<Valve> valves = new LinkedList<Valve>();
	private Grid grid;
}
