import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import constants.Constants;

public class Ball {

	private double velX = 1, velY = 1, ballSize = 20, ballX, ballY;

	private static Ball instance = new Ball();

	private Ball() {
		this.velX = 1;
		this.velY = 1;
		this.ballSize = 20;

	}

	public static Ball getInstance() {
		return instance;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public void setBallSize(double ballSize) {
		this.ballSize = ballSize;
	}

	public double getBallX() {
		return ballX;
	}

	public void setBallX(double ballX) {
		this.ballX = Constants.WINDOW_WIDTH / 2 - ballSize / 2;
	}

	public double getBallY() {
		return ballY;
	}

	public void setBallY(double ballY) {
		this.ballY = Constants.WINDOW_HEIGHT / 2 - ballSize / 2;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public double getBallSize() {
		return ballSize;

	}

	public void update(Graphics2D g) {
		Ellipse2D ball = new Ellipse2D.Double(instance.ballX, instance.ballY, instance.ballSize, instance.ballSize);
		g.fill(ball);
	}

	// pad1 bottom
	public void move(Paddle bottomPad, Paddle topPad) {

		if (ballX < 0 || ballX > Constants.WINDOW_WIDTH - ballSize) {
			velX = -velX;

		}
		// top / down walls
		if (ballY < 0) {
			velY = -velY;
			bottomPad.score++;
		}

		if (ballY + ballSize > Constants.WINDOW_HEIGHT) {
			velY = -velY;
			topPad.score++;
		}
		// bottom pad
		if (ballY + ballSize >= Constants.WINDOW_HEIGHT - Constants.PADDLE_HEIGHT - Constants.INSET && velY > 0)
			if (ballX + ballSize >= bottomPad.pos.x && ballX <= bottomPad.pos.x + Constants.PADDLE_WIDTH)
				velY = -velY;

		// top pad
		if (ballY == Constants.INSET + Constants.PADDLE_HEIGHT && velY < 0)
			if (ballX + ballSize >= topPad.pos.x && ballX <= topPad.pos.x + Constants.PADDLE_WIDTH)
				velY = -velY;

		ballX += velX;
		ballY += velY;

	}

}
