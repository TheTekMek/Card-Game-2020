package cards;

import java.util.*;

public class Deck {
	public List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		initializeCards();
	}
	
	private void initializeCards() {
		int arrIndex = 0;
		
		for (CardSuit suit : CardSuit.values()) {
			for (CardFace face : CardFace.values()) {
				cards.add(new Card(suit, face));
				arrIndex++;
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		return cards.get(0);
	}
	
	public List<Card> draw(int quantity) {
		List<Card> hand = new ArrayList<Card>();

		for (int i = 0; i < quantity; i++) {
			hand.add(cards.get(0));
		}

		return hand;
	}
}
