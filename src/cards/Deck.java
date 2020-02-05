package cards;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;;

public class Deck {
	public List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		initializeCards();
	}
	
	private void initializeCards() {
		for (CardSuit suit : CardSuit.values()) {
			for (CardFace face : CardFace.values()) {
				if (face == CardFace.PENALTY) cards.add(new Card(null, face));
				else cards.add(new Card(suit, face));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		return cards.remove(0);
	}
	
	public List<Card> draw(int quantity) {
		List<Card> hand = new ArrayList<Card>();

		for (int i = 0; i < quantity; i++) {
			hand.add(cards.get(0));
		}

		return hand;
	}
}
