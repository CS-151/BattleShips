package edu.sjsu.cs.cs151.battleship.view;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 *This class is the Game Over class for when the game ends
 * @author maryammostafavi
 *
 */

public class GameOver {
	/**
	 * Constructor for the GameOver Class
	 */
	public GameOver() {
		finish();
	}
	/**
	 * it creates the layout of the page
	 */
	public void finish() {
		f = new JFrame("Game Over");
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(6, 6, 488, 466);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		//game over label
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setForeground(new Color(255, 0, 0));
		lblGameOver.setFont(new Font("Iowan Old Style", Font.BOLD, 40));
		
		lblGameOver.setBounds(93, 77, 274, 91);
		panel.add(lblGameOver);
		
		JLabel leftShip = new JLabel("");
		leftShip.setIcon(new ImageIcon(getClass().getResource("/shipLabel.png")));
		leftShip.setBounds(34, 112, 61, 16);
		panel.add(leftShip);
		
		JLabel rightShip = new JLabel("");
		rightShip.setIcon(new ImageIcon(getClass().getResource("/shipLabel.png")));
		rightShip.setBounds(379, 112, 61, 16);
		panel.add(rightShip);
		
		JLabel winLabel = new JLabel("YOU WON!");
		winLabel.setEnabled(false);
		winLabel.setFont(new Font("Iowan Old Style", Font.BOLD, 30));
		winLabel.setBounds(141, 171, 188, 29);
		panel.add(winLabel);
		
		JLabel loseLabel = new JLabel("YOU LOST!");
		loseLabel.setFont(new Font("Iowan Old Style", Font.BOLD, 30));
		loseLabel.setBounds(141, 171, 188, 29);
		panel.add(loseLabel);
		//score label
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Iowan Old Style", Font.PLAIN, 20));
		lblScore.setBounds(189, 246, 104, 24);
		panel.add(lblScore);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(165, 307, 117, 29);
		panel.add(btnNewButton);
	
		
		JButton extBtn = new JButton("Exit");
		extBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		extBtn.setBounds(165, 340, 117, 29);
		panel.add(extBtn);
		f.setBounds(0, 0, 500, 500);
		f.setLocationRelativeTo(null);
		
	}
	private JFrame f;
}
