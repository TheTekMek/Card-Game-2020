package players;

import java.util.*;
import cards.*;

public class Player {
    String playerName;
    List<Card> hand;
    String id;
    int score = 0;

    public Player(int index) {
        this.playerName = "Player " + index;
        this.id = UUID.randomUUID().toString();
        this.hand = new ArrayList<Card>();
    }

    public void draw(Card card) {
        this.hand.add(card);
    }

    public void draw(List<Card> cards) {
        this.hand.addAll(cards);
    }

    @Override
	public String toString() {
        return "\n---------------------------------------------------------------------------------------------" +
            "\n Player: " + this.playerName +
            "\n Id: " + this.id +
            "\n Hand: " + Arrays.toString(this.hand.toArray()) +
            "\n Score: " + this.score +
            "\n---------------------------------------------------------------------------------------------\n";
	}
}
