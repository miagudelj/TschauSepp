/**
 * Contains the Cards of a player
 */
package model;

import view.ErrorDialogView;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class CardDeck extends Stack {
	
	private Player player;
	private CardStack stack;
	private CardBank bank;

	/**
	 * Constructor
	 * 
	 * @param player
	 * @param stack
	 * @param bank
	 */
	public CardDeck(Player player, CardStack stack, CardBank bank) {
		super();
		setPlayer(player);
		this.stack = stack;
		this.bank = bank;
	}

	/**
	 * Get the Player
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Set the Player
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Gives the CardStack
	 * 
	 * @return stack
	 */
	public CardStack getStack() {
		return stack;
	}

	/**
	 * Set the CardStack
	 * 
	 * @param stack
	 */
	public void setStack(CardStack stack) {
		this.stack = stack;
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
	 * Set the CardBank
	 * 
	 * @param bank
	 */
	public void setBank(CardBank bank) {
		this.bank = bank;
	}

	/**
	 * Checks if Card can be placed down, and puts it down if possible
	 * 
	 * @param card
	 */
	public void putCard(Card card) {

		if (card.isStackable(stack.getUpperCard())) { // Put down Card if able
			//System.out.println("Card " + card + " was put down by " + player.getName());
			card.putCardToStack(stack);
			player.getGame().nextTurn();

		} 
	}

	/**
	 * Takes a card from the CardBank
	 */
	public void takeCard() {
		//System.out.println(player.getName() + " took a card");
		bank.giveCards(1, this);
		player.getGame().nextTurn();
	}

	/**
	 * Punishment for not saying Tschau.
	 * puts 2 cards to players deck
	 */
	public void missedTschau() {
		bank.giveCards(2, this);
	}

	/**
	 * Punishment for not saying Sepp.
	 * puts 4 cards to players deck
	 */
	public void missedSepp() {
		bank.giveCards(4, this);
	}

	/**
	 * Overrides the toString() method to display well for debugging.
	 * 
	 * @return playerName
	 */
	@Override
	public String toString() {
		return "Deck: " + player.getName();
	}

}
