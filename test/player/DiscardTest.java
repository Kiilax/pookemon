package player;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pokemoon.Pokemoon;

public class DiscardTest {
    @Test
    public void TestAddPoke(){
        Discard disc = new Discard();
        disc.addPokemoon(new Pokemoon());
        disc.addPokemoon(new Pokemoon());
        assertTrue(disc.getSize()==2);
    }
}
