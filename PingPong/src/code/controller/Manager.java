package code.controller;

import code.pong.Ball;
import code.pong.Paddle;
import code.view.PingPongPanel;

public class Manager {

	/*
	 * Top hareket etmeli, her hareket ettiðinde repaint.
	 * paddle hareket etmeli, her hareket ettiðinde repaint.
	 * 
	 * paddle'a key listener eklenecek. hareketleri algýlayabilecek.
	 * her paddle için score eklenecek. ana framenin altýnda bir yerde yazdýrýlabilir.
	 * */
//	private PingPongPanel frame;
//	private Ball ball;/
	
	private static Manager INSTANCE;
	
	private PaddleManager paddleManager;
	
	private Manager() {
		paddleManager = new PaddleManager();
	}
	
	public static Manager getInstance() {
		if(INSTANCE == null) {
			INSTANCE= new Manager();
		}
		return INSTANCE;
	}
	
	
	
	public PaddleManager getPaddleManager() {
		return paddleManager;
	}

	public void launch() {
//		paddleManager.drawInitialPaddles();
//		drawBall();
	}
	
}
