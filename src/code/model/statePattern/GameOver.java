package code.model.statePattern;

public class GameOver implements IState{

	@Override
	public void doAction(PingPongState pingPongState) {
		pingPongState.setState(this);
	}

}
