package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvResistance extends Pouvoir{
    public PouvResistance(){
        super("Résistance", "Permet à un allié ou à lui-même de réduire chaque attaque reçu de 10 dégats. Utilisation unique.",true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player player){
        other.protec(10);
    }
}
