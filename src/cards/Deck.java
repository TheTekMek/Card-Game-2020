package cards;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Deck {
	public Card[] cards = new Card[52];
	
	public void shuffle() {
		List<Card> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cardList.toArray(cards);
		System.out.println(cards);
		System.out.println(cardList);
	}
		
	public Card draw() {
		return cards[0];
	}
}
