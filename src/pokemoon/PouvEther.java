package pokemoon;

import player.Player;
import player.FindPoke;
import pouvoir.Pouvoir;

public class PouvEther extends Pouvoir{
    public PouvEther(){
        super("Ether", "donne un nouveau type qui a un avantage sur tout les autres", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        FindPoke find = new FindPoke(joueur);
        return find.getPoke("lequel de vos poke voulez vous rendre fort");
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        poke.setAffinite(Element.ETHER);
    }
}
