package edu.sjsu.cs.cs151.battleship.model;

/**
 * Ship class keeps track of all types of ship.
 */
public class Ship 
{
	/**
	 * Constructor for the Ship class.
	 * @param blocks
	 */
	public Ship(int blocks) {
		this.blocksRemaining = blocks;
		this.size = blocks;
		row = -1;
		col = -1;
		alignment = HORIZONTAL;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @param layout
	 */
	public Ship(int row, int col, int layout)
	{
		this.row = row;
		this.col = col;
		this.alignment = layout;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAlignment()
	{
		return alignment;

	}

	/**
	 * 
	 * @param alignment
	 */
	public void setAlignment(int alignment)
	{
		this.alignment = alignment;
	}

	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * 
	 * @return
	 */
	public int getCol() {
		return col;
	}

	/**
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isHit() {
		return isHit;
	}

	/**
	 * 
	 * @param isHit
	 */
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMiss() {
		return isMiss;
	}

	/**
	 * 
	 * @param isMiss
	 */
	public void setMiss(boolean isMiss) {
		this.isMiss = isMiss;
	}

	/**
	 * 
	 * @param blocksRemaining
	 */
	public void setBlocksRemaining(int blocksRemaining) {
		this.blocksRemaining = blocksRemaining;
	}

	/**
	 * Gets the size of the ship.
	 * @return size the size of the ship
	 */
	public int getShipSize() {
		return size;
	}

	/**
	 * Gets the remaining number of blocks of the ship. 
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

	final static int  HORIZONTAL = 0;
	final static int  VERTICAL = -1;
}
