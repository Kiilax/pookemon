package pokemoon;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvKamikaz extends Pouvoir{
    protected PouvKamikaz(){
        super("kamikaz", "se suicide pour tué un adversaire", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        FindPoke find = new FindPoke(other);
        return find.getPoke("quel poke voulez vous tué ? ");
    }

    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        poke.increasePower(poke.getLifeMax());
        poke.fight(other);
        poke.fight(poke);
    }

}
