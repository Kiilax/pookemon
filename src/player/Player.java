package player;
import java.util.ArrayList;
import java.util.Random;

import pokemoon.Pokemoon;

public class Player {
    protected String m_nom;
    protected Deck m_deck;
    protected Hand m_hand;
    protected Playground m_playground;
    protected Discard m_discard;
    protected static boolean m_firstPlayer = true;

    public Player() {
        //m_firstPlayer = firstPlayer;
        if(m_firstPlayer) {
            m_deck = new Deck(20);
            m_firstPlayer = false;
        }
        else {
            m_deck = new Deck(21);
        }
        //m_nom = nom;
        m_hand = new Hand();
        m_playground = new Playground();
        m_discard = new Discard();
        fillHand();
    }

    /**
     * Permet de remplir la main (action a faire en début de tour)
     */
    public void fillHand(){
        while(m_hand.getSize()<5 && !m_deck.isEmpty()){
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
     * Rempli le terrain toujours avec les mêmes poke (pour test le fonctionnement d'un tour automatique)
     * @return
     */
    void fillPlayground(Pokemoon poke){
        m_playground.addPokemoon(poke);
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
    /**
     * Attaque un pokemon de du joueur d'en face en fonction de l'affinité de son pokemon et de la vie des pokemons adverses
     * @param other le joueur à attaquer
     * @param myPokeIndex l'index du pokemon qui est en train d'attaquer
     * @return chaine de caractères qui résume l'attaque réalisé
     */
    public String autoAttack(Player other, int myPokeIndex) {
        Pokemoon myPoke = m_playground.getPokemoonByIndex(myPokeIndex);
        ArrayList<Pokemoon> otherAffin = new ArrayList<Pokemoon>();
        String element = myPoke.getElement();
        String res;
        for(int i=0; i<3; i++){
            if(other.m_playground.getPokemoonByIndex(i).getDesavantage().equals(element)){
                otherAffin.add(other.m_playground.getPokemoonByIndex(i));
            }
        }
        if(!otherAffin.isEmpty()) {
            Pokemoon target = otherAffin.get(0);
            for (Pokemoon p : otherAffin) {
                if (p.getLife() < target.getLife()) {
                    target = p;
                }
            }
            res = myPoke.fight(target);
        }
        else {
            ArrayList<Pokemoon> alivePokemons = new ArrayList<Pokemoon>();
            for(int i=0; i<3; i++){
                alivePokemons.add(other.m_playground.getPokemoonByIndex(i));
            }
            if (!alivePokemons.isEmpty()) {
                Pokemoon target;
                int minLife = alivePokemons.get(0).getLife();
                ArrayList<Pokemoon> candidates = new ArrayList<>();
            
                for (Pokemoon p : alivePokemons) {
                    if (p.getLife() < minLife) {
                        minLife = p.getLife();
                        candidates.clear();
                        candidates.add(p);
                    } 
                    else if (p.getLife() == minLife) {
                        candidates.add(p);
                    }
                }
            
                Random random = new Random();
                target = candidates.get(random.nextInt(candidates.size()));
            
                res = myPoke.fight(target);
            }
            else {
                res = "Aucun pokemon à attaquer";
            }
        }
        return res;
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
