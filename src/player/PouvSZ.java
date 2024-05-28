package player;

import pokemoon.Pokemoon;
import pouvoir.Pouvoir;

public class PouvSZ extends Pouvoir {
    public PouvSZ() {
        super("Soin de zone", "Soigne 10 points de vie de chaque Pokemon sur son terrain, lui compris. Pouvoir réutilisable.", false);
    }

    @Override
    public void utiliser(Pokemoon poke, Object obj) {
        Pokemoon other = (Pokemoon) obj;
        other.heal(10);
    }
}
