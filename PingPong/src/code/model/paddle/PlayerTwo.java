package code.model.paddle;

public class PlayerTwo extends APaddle{

	@Override
	public void AcceptVisitor(IPaddleVisitor visitor) {
		visitor.handlePlayerTwo(this);
	}
}
