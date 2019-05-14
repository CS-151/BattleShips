package edu.sjsu.cs.cs151.battleship.app;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs.cs151.battleship.controller.Controller;
import edu.sjsu.cs.cs151.battleship.controller.Message;
import edu.sjsu.cs.cs151.battleship.model.Model;
import edu.sjsu.cs.cs151.battleship.view.*;

/**
 * Battleship application.
 * 
 */
public class Battleships 
{
	public static void main(String[] args) 
	{
		
		//view = View.wait(queue);
		model = new Model();
		
		Controller game = new Controller(view, model, queue);
		try 
		{
			game.mainLoop();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		view.playerFrame.dispose();
		queue.clear();
		new setUpView();
	}
	
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
}