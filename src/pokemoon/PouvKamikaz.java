package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvKamikaz extends Pouvoir{
    public PouvKamikaz(){
        super("Kamikaz", "Se suicide pour tuer un adversaire. Utilisation unique.", true, true);
    }

    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        poke.increasePower(1000);
        poke.fight(other);
        poke.fight(poke);
    }

}
