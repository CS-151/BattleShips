package edu.sjsu.cs.cs151.battleship.view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PlayerGrid extends JPanel {
	JPanel self;
	
	public PlayerGrid() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		self = new JPanel();
		self.setLayout(new GridLayout(0, 10));
		for (int i = 0; i< 10; i++) {
			for(int j = 0; j<10; j++) {
				val = getCell();
				self.add(val);
			}
		}
		this.add(self);
	}
	
	public JPanel getTheComp(Point p) {
		Component cmp = null;
		for(Component child : self.getComponents()) {
			if(child.getBounds().contains(p)) {
				cmp = child;
			}
		}
		return (JPanel) cmp;
		
	}
	
	JPanel getCell() {
		return null;
	}
	private JPanel val;

}
