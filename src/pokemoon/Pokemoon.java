package pokemoon;

import java.util.Random;
import pouvoir.Pouvoir;

public class Pokemoon {
    private String m_name;
    private PokeLife m_life;
    private PokePower m_powerAtt;
    private Element m_affinite;
    private Pouvoir m_pouv;

    public Pokemoon(){
        Random rd = new Random();
        Element[] tabElement = {Element.AIR,Element.EAU,Element.FEU,Element.TERRE};
        m_name = ListPokemoon.getName();
        m_life = new PokeLife(10*(10 + rd.nextInt(10)));
        m_powerAtt = new PokePower(10 * (1 + rd.nextInt(3)));
        m_affinite = tabElement[rd.nextInt(4)];
    }

    @Override
    public String toString(){
        return m_name+
        " | Points de vie : "+m_life.getPV()+"/"+m_life.getPvMax()+
        " | Puissance : "+m_powerAtt.getPower()+
        " | Type : "+m_affinite.toString()+
        " | Affinité : "+m_affinite.getAvantage()+"\n";
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

    public String getAvantage() {
        return m_affinite.getAvantage();
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

    void protec(int protec){
        m_life.setProtec(protec);
    }

    void increasePower(int increase){
        m_powerAtt.increasePower(increase);
    }

    boolean utilise(Object obj){
        if(m_pouv != null){
            m_pouv.utiliser(this, obj);
            if(m_pouv.getUnique()){
                m_pouv = null;
            }
            return true;
        }
        return false;
    }
}
