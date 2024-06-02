package pokemoon;
import pouvoir.Pouvoir;
import player.FindPoke;
import player.Player;

public class PouvSoinSimple extends Pouvoir {
    public PouvSoinSimple() {
        super("Soin simple", "Donne 30 points de vie à un Pokemon allié ou à lui même. Pouvoir réutilisable.", false);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous soigner");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joeur) {
        other.heal(30);
    }
}
