package code.controller;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.PingPongMainFrame;
import code.model.Constant;
import code.model.Paddle;

public class PaddleManager implements ActionListener, KeyListener{

	private Graphics2D graphics;
	private Paddle playerOne;
	private Paddle playerTwo;
	
	public PaddleManager() {
		playerOne = new Paddle("PlayerOne", 0, Constant.WINDOW_HEIGHT/2-Constant.PADDLE_HEIGHT/2);
		playerTwo = new Paddle("PlayerTwo", Constant.WINDOW_WIDTH-Constant.PADDLE_WIDTH, Constant.WINDOW_HEIGHT/2-Constant.PADDLE_HEIGHT/2);
	}
	
	public Paddle getPlayerOne() {
		return playerOne;
	}

	public Paddle getPlayerTwo() {
		return playerTwo;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();

		if (id == KeyEvent.VK_W){
			playerOne.moveUp();
//			playerOne.draw(graphics);
			PingPongMainFrame.getInstance().getPingPongPanel().notifyDataChange();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
