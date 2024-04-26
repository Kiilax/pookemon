import pokemoon.Pokemoon;

public class Player {
    private Deck m_deck;
    private Hand m_hand;
    //private Playground m_playground;
    //private Discard m_discard;
    private static boolean m_firstPlayer = true;
    private String m_nom;

    public Player(String nom) {
        m_nom = nom;
        if(m_firstPlayer) {
            m_deck = new Deck(20);
            m_firstPlayer = false;
        }
        else m_deck = new Deck(21);

        m_hand = new Hand(m_deck);
        //m_playground = new Playground();
        //m_discard = new Discard();
    }

    public boolean getRole() {
        return m_firstPlayer;
    }

    public Deck getDeck() {
        return m_deck;
    }

    public Hand getHand() {
        return m_hand;
    }

    /*public Playground getPlayground() {
        return m_playground;
    }

    public Discard getDiscard() {
        return m_discard;
    }

    public String toString() {
        Pokemoon p = m_deck.takePokemoon();
        String res = "Le joueur "+m_nom+" possède "+p.getName()+" !";
        return res;
    }*/
}
