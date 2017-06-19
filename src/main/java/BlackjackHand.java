import java.io.Serializable;

/**
 * Created by user on 2017-06-19.
 */
public class BlackjackHand extends Hand implements Serializable {
    public int getBlackjackValue() {
        //특정 Hand에 있는 블랙잭 합 계산
        int value = 0; // 손에 대해 계산 된 값
        int cards = 0; // 손에있는 카드의 수
        boolean ace = false; // 손에 에이스가 있으면 true로 설정됩니다
        cards = getCardCount();

        for (int i = 0; i < cards; i++) {
            Card card;
            int cardVal;
            card = getCard(i);
            cardVal = card.getValue();
            if (cardVal == 1) {
                ace = true;
            }
        }
        if (ace == true){
            value = 1;
        }
        return value;

    }
}
