package cards;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Deck {
	public Card[] cards;
	
	Deck() {
		initializeCards();
	}
	
	private void initializeCards() {
		
	}
	
	public void shuffle() {
		
	}
	
	public Card[] distribute() {
		List<Card> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cardList.toArray(cards);
		System.out.println(cards);
		System.out.println(cardList);
		return cards;
	}
	
	public Card draw() {
		return cards[0];
	}
}
