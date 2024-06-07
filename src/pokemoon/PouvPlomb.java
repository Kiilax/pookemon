package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvPlomb extends Pouvoir{
    public PouvPlomb(){
        super("Plomb", "donne un nouveau type qui a un désavantage sur tout les autres", true, true);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.setAffinite(Element.PLOMB);
    }
}
