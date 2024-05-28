package partie;
import pokemoon.Pokemoon;
import pouvoir.*;

class PouvUsur extends Pouvoir {
    public PouvUsur() {
        super("Usurpation","Prend le pouvoir d'un Pokemoon allié ou ennemi même s'il a déjà été utilisé. Utilisation unique", true);
    }

    public void utiliser(Pokemoon myPoke, Object obj) {
        Pokemoon otherPoke = (Pokemoon) obj;
        Pouvoir newPouv = otherPoke.noPouvoir();
        myPoke.newPouvoir(newPouv);
    }
}