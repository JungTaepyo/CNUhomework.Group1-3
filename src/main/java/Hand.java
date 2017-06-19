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

    public void removeCard(Card c) {
        hand.removeElement(c);
    }

    public void removeCard(int position) {
        if (position >= 0 && position < hand.size())
            hand.removeElementAt(position);
    }

    public int getCardCount() {
        return hand.size();
    }

    public Card getCard(int position) {
        return null;
    }

    public void sortBySuit() {

    }

    public void sortByValue() {
        Vector newHand = new Vector();
    }

    public String toString(){
        return "";

    }
}
