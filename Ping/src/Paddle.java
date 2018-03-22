import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Paddle {
	private vector2d pos = new vector2d(0, 0);
	private int width;
	private int height;
	private int score;
	private int speed;
	
	public Paddle (int X, int Y) {
		this.score = 0;
		this.pos.x = X;
		this.pos.y = Y;
		this.width = 40; //constantes???
		this.height = 10;
		this.speed=1;
		//Rectangle2D pad = new Rectangle(this.pos.x, this.pos.y, this.width, this.height);
		//g.fill(pad);
	}
	
	public void update (Graphics2D g) {
		Rectangle2D pad = new Rectangle(this.pos.x, this.pos.y, this.width, this.height);
		g.fill(pad);
	}
	
	public void move(int direction) {//direction: 1 -> right, 0 -> left
				if (direction == 0)
					this.pos.x-= (this.pos.x > 0) ? this.speed : 0;
				else if (direction == 1) //direction == 1
					this.pos.x += (this.pos.x < 294 - this.width) ? this.speed : 0;
	}
	

public void setscore(int score) {
	this.score = score;
}

public void setX (int X) {
	this.pos.x  = X;
}
public void setY(int Y) {
	this.pos.y  = Y;
}

public int getscore() {
	return this.score;
}
public int getPadX() {
	return this.pos.x;
}
public int getPadY() {
	return this.pos.y;
}
}
