package pokemoon;

import pouvoir.Pouvoir;

public class PouvST extends Pouvoir {
    public PouvST() {
        super("Soin total", "Soigne la totalité des points de vie d'un Pokemon allié ou de lui-même. Utilisation unique.", true);
    }

    void utiliser(Pokemoon other) {
        int heal = other.getLifeMax();
        other.heal(heal);
    }
}
