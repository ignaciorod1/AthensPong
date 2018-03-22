package strategyPattern;
import constants.Constants;

public class MoveRight implements IMoveStrategy {

	public int move(int xPos) {

		return xPos += (xPos < Constants.PADDLE_WIDTH - Constants.PADDLE_WIDTH) ? 1 : 0;

	}

}
