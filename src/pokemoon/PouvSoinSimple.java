package pokemoon;
import pouvoir.Pouvoir;

import player.Player;

public class PouvSoinSimple extends Pouvoir {
    public PouvSoinSimple() {
        super("Soin simple", "Donne 30 points de vie à un Pokemon allié ou à lui même. Pouvoir réutilisable.", false, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joeur) {
        other.heal(30);
    }
}
