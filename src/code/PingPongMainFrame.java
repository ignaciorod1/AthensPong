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
import code.view.WelcomePanel;

public class PingPongMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static PingPongMainFrame INSTANCE;
	private JPanel container;
	private PingPongPanel pingPongPanel;
	private WelcomePanel welcomePanel;
	
	public PingPongMainFrame() {
		super();
        this.setTitle("Ping Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getInnerContainer());
        this.setSize(new Dimension(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT));
        this.setResizable(false);
//        getInnerContainer().remove(0);
//        getInnerContainer().add(getPingPongPanel());
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
//			container.add(getWelcomePanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			container.add(getPingPongPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return container;
	}
	
	public WelcomePanel getWelcomePanel() {
		return ((welcomePanel == null) ? (welcomePanel = new WelcomePanel()) : welcomePanel);
	}
	
	public PingPongPanel getPingPongPanel() {
		return ((pingPongPanel == null) ? (pingPongPanel = new PingPongPanel()) : pingPongPanel);
	}
}
