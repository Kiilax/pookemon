import pokemoon.Pokemoon;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Pokemoon> m_pokemoons = new ArrayList<Pokemoon>();
    private Deck m_deck;

    public Hand(Deck deck) {
        m_deck = deck;
        for(int i = 0; i<5; i++) {
            addPokemoon();
        }
    }
    public void addPokemoon() {
        while(m_pokemoons.size()<5 && !m_deck.isDeckEmpty()) {
            m_pokemoons.add(m_deck.takePokemoon());
        }
        
    }
    public ArrayList<Pokemoon> getPokemoon() {
        return m_pokemoons;
    }
    public String toString() {
        return "Dans ma main j'ai "+m_pokemoons.size()+" pokemoons !";
    }
}
