import code.PingPongMainFrame;

public class PingPong {

	public static void main(String[] args) {
		setMainFrameVisible();
	}
	
	private static void setMainFrameVisible() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            PingPongMainFrame frame = new PingPongMainFrame();
	            frame.setVisible(true);
	         }
	      });
	}

}
