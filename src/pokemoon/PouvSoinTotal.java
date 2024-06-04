package pokemoon;

import java.util.Random;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvSoinTotal extends Pouvoir{
    public PouvSoinTotal() {
        super("Soin total", "Soigne la totalité des points de vie d'un Pokemon allié ou de lui-même. Utilisation unique.", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(0,2));  
        }
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous soigné à fond");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joeur) {
        int heal = other.getLifeMax();
        other.heal(heal);
    }
}
