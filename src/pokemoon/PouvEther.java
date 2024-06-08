package pokemoon;

import player.Player;

import pouvoir.Pouvoir;

public class PouvEther extends Pouvoir{
    public PouvEther(){
        super("Ether", "donne un nouveau type qui a un avantage sur tout les autres", true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.setAffinite(Element.ETHER);
    }
}
