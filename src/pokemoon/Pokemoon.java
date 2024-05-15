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
        m_life = new PokeLife(10*(10 + rd.nextInt(10)));
        m_powerAtt = new PokePower(10 * (1 + rd.nextInt(3)));
        m_affinite = tabElement[rd.nextInt(4)];
    }

    public Pokemoon(String name, int life, int power, Element affinite){
        m_name = name;
        m_life = new PokeLife(life);
        m_powerAtt = new PokePower(power);
        m_affinite = affinite;
    }
    @Override
    public String toString(){
        return m_name+
        "\n| Points de vie : "+m_life.getPV()+"/"+m_life.getPvMax()+
        "\n| Puissance : "+m_powerAtt.getPower()+
        "\n| Type : "+m_affinite.toString()+
        "\n| Affinité : "+m_affinite.getAvantage()+"\n\n";
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
        return m_affinite.toString();
    }

    public String getDesavantage(){
        return m_affinite.getDesavantage();
    }

    /**
     * @param other le pokemoon qui est attaquer
     */
    public String fight(Pokemoon other){
        int powerAttack = m_powerAtt.getAttackPower(m_affinite, other.m_affinite);
        other.m_life.takeDamage(powerAttack);
        return m_name+" inflige "+powerAttack+" à "+other.m_name;
    }
}
