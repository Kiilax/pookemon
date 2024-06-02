package player;

import pokemoon.Pokemoon;
import pouvoir.Pouvoir;

public class PouvSoinZone extends Pouvoir {
    public PouvSoinZone() {
        super("Soin de zone", "Soigne 10 points de vie de chaque Pokemon sur son terrain, lui compris. Pouvoir réutilisable.", false);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        return null;
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur) {
        for(int i=0; i<joueur.m_playground.getSize(); i++){
            joueur.m_playground.getPokemoonByIndex(i).heal(10);
        }
    }
}
