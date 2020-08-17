/**
 * Represents a Card
 */
package model;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class Card implements ICard {

	// variables
	private CardSymbol symbol;
	private CardValue value;
	private Stack stack;
	//

	
	/**
	 * Default constructor
	 */
	public Card() {
		
		
	}
	/**
	 * Constructor
	 * 
	 * @param symbol
	 * @param value
	 * @param stack
	 */
	public Card(CardSymbol symbol, CardValue value, Stack stack) {
		this.symbol = symbol;
		this.value = value;
		this.stack = stack;
	}

	/**
	 * get the symbol of the card
	 * 
	 * @return symbol
	 */
	public CardSymbol getSymbol() {
		return symbol;
	}

	/**
	 * set the symbol of the card
	 * 
	 * @param symbol
	 */
	public void setsymbol(CardSymbol symbol) {
		this.symbol = symbol;
	}

	/**
	 * get the value of the card
	 * 
	 * @return value
	 */
	public CardValue getValue() {
		return value;
	}

	/**
	 * set the value of the card
	 * 
	 * @param value
	 */
	public void setValue(CardValue value) {
		this.value = value;
	}

	/**
	 * get Stack
	 * 
	 * @return stack
	 */
	public Stack getStack() {
		return stack;
	}

	/**
	 * set Stack
	 * 
	 * @param stack 
	 */
	public void setStack(Stack stack) {
		this.stack = stack;
	}

	/**
	 * proves if this card is stackable with the other card.
	 * 
	 * @param card
	 * @return true if card is stackable with other card / false if card is not stackable with other card
	 */
	@Override
	public boolean isStackable(Card card) {
		if (value.isStackable(card) || symbol.isStackable(card)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * moves the card from the current stack to the given one
	 * 
	 * @param stack
	 */
	public void putCardToStack(Stack stack) {
		this.stack.removeCard(this);
		stack.addCard(this);
		//System.out.println("Card moved from " + this.stack + " stack " + stack);
		this.stack = stack;
	}

	/**
	 * Overrides the toString() method to display well for debugging.
	 * 
	 * @return card symbol and card value
	 */
	@Override
	public String toString() {
		return "Die Karte hat die " + symbol.toString() + " und die " + value.toString();
	}
}
