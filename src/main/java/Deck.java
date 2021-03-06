
import lombok.Data;
import java.io.Serializable;

/**
 * Created by user on 2017-06-19.
 */
@Data
public class Deck implements Serializable {

    private Card[] deck; // Creates card deck
    private int cardsUsed;// Card used in game, when cards reach to 52 we need to shuffle

    public Deck() { // Creates unshuffled cards deck
        deck = new Card[52]; // 52 cards
        int cardCount = 0; // Cards that have been used
        for(int suit = 0; suit <= 3; suit++){ // Create each Suits
            for(int value = 1; value <= 13; value++){ // Create each Values
                deck[cardCount] = new Card(value, suit); // Create each suit and set the value
                cardCount++;
            }
        }
        cardsUsed = 0; // Initialize the used card variable
    }

    public void shuffle() { //사용한 카드를 다시 덱에 넣어서 shuffle
        for(int i = 51; i > 0; i--){
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;  //카드를 모두 사용하고 셔플을 하기 때문에 cardUsed를 0으로 초기화
    }

    public int cardsLeft() {

        return 52 - cardsUsed; // How many cards are left
    }

    //
    public Card dealCard() {
        // 덱에서 카드 하나를 리턴하는 함수
        //shuffle
        if(cardsUsed == 52)
            shuffle();
        cardsUsed++;
        return deck[cardsUsed -1];
    }

    public String toString(){

        return "";
    }


    public Card getCard(int index){ // get the requested card from the deck

        return deck[index];
    }
}
