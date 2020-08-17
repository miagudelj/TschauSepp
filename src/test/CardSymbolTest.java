/**
 * JUnit Test which tests the class CardSymbol
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import model.Card;
import model.CardSymbol;

/**
 * @author Mia Gudelj
 * @since 25.06.2020
 * @version 1.0
 *
 */
class CardSymbolTest {
	
	private final CardSymbol cardSymbol;
	private final Card card;

	
	public CardSymbolTest() {
		cardSymbol = new CardSymbol();
		card = new Card();
    }

	@Test
	void CardSymbolIsSet() {
		cardSymbol.setSymbol(1);
		assertEquals(1, cardSymbol.getSymbol());
	}
	
	@Test
	void cardSymbolStringEqualsHerz() {
		cardSymbol.setSymbol(0);
		assertEquals("herz", cardSymbol.toString());
	}
	
	@Test
	void cardSymbolStringEqualsKreuz() {
		cardSymbol.setSymbol(1);
		assertEquals("kreuz", cardSymbol.toString());
	}
	
	@Test
	void CardSymbolStringEqualsSchaufel() {
		cardSymbol.setSymbol(2);
		assertEquals("schaufel", cardSymbol.toString());
	}
	
	@Test
	void cardSymbolStringEqualsEcke() {
		cardSymbol.setSymbol(3);
		assertEquals("ecke", cardSymbol.toString());
	}
	
	@Test
	void CardSymbolIsStackable() throws Exception {
		card.setsymbol(cardSymbol);
		assertTrue(cardSymbol.isStackable(card));
	}
	
	@Test
	void CardSymbolIsNotStackable() throws Exception {
		
		// first we set the color to 1 (red)
		cardSymbol.setSymbol(1);

		// then we create a new CardSymbol object with color value 2 (black) which is NOT equal 
		// to our CardSymbol variable
		CardSymbol wrongColor = new CardSymbol(2);
		
		// the card gets the color from CardSymbol
		card.setsymbol(cardSymbol);
		
		// but we use wrongColor as the starting point for the method isStackable
		// CardSymbol.getColor() != wrongColor.getColor()
		assertFalse(wrongColor.isStackable(card));
	}
	
	@Test()
	void CardSymbolIsNotSetOnTheCard() {
		
		// CardSymbol will NOT be set 
		//card.setColor(CardSymbol);
		Assertions.assertThrows(NullPointerException.class, () -> card.isStackable(card));
	}

}
