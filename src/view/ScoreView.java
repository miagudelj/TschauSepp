/**
 * Displays the scoreboard at the end of the game.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import model.Game;
import model.Player;
import service.ImageFinder;

/**
 * @author Mia Gudelj
 * @since 04.07.2020
 * @version 1.0
 *
 */
public class ScoreView extends JDialog {

	Game game;
	Vector<Player> players;
	//Vector<Integer> points;

	private JButton endButton, continueButton;
	private JLabel title, firstPlaceLabel, secondPlaceLabel, thirdPlaceLabel, fourthPlaceLabel;
	private JLabel pointsFirstPlaceLabel, pointsSecondPlaceLabel, pointsThirdPlaceLabel, pointsFourthPlaceLabel;
	private JPanel titlePanel, bodyPanel, panel, buttonPanel, buttonInnerPanel;

	public ScoreView(Frame parent, boolean modal, Game game) {
		super(parent, modal);
		//
		this.game = game;
		players = new Vector<Player>();
		players.addAll(game.getPlayers());
		
		/*points = new Vector<Integer>();
		points.add(game.getPlayer(0).getPoint());
		points.add(game.getPlayer(1).getPoint());
		points.add(game.getPlayer(2).getPoint());
		points.add(game.getPlayer(3).getPoint());*/
		//
		setName("Tschau Sepp");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());

