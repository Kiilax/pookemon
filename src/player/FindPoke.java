package player;

import partie.Deroulement;
import partie.affichage.GetPoke;
import pokemoon.Pokemoon;

public class FindPoke implements GetPoke{
    Player m_joueur;
    public FindPoke(Player p){
        m_joueur = p;
    }

    @Override
    public Pokemoon getPoke(String question){
        System.out.println(question);
        int poke = Deroulement.getIndexValide(m_joueur.getPlaygroundSize());
        return m_joueur.m_playground.getPokemoonByIndex(poke);
    }

    public Pokemoon getPoke(int numPoke){
        return m_joueur.m_playground.getPokemoonByIndex(numPoke);
    }
}
