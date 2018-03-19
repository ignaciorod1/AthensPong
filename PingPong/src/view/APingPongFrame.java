package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Constant;


public  class APingPongFrame extends JPanel{

	private static final long serialVersionUID = 1L;
	private Graphics2D graphics2d;
	
	public APingPongFrame() {
		this.setSize(new Dimension(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT));
		this.setBackground(Color.BLACK);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		graphics2d = (Graphics2D)g;
		super.paintComponent(graphics2d);
		drawOutline(graphics2d);
	}
	
	private void drawOutline(Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setStroke(new BasicStroke(Constant.STROKE));
		graphics.drawLine(Constant.WINDOW_WIDTH/2, 0, Constant.WINDOW_WIDTH/2, Constant.WINDOW_HEIGHT);
		graphics.drawOval(Constant.WINDOW_WIDTH/2-Constant.BALL_WIDTH/2,Constant.WINDOW_HEIGHT/2-Constant.BALL_HEIGHT/2 ,Constant.BALL_WIDTH, Constant.BALL_HEIGHT);
	}
}
