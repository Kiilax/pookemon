package pokemoon;
import pouvoir.Pouvoir;

public class PouvSS extends Pouvoir {
    public PouvSS() {
        super("Soin simple", "Donne 30 points de vie à un Pokemon allié ou à lui même. Pouvoir réutilisable.", false);
    }

    void utiliser(Pokemoon other) {
        other.heal(30);
    }
}
