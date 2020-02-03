package cards;

public class Card {
	public CardSuit suit;
	public CardFace face;
	
	Card(CardSuit suit, CardFace face) {
		this.suit = suit;
		this.face = face;
	}
	
	@Override
	public String toString() {
		return face + " of " + suit;
	}
}
