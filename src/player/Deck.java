package player;

import java.util.Stack;
import java.util.Collections;

import pokemoon.Pokemoon;
import pokemoon.ListPokemoon;

public class Deck {
    private Stack<Pokemoon> m_pokemoons;

    /*le constructeur remplie m_pokemons avec 20 ou 21 pokemons aléatoires */
    Deck(int deckSize){
        m_pokemoons = new Stack<Pokemoon>();
        for(int i = 0; i<deckSize; i++) {
            m_pokemoons.push(ListPokemoon.getPoke());
        }
    }

    void add(Pokemoon poke){
        m_pokemoons.push(poke);
    }

    void melange(){
        Collections.shuffle(m_pokemoons);
    }

    // /!\ attention ne fait pas attention ne gère pas les pilles vide
    Pokemoon takePokemoon() {
        return m_pokemoons.pop();
    }

    Pokemoon getPokeByIndex(int index){
        return m_pokemoons.elementAt(index);
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
