package code.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import code.controller.Manager;

public class PingPongPanel extends APingPongPanel{
	
	private static final long serialVersionUID = 1L;
	
	public PingPongPanel() {
		super();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setColor(Color.PINK);
		Manager.getInstance().getPaddleManager().getPlayerOne().draw(graphics);
		Manager.getInstance().getPaddleManager().getPlayerTwo().draw(graphics);
	}
	
	public void notifyDataChange() {
		this.repaint();
		this.revalidate();
	}

}
