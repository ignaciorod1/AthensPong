package code.model;

import java.awt.Graphics2D;

public class Paddle implements IMovementAction{
	
	private String playerName;
	private int xPos, yPos;
	private int score;
	
	public Paddle(String playerName, int xPos, int yPos) {
		this.playerName = playerName;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.fillRect(xPos, yPos, Constant.PADDLE_WIDTH, Constant.PADDLE_HEIGHT);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveUp() {
		if (yPos - Constant.PADDLE_SPEED > 0){
			yPos -= Constant.PADDLE_SPEED;
		}
		else{
			yPos = 0;
		}
	}
	
	public void moveDown() {
		if ((yPos + Constant.PADDLE_HEIGHT + Constant.PADDLE_SPEED) < Constant.WINDOW_HEIGHT){
			yPos += Constant.PADDLE_SPEED;
		}
		else{
			yPos = Constant.WINDOW_HEIGHT - Constant.PADDLE_HEIGHT;
		}
	}

}
