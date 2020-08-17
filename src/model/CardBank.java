/**
 * The Stack where all cards are generated and drawn from.
 */
package model;

import java.util.*;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class CardBank extends Stack {

	// variables 
	private int amountOfCards;
	private Game game;
	//
	
	/**
	 * Constructor
	 * 
	 * @param game
	 */
	public CardBank(Game game) {
		super();
		this.game = game;
	}

	/**
	 * Generates all cards and adds them to the list
	 */
	public void generateCards() {
		
		for (int setCounter = 0; setCounter < 2; setCounter++) {
			int colorChangeSwitch = 1;

			for (int symbolCounter = 0; symbolCounter < 4; symbolCounter++) {
				if (symbolCounter == 2) {
					colorChangeSwitch = 2;
				}
				for (int cardCounter = 1; cardCounter < 14; cardCounter++) {
						cards.add(new Card(new CardSymbol(symbolCounter), new CardValue(cardCounter), this));
					
				}
			}
		}

		//System.out.println("Generated cards: " + cards);
	}
	
	/**
	 * removes card. 
	 * overrides stack to check if it is low on cards. 
	 * if it is -> requests some new ones from the CardStack
	 * 
	 * @param card
	 */
	public void removeCard(Card card) {
		cards.remove(card);

		if (cards.size() == 0) {
			game.getStack().giveCardsToBank();
		}
	}
	
	/**
	 * give an amount of cards to a deck
	 * 
	 * @param amount
	 * @param deck
	 */
	public void giveCards(int amount, CardDeck deck) {
		for (int i = 0; i < amount; i++) {
			if (cards.size() > 1) {
				getUpperCard().putCardToStack(deck);
			} else {
				game.getStack().giveCardsToBank();
				getUpperCard().putCardToStack(deck);
			}
		}
	}
	
	/**
	 * shuffles a list of cards
	 * 
	 * @param cards
	 * @return cards
	 */
	public Vector<Card> shuffle(Vector<Card> cards) {
		Collections.shuffle(cards);
		//System.out.println("Shuffled Cards: " + cards);
		return cards;

	}
	
	/**
	 * get total of cards
	 * 
	 * @return amountOfCards
	 */
	public int getTotalCards() {
		return amountOfCards;

	}
}
