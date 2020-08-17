/**
 * A class containing any amount of cards
 */
package model;

import java.util.Vector;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public abstract class Stack {

	// variables
	protected Vector<Card> cards = new Vector<Card>();
	//

	/**
	 * get the card with specific index
	 * 
	 * @param index
	 * @return card
	 */
	public Card getCard(int index) {
		return cards.get(index);
	}

	/**
	 * get the index of a card
	 * 
	 * @param card
	 * @return int of card
	 */
	public int getIndexOfCard(Card card) {
		return cards.indexOf(card);
	}

	/**
	 * get all cards
	 * 
	 * @return cards
	 */
	public Vector<Card> getCards() {
		return cards;
	}

	/**
	 * sets the cards
	 * 
	 * @param cardsVector<Card>
	 */
	public void setCards(Vector<Card> cards) {
		this.cards = cards;
	}

	/**
	 * adds a card to the list.
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		cards.add(card);
	}

	/**
	 * remove a card from the list
	 * 
	 * @param card
	 */
	public void removeCard(Card card) {
		cards.remove(card);
	}

	/**
	 * remove a card with the specific from the list 
	 * 
	 * @param index
	 */
	public void removeCard(int index) {
		cards.remove(index);
	}

	/**
	 * returns the last added card
	 * 
	 * @return card
	 */
	public Card getUpperCard() {
		if (cards.size() > 0) {
			return cards.get(cards.size() - 1);
		} else {
			return null;
		}
	}

	/**
	 * returns the size of the list
	 * 
	 * @return size
	 */
	public int size() {
		return cards.size();
	}
}
