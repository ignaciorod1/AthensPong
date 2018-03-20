package code;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.controller.Manager;
import code.model.Constant;
import code.view.PingPongPanel;

public class PingPongMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static PingPongMainFrame INSTANCE;
	private JPanel container;
	private PingPongPanel pingPongPanel;
	private JButton launchBtn;
	
	public PingPongMainFrame() {
		super();
        this.setTitle("Ping Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getInnerContainer());
        this.setSize(new Dimension(Constant.WINDOW_WIDTH+20, Constant.WINDOW_HEIGHT+20));
//      this.pack();
	}
	
	public static PingPongMainFrame getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PingPongMainFrame();
		} 
		return INSTANCE;
	}
	
	private JPanel getInnerContainer() {
		if(container == null) {
			container = new JPanel();
			container.setLayout(new GridBagLayout());
			container.add(getPingPongPanel(), new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			container.add(getLaunchBtn(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return container;
	}
	
	public PingPongPanel getPingPongPanel() {
		return ((pingPongPanel == null) ? (pingPongPanel = new PingPongPanel()) : pingPongPanel);
	}
	
	private JButton getLaunchBtn() {
		if(launchBtn == null) {
			launchBtn = new JButton("Launch");
			launchBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Manager.getInstance().launch();
					
				}
			});
		}
		return launchBtn;
	}
}
