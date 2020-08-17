/**
 * 
 */
package model;

/**
 * @author Mia
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class CardValue implements ICard {

	// variables
	private int value;
	private int points;
	//

	/**
	 * Constructor
	 * 
	 * @param value
	 */
	public CardValue(int value) {
		this.value = value;
		if (value == 1) { // Ass
			points = 11;
			
		} else if (value == 11) { // Bauer
			points = 20;
			
		} else if (value == 12) { // Dame
			points = 3;
			
		} else if (value == 13) { // Koenig
			points = 4;
		}
	}

	/**
	 * get value of the card
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * set value of the card
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * get points of the card
	 * 
	 * @return points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * sets points of the card
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * proves if this card is stackable with the other card.
	 * 
	 * @param card
	 * @return true if card is stackable / false if card is not stackable
	 */
	@Override
	public boolean isStackable(Card card) {
		if (this.getValue() == card.getValue().getValue()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		/*if (value == 13 || value == 11 || value == 10) {
			return "Figur " + value;
		} else {
			return "Zahl " + value;
		}*/
		return "";
	}
}
