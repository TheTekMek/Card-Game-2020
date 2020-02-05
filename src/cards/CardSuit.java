package cards;

public enum CardSuit {
	CLUBS(1),
	DIAMONDS(2),
	HEARTS(3),
	SPADES(4);

	int value;

	CardSuit(int val) {
		value = val;
	}

	public int getValue() {
		return value;
	}
}
