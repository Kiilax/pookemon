package player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testInit(){
        Player p1 = new Player();
        Player p2 = new Player();
        assertEquals(5,p1.getDeckSize());
        assertEquals(6,p2.getDeckSize());
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

    /*@Test
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
    }*/
}
