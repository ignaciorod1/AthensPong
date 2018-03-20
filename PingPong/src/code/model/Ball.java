package code.model;

import java.awt.Graphics2D;

import code.PingPongMainFrame;

public class Ball implements IMovementAction, Runnable{
	private int xPos, yPos;
	
	public Ball(int x, int y){
		this.xPos = x;
		this.yPos = y;
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.fillOval(xPos, yPos, Constant.BALL_RADIUS, Constant.BALL_HEIGHT);
	}
	
	@Override
	public void move() {
		run();
	}
	
	 private float ballSpeedX = 3;   // Ball's speed for x and y
	 private float ballSpeedY = 2;

	@Override
	public void run() {
		while (true) { // Execute one update step
            // Calculate the ball's new position
			xPos += ballSpeedX;
            yPos += ballSpeedY;
            // Check if the ball moves over the bounds
            // If so, adjust the position and speed.
            if (xPos - Constant.BALL_RADIUS < 0) {
            	ballSpeedX = -ballSpeedX; // Reflect along normal
               xPos = Constant.BALL_RADIUS; // Re-position the ball at the edge
            } else if (xPos + Constant.BALL_RADIUS > Constant.WINDOW_WIDTH) {
            	ballSpeedX = -ballSpeedX;
               xPos = Constant.WINDOW_WIDTH - Constant.BALL_RADIUS;
            }
            // May cross both x and y bounds
            if (yPos - Constant.BALL_HEIGHT < 0) {
            	ballSpeedY = -ballSpeedY;
               yPos = Constant.BALL_HEIGHT;
            } else if (yPos + Constant.BALL_HEIGHT > Constant.WINDOW_HEIGHT) {
            	ballSpeedY = -ballSpeedY;
               yPos = Constant.WINDOW_HEIGHT - Constant.BALL_HEIGHT;
            }
            try {
				Thread.sleep(100);
				PingPongMainFrame.getInstance().getPingPongPanel().notifyDataChange();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
