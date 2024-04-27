package player;

import java.util.Stack;

import pokemoon.Pokemoon;

public class Discard {
    private Stack<Pokemoon> m_pokemoons;

    Discard(){
        m_pokemoons = new Stack<Pokemoon>();
    }

    void addPokemoon(Pokemoon poke){
        m_pokemoons.add(poke);
    }

    int getSize(){
        return m_pokemoons.size();
    }

    @Override
    public String toString(){
        String listPoke = "";
        for (Pokemoon poke : m_pokemoons) {
            listPoke += poke.getName()+", ";
        }
        return listPoke;
    }
}
