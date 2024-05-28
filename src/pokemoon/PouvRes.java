package pokemoon;

import pouvoir.Pouvoir;

public class PouvRes extends Pouvoir{
    public PouvRes(){
        super("Résistance", "-10 dégat au attaque subit",true);
    }

    @Override
    public void utiliser(Pokemoon poke, Object obj){
        Pokemoon other = (Pokemoon)obj;
        other.protec(10);
    }
}
