package code.model.statePattern;

public class Welcome implements IState{

	@Override
	public void doAction(PingPongState pingPongState) {
		pingPongState.setState(this);	
	}

}
