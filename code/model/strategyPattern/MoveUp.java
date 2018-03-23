package code.model.strategyPattern;

import code.model.Constant;

public class MoveUp implements IMoveStrategy {

	/**
	 * This method takes y-position of the paddle and returns new y position
	 * @return int
	 */
	@Override
	public int move(int yPos) {
		System.out.println("moveUp");
		if (yPos - Constant.PADDLE_SPEED > 0){
			yPos -= Constant.PADDLE_SPEED;
		}
		else{
			yPos = 0;
		}
		return yPos;
	}

}
