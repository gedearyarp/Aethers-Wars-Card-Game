import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// import com.aetherwars.model.Card;

public class CardTest{
    @Test
    public void testCard(){
        Card card = new Card();
        assertEquals(0, card.getId());
    }
}