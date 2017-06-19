import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

}
