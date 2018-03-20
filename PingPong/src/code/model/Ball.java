package code.model;

import java.awt.Graphics2D;

public class Ball implements IMovementAction{
	private int xPos, yPos;

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawOval(xPos, yPos, Constant.BALL_WIDTH, Constant.BALL_HEIGHT);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}


}
