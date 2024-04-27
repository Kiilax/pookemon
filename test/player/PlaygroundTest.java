package player;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import pokemoon.Pokemoon;

public class PlaygroundTest {

    @Test
    public void TestTcheck(){
        Playground play = new Playground();
        Pokemoon poke = new Pokemoon();
        Pokemoon poke2 = new Pokemoon();
        while (poke.getLife()>0) {
            poke2.fight(poke);
        }
        play.addPokemoon(poke);
        assertTrue(play.getSize()==1);
        play.tcheck();
        assertTrue(play.getSize()==0);
        
    }
}
