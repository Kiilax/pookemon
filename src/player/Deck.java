package player;

import java.util.Stack;
import pokemoon.Pokemoon;

public class Deck {
    private Stack<Pokemoon> m_pokemoons;

    /*le constructeur remplie m_pokemons avec 20 ou 21 pokemons aléatoires */
    Deck(int deckSize){
        m_pokemoons = new Stack<Pokemoon>();
        for(int i = 0; i<deckSize; i++) {
            m_pokemoons.push(new Pokemoon());
        }
    }

    Pokemoon takePokemoon() {
        return m_pokemoons.pop();
    }

    boolean isEmpty() {
        return m_pokemoons.empty();
    }

    int getSize(){
        return m_pokemoons.size();
    }

    @Override
    public String toString() {
        return "Dans mon deck il y a "+m_pokemoons.size()+" pokémoons !";
    }
}
