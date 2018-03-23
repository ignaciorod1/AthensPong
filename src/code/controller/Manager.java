package code.controller;

public class Manager{

	private final static Manager INSTANCE = new Manager();
	
	private PaddleManager paddleManager;
	private BallManager ballManager;
	
	private Manager() {
		paddleManager = new PaddleManager();
		ballManager = new BallManager();
	}
	
	public static Manager getInstance() {
		return INSTANCE;
	}
	
	public PaddleManager getPaddleManager() {
		return paddleManager;
	}
	
	
	public BallManager getBallManager() {
		return ballManager;
	}
	
}
