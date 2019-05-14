package edu.sjsu.cs.cs151.battleship.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import edu.sjsu.cs.cs151.battleship.model.Coordinates;
import edu.sjsu.cs.cs151.battleship.model.Grid;
import edu.sjsu.cs.cs151.battleship.controller.Valve.ValveResponse;
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
			updateGameInfo();

			if (model.getStatus())
			{
				if (!model.isWinner())
				{
					view.change(gameInfo);
				}
				else
				{
					model.gameOver();	//Used to debug. Implement in Model.
					gameInfo.setWin();
					//view.change(gameInfo);
				}
			}
			else
			{
				model.gameOver();		//Used to debug. Implement in Model.
				view.change(gameInfo);
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
