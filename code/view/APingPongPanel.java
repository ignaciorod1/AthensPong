package code.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import code.model.Constant;


public  class APingPongPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Graphics2D graphics2d;
	
	public APingPongPanel() {
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
		graphics.drawOval(Constant.WINDOW_WIDTH/2-Constant.CIRCLE_WIDTH/2,Constant.WINDOW_HEIGHT/2-Constant.CIRCLE_HEIGHT/2 ,Constant.CIRCLE_WIDTH, Constant.CIRCLE_HEIGHT);
	}
	
	public Graphics2D getPingPongGraphics() {
		return this.graphics2d;
	}
}
