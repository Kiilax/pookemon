package pokemoon;

import java.util.Random;

import player.Player;
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

    public Pokemoon(Pouvoir pouv){
        Random rd = new Random();
        Element[] tabElement = {Element.AIR,Element.EAU,Element.FEU,Element.TERRE};
        m_name = ListPokemoon.getName();
        m_life = new PokeLife(10*(10 + rd.nextInt(10)));
        m_powerAtt = new PokePower(10 * (1 + rd.nextInt(3)));
        m_affinite = tabElement[rd.nextInt(4)];
        m_pouv = pouv;
    }

    @Override
    public String toString(){
        return m_name+
        " | Points de vie : "+m_life.getPV()+"/"+m_life.getPvMax()+
        " | Puissance : "+m_powerAtt.getPower()+
        " | Type : "+m_affinite.toString()+
        " | Affinité : "+m_affinite.getAvantage()+
        " | Pouvoir : "+getPouvoir()+"\n";
    }

    public void heal(int heal){
        m_life.takeHeal(heal);
    }

    public void setAffinite(Element type){
        m_affinite = type;
    }

    public boolean hasPower(){
        return !(m_pouv==null);
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

    public String getPouvoir(){
        if(m_pouv == null){
            return "----";
        }
        else{
            return m_pouv.getNom();
        }
    }

    public Boolean getOffencif(){
        return m_pouv.getOffencif();
    }

    public String getDescPouvoir() {
        if(m_pouv == null) {
            return "Pas de pouvoir";
        }
        else {
            return m_pouv.getNom()+" : "+m_pouv.getDesc();
        }
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

    public void utilise(Player joueur, Pokemoon other){
            if(m_pouv != null){
                m_pouv.utiliser(this, other, joueur);
                if(m_pouv.getUnique()){
                    m_pouv = null;
                }
            }
    }
}
