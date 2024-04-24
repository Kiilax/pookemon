package pokemoon;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class PokePowerTest {
    @Test
    public void TestInit(){
        PokePower power = new PokePower(10);
        assertTrue(power.getPower() == 10);
    }

    @Test
    public void TestGetAttackPowerAvantage(){
        PokePower power = new PokePower(10);
        Element eau = Element.EAU;
        Element feu = Element.FEU;
        assertTrue(power.getAttackPower(eau, feu) == 20);
    }

    @Test
    public void TestGetAttackPowerDesavantage(){
        PokePower power = new PokePower(10);
        Element eau = Element.EAU;
        Element terre = Element.TERRE;
        assertTrue(power.getAttackPower(eau, terre) == 0);
    }
}
