package pokemoon;

import player.Player;
import pouvoir.Pouvoir;

public class PouvFerveurGuerriere extends Pouvoir{
    public PouvFerveurGuerriere(){
        super("Ferveur guerrière", "augmente de 10 l'attaque", true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.increasePower(10);
    }
}
