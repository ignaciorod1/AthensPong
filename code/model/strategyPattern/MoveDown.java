package code.model.strategyPattern;

import code.model.Constant;

public class MoveDown implements IMoveStrategy {

	@Override
	public int move(int yPos) {
		System.out.println("moveDown");
		if ((yPos + Constant.PADDLE_HEIGHT + Constant.PADDLE_SPEED) < Constant.WINDOW_HEIGHT){
			yPos += Constant.PADDLE_SPEED;
		}
		else{
			yPos = Constant.WINDOW_HEIGHT - Constant.PADDLE_HEIGHT;
		}
		return yPos;
	}


}
