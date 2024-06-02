package pokemoon;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvFerveurGuerriere extends Pouvoir{
    public PouvFerveurGuerriere(){
        super("Ferveur guerrière", "augmente de 10 l'attaque", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous rendre fort");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.increasePower(10);
    }
}
