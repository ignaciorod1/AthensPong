package code.controller;

import java.awt.Graphics2D;

import code.model.Ball;
import code.model.Constant;


public class BallManager{

    private Graphics2D graphics;
    private Ball ball;

    public BallManager(){
        ball = new Ball(Constant.BALL_RADIUS,Constant.BALL_HEIGHT);
    }
    
    public Ball getBall() {
    	return ball;
    }
    
//    public int checkCollision(Paddle paddle)
//	{
//		if (this.x < paddle.x + paddle.width && this.x + width > paddle.x && this.y < paddle.y + paddle.height && this.y + height > paddle.y)
//		{
//			return 1; //bounce
//		}
//		else if ((paddle.x > x && paddle.paddleNumber == 1) || (paddle.x < x - width && paddle.paddleNumber == 2))
//		{
//			return 2; //score
//		}
//
//		return 0; //nothing
//	}
}
