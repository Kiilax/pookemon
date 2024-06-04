package pokemoon;

import java.util.Random;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvKamikaz extends Pouvoir{
    protected PouvKamikaz(){
        super("kamikaz", "se suicide pour tué un adversaire", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(2));  
        }
        FindPoke find = new FindPoke(other);
        return find.getPoke("quel poke voulez vous tué ? ");
    }

    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        poke.increasePower(poke.getLifeMax());
        poke.fight(other);
        poke.fight(poke);
    }

}
