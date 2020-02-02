package cards;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Deck {
	public Card[] cards = new Card[52];
	
	public Deck() {
		initializeCards();
	}
	
	private void initializeCards() {
		int arrIndex = 0;
		
		for (CardSuit suit : CardSuit.values()) {
			for (CardFace face : CardFace.values()) {
				cards[arrIndex] = new Card(suit, face);
				arrIndex++;
			}
		}
	}
	
	public void shuffle() {
		List<Card> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cardList.toArray(cards);
		System.out.println("Cards after shuffle: " + cardList);
	}
	
	public Card draw() {
		return cards[0];
	}
}
