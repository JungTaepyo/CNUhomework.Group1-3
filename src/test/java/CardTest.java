import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 2017-06-19.
 */
public class CardTest {

    @Test
    public void 카드가_잘_작동하나(){
        Card firstCard = new Card(1,1);
        Card secondCard = new Card(1,1);
        assertThat(firstCard==secondCard);
    }
}
