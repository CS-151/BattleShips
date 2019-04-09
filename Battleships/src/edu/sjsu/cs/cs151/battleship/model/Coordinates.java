package edu.sjsu.cs.cs151.battleship.model;

/*
 * Coordinate class keeps track of the x and y coordinates of the grid. It also
 * keeps track whether a specific coordinate has already been hit or not.
 */

public class Coordinates {

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		containsShip = false;
		isHit = false;
		status = "-";
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	



	public boolean isContainsShip() {
		return containsShip;
	}



	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}



	
	/*
	 * Gets the x-coordinate
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}

	/*
	 * Sets the x-coordinate
	 * 
	 * @param x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/*
	 * Gets the y-coordinate
	 * 
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}

	/*
	 * Sets the x-coordinate
	 * 
	 * @param x coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/*
	 * Returns a boolean value whether the coordinate has already been hit.
	 * 
	 * @return status of coordinate
	 */
	public boolean isHit() {
		return isHit;
	}

	/*
	 * Changes the status of the coordinate to either being hit or not.
	 * 
	 * @param status of coordinate
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
