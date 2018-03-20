package code.controller;
package model;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.PingPongMainFrame;
import code.model.Constant;
import code.model.Ball;


public class BallManager implements ActionListener, KeyListener{

    private Graphics2D graphics;
    private Ball ball;

    public BallManager(){
        ball = new Ball()
    }
    
    public int checkCollision(Paddle paddle)
	{
		if (this.x < paddle.x + paddle.width && this.x + width > paddle.x && this.y < paddle.y + paddle.height && this.y + height > paddle.y)
		{
			return 1; //bounce
		}
		else if ((paddle.x > x && paddle.paddleNumber == 1) || (paddle.x < x - width && paddle.paddleNumber == 2))
		{
			return 2; //score
		}

		return 0; //nothing
	}
}
