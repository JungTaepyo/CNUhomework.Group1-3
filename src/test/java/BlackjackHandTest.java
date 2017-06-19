import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 2017-06-19.
 */
public class BlackjackHandTest {

    @Test
    public void 블랙잭_핸드_개수_테스트() {
        BlackjackHand blackjackHand = new BlackjackHand();
        assertThat(blackjackHand.getBlackjackValue(), is(21));
    }

    @Test
    public void ace를_찾게_되면_true로_리턴() {
        BlackjackHand blackjackHand = new BlackjackHand();
    }
}