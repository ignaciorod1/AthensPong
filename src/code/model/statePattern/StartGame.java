package code.model.statePattern;

public class StartGame implements IState{

	@Override
	public void doAction(PingPongState pingPongState) {
		pingPongState.setState(this);
	}

}
