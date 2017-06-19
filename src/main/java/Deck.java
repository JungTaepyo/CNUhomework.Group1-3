import java.io.Serializable;

/**
 * Created by user on 2017-06-19.
 */
public class Deck implements Serializable {
    private Card[] deck;
    private int cardsUsed;

    public Deck() {
        //섞이지 않은 카드 덱 생성
        deck = new Card[52];
        int cardCount = 0; // 카드를 추가할때마다 증가
        for(int suit = 0; suit <= 3; suit++){
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