		//
		init();
		//
		setVisible(false);
		setResizable(false);
	}

	private void init() {

		// titel
		title = new JLabel("WINNER");
		title.setFont(title.getFont().deriveFont(30.0f));
		title.setForeground(Color.black);
		title.setHorizontalAlignment(JLabel.CENTER);

		// title panel
		titlePanel = new JPanel(new BorderLayout(570, 20));
		titlePanel.add(title, BorderLayout.CENTER);
		titlePanel.add(new JLabel(), BorderLayout.NORTH);
		titlePanel.add(new JLabel(), BorderLayout.WEST);
		titlePanel.add(new JLabel(), BorderLayout.EAST);
		titlePanel.add(new JLabel(), BorderLayout.SOUTH);
		titlePanel.setBackground(Color.red.darker());

		sortPlayers();

		//Collections.sort(points);

		// labels for names
		firstPlaceLabel = new JLabel("#1\t" + players.get(0).getName());
		firstPlaceLabel.setForeground(Color.black);
		firstPlaceLabel.setFont(firstPlaceLabel.getFont().deriveFont(24.0f));

		secondPlaceLabel = new JLabel("#2\t" + players.get(1).getName());
		secondPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		secondPlaceLabel.setFont(firstPlaceLabel.getFont());

		thirdPlaceLabel = new JLabel("#3\t" + players.get(2).getName());
		thirdPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		thirdPlaceLabel.setFont(firstPlaceLabel.getFont());

		fourthPlaceLabel = new JLabel("#4\t" + players.get(3).getName());
		fourthPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		fourthPlaceLabel.setFont(firstPlaceLabel.getFont());

		// text fields for name input
		pointsFirstPlaceLabel = new JLabel("Points: " + players.get(0).getPoint());
		pointsFirstPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		secondPlaceLabel.setFont(firstPlaceLabel.getFont());

		// nameText1.setMargin(new Insets(0, 30, 0, 30));
		pointsSecondPlaceLabel = new JLabel("Points: " + players.get(1).getPoint());
		pointsSecondPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		secondPlaceLabel.setFont(firstPlaceLabel.getFont());

		pointsThirdPlaceLabel = new JLabel("Points: " + players.get(2).getPoint());
		pointsThirdPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		secondPlaceLabel.setFont(firstPlaceLabel.getFont());

		pointsFourthPlaceLabel = new JLabel("Points: " + players.get(3).getPoint());
		pointsFourthPlaceLabel.setForeground(firstPlaceLabel.getForeground());
		secondPlaceLabel.setFont(firstPlaceLabel.getFont());

		// panel
		panel = new JPanel(new GridLayout(8, 1, 0, 20));
		panel.add(firstPlaceLabel);
		panel.add(pointsFirstPlaceLabel);
		panel.add(secondPlaceLabel);
		panel.add(pointsSecondPlaceLabel);
		panel.add(thirdPlaceLabel);
		panel.add(pointsThirdPlaceLabel);
		panel.add(fourthPlaceLabel);
		panel.add(pointsFourthPlaceLabel);
		panel.setBackground(titlePanel.getBackground());

		// bodyPanel
		bodyPanel = new JPanel(new BorderLayout(550, 90));
		bodyPanel.add(panel, BorderLayout.CENTER);
		bodyPanel.add(new JLabel(), BorderLayout.NORTH);
		bodyPanel.add(new JLabel(), BorderLayout.WEST);
		bodyPanel.add(new JLabel(), BorderLayout.EAST);
		bodyPanel.add(new JLabel(), BorderLayout.SOUTH);
		bodyPanel.setBackground(panel.getBackground());

		// buttons
		endButton = new JButton("Beenden");
		endButton.setBackground(Color.white);
		endButton.setForeground(Color.black);
		endButton.setFont(endButton.getFont().deriveFont(24.0f));
		endButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f), Color.black));

		continueButton = new JButton("Weiter");
		continueButton.setBackground(endButton.getBackground());
		continueButton.setForeground(endButton.getForeground());
		continueButton.setFont(endButton.getFont());
		continueButton.setBorder(endButton.getBorder());

		// buttonInnerPanel
		buttonInnerPanel = new JPanel(new GridLayout(1, 2, 100, 0));
		buttonInnerPanel.setBackground(panel.getBackground());
		buttonInnerPanel.add(continueButton);
		buttonInnerPanel.add(endButton);

		// buttonPanel
		buttonPanel = new JPanel(new BorderLayout(500, 100));
		buttonPanel.setBackground(buttonInnerPanel.getBackground());
		buttonPanel.add(buttonInnerPanel, BorderLayout.CENTER);
		buttonPanel.add(new JLabel(), BorderLayout.NORTH);
		buttonPanel.add(new JLabel(), BorderLayout.WEST);
		buttonPanel.add(new JLabel(), BorderLayout.EAST);
		buttonPanel.add(new JLabel(), BorderLayout.SOUTH);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		// getContentPane().setLayout(new BorderLayout(500, 200));
		getContentPane().add(titlePanel, BorderLayout.NORTH);
		getContentPane().add(bodyPanel, BorderLayout.CENTER);
		getContentPane().add(new JLabel(), BorderLayout.WEST);
		getContentPane().add(new JLabel(), BorderLayout.EAST);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		getContentPane().setBackground(Color.red.darker());

		// ACTIONLISTENER
		continueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayer(0).getPoint() < 200 || game.getPlayer(1).getPoint() < 200
						|| game.getPlayer(2).getPoint() < 200 || game.getPlayer(3).getPoint() < 200) {

					dispose();
					startNewRound(e);
				} else {
					continueButton.setText("Neues Spiel");
					startNewGame(e);
				}

			}
		});

		endButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);

			}
		});
	}

	private void sortPlayers() {

		// sort players with bubblesort
		int[] points = new int[4];
		boolean sorted = false;

		Player p;
		Player player;
		Player nextPlayer;

		while (!sorted) {
			sorted = true;
			for (int i = 0; i < 3; i++) { // Bubblesort zum Gewinner herausfinden
				player = players.get(i);
				nextPlayer = players.get(i + 1);

				for (int j = 0; j < player.getDeck().size(); j++) {
					points[i] += player.getDeck().getCards().get(j).getValue().getPoints();
				}

				for (int j = 0; j < nextPlayer.getDeck().size(); j++) {
					points[i + 1] += nextPlayer.getDeck().getCards().get(j).getValue().getPoints();
				}

				if (points[i] > points[i + 1]) {
					p = nextPlayer;
					nextPlayer = player;
					player = p;

					int point = points[i + 1];
					points[i + 1] = points[i];
					points[i] = point;

					sorted = false;
				}
			}
		}
	}

	private void startNewRound(ActionEvent e) {

		game.newGame();

		for (int i = 0; i < game.getPlayers().size(); i++) {
			game.getPlayer(i).setGame(game);
			game.getPlayer(i).setPoints(game.getPlayer(i).getPoint());
		}

		GameView g = new GameView(null, rootPaneCheckingEnabled, game, new ImageFinder());
		g.setVisible(true);

	}

	private void startNewGame(ActionEvent e) {

		game.newGame();

		for (int i = 0; i < game.getPlayers().size(); i++) {
			game.getPlayer(i).setGame(game);
			game.getPlayer(i).setPoints(0);
		}

		GameView g = new GameView(null, rootPaneCheckingEnabled, game, new ImageFinder());
		g.setVisible(true);

	}

	/*
	 * public static void main(String[] args) { Player p1, p2, p3, p4;
	 * 
	 * p1 = new Player("1"); p4 = new Player("2"); p2 = new Player("3"); p3 = new
	 * Player("4");
	 * 
	 * Game game = new Game(p1, p2, p3, p4);
	 * 
	 * p1.setGame(game); p2.setGame(game); p3.setGame(game); p4.setGame(game);
	 * 
	 * new ScoreView(null, false, game);
	 * 
	 * }
	 */

}
