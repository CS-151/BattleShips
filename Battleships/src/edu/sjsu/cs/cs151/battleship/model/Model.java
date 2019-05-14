package edu.sjsu.cs.cs151.battleship.model;

public class Model 
{
	public Model()
	{
		this.grid = new Grid();
		 p1 = new Player();
		 p2 = new Player();
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
	
	public Player getPlayer1()
	{
		return p1;
	}
	
	public Player getPlayer2()
	{
		return p2;
	}
	
	public boolean gameStats;
	private int row;
	private int column;
	private int cellCt;
	private Player p1;
	private Player p2;
	private Grid grid;
}
