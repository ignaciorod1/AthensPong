package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.Constant;


public abstract class APingPongFrame extends JPanel{

	public APingPongFrame() {
		this.setSize(new Dimension(Constant.WINDOW_WITDH, Constant.WINDOW_HEIGHT));
		this.setBackground(Color.BLACK);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	private void drawOutline(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.drawLine(Constant.WINDOW_WITDH/2, 0, Constant.WINDOW_WITDH/2, Constant.WINDOW_HEIGHT);
	}
}
