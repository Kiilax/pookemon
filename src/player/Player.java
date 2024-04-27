package player;
import java.util.ArrayList;

import pokemoon.Pokemoon;

public class Player {
    private Deck m_deck;
    private Hand m_hand;
    private Playground m_playground;
    private Discard m_discard;
    private static boolean m_firstPlayer = true;

    public Player() {
        if(m_firstPlayer) {
            m_firstPlayer = false;
            m_deck = new Deck(5);
        }
        else {
            m_deck = new Deck(6);
        }
        m_hand = new Hand();
        m_playground = new Playground();
        m_discard = new Discard();
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
     * @param namePoke le nom du pokemon 
     * /!\ si le nom est vide alors choix automatique
     */
    public void choosePoke(String namePoke){
        if(namePoke.isEmpty()){
            m_playground.addPokemoon(m_hand.getPokemoonByIndex(0));
        }
        else{
            m_playground.addPokemoon(m_hand.getPokemoonByName(namePoke));
        }
    }

    /**
     * permet d'attaquer un pokemon d'un autre joueur (si on veut jouer a plus de deux)
     * @param other le joueur que l'on veut embête
     * @param namePoke le nom de poke que l'on veut éliminer
     * @return Retourne true si le pokemon a été attaque, false sinon
     * /!\ le champ other ne peut pas être null
     * /!\ le champ namePoke vide veut dire que l'on attaque un pokemon sur lequel on a un avantage
     */
    public boolean attack(Player other, String namePokeAttack, String namePokeOther){
        // tes l'adversaire
        if(other == null){
            return false;
        }

        //trouve le poke que je veux utiliser pour attaquer et test si null
        Pokemoon pokeAttack;
        if(namePokeAttack.isEmpty()){ //si vido on prend le 1er
            pokeAttack = m_playground.getPokemoonByIndex(0);
        }
        else{
            pokeAttack = m_playground.getPokemoonByName(namePokeAttack);
        }
        if(pokeAttack == null){
            return false;
        }

        // trouve le pokemon que je veux attaquer et test si null
        Pokemoon pokeOther;
        if(namePokeOther.isEmpty()){
            if((pokeOther = other.m_playground.getPokemoonByIndex(0))==null){
                return false;
            }
            String element = pokeAttack.getElement();
            for(int i=1; i<3; i++){
                if(other.m_playground.getPokemoonByIndex(i).getDesavantage() == element){
                    pokeOther = other.m_playground.getPokemoonByIndex(i);
                }
            }
        }
        else{
            pokeOther = other.m_playground.getPokemoonByName(namePokeOther);
        }
        if(pokeOther == null){
            return false;
        }

        pokeAttack.fight(pokeOther);
        return true;
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

    public String getPlayground(){
        return m_playground.toString();
    }

    public int getDeckSize(){
        return m_deck.getSize();
    }

    public int getDiscardSize(){
        return m_discard.getSize();
    }

    public String toString() {
        return m_playground.toString();
    } 
}
