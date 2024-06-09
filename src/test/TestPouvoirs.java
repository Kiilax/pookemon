package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import pouvoir.Pouvoir;
import pokemoon.*;

public class TestPouvoirs {
    // pv a 0 pour les deux
    @Test
    public void testKamikaz(){
        Pokemoon alqaeida = new Pokemoon();
        Pokemoon lesJumel = new Pokemoon();
        Pouvoir kamikaz = new PouvKamikaz();
        kamikaz.utiliser(alqaeida, lesJumel, null);
        assertEquals(alqaeida.getLife(),0);
        assertEquals(lesJumel.getLife(),0);
    }

    // tout les pv 
    @Test
    public void testSoinTotal(){
        Pokemoon alqaeida = new Pokemoon();
        Pouvoir soinTotal = new PouvSoinTotal();
        alqaeida.fight(alqaeida);
        assertNotEquals(alqaeida.getLife(), alqaeida.getLifeMax());
        soinTotal.utiliser(null,alqaeida, null);
        assertEquals(alqaeida.getLife(),alqaeida.getLifeMax());
    }

    // 30 pv en plus
    @Test
    public void testSoinSimple(){
        Pokemoon alqaeida = new Pokemoon();
        Pouvoir soinSimple = new PouvSoinSimple();
        alqaeida.fight(alqaeida);
        alqaeida.fight(alqaeida);
        alqaeida.fight(alqaeida);
        int vieRestante = alqaeida.getLife();
        soinSimple.utiliser(null, alqaeida, null);
        assertEquals(alqaeida.getLife(), vieRestante+30);
    }

    // -10 dégas par attaque
    @Test
    public void testResitance(){
        Pokemoon alqaeida = new Pokemoon();
        Pouvoir resistance = new PouvResistance();
        resistance.utiliser(null, alqaeida, null);
        int vieRestante = alqaeida.getLifeMax() - 2*(alqaeida.getPower()-10);
        alqaeida.fight(alqaeida);
        alqaeida.fight(alqaeida);
        assertEquals(alqaeida.getLife(), vieRestante);
    }

    @Test
    public void testPlomb(){
        Pokemoon alqaeida = new Pokemoon();
        Pokemoon lesJumel = new Pokemoon();
        Pouvoir plomb = new PouvPlomb();
        plomb.utiliser(null, lesJumel, null);
        lesJumel.fight(alqaeida);
        alqaeida.fight(lesJumel);
        int vieRestanteAutre = alqaeida.getLifeMax() - (lesJumel.getPower()-10);
        int vieRestantePlomb = lesJumel.getLifeMax() - (alqaeida.getPower()+10);
        assertEquals(lesJumel.getElement(), "PLOMB");
        assertEquals(alqaeida.getLife(), vieRestanteAutre);
        assertEquals(lesJumel.getLife(), vieRestantePlomb);
    }

    @Test
    public void testEther(){
        Pokemoon alqaeida = new Pokemoon();
        Pokemoon lesJumel = new Pokemoon();
        Pouvoir ether = new PouvEther();
        ether.utiliser(null, lesJumel, null);
        lesJumel.fight(alqaeida);
        alqaeida.fight(lesJumel);
        int vieRestanteAutre = alqaeida.getLifeMax() - (lesJumel.getPower()+10);
        int vieRestanteEther = lesJumel.getLifeMax() - (alqaeida.getPower()-10);
        assertEquals(lesJumel.getElement(), "ETHER");
        assertEquals(vieRestanteAutre, alqaeida.getLife());
        assertEquals(vieRestanteEther, lesJumel.getLife());
    }

    @Test
    public void testFerveurGuerriere(){
        Pokemoon alqaeida = new Pokemoon();
        Pouvoir ferveurGuerriere = new PouvFerveurGuerriere();
        ferveurGuerriere.utiliser(null, alqaeida, null);
        int vieRestante = alqaeida.getLife()-alqaeida.getPower();
        alqaeida.fight(alqaeida);
        assertEquals(vieRestante, alqaeida.getLife());
    }



}
