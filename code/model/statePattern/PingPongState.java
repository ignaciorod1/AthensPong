package code.model.statePattern;

public class PingPongState {

	private IState iState;

	   public PingPongState(){
	      iState = null;
	   }

	   public void setState(IState state){
	      this.iState = state;		
	   }

	   public IState getState(){
	      return iState;
	   }
}
