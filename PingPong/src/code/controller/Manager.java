package code.controller;

import code.PingPongMainFrame;

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
	
	private static PingPongMainFrame mainFrame;
	private PaddleManager paddleManager;
	
	private Manager() {
		mainFrame = PingPongMainFrame.getInstance();
//		mainFrame.getPingPongPanel().addKeyListener(this);
//		mainFrame.addKeyListener(this);
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
