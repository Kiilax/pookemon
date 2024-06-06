package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvResistance extends Pouvoir{
    public PouvResistance(){
        super("Résistance", "-10 dégat au attaque subit",true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        other.protec(10);
    }
}
