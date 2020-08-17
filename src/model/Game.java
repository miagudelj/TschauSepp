/**
 * Controls the Game and the Players
 */
package model;

import java.util.*;
import view.GameView;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class Game {

	private Vector<Player> players;
	private CardBank bank;
	private CardStack stack;
	private int roundNr;
	private int currentTurn;
	private GameView view;

	/**
	 * Constructor
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public Game(Player p1, Player p2, Player p3, Player p4) {
		players = new Vector<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
	}

	/**
	 * Get the GameView
	 * 
	 * @return view
	 */
	public GameView getView() {
		return view;
	}

	/**
	 * Set the GameView
	 * 
	 * @param gameView
	 */
	public void setView(GameView gameView) {
		this.view = gameView;
	}

	/**
	 * Gets the player from vector with specific index
	 * 
	 * @param index
	 * @return player
	 */
	public Player getPlayer(int index) {

		if (index < 4) {
			return players.get(index);
		} else if (index >= 4 && index < 8) {
			return players.get(index - 4);
		} else if (index == -4) {
			return players.get(index - 4);
		} else {
			return null;
		}
	}

	/**
	 * Gets the player with the current turn
	 * 
	 * @return player
	 */
	public Player getCurrentPlayer() {
		return players.get(currentTurn);
	}

	/**
	 * Gets the players who's next
	 * 
	 * @return player
	 */
	public Player getNextPlayer() {
		if (currentTurn < 3) {
			return players.get(currentTurn + 1);
		} else {
			return players.get(0);
		}
	}

	/**
	 * Get all player in the vector
	 * 
	 * @return players
	 */
	public Vector<Player> getPlayers() {
		return players;
	}

	/**
	 * Get the CardBank
	 * 
	 * @return bank
	 */
	public CardBank getBank() {
		return bank;
	}

	/**
	 * Get the CardStack
	 * 
	 * @return stack
	 */
	public CardStack getStack() {
		return stack;
	}

	/**
	 * Get current round number
	 * 
	 * @return roundNr
	 */
	public int getRoundNr() {
		return roundNr;
	}

	/**
	 * Get current player
	 * 
	 * @return currentTurn
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}

	/**
	 * Ends turns & switches them
	 */
	public void nextTurn() {

		if ((getCurrentPlayer().getDeck().size() == 2 && !getCurrentPlayer().saidTschau()) || ((getCurrentPlayer().getDeck().size() > 2 || getCurrentPlayer().getDeck().size() == 1) && getCurrentPlayer().saidTschau())) { // If didn't say Tschau or said tschau while having more than 2 or only 1 card(s)
			// System.out.println("Da hat " + getCurrentPlayer().getName() + " nicht Tschau
			// gesagt");
			getCurrentPlayer().getDeck().missedTschau(); // punish

		} else if ((getCurrentPlayer().getDeck().size() == 1 && !getCurrentPlayer().saidSepp())|| (getCurrentPlayer().getDeck().size() > 1 && getCurrentPlayer().saidSepp())) { // If didn't say Sepp or said Sepp while having more than 1 card
			// System.out.println("Da hat " + getCurrentPlayer().getName() + " nicht Sepp
			// gesagt");
			getCurrentPlayer().getDeck().missedSepp(); // punish
		}

		if (getCurrentPlayer().getDeck().size() > 0) { // If Player has Cards

			currentTurn++;

			if (currentTurn == 4) { // Change Turn from 4. to 1. Player
				currentTurn = 0;
			}

			// System.out.println(stack.getCards());

			for (Player p : players) { // Register if it is their Turn in all Players
				if (players.get(currentTurn) == p) {
					p.setPlayersTurn(true);
				} else {
					p.setPlayersTurn(false);
				}
			}
		} else if (getCurrentPlayer().getDeck().size() == 0) { // If Player has played all his Cards

			endGame(getCurrentPlayer());

		} else {
			System.out.println("player " + getCurrentPlayer().getName() + " has a negative amount of Cards");
		}
	}

	/**
	 * Ends the Game, opening the ScoreboardView
	 * 
	 * @param winner
	 */
	public void endGame(Player winner) {

		System.out.println("\n\n" + winner.getName() + " won!");

		/**
		 * get card points from every player and add the points for the winner
		 */
		for (Player p : players) {
			for (Card c : p.getDeck().cards) {
				//p.addPoints(c.getValue().getValue());
				//winner.addPoints(p.getPoint());
				winner.addPoints(c.getValue().getPoints());
			}
		}

		/**
		 * outprints how many points every player has
		 */
		for (Player p : players) {
			System.out.println(p.getName() + " has " + p.getPoint() + " points");
		}
	}

	/**
	 * Starts a new Game
	 */
	public void newGame() {

		bank = new CardBank(this); // Create new Bank + Stack for empty card Arraylists
		stack = new CardStack(bank, this);

		bank.generateCards(); // Generate Cards in Bank
		bank.setCards(bank.shuffle((bank.getCards())));

		bank.getUpperCard().putCardToStack(stack); // Move first Card to Stack

		for (Player p : players) { // Create new Decks for each Player and give them 7 starting Cards
			p.setDeck(new CardDeck(p, stack, bank));
			bank.giveCards(7, p.getDeck());
		}

		players.get(0).setPlayersTurn(true); // Set the Turn to the first Player

	}

}
