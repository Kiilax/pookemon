package pokemoon;

import player.Player;

import pouvoir.Pouvoir;

public class PouvEther extends Pouvoir{
    public PouvEther(){
        super("Ether", "Donne un nouveau type à un allié ou à lui-même qui a un avantage sur tout les autres. Utilisation unique", true, false);
    }

    @Override
    public void utiliser(Pokemoon poke, Pokemoon other, Player joueur){
        other.setAffinite(Element.ETHER);
    }
}
