import java.io.Serializable;

/**
 * Created by user on 2017-06-19.
 */
public class Deck implements Serializable {
    private Card[] deck;
    private int cardsUsed;

    public Deck() {
        // create unshuffled cards deck
        deck = new Card[52];
        int cardCount = 0; // Cards that have been used
        for(int suit = 0; suit <= 3; suit++){ // Create each Suits
            for(int value = 0; value <= 13; value++){

            }
        }


    }

    public void shuffle() { //사용한 카드를 다시 덱에 넣어서 shuffle

    }

    public int cardsLeft() {
        return cardsUsed;
    }

    public Card dealCard() {
        return deck[0];
    }

    public String toString(){
        return "";

    }
}
