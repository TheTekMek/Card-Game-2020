package game;

import java.util.Arrays;

import cards.*;

public class Game {
	Deck cardDeck = new Deck();
	
	public void printCards() {
		System.out.println("Cards before shuffle: " + Arrays.toString(cardDeck.cards));		
	}
//	cardDeck.shuffle();
}
