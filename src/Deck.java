import java.util.Stack;

public class Deck {
    private Stack<Pokemoon> m_pokemons = new Stack<>();

    public Deck(int deckSize)/*le constructeur remplie m_pokemons avec 20 ou 21 pokemons aléatoires */ {
        for(int i = 0; i<deckSize; i++) {
            m_pokemons.push(new Pokemoon());
        }
    }
    public Pokemoon takePokemoons() {
        return m_pokemons.pop();
    }
    public String toString() {
        return "Dans mon deck il y a "+m_pokemons.size()+" pokémoons !";
    }
}
