package cards;

import java.util.Comparator;

public class CardSuitComparator implements Comparator<CardSuit> {
    
    @Override
    public int compare(CardSuit card1, CardSuit card2) {
         return card1.getValue() - card2.getValue();
    }
}