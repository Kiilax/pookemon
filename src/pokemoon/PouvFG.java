package pokemoon;

import pouvoir.Pouvoir;

public class PouvFG extends Pouvoir{
    public PouvFG(){
        super("Ferveur guerrière", "augmente de 10 l'attaque", true);
    }

    @Override
    public void utiliser(Pokemoon poke, Object obj){
        Pokemoon other = (Pokemoon)obj;
        other.increasePower(10);
    }
}
