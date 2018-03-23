package code.model.strategyPattern;

public class MoveStrategy {

	private IMoveStrategy iMoveStrategy;
	
	public MoveStrategy(IMoveStrategy iMoveStrategy) {
		this.iMoveStrategy = iMoveStrategy;
	}
	
	public int executeMoveStrategy(int yPos){
      return iMoveStrategy.move(yPos);
	}
}
