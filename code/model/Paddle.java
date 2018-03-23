package code.model;

import java.awt.Graphics2D;

import code.model.decoratorPattern.IElement;
import code.model.strategyPattern.MoveDown;
import code.model.strategyPattern.MoveStrategy;
import code.model.strategyPattern.MoveUp;

public class Paddle implements IElement{
	
	private String playerName;
	private int xPos, yPos;
	private int score;
	
	private MoveStrategy moveStrategyMoveUp;
	private MoveStrategy moveStrategyMoveDown;
	
	public Paddle(String playerName, int xPos, int yPos) {
		this.playerName = playerName;
		this.xPos = xPos;
		this.yPos = yPos;
		
		moveStrategyMoveUp = new MoveStrategy(new MoveUp());
		moveStrategyMoveDown = new MoveStrategy(new MoveDown());
	}
	
	
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.fillRect(xPos, yPos, Constant.PADDLE_WIDTH, Constant.PADDLE_HEIGHT);
	}


	//Getter - Setter
	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	//Methods
	public void moveUp() {
    	yPos = moveStrategyMoveUp.executeMoveStrategy(yPos);
    }
    
    public void moveDown() {
    	yPos = moveStrategyMoveDown.executeMoveStrategy(yPos);
    }
    
    public void increaseScore() {
    	score = score +1 ;
    }
	
}
