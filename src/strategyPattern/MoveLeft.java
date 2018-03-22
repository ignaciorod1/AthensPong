package strategyPattern;

public class MoveLeft implements IMoveStrategy {

	public int move(int xPos) {

		return xPos -= (xPos > 0) ? 1 : 0;
	}

}
