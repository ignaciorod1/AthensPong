package code.controller;

public class Manager /*implements ActionListener, KeyListener*/{

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
	private BallManager ballManager;
	
	private Manager() {
		paddleManager = new PaddleManager();
		ballManager = new BallManager();
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
	
	
	public BallManager getBallManager() {
		return ballManager;
	}

	public void launch() {
		ballManager.getBall().run();
//		paddleManager.drawInitialPaddles();
//		drawBall();
	}
	
}
