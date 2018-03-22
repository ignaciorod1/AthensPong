package strategyPattern;

public class MoveStrategy {
private IMoveStrategy iMoveStrategy;
	
	public MoveStrategy(IMoveStrategy iMoveStrategy) {
		this.iMoveStrategy = iMoveStrategy;
	}
	
	public int executeMoveStrategy(int xPos){
      return iMoveStrategy.move(xPos);
	}
	
}
