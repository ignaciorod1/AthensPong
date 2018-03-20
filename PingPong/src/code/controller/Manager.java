package code.controller;

import code.pong.Ball;
import code.pong.Paddle;
import code.view.PingPongPanel;

public class Manager {

	/*
	 * Top hareket etmeli, her hareket etti�inde repaint.
	 * paddle hareket etmeli, her hareket etti�inde repaint.
	 * 
	 * paddle'a key listener eklenecek. hareketleri alg�layabilecek.
	 * her paddle i�in score eklenecek. ana framenin alt�nda bir yerde yazd�r�labilir.
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
