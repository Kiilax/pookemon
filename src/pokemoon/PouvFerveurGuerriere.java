package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvFerveurGuerriere extends Pouvoir{
    public PouvFerveurGuerriere(){
        super("Ferveur guerrière", "Augmente de 10 l'attaque d'un Pokemoon allié ou lui-même. Utilisation unique", true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.increasePower(10);
    }
}
