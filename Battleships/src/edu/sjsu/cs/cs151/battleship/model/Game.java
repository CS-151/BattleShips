package edu.sjsu.cs.cs151.battleship.model;

import java.util.Scanner;

public class Game {
	

	public static void main(String[] args) {
		
		System.out.println("Welcome to BattleShip");
		Scanner scan = new Scanner(System.in);
		
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		String done = "no";
		System.out.println("Player 1: Place your ships");
		p1.playerGrid.printGrid();
		while(done.equals("no"))
		{
			int row = 0;
			int col = 0;
			int size = 0;
			String alignment = "";
			int layout = 0;
			
			System.out.println("Enter size of ship");
			size = scan.nextInt();
			
			System.out.println("Enter row");
			row = scan.nextInt();
			
			System.out.println("Enter col");
			col = scan.nextInt();
			
			System.out.println("Horizontal or Vertical?");
			alignment = scan.next();
			alignment = alignment.toLowerCase();
			
			if(alignment.equals("horizontal"))
			{
				layout = Ship.HORIZONTAL;
			}
			else
			{
				layout = Ship.VERTICAL;
			}
			
			Ship temp = new Ship(row,col,layout);
			p1.chooseShipLocation(size, row, col, layout);
			System.out.println("Are you done (yes/no)");
			done = scan.next();

		}
		

		//p1.chooseShipLocation(5, 2, 4, Ship.HORIZONTAL);
//		 p2.chooseShipLocation(3, 4, 1, Ship.HORIZONTAL);
//		 p1.guessOpponentShip(4, 1, p2);

	}

}
