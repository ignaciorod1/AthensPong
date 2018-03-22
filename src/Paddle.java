import java.awt.Graphics2D;
import strategyPattern.IMoveStrategy;
import strategyPattern.MoveLeft;
import strategyPattern.MoveRight;
import strategyPattern.MoveStrategy;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;
import constants.Constants;

public class Paddle {

	private int paddlenumber;
	public vector2d pos = new vector2d(0, 0);
	public int score;
	private HashSet<String> keys = new HashSet<String>();
	private MoveStrategy moveStrategyMoveUp;
	private MoveStrategy moveStrategyMoveDown;

	public Paddle(int X, int Y, int paddlenumber) {
		this.paddlenumber = paddlenumber;
		this.score = 0;
		this.pos.x = X;
		this.pos.y = Y;
		moveStrategyMoveUp = new MoveStrategy(new MoveLeft());
		moveStrategyMoveDown = new MoveStrategy(new MoveRight());

	}

	public void update(Graphics2D g) {
		Rectangle2D pad = new Rectangle(this.pos.x, this.pos.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
		g.fill(pad);
	}

	public void moveLeft() {
		this.pos.x = moveStrategyMoveUp.executeMoveStrategy(this.pos.x);
	}

	public void moveRight() {
		this.pos.x = moveStrategyMoveDown.executeMoveStrategy(this.pos.x);
	}

}
