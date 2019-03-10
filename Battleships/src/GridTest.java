import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	@Test
	public void test() {
		
		Grid grid = new Grid();
		assertEquals(1, grid.getCoordinate(1, 1).getX());
		assertEquals(9, grid.getCoordinate(2, 9).getY());
		
		grid.getCoordinate(2, 4).setHit(true);
		assertEquals(true, grid.getCoordinate(2, 4).isHit());
	}

}
