package code.controller;

import code.PingPongMainFrame;
import code.model.Ball;
import code.model.Constant;
import code.model.statePattern.PingPongState;
import code.model.strategyPattern.MoveStrategy;
import code.view.PingPongPanel;


public class BallManager{

	private PingPongPanel pingPongPanel;
    private Ball ball;
//	private IElement ball;
    PingPongState state = new PingPongState();
    
    private float ballSpeedX = Constant.BALL_SPEED_X_POS;
	private float ballSpeedY = Constant.BALL_SPEED_Y_POS;

    public BallManager(){
    	pingPongPanel = PingPongMainFrame.getInstance().getPingPongPanel();
        ball = new Ball(Constant.BALL_RADIUS,Constant.BALL_RADIUS);
//    	ball = new ElementDrawDecorator(new Ball(Constant.BALL_RADIUS,Constant.BALL_RADIUS));
    }
    
    public Ball getBall() {
    	return ball;
    }
    
//    public IElement getBall() {
//    	return ball;
//    }
    
    private int xPos;
    private int yPos;
    
    public void move() {
//		System.out.println("Ball Move");
    	xPos = ball.getXPos();
    	yPos = ball.getYPos();
    	
		int paddleYPos;
		//Check where is the ball, is it in playerOne region or playerTwo region.
		if(xPos < Constant.WINDOW_WIDTH/2) {
			paddleYPos = Manager.getInstance().getPaddleManager().getPlayerOne().getYPos();
		}else {
			paddleYPos = Manager.getInstance().getPaddleManager().getPlayerTwo().getYPos();
		}
		
//		 side walls
		if (yPos < 0 || yPos > Constant.WINDOW_HEIGHT - Constant.BALL_RADIUS) {
			ballSpeedY = -ballSpeedY;
		}
		
		// top / down walls
		if (xPos < 0) {
			ballSpeedX = -ballSpeedX;
			increaseScore();
			startNewRound();
//			++ scoreBottom;
		}
		
		if (xPos + Constant.BALL_RADIUS > Constant.WINDOW_WIDTH) {
			ballSpeedX = -ballSpeedX;
			increaseScore();
			startNewRound();
//			++ scoreTop;
		}
		
		// bottom pad - right
		if (xPos + Constant.PADDLE_WIDTH >= Constant.WINDOW_WIDTH - Constant.PADDLE_WIDTH /*-Constant.BALL_RADIUS*/ && ballSpeedX > 0)
			if (yPos + Constant.BALL_RADIUS >= paddleYPos && yPos <= paddleYPos + Constant.PADDLE_HEIGHT)
				ballSpeedX = -ballSpeedX;

		// top pad - left
		if (xPos <= Constant.PADDLE_WIDTH && ballSpeedX < 0)
			if (yPos + Constant.BALL_RADIUS >= paddleYPos && yPos <= paddleYPos + Constant.PADDLE_HEIGHT)
				ballSpeedX = -ballSpeedX;
		
		keepMoving();
	}
	
	private void startNewRound() {
		xPos = Constant.WINDOW_WIDTH/2;
		yPos = Constant.WINDOW_HEIGHT/2;
		
		ball.setXPos(xPos);
		ball.setYPos(yPos);
	}
	
	private void keepMoving() {
		xPos += ballSpeedX;
        yPos += ballSpeedY;
        
        ball.setXPos(xPos);
		ball.setYPos(yPos);
	}
	
	/**
	 * This method increase player score
	 */
	private void increaseScore() {
		System.out.println("Increase player score");
		if(xPos < Constant.WINDOW_WIDTH/2) {
			Manager.getInstance().getPaddleManager().getPlayerOne().increaseScore();
		}else {
			Manager.getInstance().getPaddleManager().getPlayerTwo().increaseScore();
		}
	}
}
