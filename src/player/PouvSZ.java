package player;

import java.util.ArrayList;
import pokemoon.Pokemoon;
import pouvoir.Pouvoir;

public class PouvSZ extends Pouvoir {
    public PouvSZ() {
        super("Soin de zone", "Soigne 10 points de vie de chaque Pokemon sur son terrain, lui compris. Pouvoir réutilisable.", false);
    }

    void utiliser(ArrayList<Pokemoon> others) {
        for (Pokemoon poke : others) {
            poke.heal(10);
        }
    }
}
