package game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

import cards.*;
import players.*;

public class Game {
	Deck cardDeck;
	Player[] players;

	public static final int PLAYERHAND = 13;
	
	public Game() {
		displayMessage("How many players will be in this game (2 to 4 players)?");
		Scanner input = new Scanner(System.in);
		int numberOfPlayers;

		try {
			numberOfPlayers = input.nextInt();
		} catch (InputMismatchException e) {
			e.toString();
			// displayMessage("You must enter a number, between 2 to 4");
			// numberOfPlayers = input.nextInt();
		} finally {
			displayMessage("You will default to a 2 player game");
			numberOfPlayers = 2;
		}
		
		if (numberOfPlayers > 4) numberOfPlayers = 4;
		
		this.players = new Player[numberOfPlayers];
		
		Scanner nameInput = new Scanner(System.in);
		for (int i = 0; i < numberOfPlayers; i++) {
			String defaultPlayerName = "Player " + (i + 1);
			displayMessage("Please enter a name for " + defaultPlayerName);
			String playerName = nameInput.nextLine();
			
			if (playerName.length() == 0) playerName = defaultPlayerName;
			
			players[i] = new Player(playerName.toUpperCase());
		}

		input.close();
		nameInput.close();

		System.out.println(Arrays.toString(this.players));
		// Initialize card deck 
		initDeck();
		dealCards();
		
	}

	private void displayMessage(String message) {
		System.out.println(message);
	}

	private void initDeck() {
		this.cardDeck = new Deck();
	}
	
	private void dealCards() {
		int numPlayers = this.players.length;
		
		shuffleDeck();
		
		for (int i = 0; i < numPlayers; i++) {
			players[i].draw(cardDeck.draw());	
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