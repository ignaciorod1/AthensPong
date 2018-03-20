package code.controller;

import code.model.Constant;
import code.model.Paddle;

public class PaddleManager {

	private Paddle playerOne;
	private Paddle playerTwo;
	
	public PaddleManager() {
		playerOne = new Paddle("PlayerOne", 0, Constant.WINDOW_HEIGHT/2-Constant.PADDLE_HEIGHT/2);
		playerTwo = new Paddle("PlayerTwo", Constant.WINDOW_WIDTH-Constant.PADDLE_WIDTH, Constant.WINDOW_HEIGHT/2-Constant.PADDLE_HEIGHT/2);
	}
	
	public Paddle getPlayerOne() {
		return playerOne;
	}

	public Paddle getPlayerTwo() {
		return playerTwo;
	}
}
