package player;
import pokemoon.*;

public class User extends Player {
    public User(String nom, boolean firstPlayer) {
        super(nom, firstPlayer);
    }

    /**
     * permet d'attaquer un pokemon d'un autre joueur (si on veut jouer a plus de deux)
     * @param other le joueur que l'on veut embête
     * @param namePoke le nom de poke que l'on veut éliminer
     * @return Retourne true si le pokemon a été attaque, false sinon
     * /!\ le champ other ne peut pas être null
     * /!\ le champ namePoke vide veut dire que l'on attaque un pokemon sur lequel on a un avantage
     */
    public String userAttack(Player other, int myPokeIndex, int otherPokeIndex) {
        //trouve le poke que je veux utiliser pour attaquer et test si null
        Pokemoon myPoke = m_playground.getPokemoonByIndex(myPokeIndex);
        // trouve le pokemon que je veux attaquer et test si null
        Pokemoon otherPoke = other.m_playground.getPokemoonByIndex(otherPokeIndex);
        
        return myPoke.fight(otherPoke);
    }
}
