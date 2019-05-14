package edu.sjsu.cs.cs151.battleship.controller;

import edu.sjsu.cs.cs151.battleship.model.Model;

public class GameInfo 
{
	public GameInfo(Model model)
	{
		row = model.getRow();
		column = model.getColumn();
		cellsLeft = model.getNumofCells();
		status = new int[row][column];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
				status[i][j] = -2;
		}
		isStarted = true;
		isWinner = false;
	}
	/**
	 * Updates the status of the game.
	 * @param i row val
	 * @param j column val
	 * @param updateVal val to be updated
	 */
	public void gameInfoUpdate(int i, int j, int updateVal)
	{
		status[i][j] = updateVal;
	}
	
	/**
	 * Gets the status of the game.
	 * @return
	 */
	public int[][] getStatus()
	{
		return status;
	}
	
	/**
	 * Gets the number of ship cells left.
	 * @return number of ships left
	 */
	public int getNumOfCellsLeft()
	{
		return this.cellsLeft;
	}
	
	/**
	 * Updates the number of ship cells left.
	 */
	public void updateNumofCellsLeft(int cells)
	{
		this.cellsLeft = cells;
	}
	
	/**
	 * Sets game has started.
	 * @return true if game has started.
	 */
	public boolean isStarted()
	{
		return isStarted;
	}
	
	/**
	 * Sets game is over.
	 * @return true if game is over.
	 */
	public boolean isOver()
	{
		return isOver;
	}
	
	/**
	 * Sets the player as winner.
	 */
	public void setWin()
	{
		isWinner = true;
	}
	
	/**
	 * Gets the winner player.
	 * @return the winner player.
	 */
	public boolean isWinner()
	{
		return isWinner;
	}
	
	private int[][] status;
	private boolean isWinner;
	private boolean isStarted;
	private boolean isOver;
	private int cellsLeft;
	private int row;
	private int column;	
}
