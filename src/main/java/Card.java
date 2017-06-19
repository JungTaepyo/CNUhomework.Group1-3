/**
 * Created by user on 2017-06-19.
 */
import java.io.Serializable;
public class Card implements Serializable {

    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int ACE = 1 ;
    public final static int JACK = 11 ;
    public final static int QUEEN = 12 ;
    public final static int KING = 13 ;

    private final int suit;
    private final int value;

    public Card(int theValue, int theSuit) {
        value = theValue;
        suit = theSuit;
    }
    public int getSuit() {
        // Suit에 맞는 integer 리턴
        return suit;
    }
    public int getValue() {
        return value;
    }
    public String getSuitAsString() {
        return "Spades";
    }
    public String getValueAsString() {
        return "10";
    }
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }

}
