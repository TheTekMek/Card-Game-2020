package game;

import java.util.Arrays;

import cards.*;

public class Game {
	Deck cardDeck;
	
	Game() {
		initGame();
	}

	private void initGame() {
		this.cardDeck = new Deck();
		shuffleDeck();
		printCards();
	}

	public void shuffleDeck() {
		cardDeck.shuffle();
	}
	
	public void printCards() {
		System.out.println(Arrays.toString(cardDeck.cards));		
	}
}