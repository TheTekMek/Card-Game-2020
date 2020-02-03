package game;

import java.util.Arrays;
import java.util.Scanner;

import cards.*;
import players.*;

public class Game {
	Deck cardDeck;
	Player[] players;

	public static final int PLAYERHAND = 13;
	
	public Game() {
		System.out.println("How many players will be in this game?");
		Scanner input = new Scanner(System.in);
		int numberOfPlayers = input.nextInt();
		
		if (numberOfPlayers > 4) numberOfPlayers = 4;

		this.players = new Player[numberOfPlayers];

		for (int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(i + 1);
		}

		initDeck();
		dealCards();
		
		System.out.println(Arrays.toString(this.players));
	}

	private void initDeck() {
		this.cardDeck = new Deck();
	}
	
	private void dealCards() {
		int numPlayers = this.players.length;
		
		shuffleDeck();
		
		for (int i = 0; i < numPlayers; i++) {
			players[i].draw(cardDeck.draw(PLAYERHAND));	
		}
	}

	public void shuffleDeck() {
		cardDeck.shuffle();
	}
	
	public void printCardDeck() {
		System.out.println(Arrays.toString(cardDeck.cards.toArray()));		
	}

	public void printPlayerInfo() {
		System.out.println(Arrays.toString(players));
	}
}