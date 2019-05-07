package edu.sjsu.cs.cs151.battleship.app;
import edu.sjsu.cs.cs151.battleship.controller.Controller;
import edu.sjsu.cs.cs151.battleship.view.*;

public class Battleships 
{
	public enum STATE {
		MENU,
		GAME
	};

	public static STATE state = STATE.MENU;
	public static void main(String[] args)
	{
		Controller game = new Controller();	
		if(state == STATE.GAME)
		{

		}
		else if (state == STATE.MENU)
		{
			Welcome screen = new Welcome();
			screen.initialize();
		}
	}
}