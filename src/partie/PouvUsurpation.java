package partie;
import player.FindPoke;
import player.Player;
import pokemoon.Pokemoon;
import pouvoir.*;

public class PouvUsurpation extends Pouvoir {
    public PouvUsurpation() {
        super("Usurpation","Prend le pouvoir d'un Pokemoon allié ou ennemi même s'il a déjà été utilisé. Utilisation unique", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        FindPoke find = new FindPoke(other);
        return find.getPoke("quel poke voulez vous volé comme un arabe");
    }

    public void utiliser(Pokemoon myPoke, Pokemoon other, Player player) {
        Pouvoir newPouv = other.noPouvoir();
        myPoke.newPouvoir(newPouv);
    }
}