package cards;

public enum CardFace {
	PENALTY(0),
	TWO(1),
	THREE(2),
	FOUR(3),
	FIVE(4),
	SIX(5),
	SEVEN(6),
	EIGHT(7),
	NINE(8),
	TEN(9),
	JACK(10),
	QUEEN(11),
	KING(12),
	ACE(13);

	int rank;

	CardFace(int r) {
		rank = r;
	}

	public int getRank() {
		return rank;
	}
}
