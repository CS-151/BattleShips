package edu.sjsu.cs.cs151.battleship.model;

import java.util.Scanner;

public class Model {

	public Model() {
		player1 = new Player();
		player2 = new Player();
	}
	
	public static void main(String[] args) {

		System.out.println("Welcome to BattleShip");
		Scanner scan = new Scanner(System.in);


		Player p1 = new Player();
		Player p2 = new Player();

		int row = 0;
		int col = 0;
		int size = 0;
		String alignment = "";
		int layout = 0;

		String done = "no";
		System.out.println("Player 1: Place your ships");
		p1.getPlayerGrid().printGrid();
		while(done.equals("no"))
		{

			System.out.println("Enter size of ship");
			size = scan.nextInt();

			System.out.println("Enter row");
			row = scan.nextInt();

			System.out.println("Enter col");
			col = scan.nextInt();

			System.out.println("Vertical or Horizontal? (v/h)");
			alignment = scan.next();
			alignment = alignment.toLowerCase();

			if(alignment.equals("h"))
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

		done  = "no";
		System.out.println("Player 2: Place your ships");
		p2.getPlayerGrid().printGrid();
		while(done.equals("no"))
		{


			System.out.println("Enter size of ship");
			size = scan.nextInt();

			System.out.println("Enter row");
			row = scan.nextInt();

			System.out.println("Enter col");
			col = scan.nextInt();

			System.out.println("Vertical or Horizontal? (v/h)");
			alignment = scan.next();
			alignment = alignment.toLowerCase();

			if(alignment.equals("h"))
			{
				layout = Ship.HORIZONTAL;
			}
			else
			{
				layout = Ship.VERTICAL;
			}

			Ship temp = new Ship(row,col,layout);
			p2.chooseShipLocation(size, row, col, layout);
			System.out.println("Are you done (yes/no)");
			done = scan.next();
		}

		done = "no";
		while(done.equals("no"))
		{
			System.out.println("Player 1: Take a guess");

			System.out.println("Guess row");
			row = scan.nextInt();

			System.out.println("Guess col");
			col = scan.nextInt();

			p1.guessOpponentShip(row, col, p2);

			System.out.println("Player 2: Take a guess");

			System.out.println("Guess row");
			row = scan.nextInt();

			System.out.println("Guess col");
			col = scan.nextInt();

			p2.guessOpponentShip(row, col, p1);

			System.out.println("Are you done (yes/no)");
			done = scan.next();
		}
	}

	public Player getPlayer1()
	{
		return player1;
	}

	public Player getPlayer2()
	{
		return player2;
	}
	private int row = 0;
	private int col = 0;
	private int size = 0;
	private String alignment = "";
	private int layout = 0;
	private Player player1;
	private Player player2;

}
