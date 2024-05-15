package pokemoon;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PokeTest{
    @Test
    public void testAttaqueEgale(){
        Pokemoon pokeA1 = new Pokemoon("moi",100,20,Element.AIR);
        Pokemoon pokeA2 = new Pokemoon("l'autre", 100, 20, Element.AIR);
        Pokemoon pokeF1 = new Pokemoon("moi",100,20,Element.FEU);
        Pokemoon pokeF2 = new Pokemoon("l'autre", 100, 20, Element.FEU);
        Pokemoon pokeE1 = new Pokemoon("moi",100,20,Element.EAU);
        Pokemoon pokeE2 = new Pokemoon("l'autre", 100, 20, Element.EAU);
        Pokemoon pokeT1 = new Pokemoon("moi",100,20,Element.TERRE);
        Pokemoon pokeT2 = new Pokemoon("l'autre", 100, 20, Element.TERRE);
        assertEquals("moi inflige 20 à l'autre", pokeA1.fight(pokeA2));
        assertEquals("moi inflige 20 à l'autre", pokeF1.fight(pokeF2));
        assertEquals("moi inflige 20 à l'autre", pokeE1.fight(pokeE2));
        assertEquals("moi inflige 20 à l'autre", pokeT1.fight(pokeT2));
    }

    @Test
    public void testAttaqueSup(){
        Pokemoon pokeA = new Pokemoon("air",100,20,Element.AIR);
        Pokemoon pokeF = new Pokemoon("feu",100,20,Element.FEU);
        Pokemoon pokeE = new Pokemoon("eau",100,20,Element.EAU);
        Pokemoon pokeT = new Pokemoon("terre",100,20,Element.TERRE);
        assertEquals("feu inflige 30 à air", pokeF.fight(pokeA));
        assertEquals("air inflige 30 à terre", pokeA.fight(pokeT));
        assertEquals("eau inflige 30 à feu", pokeE.fight(pokeF));
        assertEquals("terre inflige 30 à eau", pokeT.fight(pokeE));
    }

    @Test
    public void testAttaqueInf(){
        Pokemoon pokeA = new Pokemoon("air",100,20,Element.AIR);
        Pokemoon pokeF = new Pokemoon("feu",100,20,Element.FEU);
        Pokemoon pokeE = new Pokemoon("eau",100,20,Element.EAU);
        Pokemoon pokeT = new Pokemoon("terre",100,20,Element.TERRE);
        assertEquals("air inflige 10 à feu", pokeA.fight(pokeF));
        assertEquals("terre inflige 10 à air", pokeT.fight(pokeA));
        assertEquals("feu inflige 10 à eau", pokeF.fight(pokeE));
        assertEquals("eau inflige 10 à terre", pokeE.fight(pokeT));
    }
}