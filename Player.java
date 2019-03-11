/**
The player class holds information regarding the number of ships a player has and the location of the ship.
**/

public class Player
{  
    public Ship[] ships;
    public Grid playerGrid;
    public Grid oppGrid;
    /**
    Constructs the player class.
    **/
    public Player()
    {
        if (NUM_OF_SHIPS != 5) // Num of ships must be 5
        {
            throw new IllegalArgumentException("ERROR! Num of ships must be 5");
        }
        
        ships = new Ship[NUM_OF_SHIPS];
        for (int i = 0; i < NUM_OF_SHIPS; i++)
        {
            Ship tempShip = new Ship(SHIP_LENGTHS[i]);
            ships[i] = tempShip;
        }
        
        playerGrid = new Grid();
        oppGrid = new Grid();
    }
    /**
    Adds a ship to the array of ships.
    **/
    public void addShips()
    {
        for (Ship s: ships)
        {
            playerGrid.addShip(s);
        }
    }
    /**
    Returns how many ships are left.
    @return counter number of ships
    **/
    public int numOfShipsLeft()
    {
        int counter = 5;
        for (Ship s: ships)
        {
            if (s.isLocationSet() && s.isDirectionSet())
                counter--;
        }
        
        return counter;
        
    }
    /**
    Chooses the location of the ship.
    @param s the ship identifier 
    @param row the row the ship will be in 
    @param col the column that the ship will be
    @param direction the direction the ship will go
    **/
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        s.setLocation(row, col);
        s.setDirection(direction);
        playerGrid.addShip(s);
    }
    
    //lengths of all of the ships.
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    //number of ships 
    private static final int NUM_OF_SHIPS = 5;
}
