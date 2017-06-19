import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 2017-06-19.
 */
public class CardTest {
    Card firstCard = new Card(1,1);

    @Test
    public void 카드가_잘_작동하나(){
        Card secondCard = new Card(1,1);
        assertThat(firstCard==secondCard);
    }

    @Test
    public void isValue_잘되나(){
        assertThat(firstCard.getValue()==1);
    }

    @Test
    public void getSuit_잘되나(){
        assertThat(firstCard.getSuit()==1);
    }

    @Test
    public void getSuitAsString_테스트(){
        assertThat(firstCard.getSuitAsString()== "Heart");
    }

    @Test
    public void getValueAsString_초기값테스트(){
        assertThat(firstCard.getValueAsString()=="10");
        //do not use this test method again, it will not work
    }

    @Test
    public void getValueAsString_테스트(){
    }


}
