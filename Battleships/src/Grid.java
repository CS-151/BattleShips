/*
 * Constructs grid with a fixed length and width. Each cell has a coordinate object. 
 */
public class Grid {
	
	 public Grid()
	 {
		 grid = new Coordinates[GRID_ROW][GRID_COLUMN];
		 for(int i = 0; i < GRID_ROW; i++)
		 {
			 for(int j = 0; j< GRID_COLUMN; j++)
			 {
				 grid[i][j] = new Coordinates(i,j);
			 }
		 }
	 }
	/*
	 * Returns coordinates of specific grid
	 * @return coordinates
	 */
	public Coordinates getCoordinate(int x, int y)
	{
		return grid[x][y];
	}
	
	
	 public static final int GRID_ROW = 10;
	 public static final int GRID_COLUMN = 10;
	 
	 private Coordinates[][] grid;
}
