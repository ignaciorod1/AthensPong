package code.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import code.controller.Manager;

public class PingPongPanel extends APingPongPanel implements KeyListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	 private Timer timer = new Timer(70, this);
	 
	boolean flag_1D=false;
	boolean flag_2D=false;
	boolean flag_1U=false;
	boolean flag_2U=false;
	
	public PingPongPanel() {
		super();
		this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();
		addKeyListener(this);
		timer.setInitialDelay(100);
		timer.start();
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setColor(Color.PINK);
		Manager.getInstance().getPaddleManager().getPlayerOne().draw(graphics);
		Manager.getInstance().getPaddleManager().getPlayerTwo().draw(graphics);
		Manager.getInstance().getBallManager().getBall().draw(graphics);
		
		String score1 = "Player 1: " + new Integer(Manager.getInstance().getPaddleManager().getPlayerTwo().getScore()).toString();
		String score2 = "Player 2: " + new Integer(Manager.getInstance().getPaddleManager().getPlayerOne().getScore()).toString();
		g.drawString(score1, 10, getHeight()-50);
		g.drawString(score2, getWidth() - 75, getHeight()-50);
	}
	
	public void notifyDataChange() {
		this.repaint();
		this.revalidate();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_W:
			flag_1U=true;
			break;
			
		case KeyEvent.VK_S:
			flag_1D=true;	
			break;
			
		case KeyEvent.VK_UP:
			flag_2U=true;
			break;
			
		case KeyEvent.VK_DOWN:
			flag_2D=true;	
			break;
		default:
			break;
		}
		notifyDataChange();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("keyReleased");
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_W:
			flag_1U=false;
			break;
			
		case KeyEvent.VK_S:
			flag_1D=false;	
			break;
			
		case KeyEvent.VK_UP:
			flag_2U=false;
			break;
			
		case KeyEvent.VK_DOWN:
			flag_2D=false;	
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("KeyEvent");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// pads
	   	if(flag_2D)
	   		Manager.getInstance().getPaddleManager().getPlayerTwo().moveDown();
		if(flag_1D)
			Manager.getInstance().getPaddleManager().getPlayerOne().moveDown();
		if(flag_2U)
			Manager.getInstance().getPaddleManager().getPlayerTwo().moveUp();
		if(flag_1U)
			Manager.getInstance().getPaddleManager().getPlayerOne().moveUp();
		
		Manager.getInstance().getBallManager().move();
		notifyDataChange();
	}
}
