package edu.sjsu.cs.cs151.battleship.model;

/**
 * Coordinate class keeps track of the x and y coordinates of the grid. It also
 * keeps track whether a specific coordinate has already been hit or not.
 *
 */
public class Coordinates {

	/**
	 * Coordinates constructor.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		containsShip = false;
		isHit = false;
		status = "-";
	}

	/**
	 * Gets the status.
	 * @return status the status as a string
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * @param status the status that is a string
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns if ship is contained.
	 * @return containsShip the boolean
	 */
	public boolean isContainsShip() {
		return containsShip;
	}

	/**
	 * Sets a boolean to containShip.
	 * @param containsShip the boolean
	 */
	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}

	/**
	 * Gets the x-coordinate.
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate.
	 * @return x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the x-coordinate.
	 * @return x coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the x-coordinate.
	 * @param x coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns a boolean value whether the coordinate has already been hit.
	 * @return status of coordinate
	 */
	public boolean isHit() {
		return isHit;
	}

	/**
	 * Changes the status of the coordinate to either being hit or not.
	 * @param status of coordinate
	 * @param isHit
	 */
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	private int x;
	private int y;
	private boolean isHit;
	private String status;
	boolean containsShip;
}
