package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvSoinTotal extends Pouvoir{
    public PouvSoinTotal() {
        super("Soin total", "Soigne la totalité des points de vie d'un Pokemon allié ou de lui-même. Utilisation unique.", true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joeur) {
        int heal = other.getLifeMax();
        other.heal(heal);
    }
}
