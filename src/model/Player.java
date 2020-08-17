/**
 * A player
 */
package model;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class Player {

	private CardDeck deck;
	private Game game;
	private String name;
	private int points;
	private boolean saidTschau;
	private boolean saidSepp;
	private boolean playersTurn;

	/**
	 * Constructor
	 */
	public Player() {
		System.out.println("Spieler erstellt");
		points = 0;
		saidTschau = false;
		saidSepp = false;
		playersTurn = false;
	}

	/**
	 * Constructor with name
	 * 
	 * @param name
	 */
	public Player(String name) {
		super();
		//System.out.println("Spieler " + name + " erstellt");
		this.name = name;
	}

	/**
	 * Get the player name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the player name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Game
	 * 
	 * @return game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Set Game
	 * 
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Get the Deck
	 * 
	 * @return deck
	 */
	public CardDeck getDeck() {
		return deck;
	}

	/**
	 * Set the Deck
	 * 
	 * @param deck
	 */
	public void setDeck(CardDeck deck) {
		this.deck = deck;
	}

	/**
	 * Get the current points
	 * 
	 * @return points
	 */
	public int getPoint() {
		return points;
	}

	/**
	 * Set points
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Add points to the counter
	 * 
	 * @param points
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * Get if it's the players turn or not
	 * 
	 * @return playersTurn
	 */
	public boolean isPlayersTurn() {
		return playersTurn;
	}
	
	/**
	 * Set if it's the players turn or not
	 * 
	 * @param playersTurn
	 */
	public void setPlayersTurn(boolean playersTurn) {
		this.playersTurn = playersTurn;
		saidSepp = false;
		saidTschau = false;
	}

	/**
	 * Say tschau
	 */
	public void sayTschau() {
		saidTschau = true;
	}

	/**
	 * Say sepp
	 */
	public void saySepp() {
		saidSepp = true;
	}

	/**
	 * Check if player said tschau
	 * 
	 * @return saidTschau
	 */
	public boolean saidTschau() {
		return saidTschau;
	}

	/**
	 * Check if player said sepp
	 * 
	 * @return saidSepp
	 */
	public boolean saidSepp() {
		return saidSepp;
	}
}
