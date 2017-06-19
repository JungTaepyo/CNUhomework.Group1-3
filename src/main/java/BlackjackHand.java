import java.io.Serializable;

/**
 * Created by user on 2017-06-19.
 */
public class BlackjackHand extends Hand implements Serializable {
    public int getBlackjackValue() {
        //특정 Hand에 있는 블랙잭 합 계산
        int value = 0;
        int cards = 0;
        boolean ace = false;
        cards = getCardCount();

        for (int i = 0; i < cards; i++) {
            Card card;
            int cardVal;
            card = getCard(i);
            cardVal = card.getValue();
            if (cardVal == 1) {
                ace = true;     // There is at least one ace.
            }
        }
        if (ace == true){
            value = 1;
        }
        return value;

    }
}
