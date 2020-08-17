/**
 * Interface for Cards
 */
package model;

/**
 * @author Mia Gudelj
 * @since 24-06-2020
 * @version 1.0
 *
 */
public interface ICard {

	/**
	 * proves if this card is stackable with the other card.
	 * 
	 * @param card
	 * @return false
	 */
	public default boolean isStackable(Card card){
		return false;
	}
	
	/**
	 * 
	 * @return string
	 */
	public String toString();
}
