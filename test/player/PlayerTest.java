package player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testInit(){
        Random rd = new Random();
        if(rd.nextBoolean()){
            
        }
        Player p1 = new Player();
        Player p2 = new Player();
        assertEquals(p1.getDeckSize(), 15);
        assertEquals(p2.getDeckSize(), 21);
    }

    @Test
    public void testFillHand(){
        Player p = new Player();
        Player p1 = new Player();
        p.fillHand();
        p1.fillHand();
        assertEquals(1,p1.getDeckSize());
        assertEquals(5, p1.getHand().split(",").length);
    }

    @Test
    public void testAttack(){
        Player p1 = new Player();
        Player p2 = new Player();
        p1.fillHand();
        p2.fillHand();
        p1.choosePoke("");
        p2.choosePoke("");
        while(p2.cleanPlayground() <= 0){
            p1.attack(p2, "","");
        }
        assertEquals(1,p2.getDiscardSize());
    }
}
