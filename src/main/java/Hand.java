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
        Vector newHand = new Vector();
        while(hand.size()>0){
            int pos = 0;
            Card c = (Card)hand.elementAt(0);
            for(int i = 1; i< hand.size(); i++){
                Card c1 = (Card)hand.elementAt(i);
                if ( c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ){
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.addElement(c);
        }
    }

    public void sortByValue() {

    }

    public String toString(){
        return "";

    }
}
