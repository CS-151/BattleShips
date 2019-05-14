package edu.sjsu.cs.cs151.battleship.model;

/**
 * Ship class keeps track of all types of ship.
 */
public class Ship {

	/**
	 * Constructor for the Ship class.
	 */
	public Ship(int blocks) {
		this.blocksRemaining = blocks;
		this.size = blocks;
		row = -1;
		col = -1;
		alignment = HORIZONTAL;
	}

	/**
	 * Second constructor
	 * 
	 * @param row
	 * @param col
	 * @param layout
	 */
	public Ship(int row, int col, int layout) {
		this.row = row;
		this.col = col;
		this.alignment = layout;
	}

	/**
	 * gets the alignment
	 * 
	 * @return alignment
	 */
	public int getAlignment() {
		return alignment;

	}

	/**
	 * Sets the alignment
	 * 
	 * @param alignment
	 */
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	/**
	 * gets the size
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the row
	 * 
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Sets the row
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Gets Column
	 * 
	 * @return col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * sets the column
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Determines whether the ship was hit
	 * 
	 * @return isHit
	 */
	public boolean isHit() {
		return isHit;
	}

	/**
	 * Sets the hit
	 * 
	 * @param isHit
	 */
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	/**
	 * Determines whether the ship was missed
	 * 
	 * @return isMiss
	 */
	public boolean isMiss() {
		return isMiss;
	}

	/**
	 * Sets the miss
	 * 
	 * @param isMiss
	 */
	public void setMiss(boolean isMiss) {
		this.isMiss = isMiss;
	}

	/**
	 * Sets the remaining blocks
	 * 
	 * @param blocksRemaining
	 */
	public void setBlocksRemaining(int blocksRemaining) {
		this.blocksRemaining = blocksRemaining;
	}

	/**
	 * Gets the size of the ship.
	 * 
	 * @return size the size of the ship
	 */
	public int getShipSize() {
		return size;
	}

	/**
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

	final static int HORIZONTAL = 0;
	final static int VERTICAL = -1;
}
