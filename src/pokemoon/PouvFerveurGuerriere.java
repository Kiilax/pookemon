package pokemoon;

import java.util.Random;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvFerveurGuerriere extends Pouvoir{
    public PouvFerveurGuerriere(){
        super("Ferveur guerrière", "augmente de 10 l'attaque", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(0,2));  
        }
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous rendre fort");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.increasePower(10);
    }
}
