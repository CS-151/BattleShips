/*
 * Ship class keeps track of all types of ship.
 */
public class Ship 
{
	/*
	 * Constructor for the Ship class.
	 */
	public Ship()
	{
	}

	/*
	 * Gets the name of the ship.
	 * @return shipName the name of the ship
	 */
	public String getShipName() 
	{
		return shipName;
	}

	/*
	 * Gets the name of the ship.
	 * @return shipName the name of the ship
	 */
	public String getShipName() 
	{
		return shipName;
	}
  
  /*
	 * Gets the size of the ship.
	 * @return size the size of the ship
	 */
	public int getShipSize() 
	{
		return size;
	}
  
  /*
	 * Gets the remaining number of blocks of the ship.
	 * @return blocksRemaining the remaining number of blocks of the ship
	 */
	public String getBlocksRemaining() 
	{
		return blocksRemaining;
	}

	private int size;
  private int blocksRemaining;
	private String position;
  private String shipName;
  private boolean isHit;
  private boolean isMiss;
}
