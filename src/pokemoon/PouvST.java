package pokemoon;

import pouvoir.Pouvoir;

public class PouvST extends Pouvoir {
    public PouvST() {
        super("Soin total", "Soigne la totalité des points de vie d'un Pokemon allié ou de lui-même. Utilisation unique.", true);
    }

    @Override
    public void utiliser(Pokemoon poke, Object obj) {
        Pokemoon other = (Pokemoon) obj;
        int heal = other.getLifeMax();
        other.heal(heal);
    }
}
