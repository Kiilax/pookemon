package partie;

import player.Player;
import pokemoon.*;
import pouvoir.Pouvoir;

public class PouvUsurpation extends Pouvoir {
    public PouvUsurpation() {
        super("Usurpation","Prend le pouvoir d'un Pokemoon allié ou ennemi même s'il a déjà été utilisé. Utilisation unique", true, true);
    }

    public void utiliser(Pokemoon myPoke, Pokemoon other, Player player) {
        Pouvoir newPouv = other.noPouvoir();
        myPoke.newPouvoir(newPouv);
    }
}