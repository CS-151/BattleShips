package edu.sjsu.cs.cs151.battleship.model;

public class Model 
{
	public Model()
	{
		this.grid = new Grid();
	}
	
	public void clickedCell(int r, int c)
	{
		
	}
	public Model newGame()
	{
		return new Model();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getStatus()
	{
		return gameStats;
	}
	
	public boolean isWinner()
	{
		if (gameStats)
		{
			if(this.getNumofCells() == 17)
			{
				return true;
			}
		}
		return false;
	}
	
	public int getNumofCells()
	{
		return cellCt;
	}
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public Grid getGrid()
	{
		return grid;
	}
	
	public boolean gameStats;
	private int row;
	private int column;
	private int cellCt;
	private Grid grid;
}
