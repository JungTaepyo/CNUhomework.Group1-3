import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by ryan on 2017. 6. 19..
 */
public class DeckTest {

    @Test
    public void Check_Cardsused(){
        Deck deck = new Deck();
        assertThat(deck.cardsLeft(),is(52));
    }

}
