package pokemoon;

import java.util.Random;

import player.FindPoke;
import player.Player;
import pouvoir.Pouvoir;

public class PouvPlomb extends Pouvoir{
    public PouvPlomb(){
        super("Plomb", "donne un nouveau type qui a un désavantage sur tout les autres", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(0,2));  
        }
        FindPoke find = new FindPoke(other);
        return find.getPoke("quel poke voulez vous rendre faible");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.setAffinite(Element.PLOMB);
    }
}
