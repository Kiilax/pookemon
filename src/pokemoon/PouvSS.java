package pokemoon;
import pouvoir.Pouvoir;

public class PouvSS extends Pouvoir {
    public PouvSS() {
        super("Soin simple", "Donne 30 points de vie à un Pokemon allié ou à lui même. Pouvoir réutilisable.", false);
    }

    @Override
    public void utiliser(Pokemoon poke, Object obj) {
        Pokemoon other = (Pokemoon) obj;
        other.heal(30);
    }
}
