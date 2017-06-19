import java.util.Vector;

/**
 * Created by 이충완 on 2017-06-19.
 */
public class Hand {
    private Vector hand;

    public Hand(){
        hand = new Vector();
    }

    public void clear() {
        hand.removeAllElements();
    }

    public void addCard(Card c) {
        if (c != null)
            hand.addElement(c);
    }
}
