package edu.sjsu.cs.cs151.battleship.model;

public class Game {
	

	public static void main(String[] args) {
				
		Player p1 = new Player();
		Player p2 = new Player();
		//p1.chooseShipLocation(5, 2, 4, Ship.HORIZONTAL);
		 p2.chooseShipLocation(3, 4, 1, Ship.HORIZONTAL);
		 p1.guessOpponentShip(4, 1, p2);

	}

}
