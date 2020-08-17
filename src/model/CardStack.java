/**
 * 
 */
package model;

/**
 * @author Mia Gudelj
 * @since 25-06-2020
 * @version 1.0
 *
 */
public class CardStack extends Stack {

	// variables
	private CardBank bank;
	private Game game;
	//
	
	public CardStack(CardBank bank, Game game) {
		super();
		this.bank = bank;
		this.game = game;
	}
	
	/**
	 * Transfer all Cards in the list except for the upper one to the bank
	 */
	public void giveCardsToBank() {
		for (int i = 1; i < cards.size(); i++) { // moves all cards except the first
			cards.get(i).putCardToStack(bank);
		}
	}
}
