/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.Game;
import service.ImageFinder;

/**
 * @author Mia Gudelj
 * @since 03.07.2020
 * @version 1.0
 *
 */
public class NextPlayerView extends JDialog {

	private Game game;
	private JButton goButton;
	private JLabel messsage;
	private JPanel labelPanel, buttonPanel, panel;

	/**
	 * Constructor
	 * 
	 * @param parent
	 * @param modal
	 * @param game
	 */
	public NextPlayerView(Frame parent, boolean modal, Game game) {
		super(parent, modal);
		this.game = game;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//
		init();
		//
		setVisible(false);
		setResizable(false);
	}

	/**
	 * initializing the components and builds the components to the frame
	 */
	private void init() {

		// JLabel
		messsage = new JLabel("Spieler " + game.getCurrentPlayer().getName() + " ist an der Reihe");
		messsage.setForeground(Color.black);
		messsage.setFont(messsage.getFont().deriveFont(24.0f));
		messsage.setHorizontalAlignment(JLabel.CENTER);

		// labelPanel
		labelPanel = new JPanel(new BorderLayout(0, 10));
		labelPanel.add(messsage, BorderLayout.CENTER);
		labelPanel.add(new JLabel(), BorderLayout.NORTH);
		labelPanel.add(new JLabel(), BorderLayout.WEST);
		labelPanel.add(new JLabel(), BorderLayout.EAST);
		labelPanel.add(new JLabel(), BorderLayout.SOUTH);
		labelPanel.setBackground(Color.red.darker());

		// JButton
		goButton = new JButton("los gehts!");
		goButton.setBackground(Color.white);
		goButton.setForeground(Color.black);
		goButton.setFont(goButton.getFont().deriveFont(20.0f));
		goButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f), Color.black));

		// buttonPanel
		buttonPanel = new JPanel(new BorderLayout(150, 25));
		buttonPanel.add(goButton, BorderLayout.CENTER);
		buttonPanel.add(new JLabel(), BorderLayout.NORTH);
		buttonPanel.add(new JLabel(), BorderLayout.WEST);
		buttonPanel.add(new JLabel(), BorderLayout.EAST);
		buttonPanel.add(new JLabel(), BorderLayout.SOUTH);
		/*
		 * buttonPanel.add(new JLabel()); buttonPanel.add(new JLabel());
		 */
		buttonPanel.setBackground(labelPanel.getBackground());

		// panel
		panel = new JPanel(new GridLayout(2, 1, 10, 10));
		panel.add(labelPanel);
		panel.add(buttonPanel);
		panel.setBackground(buttonPanel.getBackground());

		getContentPane().setLayout(new BorderLayout(500, 300));
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(new JLabel(), BorderLayout.NORTH);
		getContentPane().add(new JLabel(), BorderLayout.WEST);
		getContentPane().add(new JLabel(), BorderLayout.EAST);
		getContentPane().add(new JLabel(), BorderLayout.SOUTH);
		getContentPane().setBackground(panel.getBackground());

		// ACTIONLISTENER
		goButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resumeGame(e);				
			}
		});
	}

	/**
	 * Listener to resume the game
	 * 
	 * @param e
	 */
	private void resumeGame(ActionEvent e) {
		GameView gameView = new GameView(null, rootPaneCheckingEnabled, game, new ImageFinder());
		gameView.setVisible(true);
		this.setVisible(false);
		dispose();

	}
	
	/*public static void main(String[] args) {
		Player p1, p2, p3, p4;

		p1 = new Player("1");
		p4 = new Player("2");
		p2 = new Player("3");
		p3 = new Player("4");

		Game game = new Game(p1, p2, p3, p4);

		p1.setGame(game);
		p2.setGame(game);
		p3.setGame(game);
		p4.setGame(game);
		new NextPlayerView(null, false, game);
	}*/
}
