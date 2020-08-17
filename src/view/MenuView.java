/**
 * Popup to read the rules again or the end the game.
 */
package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Mia Gudelj
 * @since 01.07.2020
 * @version 1.0
 */
public class MenuView extends JDialog {
	
	private JButton endButton, anleitungButton, backButton;
	private JPanel buttonPanel;

	/**
	 * constructor
	 * 
	 * @param parent
	 * @param modal
	 */
	public MenuView(JFrame parent, boolean modal) {
		super(parent, modal);
		//
		setName("Menü");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(250, 350);
		//
		init();
		//
		setVisible(false);
		setResizable(false);
	}

	/**
	 * create view-elements and set them to the window/frame 
	 */
	private void init() {
		
		// Buttons
		endButton = new JButton("Spiel beenden");
		endButton.setBackground(Color.white);
		endButton.setForeground(Color.black);
		endButton.setFont(endButton.getFont().deriveFont(20.0f));
		endButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.5f), Color.black));
		
		anleitungButton = new JButton("Anleitung");
		anleitungButton.setBackground(endButton.getBackground());
		anleitungButton.setForeground(endButton.getForeground());
		anleitungButton.setFont(endButton.getFont());
		anleitungButton.setBorder(endButton.getBorder());
		
		backButton = new JButton("zurück");
		backButton.setBackground(endButton.getBackground());
		backButton.setForeground(endButton.getForeground());
		backButton.setFont(endButton.getFont());
		backButton.setBorder(endButton.getBorder());
		
		buttonPanel = new JPanel(new GridLayout(3, 1, 0, 50));
		buttonPanel.add(endButton);
		buttonPanel.add(anleitungButton);
		buttonPanel.add(backButton);
		buttonPanel.setBackground(Color.red.darker());
		
		getContentPane().setLayout(new BorderLayout(40, 40));
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		getContentPane().add(new JLabel(), BorderLayout.NORTH);
		getContentPane().add(new JLabel(), BorderLayout.SOUTH);
		getContentPane().add(new JLabel(), BorderLayout.WEST);
		getContentPane().add(new JLabel(), BorderLayout.EAST);
		getContentPane().setBackground(buttonPanel.getBackground());
		
		// ACTIONLISTENER
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
				cancelGameandGoBackToHome(e);			
			}
		});
		
		anleitungButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				openAnleitung(e);
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				backToGame(e);					
			}
		});
	}
	
	private void backToGame(ActionEvent e) {
		this.setVisible(false);
		
	}

	private void openAnleitung(ActionEvent e) {
		AnleitungPopUpView anleitung = new AnleitungPopUpView(null, rootPaneCheckingEnabled);
		anleitung.dispose();
	}

	private void cancelGameandGoBackToHome(ActionEvent e) {
		StartseiteView start = new StartseiteView();
		start.setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new MenuView(new JFrame(), true);
	}*/

}
