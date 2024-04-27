package pokemoon;

import java.util.Random;

public class Pokemoon {
    private String m_name;
    private PokeLife m_life;
    private PokePower m_powerAtt;
    private Element m_affinite;

    public Pokemoon(){
        Random rd = new Random();
        Element[] tabElement = {Element.AIR,Element.EAU,Element.FEU,Element.TERRE};
        m_name = ListPokemoon.getName();
        m_life = new PokeLife(10*rd.nextInt(10,20));
        m_powerAtt = new PokePower(10 * rd.nextInt(1,4));
        m_affinite = tabElement[rd.nextInt(0,3)];
    }

    @Override
    public String toString(){
        return "nom : "+m_name+"\nvie : "+m_life.getPV()+"\npuissance : "+m_powerAtt.getPower()+"\ntype : "+m_affinite.toString();
    }

    public String getName(){
        return new String(m_name);
    }

    public int getPower(){
        return m_powerAtt.getPower();
    }

    public int getLife(){
        return m_life.getPV();
    }

    public int getLifeMax(){
        return m_life.getPvMax();
    }

    public String getElement(){
        return m_affinite.name();
    }

    public String getDesavantage(){
        return m_affinite.getDesavantage();
    }

    /**
     * @param other le pokemoon qui est attaquer
     */
    public void fight(Pokemoon other){
        int powerAttack = m_powerAtt.getAttackPower(m_affinite, other.m_affinite);
        other.m_life.takeDamage(powerAttack);
    }
}
