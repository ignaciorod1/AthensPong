import code.PingPongMainFrame;

public class PingPong {

	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            PingPongMainFrame frame = new PingPongMainFrame();
            frame.setVisible(true);
         }
      });
	}

}
