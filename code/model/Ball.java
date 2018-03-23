package code.model;

import java.awt.Graphics2D;

import code.model.decoratorPattern.IElement;

public class Ball implements IElement{
	private int xPos, yPos;
//	private float ballSpeedX = Constant.BALL_SPEED_X_POS;
//	private float ballSpeedY = Constant.BALL_SPEED_Y_POS;
	
	public Ball(int x, int y){
		this.xPos = x;
		this.yPos = y;
	}
	

	@Override
	public void draw(Graphics2D graphics) {
		graphics.fillOval(xPos, yPos, Constant.BALL_RADIUS, Constant.BALL_RADIUS);
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	
	
	
//	/**
//	 * This method controls whether the ball hit the paddle*/
//	public boolean hasCollision(int paddleYPos) {
//		if(paddleYPos - Constant.BALL_RADIUS <= yPos && yPos <= paddleYPos + Constant.BALL_RADIUS)
//			return true;
//		return false;
//	}
}
