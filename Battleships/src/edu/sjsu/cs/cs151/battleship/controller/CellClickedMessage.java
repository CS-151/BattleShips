package edu.sjsu.cs.cs151.battleship.controller;

public class CellClickedMessage extends Message
{
	int row;
	int column;
	
	public CellClickedMessage(int r, int c)
	{
		row = r;
		column = c;
	}
	
	/**
	 * Gets the row.
	 * @return row the row of a clicked cell
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * Gets the column.
	 * @return column the column of a clicked cell
	 */
	public int getColumn()
	{
		return column;
	}
}
