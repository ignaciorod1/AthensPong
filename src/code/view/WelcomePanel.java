package code.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel innerPanel;
	private JButton btnStartGame;
	
	public WelcomePanel() {
		super();
		getInnerContainer();
	}
	
	private JPanel getInnerContainer() {
		if(innerPanel == null) {
			innerPanel = new JPanel();
			innerPanel.setLayout(new GridBagLayout());
			innerPanel.add(getStartBtn(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return innerPanel;
	}
	
	private JButton getStartBtn() {
		if(btnStartGame == null){
			btnStartGame = new JButton("Start");
			btnStartGame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		}
		return btnStartGame;
	}
}
