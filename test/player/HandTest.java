package player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pokemoon.Pokemoon;

public class HandTest {
    @Test
    public void TestAddPoke(){
        Hand hand = new Hand();
        for(int i=0; i<5; i++){
            assertTrue(hand.addPokemoon(new Pokemoon()));
        }
        assertFalse(hand.addPokemoon(new Pokemoon()));
    }

    @Test
    public void TestGetPoke(){
        Hand hand = new Hand();
        Pokemoon poke = new Pokemoon();
        hand.addPokemoon(poke);
        assertEquals(poke, hand.getPokemoonByName(poke.getName()));
    }
}
