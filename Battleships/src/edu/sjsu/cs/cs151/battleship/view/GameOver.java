package edu.sjsu.cs.cs151.battleship.view;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GameOver {
	/**
	 * Constructor for the GameOver Class
	 */
	public GameOver() {
		finish();
	}
	public void finish() {
		f = new JFrame("Game Over");
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 488, 466);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(new Font("Iowan Old Style", Font.BOLD, 30));
		lblGameOver.setIcon(new ImageIcon(getClass().getResource("/shipLable.png")));
		lblGameOver.setBounds(129, 88, 239, 91);
		panel.add(lblGameOver);
		f.setBounds(0, 0, 500, 500);
		f.setLocationRelativeTo(null);
	}
	private JFrame f;
}
