package pokemoon;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PokeLifeTest {
    @Test
    public void TestInit(){
        PokeLife life = new PokeLife(10);
        assertTrue(life.getPV() == 10 && life.getPvMax() == 10);
    }

    @Test
    public void TestTakeDamageVieEnPlus(){
        PokeLife life = new PokeLife(10);
        assertTrue(life.takeDamage(5) == 5);
    }

    @Test
    public void TestTakeDamageVieEnMoins(){
        PokeLife life = new PokeLife(10);
        assertTrue(life.takeDamage(15) == 0);
    }

    @Test
    public void TestTakeDamagePlusDeVie(){
        PokeLife life = new PokeLife(10);
        assertTrue(life.takeDamage(10)==0);
    }
}
