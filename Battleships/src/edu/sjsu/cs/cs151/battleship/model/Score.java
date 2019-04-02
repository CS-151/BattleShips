package edu.sjsu.cs.cs151.battleship.model;

/*
 * Score class keeps track of the scores for each player.
 */
public class Score 
{
	/*
	 * Constructor for the Score class.
	 */
	public Score()
	{
		score = 0;
	}

	/*
	 * Gets the score.
	 * @return score the score
	 */
	public int getScore() 
	{
		return score;
	}

	/*
	 * Updates the status of a ship.
	 * @param s the ship type that was hit
	 */
	private void setStatus(Ship s) 
	{
		if (this.shipStatus == 0)
		{
			//Error
		}
		else
		{
			this.shipStatus = s.shipStatus - 1;
		}
	}

	/*
	 * Gets status of a ship.
	 * @param s the ship type to get an update of
	 */
	private void setStatus(Ship s) 
	{
		return s.shipStatus;
	}

	private int score;
	private int shipStatus;
}
