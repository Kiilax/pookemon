package partie;
import java.util.Random;

import player.FindPoke;
import player.Player;
import pokemoon.*;
import pouvoir.Pouvoir;

public class PouvUsurpation extends Pouvoir {
    public PouvUsurpation() {
        super("Usurpation","Prend le pouvoir d'un Pokemoon allié ou ennemi même s'il a déjà été utilisé. Utilisation unique", true);
    }

    @Override
    public Pokemoon getPokemoon(Player joueur, Player other){
        if(joueur.getPlayerName().equals("albert")){
            FindPoke find = new FindPoke(other);
            Random rd = new Random();
            return find.getPoke(rd.nextInt(0,2));  
        }
        else{
            FindPoke find = new FindPoke(other);
            return find.getPoke("vsy l'arabe");
        }
        
    }

    public void utiliser(Pokemoon myPoke, Pokemoon other, Player player) {
        Pouvoir newPouv = other.noPouvoir();
        myPoke.newPouvoir(newPouv);
    }
}