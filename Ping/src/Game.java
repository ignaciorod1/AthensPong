import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.*;

public class Game extends JPanel implements KeyListener, ActionListener {

	// private int height, width;
	private static final long serialVersionUID = 1L;
	private Timer t = new Timer(5, this);
	private boolean first;
	
	private int height = 671, width = 294;// constants
	private int padH = 10, padW = 40;
	private int inset = 10;
	// Paddle motion flags
	boolean flag_TL = false;
	boolean flag_BL = false;
	boolean flag_TR = false;
	boolean flag_BR = false;
	// score
	private Ball Tball = Ball.getInstance();
    private Paddle bottomPad = new Paddle(width / 2 - 20, height - padH - inset, 1); // �constantes: 20???? height
	private Paddle topPad = new Paddle(width / 2 - 20, inset, 2);

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
		// height = getHeight();
		// width = getWidth();

		// initial positioning
		if (first) {

			first = false;
		}

		// paddle
		bottomPad.update(g2d);
		topPad.update(g2d);
		Tball.update(g2d);

		// scores
		String scoreB = "Bottom: " + new Integer(bottomPad.score).toString();
		String scoreT = "Top: " + new Integer(topPad.score).toString();
		g2d.drawString(scoreB, 10, height / 2);
		g2d.drawString(scoreT, width - 50, height / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Tball.move(bottomPad, topPad);

		// pads
		if (flag_BL)
			bottomPad.move(0);
		if (flag_TL)
			topPad.move(0);
		if (flag_BR)
			bottomPad.move(1);
		if (flag_TR)
			topPad.move(1);

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			flag_BL = true;
			break;
		case KeyEvent.VK_RIGHT:
			flag_BR = true;
			break;
		case KeyEvent.VK_Z:
			flag_TL = true;
			break;
		case KeyEvent.VK_X:
			flag_TR = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			flag_BL = false;
			break;
		case KeyEvent.VK_RIGHT:
			flag_BR = false;
			break;
		case KeyEvent.VK_Z:
			flag_TL = false;
			break;
		case KeyEvent.VK_X:
			flag_TR = false;
			break;
		}

	}
}

