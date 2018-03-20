package code.controller;

public class Manager /*implements ActionListener, KeyListener*/{

	/*
	 * Top hareket etmeli, her hareket ettiğinde repaint.
	 * paddle hareket etmeli, her hareket ettiğinde repaint.
	 * 
	 * paddle'a key listener eklenecek. hareketleri algılayabilecek.
	 * her paddle için score eklenecek. ana framenin altında bir yerde yazdırılabilir.
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
