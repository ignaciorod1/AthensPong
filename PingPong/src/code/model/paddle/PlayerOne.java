package code.model.paddle;

import java.awt.Graphics2D;

public class PlayerOne extends APaddle{

	@Override
	public void AcceptVisitor(IPaddleVisitor visitor) {
		visitor.handlePlayerOne(this);
	}
}
