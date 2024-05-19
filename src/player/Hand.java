package player;
import java.util.ArrayList;

import pokemoon.Pokemoon;

public class Hand {
    private ArrayList<Pokemoon> m_pokemoons;

    Hand() {
        m_pokemoons = new ArrayList<Pokemoon>();
    }

    /**
     * ajoute un pokemoon a la main
     * @param poke le poke que l'on veut ajouté
     */
    void addPokemoon(Pokemoon poke) {
        m_pokemoons.add(poke);
    }

    /**
     * trouve un pokemon grace a son index
     * @param index l'index du poke que l'on veut
     * @return le pokemon qui se trouve a cette index
     * /!\ si l'index n'est pas dans les bornes on retourne null
     */
    Pokemoon getPokemoonByIndex(int index) {
        Pokemoon res;
        if(index < m_pokemoons.size()){
            res = m_pokemoons.get(index);
            m_pokemoons.remove(index);
            return res;
        }
        return null;
    }

    /**
     * trouve un pokemon grace a son nom
     * @param nomPoke le nom du pokemon que l'on veut
     * @return le pokemon qui a se nom
     * /!\ si le nom est faux on retourne null
     */
    Pokemoon getPokemoonByName(String nomPoke) {
        int i=0;
        for(Pokemoon poke : m_pokemoons){
            if(poke.getName().equals(nomPoke)){
                return m_pokemoons.remove(i);
            }
        }
        return null;
    }
    
    int getSize(){
        return m_pokemoons.size();
    }

    @Override
    public String toString() {
        if(!m_pokemoons.isEmpty()) {
            String listePoke = "Pokémoon(s) dans la main :\n";
            int i = 1;
            for(Pokemoon poke : m_pokemoons){
                listePoke += 
                "Pokemoon n°"+i+" : "+poke.toString();
                i++;
            }  
            return listePoke;
        }
        else return "Main vide";
    }
}
