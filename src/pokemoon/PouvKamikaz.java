package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvKamikaz extends Pouvoir{
    protected PouvKamikaz(){
        super("kamikaz", "se suicide pour tué un adversaire", true, true);
    }

    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        poke.increasePower(poke.getLifeMax());
        poke.fight(other);
        poke.fight(poke);
    }

}
