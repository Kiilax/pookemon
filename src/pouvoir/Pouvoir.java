package pouvoir;

import pokemoon.Pokemoon;

public abstract class Pouvoir {
    private String m_nom;
    private String m_desc;
    private boolean m_unique;

    protected Pouvoir(String nom, String desc, boolean unique){
        m_nom = nom;
        m_desc = desc;
        m_unique = unique;
    }

    abstract public void utiliser(Pokemoon poke, Object obj);

    public String getNom(){
        return m_nom;
    }

    public String getDesc(){
        return m_desc;
    }

    public boolean getUnique(){
        return m_unique;
    }
}
