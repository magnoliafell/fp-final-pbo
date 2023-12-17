package id.its.pbo.graphic;

import java.awt.Dimension;

import javax.swing.JFrame;

import id.its.pbo.main.gameEngine;

public class Frame {
	private JFrame frame;
	private Dimension size;
	
	public Frame (int width, int height, String title, gameEngine game) {
		size = new Dimension (width, height);
		frame = new JFrame (title);
		frame.setPreferredSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.add(game);
		frame.setVisible(true);
	}
}
