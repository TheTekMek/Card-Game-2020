package game;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;

import cards.*;
import gameError.DuplicateCardsException;
import players.*;

public class Game {
	Deck cardDeck;
	Player[] players;
	Player gameWinner = null;

	public void runGame() {
		displayMessage("How many players will be in this game (2 to 4 players)?");
		Scanner input = new Scanner(System.in);
		Scanner nameInput = new Scanner(System.in);
		Scanner drawInput = new Scanner(System.in);
		int numberOfPlayers;
		int turnCount = 1;
		int highScore = 0;

		try {
			numberOfPlayers = input.nextInt();
		} catch (InputMismatchException e) {
			e.toString();
			displayMessage("You will default to a 2 player game");
			numberOfPlayers = 2;
		}
		
		if (numberOfPlayers > 4) numberOfPlayers = 4;
		
		this.players = new Player[numberOfPlayers];
		
		for (int i = 0; i < numberOfPlayers; i++) {
			String defaultPlayerName = "Player " + (i + 1);
			displayMessage("Please enter a name for " + defaultPlayerName);
			String playerName = nameInput.nextLine();
			
			if (playerName.length() == 0) playerName = defaultPlayerName;
			
			players[i] = new Player(playerName.toUpperCase());
		}

		initDeck();
		
		
		while (gameWinner == null) {
			List<Card> activeCards = new ArrayList<Card>();
			
			displayMessage("This is turn number " + turnCount);
			shuffleDeck();

			for (int i = 0; i < this.players.length; i++) {
				Player activePlayer = this.players[i];

				displayMessage(activePlayer.getPlayerName() + " Please press [ ENTER ] to draw a card");
				String nextRead = drawInput.nextLine();
				
				if (!nextRead.isEmpty()) {
					displayMessage("Sorry; cannot understand your input. But you will be forced to draw a card against your will.");
				}
				
				Card playerCard = cardDeck.draw();
				playerCard.setPlayerId(activePlayer.getId());

				activeCards.add(i, playerCard);
			}

			printCardStack(activeCards);
			
			try {
				declareRoundWinner(activeCards);
				
			} catch (DuplicateCardsException e) {
				displayMessage(e.getMessage());
			}
			
			for (Player player : players) {
				Card turnCard = null;
				
				for (Card cd : activeCards) {
					if (turnCard == null && cd.getPlayerId() == player.getId()) {
						turnCard = cd;
					}
				}
				
				if (turnCard.getRoundWinner()) player.increaseScore();
				else if (turnCard.getPenaltyCard()) player.decreaseScore();
			}
			
			turnCount++;

			declareGameWinner();

			printPlayerInfo();
		}

		displayMessage("And the WINNER of the game is " + gameWinner.getPlayerName() + " with a final score of " + gameWinner.getScore());

		input.close();
		nameInput.close();
		drawInput.close();
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
			players[i].pullCard(cardDeck.draw());	
		}
	}

	private void declareRoundWinner(List<Card> cards) throws DuplicateCardsException {
		int winningIndex = cards.size() - 1;
		final Comparator<CardFace> faceComparator = new CardFaceComparator();
		final Comparator<CardSuit> suitComparator = new CardSuitComparator();
		for (int i = 0; i < cards.size() - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (faceComparator.compare(cards.get(j).getFace(), cards.get(j-1).getFace()) < 0) {
					Collections.swap(cards, j, j-1);
				} else if (faceComparator.compare(cards.get(j).getFace(), cards.get(j-1).getFace()) == 0) {
					if (suitComparator.compare(cards.get(j).getSuit(), cards.get(j-1).getSuit()) < 0) Collections.swap(cards, j, j-1);
					else if (suitComparator.compare(cards.get(j).getSuit(), cards.get(j-1).getSuit()) == 0) throw new DuplicateCardsException("Found two duplicate cards in the deck!");
					else break;
				} else break;
			}
		}

		if (!cards.get(winningIndex).getPenaltyCard()) cards.get(winningIndex).setRoundWinner();
	}

	private void declareGameWinner() {
		final Comparator<Player> scoreComparator = new PlayerScoreComparator();
		List<Player> playerList = new ArrayList<Player>();
		Player highScorer;

		for (Player pl : players) {
			playerList.add(pl);
		}

		for (int i = 0; i < playerList.size() - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (scoreComparator.compare(playerList.get(j), playerList.get(j-1)) < 0) Collections.swap(playerList, j, j-1);
				// else if (scoreComparator.compare(players.get(j), players.get(j-1)) == 0)
			}
		}

		highScorer = playerList.get(playerList.size()-1);

		if (highScorer.getScore() >= 21) {
			if (highScorer.getScore() - playerList.get(playerList.size()-2).getScore() >= 2)
				gameWinner = highScorer;
		}
	}

	public void shuffleDeck() {
		cardDeck.shuffle();
	}
	
	public void printCardStack(List<Card> cards) {
		System.out.println(Arrays.toString(cards.toArray()));		
	}

	public void printPlayerInfo() {
		System.out.println(Arrays.toString(players));
	}
}