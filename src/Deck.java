import java.util.Stack;

public class Deck {
    private Stack<Pokemoon> m_pokemoons = new Stack<Pokemoon>();

    public Deck(int deckSize)/*le constructeur remplie m_pokemons avec 20 ou 21 pokemons aléatoires */ {
        for(int i = 0; i<deckSize; i++) {
            m_pokemoons.push(new Pokemoon());
        }
    }
    public Pokemoon takePokemoon() {
        return m_pokemoons.pop();
    }
    public boolean isDeckEmpty() {
        return m_pokemoons.empty();
    }
    public String toString() {
        return "Dans mon deck il y a "+m_pokemoons.size()+" pokémoons !";
    }
}
