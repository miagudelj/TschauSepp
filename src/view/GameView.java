/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import model.Card;
import model.Game;
import model.Player;
import service.ImageFinder;
import service.OverlapLayout;

/**
 * @author Mia Gudelj
 * @since 31.06.2020
 * @version 1.0
 *
 */
public class GameView extends JDialog {

	private Game game;
	private ImageFinder image;
	private boolean tookCard = false;
	//
	private JButton person1, person2, person3, karteZiehenButton, seppButton, tschauButton, menuButton;
	// panels
	private JPanel personPanel1, personPanel2, personPanel3, mainPanel;
	private JPanel personName1Panel, personName2Panel, personName3Panel;
	private JPanel menuPanel, menuInnerPanel, headerPanel;
	private JPanel bodyPanel, cardStackPanel;
	private JPanel footerPanel, playernamePanel, buttonPanel, buttonInnerPanel, deckPanel, deckInnerPanel;

	private JLabel personName1, personName2, personName3, personName4;
	private JLabel cardBankLabel, cardStackLabel;

	public GameView(Frame parent, boolean modal, Game game, ImageFinder image) {
		super(parent, modal);
		//
		this.game = game;
		this.image = image;
		//
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//
		init();
		//
		setVisible(false);
		setResizable(false);
	}

	private void init() {

		// player 1
		person1 = new JButton();
		person1.setIcon(new ImageIcon("./Pictures/Graphics/mensch.png"));
		person1.setBorderPainted(false);
		person1.setContentAreaFilled(false);
		person1.setEnabled(false);

		// player 2
		person2 = new JButton();
		person2.setIcon(new ImageIcon("./Pictures/Graphics/mensch.png"));
		person2.setBorderPainted(false);
		person2.setContentAreaFilled(false);
		person2.setEnabled(false);

		// player 3
		person3 = new JButton();
		person3.setIcon(new ImageIcon("./Pictures/Graphics/mensch.png"));
		person3.setBorderPainted(false);
		person3.setContentAreaFilled(false);
		person3.setEnabled(false);

		// personName label for player 1
		personName1 = new JLabel(game.getPlayer(game.getCurrentTurn() + 1).getName());
		personName1.setHorizontalAlignment(JLabel.CENTER);
		personName1.setForeground(Color.black);
		personName1.setFont(personName1.getFont().deriveFont(20.0f));

		// personName label for player 2
		personName2 = new JLabel(game.getPlayer(game.getCurrentTurn() + 3).getName());
		personName2.setHorizontalAlignment(JLabel.CENTER);
		personName2.setForeground(personName1.getForeground());
		personName2.setFont(personName1.getFont());

		// personName label for player 3
		personName3 = new JLabel(game.getPlayer(game.getCurrentTurn() + 2).getName());
		personName3.setHorizontalAlignment(JLabel.CENTER);
		personName3.setForeground(personName1.getForeground());
		personName3.setFont(personName1.getFont());

		// personName label for player 4
		personName4 = new JLabel(game.getPlayer(game.getCurrentTurn()).getName());
		personName4.setHorizontalAlignment(JLabel.CENTER);
		personName4.setForeground(Color.white);
		personName4.setFont(personName1.getFont());
		personName4.setBorder(new EmptyBorder(10, 100, 0, 100));

		// personName1Panel
		// panel for nameLabel of player 1 to center the name
		personName1Panel = new JPanel(new BorderLayout());
		personName1Panel.add(personName1, BorderLayout.CENTER);
		personName1Panel.setBackground(Color.red.darker());

		// personName2Panel
		// panel for nameLabel of player 1 to center the name
		personName2Panel = new JPanel(new BorderLayout());
		personName2Panel.add(personName2, BorderLayout.CENTER);
		personName2Panel.setBackground(personName1Panel.getBackground());

		// personName2Panel
		// panel for nameLabel of player 1 to center the name
		personName3Panel = new JPanel(new BorderLayout());
		personName3Panel.add(personName3, BorderLayout.CENTER);
		personName3Panel.setBackground(personName2Panel.getBackground());

		// personPanel
		// panel for figure of player 1
		personPanel1 = new JPanel(new GridLayout(2, 1, 0, -70));
		personPanel1.add(person1);
		personPanel1.add(personName1Panel);
		personPanel1.setBackground(Color.red.darker());

		// personPanel
		// panel for figure of player 2
		personPanel2 = new JPanel(new GridLayout(2, 1, 0, -70));
		personPanel2.add(person2);
		personPanel2.add(personName2Panel);
		personPanel2.setBackground(personPanel1.getBackground());

		// personPanel
		// panel for figure of player 3
		personPanel3 = new JPanel(new GridLayout(2, 1, 0, -70));
		personPanel3.add(person3);
		personPanel3.add(personName3Panel);
		personPanel3.setBackground(personPanel2.getBackground());

		// menuButton
		menuButton = new JButton();
		menuButton.setFocusPainted(false);
		menuButton.setBorderPainted(false);
		menuButton.setBackground(Color.red.darker());
		menuButton.setIcon(new ImageIcon("./Pictures/Graphics/menuLogo.png"));
		menuButton.setContentAreaFilled(false);

		// menuInnerPanel
		menuInnerPanel = new JPanel(new BorderLayout(0, 0));
		menuInnerPanel.add(menuButton, BorderLayout.CENTER);
		menuInnerPanel.add(new JLabel(), BorderLayout.NORTH);
		menuInnerPanel.add(new JLabel(), BorderLayout.SOUTH);
		menuInnerPanel.add(new JLabel(), BorderLayout.WEST);
		menuInnerPanel.add(new JLabel(), BorderLayout.EAST);
		menuInnerPanel.setBackground(personPanel1.getBackground());

		// menuPanel
		menuPanel = new JPanel(new GridLayout(3, 1));
		menuPanel.add(menuInnerPanel);
		menuPanel.add(new JLabel());
		menuPanel.add(new JLabel());
		menuPanel.setBackground(menuInnerPanel.getBackground());

		// headerPanel
		headerPanel = new JPanel(new BorderLayout(0, 10));
		headerPanel.add(menuPanel, BorderLayout.WEST);
		headerPanel.add(personPanel1, BorderLayout.CENTER);
		headerPanel.add(new JLabel(), BorderLayout.NORTH);
		headerPanel.add(new JLabel(), BorderLayout.SOUTH);
		headerPanel.add(new JLabel(), BorderLayout.EAST);
		headerPanel.setBackground(menuPanel.getBackground());

		// cardBankLabel
		cardBankLabel = new JLabel();
		cardBankLabel.setIcon(new ImageIcon("./Pictures/Cards/bank.jpg"));
		cardBankLabel.setHorizontalAlignment(JLabel.CENTER);

		cardStackLabel = new JLabel();
		cardStackLabel.setIcon(new ImageIcon(image.getImage(game.getStack().getUpperCard())));
		cardStackLabel.setBackground(Color.black);
		cardStackLabel.setHorizontalAlignment(JLabel.CENTER);

		// cardStackPanel
		cardStackPanel = new JPanel(new GridLayout(1, 2));
		cardStackPanel.add(cardBankLabel);
		cardStackPanel.add(cardStackLabel);
		cardStackPanel.setBackground(personPanel2.getBackground());

		// bodyPanel
		bodyPanel = new JPanel(new GridLayout(1, 3, 30, 0));
		bodyPanel.add(personPanel2);
		bodyPanel.add(cardStackPanel);
		bodyPanel.add(personPanel3);
		bodyPanel.setBackground(personPanel2.getBackground());

		// playernamePanel
		playernamePanel = new JPanel(new BorderLayout(20, 0));
		playernamePanel.add(personName4, BorderLayout.NORTH);
		playernamePanel.setBackground(bodyPanel.getBackground().darker());

		// JButtons
		// sepp
		seppButton = new JButton("Sepp");
		seppButton.setBackground(Color.black);
		seppButton.setForeground(Color.white);
		seppButton.setFont(seppButton.getFont().deriveFont(20.0f));
		seppButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f), Color.black));
		// seppButton.setEnabled(false);

		// tschau
		tschauButton = new JButton("Tschau");
		tschauButton.setBackground(seppButton.getBackground());
		tschauButton.setForeground(seppButton.getForeground());
		tschauButton.setFont(seppButton.getFont());
		tschauButton.setBorder(seppButton.getBorder());
		// tschauButton.setEnabled(false);

		// JButton karte ziehen (take a card)
		karteZiehenButton = new JButton(" Karte ziehen ");
		karteZiehenButton.setBackground(Color.white);
		karteZiehenButton.setForeground(Color.black);
		karteZiehenButton.setFont(seppButton.getFont());
		karteZiehenButton.setBorder(seppButton.getBorder());

		// buttonInnerPanel
		buttonInnerPanel = new JPanel(new GridLayout(3, 1, 20, 15));
		buttonInnerPanel.add(seppButton);
		buttonInnerPanel.add(tschauButton);
		buttonInnerPanel.add(karteZiehenButton);
		buttonInnerPanel.setBackground(playernamePanel.getBackground());

		// buttonPanel
		buttonPanel = new JPanel(new BorderLayout(50, 50));
		buttonPanel.add(buttonInnerPanel, BorderLayout.CENTER);
		buttonPanel.add(new JLabel(), BorderLayout.SOUTH);
		buttonPanel.add(new JLabel(), BorderLayout.WEST);
		buttonPanel.add(new JLabel(), BorderLayout.NORTH);
		buttonPanel.add(new JLabel(), BorderLayout.EAST);
		buttonPanel.setBackground(buttonInnerPanel.getBackground());

		JPanel mainButtonPanel = new JPanel(new BorderLayout(30, 0));
		mainButtonPanel.add(buttonPanel, BorderLayout.CENTER);
		mainButtonPanel.add(new JLabel(), BorderLayout.SOUTH);
		mainButtonPanel.add(new JLabel(), BorderLayout.WEST);
		mainButtonPanel.add(new JLabel(), BorderLayout.NORTH);
		mainButtonPanel.add(new JLabel(), BorderLayout.EAST);
		mainButtonPanel.setBackground(buttonPanel.getBackground());

		// deckInnerPanel --> here are the cards
		deckInnerPanel = new JPanel();
		deckInnerPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createStrokeBorder(new BasicStroke(3.0f), Color.red.darker().darker().darker()),
				BorderFactory.createEmptyBorder(20, 50, 20, 50)));
		deckInnerPanel.setBackground(mainButtonPanel.getBackground());

		placeDynamicCards();

		// stackPanel
		deckPanel = new JPanel(new BorderLayout(0, 0));
		deckPanel.add(deckInnerPanel, BorderLayout.CENTER);
		deckPanel.add(new JLabel(), BorderLayout.NORTH);
		deckPanel.add(new JLabel(), BorderLayout.SOUTH);
		deckPanel.add(new JLabel(), BorderLayout.WEST);
		deckPanel.add(new JLabel(), BorderLayout.EAST);
		deckPanel.setBackground(deckInnerPanel.getBackground());
		deckPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		// footerPanel
		footerPanel = new JPanel(new BorderLayout(0, 0));
		footerPanel.add(playernamePanel, BorderLayout.WEST);
		footerPanel.add(deckPanel, BorderLayout.CENTER);
		footerPanel.add(mainButtonPanel, BorderLayout.EAST);
		footerPanel.add(new JLabel(), BorderLayout.NORTH);
		footerPanel.add(new JLabel(), BorderLayout.SOUTH);
		footerPanel.setBackground(mainButtonPanel.getBackground());
		footerPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.5f), Color.black));

		// mainPanel
		mainPanel = new JPanel(new GridLayout(3, 1));
		mainPanel.add(headerPanel);
		mainPanel.add(bodyPanel);
		mainPanel.add(footerPanel);
		mainPanel.setBackground(headerPanel.getBackground());

		getContentPane().add(mainPanel, BorderLayout.NORTH);
		getContentPane().setBackground(mainPanel.getBackground());

		// EVENTS

		tschauButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tschauClicked(e);
			}
		});

		seppButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seppClicked(e);
			}
		});

		karteZiehenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				karteZiehenClicked(e);

			}
		});

		menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuButtonClicked(e);
			}
		});
	}

	private void placeDynamicCards() {

		int size = game.getCurrentPlayer().getDeck().size();
		int overlap = 109200 / (size * 130); // A card is 133 px wide

		OverlapLayout layout = new OverlapLayout(new Point(overlap, 0), true);

		deckInnerPanel.setLayout(layout);

		deckInnerPanel.removeAll();

		for (Card c : game.getCurrentPlayer().getDeck().getCards()) {

			// System.out.println(c);

			JButton card = new JButton(new ImageIcon(image.getImage(c)));
			card.setBorder(BorderFactory.createEmptyBorder());
			card.setBorderPainted(false);
			// card.setToolTipText(card.getIcon().toString());

			card.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cardClicked(e, c, layout, card);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			deckInnerPanel.add(card);
		}

		deckInnerPanel.revalidate();
		deckInnerPanel.repaint();

		JButton cardStack = new JButton();
		cardStack.setIcon(new ImageIcon(image.getImage(game.getStack().getUpperCard())));
		cardStack.setBackground(Color.white);
		cardStackLabel.add(cardStack);

	}

	private void cardClicked(ActionEvent e, Card c, OverlapLayout layout, JButton button) {
		// System.out.println("Clicked " + c);

		if (c.isStackable(game.getStack().getUpperCard())) {
			game.getCurrentPlayer().getDeck().putCard(c);
			// System.out.println(game.getCurrentPlayer().getDeck().size());

			if (game.getCurrentPlayer().getDeck().size() == 0) {

				// System.out.println("sbdy won");
				this.setVisible(false);
				this.dispose();
				ScoreView score = new ScoreView(new JFrame(), true, game);
				score.setVisible(true);
			} else {
				nextPlayerDialog();
			}
		} else {
			// TODO error message to GUI
			game.getBank().giveCards(1, game.getCurrentPlayer().getDeck());
			new ErrorDialogView(this, rootPaneCheckingEnabled).setVisible(true);
		}
	}

	/**
	 * Listener for taking cards
	 * 
	 * @param MouseEvent
	 */
	private void karteZiehenClicked(ActionEvent e) {

		if (!tookCard) {

			if (game.getBank().size() > 0) {
				game.getBank().giveCards(1, game.getCurrentPlayer().getDeck());
			} else {
				System.out.println("Not enough Cards left in Bank");
			}
			karteZiehenButton.setText("Nicht spielen");
			placeDynamicCards();
			tookCard = true;

		} else {
			tookCard = false;
			game.nextTurn();
			karteZiehenButton.setText("Karte nehmen");
			nextPlayerDialog();
		}

	}

	private void nextPlayerDialog() {
		this.setVisible(false);
		this.dispose();
		NextPlayerView dialog = new NextPlayerView(new JFrame(), false, game);
		dialog.setVisible(true);

	}

	private void tschauClicked(ActionEvent e) {
		game.getCurrentPlayer().sayTschau();
		tschauButton.setEnabled(false);
	}

	private void seppClicked(ActionEvent e) {
		game.getCurrentPlayer().saySepp();
		seppButton.setEnabled(false);
	}

	/**
	 * Listener when the menu gets clicked
	 * 
	 * @param MouseEvent
	 */
	private void menuButtonClicked(ActionEvent e) {
		MenuView menu = new MenuView(new JFrame(), true);
		menu.setVisible(true);

	}

	public static void main(String[] args) {
		Player p1, p2, p3, p4;

		p1 = new Player("Player 1");
		p4 = new Player("Player 2");
		p2 = new Player("Player 3");
		p3 = new Player("Player 4");

		Game game = new Game(p1, p2, p3, p4);

		p1.setGame(game);
		p2.setGame(game);
		p3.setGame(game);
		p4.setGame(game);

		game.newGame();

		GameView g = new GameView(new JFrame(), true, game, new ImageFinder());
		g.setVisible(true);
	}
}
