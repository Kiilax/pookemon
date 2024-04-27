package player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeckTest {

    @Test
    public void TestGetSize(){
        Deck deck = new Deck(4);
        assertTrue(deck.getSize()==4);
    }

    @Test
    public void TestTakePokemoon(){
        Deck deck = new Deck(1);
        deck.takePokemoon();
        assertTrue(deck.getSize()==0);
    }

    @Test
    public void TestIsDeckEmpty(){
        Deck deck = new Deck(1);
        assertFalse(deck.isEmpty());
        deck.takePokemoon();
        assertTrue(deck.isEmpty());
    }
}