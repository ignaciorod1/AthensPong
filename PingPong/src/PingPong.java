import java.awt.Dimension;

import javax.swing.JFrame;

import model.Constant;
import view.APingPongFrame;
import view.PingPongFrame;

public class PingPong {

	public static void main(String[] args) {
		
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            // Set up main window (using Swing's Jframe)
            JFrame frame = new JFrame("A Bouncing Ball");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new PingPongFrame());
            frame.setSize(new Dimension(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT));
//            frame.pack();
            frame.setVisible(true);
         }
      });
	}

}
