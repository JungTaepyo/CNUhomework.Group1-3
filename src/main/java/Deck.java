import java.io.Serializable;

/**
 * Created by user on 2017-06-19.
 */
public class Deck implements Serializable {
    private Card[] deck;
    private int cardsUsed;

    public Deck() {
        //섞이지 않은 카드 덱 생
        deck = new Card[52];
    }

    public void shuffle() { //사용한 카드를 다시 덱에 넣어서 shuffle

    }

    public int cardsLeft() {
        return cardsUsed;
    }
}
