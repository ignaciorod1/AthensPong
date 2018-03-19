import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.*;


public class Game extends JPanel implements KeyListener, ActionListener {
	
	private int height, width;
	private Timer t = new Timer(5, this);
	private boolean first;
	
	private HashSet<String> keys = new HashSet<String>();
	
	// pad
	private final int SPEED = 1;
	private int padH = 10, padW = 40;
	private int P2_PadX, P1_PadX;
	private int inset = 10;
	
	// ball
	private double ballX, ballY, velX = 1, velY = 1, ballSize = 20;
	
	// score
	private int scoreTop, scoreBottom;
	
	public Game() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		first = true;
		t.setInitialDelay(100);
		t.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		height = getHeight();
		width = getWidth();

		// initial positioning
		if (first) {
			P2_PadX = width / 2 - padW / 2;
			P1_PadX = P2_PadX;
			ballX = width / 2 - ballSize / 2;
			ballY = height / 2 - ballSize / 2;
			first = false;
		}
		
		// bottom pad
		Rectangle2D bottomPad = new Rectangle(P2_PadX, height - padH - inset, padW, padH);
		g2d.fill(bottomPad);
		
		// top pad
		Rectangle2D topPad = new Rectangle(P1_PadX, inset, padW, padH);
		g2d.fill(topPad);
		
		// ball
		Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
		g2d.fill(ball);
		
		// scores
		String scoreB = "Bottom: " + new Integer(scoreBottom).toString();
		String scoreT = "Top: " + new Integer(scoreTop).toString();
		g2d.drawString(scoreB, 10, height / 2);
		g2d.drawString(scoreT, width - 50, height / 2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// side walls
		if (ballX < 0 || ballX > width - ballSize) {
			velX = -velX;
		}
		// top / down walls
		if (ballY < 0) {
			velY = -velY;
			++ scoreBottom;
		}
		
		if (ballY + ballSize > height) {
			velY = -velY;
			++ scoreTop;
		}
		// bottom pad
		if (ballY + ballSize >= height - padH - inset && velY > 0)
			if (ballX + ballSize >= P2_PadX && ballX <= P2_PadX + padW)
				velY = -velY;

		// top pad
		if (ballY + ballSize >= height - padH - inset && velY > 0)
			if (ballX + ballSize >= P1_PadX && ballX <= P1_PadX + padW)
				velY = -velY;

		ballX += velX;
		ballY += velY;
		
		// pressed keys
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				P2_PadX -= (P2_PadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("RIGHT")) {
				P2_PadX += (P2_PadX < width - padW) ? SPEED : 0;
			}
			else if (keys.contains("Z")) {
				P1_PadX -= (P1_PadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("X")) {
				P1_PadX += (P1_PadX < width - padW) ? SPEED : 0;
			}
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.add("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.add("RIGHT");
			break;
		case KeyEvent.VK_Z:
			keys.add("Z");
			break;
		case KeyEvent.VK_X:
			keys.add("X");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.remove("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.remove("RIGHT");
			break;
		case KeyEvent.VK_Z:
			keys.remove("Z");
			break;
		case KeyEvent.VK_X:
			keys.remove("X");
			break;
		}
	}
}