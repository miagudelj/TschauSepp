/**
 * 
 */
package model;


/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public class CardSymbol implements ICard {

	// variables
	//private int color; // 1 = rot, 2 = schwarz
	private int symbol; // 1 = herz, 2 = kreuz, 3 = schaufel, 4 = ecke
	//

	public CardSymbol() {

	}

	public CardSymbol(/*int color,*/ int symbol) {
		//this.color = color;
		this.symbol = symbol;
	}

	/**
	 * gets the color of the card
	 * 
	 * @return the color
	 */
	/*public int getColor() {
		return color;
	}*/

	/**
	 * sets the color of the card
	 * 
	 * @param color the color to set
	 */
	/*public void setColor(int color) {
		this.color = color;
	}*/

	/**
	 * gets the color of the card
	 * 
	 * @return the color
	 */
	public int getSymbol() {
		return symbol;
	}

	/**
	 * sets the color of the card
	 * 
	 * @param color the color to set
	 */
	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

	/**
	 * proves if this card is stackable with the other card.
	 * 
	 * @throws Exception
	 */
	@Override
	public boolean isStackable(Card card) {

		if (card.getSymbol() == null) {
			throw new NullPointerException("Color NOT set on the card");
		}

		if (this.getSymbol() == card.getSymbol().getSymbol()) {
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
		
		switch (symbol) {
		case 0:
			return "herz";
		case 1:
			return "kreuz";
		case 2:
			return "schaufel";
		case 3:
			return "ecke";
		default:
			return null;
		}
	}
}
