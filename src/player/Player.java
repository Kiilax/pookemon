package player;
import java.util.ArrayList;

import pokemoon.Pokemoon;

public class Player {
    protected String m_nom;
    protected Deck m_deck;
    protected Hand m_hand;
    protected Playground m_playground;
    protected Discard m_discard;
    protected static boolean m_firstPlayer;

    public Player(String nom, boolean firstPlayer) {
        m_firstPlayer = firstPlayer;
        if(m_firstPlayer) {
            m_deck = new Deck(20);
        }
        else {
            m_deck = new Deck(21);
        }
        m_nom = nom;
        m_hand = new Hand();
        m_playground = new Playground();
        m_discard = new Discard();
        fillHand();
    }

    /**
     * Permet de remplir la main (action a faire en début de tour)
     */
    public void fillHand(){
        while(m_hand.getSize()<5){
            m_hand.addPokemoon(m_deck.takePokemoon());
        }
    }
    /**
     * ajoute un pokemon au playground
     * @param index l'index du pokemon
     */
    public void choosePoke(int index) {
        m_playground.addPokemoon(m_hand.getPokemoonByIndex(index));
    }

    /**
     * transfert les poke qui n'on plus de vie du plateau à la defausse
     * @return le nombre de poke mort
     */
    public int cleanPlayground(){
        ArrayList<Pokemoon> pokedead = m_playground.tcheck();
        for(Pokemoon poke : pokedead){
            m_discard.addPokemoon(poke);
        }
        return pokedead.size();
    }
    public String getHand(){
        return m_hand.toString();
    }
    public int getHandSize(){
        return m_hand.getSize();
    }

    public String getPlayground(){
        return m_playground.toString();
    }

    public int getPlaygroundSize() {
        return m_playground.getSize();
    }

    public int getDeckSize(){
        return m_deck.getSize();
    }

    public int getDiscardSize(){
        return m_discard.getSize();
    }

    public String getPlayerName() {
        return m_nom;
    }
    public boolean getFirstPlayer() {
        return m_firstPlayer;
    }
    public String toString() {
        return m_playground.toString();
    }
    
}
