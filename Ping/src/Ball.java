mport java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball implements StrategyGraphics{

	private int height = 671, width = 294;
	private double velX = 1, velY = 1, ballSize = 20, ballX, ballY;
	private int padH = 10, padW = 40;
	private int inset = 10;

	private static Ball instance = new Ball();

	private Ball() {
		this.velX = 1;
		this.velY = 1;
		this.ballSize=20;
		
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
		this.ballX = width / 2 - ballSize / 2;
	}

	public double getBallY() {
		return ballY;
	}

	public void setBallY(double ballY) {
		this.ballY = height / 2 - ballSize / 2;
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
	//pad1 bottom
	public void move(Paddle bottomPad, Paddle topPad) {
		
		if (ballX < 0 || ballX > width - ballSize) {
			velX = -velX;
			
		}
		// top / down walls
		if (ballY < 0) {
			velY = -velY;
			bottomPad.score++;
		}
		
		if (ballY + ballSize > height) {
			velY = -velY;
			topPad.score++;
		}
		// bottom pad
	    if (ballY + ballSize >= height - padH - inset && velY > 0)
			if (ballX + ballSize >= bottomPad.pos.x && ballX <= bottomPad.pos.x + padW)
				velY = -velY;

		// top pad
		if (ballY == inset + padH && velY < 0)
			if (ballX + ballSize >= topPad.pos.x && ballX <= topPad.pos.x + padW)
				velY = -velY;

		ballX += velX;
	   	ballY += velY;

	}
	
}

