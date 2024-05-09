package player;

import java.util.ArrayList;
import java.util.Random;

import pokemoon.Pokemoon;

public class Bot extends Player {
    public Bot(String nom, boolean firstPlayer) {
        super(nom, firstPlayer);
    }

    public String botAttack(Player other, int myPokeIndex) {
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
}
