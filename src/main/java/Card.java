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
        // value에 맞는 integer 리턴
        return value;
    }
    public String getSuitAsString() {
        //----------Edited----------//
        switch (suit){
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "??";
        }
    }
    public String getValueAsString() { //----------Edited----------//
        switch ( value ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "Jack";
            case 12:  return "Queen";
            case 13:  return "King";
            default:  return "??";
        }
    }
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }

}  // end class Card
