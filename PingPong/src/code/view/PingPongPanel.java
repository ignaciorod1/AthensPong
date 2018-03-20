package code.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.controller.Manager;

public class PingPongPanel extends APingPongPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	public PingPongPanel() {
		super();
		this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();
		addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setColor(Color.PINK);
		Manager.getInstance().getPaddleManager().getPlayerOne().draw(graphics);
		Manager.getInstance().getPaddleManager().getPlayerTwo().draw(graphics);
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
			Manager.getInstance().getPaddleManager().getPlayerOne().moveUp();
			break;
			
		case KeyEvent.VK_S:
			Manager.getInstance().getPaddleManager().getPlayerOne().moveDown();	
			break;
			
		case KeyEvent.VK_UP:
			Manager.getInstance().getPaddleManager().getPlayerTwo().moveUp();
			break;
			
		case KeyEvent.VK_DOWN:
			Manager.getInstance().getPaddleManager().getPlayerTwo().moveDown();
			break;
		default:
			break;
		}
		notifyDataChange();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyEvent");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ActionEvent");
		
	}

}
