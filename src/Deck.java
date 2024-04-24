import java.util.Stack;

public class Deck {
    private Stack<Pokemoon> m_pokemons;

    public Deck(int deckSize)/*le constructeur remplie m_pokemons avec 20 ou 21 pokemons aléatoires */ {
        m_pokemons = new Stack<>();
        Pokemoon roro = new Pokemoon("Pikachu");
        m_pokemons.push(roro);
    }
    public Pokemoon takePokemoons() {
        return m_pokemons.pop();
    }
    public String toString() {
        return "Dans mon deck il y a "+m_pokemons.size()+" pokémoons !";
    }
}
