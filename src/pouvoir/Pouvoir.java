package pouvoir;

import player.Player;
import pokemoon.Pokemoon;

public abstract class Pouvoir {
    private String m_nom;
    private String m_desc;
    private boolean m_unique;
    private Boolean m_offencif;

    protected Pouvoir(String nom, String desc, boolean unique, Boolean offencif){
        m_nom = nom;
        m_desc = desc;
        m_unique = unique;
        m_offencif = offencif;
    }

    abstract public void utiliser(Pokemoon poke, Pokemoon other, Player joeur);

    public String getNom(){
        return m_nom;
    }

    public String getDesc(){
        return m_desc;
    }

    public boolean getUnique(){
        return m_unique;
    }

    public Boolean getOffencif(){
        return m_offencif;
    }

    @Override
    public String toString(){
        return m_nom + " " + m_desc;
    }
}
