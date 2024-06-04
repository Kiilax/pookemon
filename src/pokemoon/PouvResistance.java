package pokemoon;

import java.util.Random;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvResistance extends Pouvoir{
    public PouvResistance(){
        super("Résistance", "-10 dégat au attaque subit",true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(2));  
        }
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous rendre resistant");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        other.protec(10);
    }
}
