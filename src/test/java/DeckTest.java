import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.util.Assert.isInstanceOf;

/**
 * Created by ryan on 2017. 6. 19..
 */
public class DeckTest {

    @Test
    public void Check_Cardsused(){
        Deck deck = new Deck();
        assertThat(deck.cardsLeft(),is(52));
    }
    @Test
    public void DEAL_CARD_CHECK_WHETHER_IT_RETURNS_A_CARD_FROM_DECK(){
        Deck deck = new Deck();
        Card returnCard = deck.dealCard();
        assertThat(returnCard, instanceOf(Card.class));
    }
    @Test
    public void DEAL_CARD_CHECK_WHETHER_IT_SHUFFLES_THE_DECK_WHEN_CARD_USED_REACHED_TO_52(){
        Deck deck = new Deck();
        int count=1;
        Card returnCard=deck.dealCard();
        while(count<52){
            deck.dealCard();
            count++;
        }
        assertNotEquals(returnCard, deck.dealCard());
    }
    @Test
    public void SHUFFLING_DOING_OK(){
        Deck deck = new Deck();
        Card card1=deck.getDeck()[0];
        deck.shuffle();
        Card card2=deck.getDeck()[0];

        assertNotEquals(card1, card2);
    }

}
