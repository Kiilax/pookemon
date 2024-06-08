package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvPlomb extends Pouvoir{
    public PouvPlomb(){
        super("Plomb", "Donne un nouveau type à un Pokemoon adverse qui a un désavantage sur tout les autres. Utilisation unique.", true, true);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.setAffinite(Element.PLOMB);
    }
}
