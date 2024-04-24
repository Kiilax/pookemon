package pokemoon;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class ElementTest {
    @Test
    public void TestEau(){
        Element eau = Element.EAU;
        assertTrue(eau.getAvantage().equals("feu") && eau.getDesavantage().equals("terre"));
    }

    @Test
    public void TestTerre(){
        Element terre = Element.TERRE;
        assertTrue(terre.getAvantage().equals("eau") && terre.getDesavantage().equals("air"));
    }

    @Test
    public void TestFeu(){
        Element feu = Element.FEU;
        assertTrue(feu.getAvantage().equals("air") && feu.getDesavantage().equals("eau"));
    }

    @Test
    public void TestAir(){
        Element air = Element.AIR;
        assertTrue(air.getAvantage().equals("terre") && air.getDesavantage().equals("feu"));
    }
}
