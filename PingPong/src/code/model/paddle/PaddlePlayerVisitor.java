package code.model.paddle;

import code.model.Constant;

public class PaddlePlayerVisitor implements IPaddleVisitor{

	private int xPos;
	
	public int getXPosition() {
		return xPos;
	}
	
	@Override
	public void handlePlayerOne(PlayerOne player) {
		this.xPos = 0;
	}

	@Override
	public void handlePlayerTwo(PlayerTwo player) {
		this.xPos = Constant.WINDOW_WIDTH - Constant.PADDLE_WIDTH;
	}

}
