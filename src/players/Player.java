package players;

import java.util.*;
import cards.*;

public class Player {
    private String playerName;
    private List<Card> hand;
    private final String id;
    private int score = 0;

    public String getPlayerName() {
        return playerName;
    }

    public List<Card> getPlayerHand() {
        return hand;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setPlayerName(String name) {
        playerName = name;
    }

    public void increaseScore() {
        score += 2;
    } 
    
    public void decreaseScore() {
        score--;
    } 

    public Player(String name) {
        this.playerName = name;
        this.id = UUID.randomUUID().toString();
        this.hand = new ArrayList<Card>();
    }

    public void pullCard(Card card) {
        hand.add(card);
    }

    @Override
	public String toString() {
        return "\n---------------------------------------------------------------------------------------------" +
            "\n Player: " + this.playerName + "                             Id: " + this.id +
            "\n Hand: " + Arrays.toString(this.hand.toArray()) +
            "\n Score: " + this.score +
            "\n---------------------------------------------------------------------------------------------\n";
	}
}
