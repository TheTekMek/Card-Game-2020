package cards;

public class Card {
	private final CardSuit suit;
	private final CardFace face;
	private boolean isRoundWinner = false;
	private boolean isPenalty = false;
	private String playerId;
	
	public CardSuit getSuit() {
		return suit;
	}

	public CardFace getFace() {
		return face;
	}

	public boolean getRoundWinner() {
		return isRoundWinner;
	}

	public boolean getPenaltyCard() {
		return isPenalty;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setRoundWinner() {
		isRoundWinner = true;
	}

	public void setPlayerId(String id) {
		playerId = id;
	}

	Card(CardSuit suit, CardFace face) {
		this.suit = suit;
		this.face = face;

		if (face == CardFace.PENALTY) isPenalty = true;
	}
	
	@Override
	public String toString() {
		return face + " of " + suit;
	}
}
