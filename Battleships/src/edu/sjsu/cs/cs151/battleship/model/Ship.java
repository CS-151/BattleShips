package edu.sjsu.cs.cs151.battleship.model;

/*
 * Ship class keeps track of all types of ship.
 */
public class Ship {
	
	/*
	 * Constructor for the Ship class.
	 */

	public Ship(int blocks) {
		this.blocksRemaining = blocks;
		this.size = blocks;
		row = -1;
		col = -1;
		alignment = HORIZONTAL;
		
	}
	public Ship(int row, int col, int layout)
	{
		this.row = row;
		this.col = col;
		this.alignment = layout;
	}
	public int getAlignment()
	{
		return alignment;
		
	}
	
	public void setAlignment(int alignment)
	{
		this.alignment = alignment;
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public boolean isHit() {
		return isHit;
	}


	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}


	public boolean isMiss() {
		return isMiss;
	}


	public void setMiss(boolean isMiss) {
		this.isMiss = isMiss;
	}


	public void setBlocksRemaining(int blocksRemaining) {
		this.blocksRemaining = blocksRemaining;
	}


	/*
	 * Gets the size of the ship.
	 * 
	 * @return size the size of the ship
	 */
	public int getShipSize() {
		return size;
	}

	/*
	 * Gets the remaining number of blocks of the ship.
	 * 
	 * @return blocksRemaining the remaining number of blocks of the ship
	 */
	public int getBlocksRemaining() {
		return blocksRemaining;
	}

	private int size;
	private int blocksRemaining;
	private int row;
	private int col; 
	private boolean isHit;
	private boolean isMiss;
	private int alignment;
	
	final static int  HORIZONTAL = 1;
	final static int  VERTICAL = -1;
}
