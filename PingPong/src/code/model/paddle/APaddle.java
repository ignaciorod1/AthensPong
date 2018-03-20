package code.model.paddle;

import code.model.Constant;

public abstract class APaddle /*implements IMovementAction*/{

	public String playerName;
	public int xPos, yPos;
	public int score;
	
	public abstract void AcceptVisitor(IPaddleVisitor visitor);
	
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
