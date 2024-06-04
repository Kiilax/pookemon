package pokemoon;

import player.Player;

import java.util.Random;

import player.FindPoke;
import pouvoir.Pouvoir;

public class PouvEther extends Pouvoir{
    public PouvEther(){
        super("Ether", "donne un nouveau type qui a un avantage sur tout les autres", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(2));  
        }
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous rendre fort");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        poke.setAffinite(Element.ETHER);
    }
}
