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

        for (int i = 0; i < cards; i++) {// i 번째 카드의 값을 손에 넣는다.
            Card card;
            int cardVal;
            card = getCard(i);
            cardVal = card.getValue();
            if (cardVal == 1)
                ace = true;
            if (cardVal > 10)
                cardVal = 10;
            value = value + cardVal;
        }
        if (ace == true) {
            value = 1;
        }
        return value;

    }
}
