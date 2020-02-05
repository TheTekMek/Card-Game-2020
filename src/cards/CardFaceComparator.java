package cards;

import java.util.Comparator;

public class CardFaceComparator implements Comparator<CardFace> {
    
    @Override
    public int compare(CardFace card1, CardFace card2) {
         return card1.getRank() - card2.getRank();
    }
}