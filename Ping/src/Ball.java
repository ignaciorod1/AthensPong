
public class Ball {

	private int height = 671, width = 294;
	private double velX = 1, velY = 1, ballSize = 20, ballX, ballY;

	private static Ball instance = new Ball();

	private Ball() {
		
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

	public void setBallX(double X) {
		this.ballX = width / 2 - ballSize / 2;
	}

	public double getBallY() {
		return ballY;
	}

	public void setBallY(double Y) {
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

}
