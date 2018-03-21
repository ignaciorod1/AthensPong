import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Paddle {
	public vector2d pos = new vector2d(0, 0);
	private int width;
	private int height;
	public int score;
	private int speed;
	
	public Paddle (int X, int Y,int paddlenumber) {
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
	
}
