package player;
import java.util.ArrayList;
import pokemoon.*;

public class Playground {
    private ArrayList<Pokemoon> m_pokemoons;

    Playground() {
        m_pokemoons = new ArrayList<Pokemoon>();
    }

    void addPokemoon(Pokemoon poke){
        m_pokemoons.add(poke);
    }

    /**
     * trouve un pokemon grace a son index
     * @param index l'index du poke que l'on veux
     * @return le pokemon qui se trouve a cette index
     * /!\ si l'index n'est pas dans les bornes on retourn null
     */
    Pokemoon getPokemoonByIndex(int index) {
        if(index < m_pokemoons.size()){
            return m_pokemoons.get(index);
        }
        return null;
    }

    Pokemoon getPokemoonByName(String nomPoke) {
        int i=0;
        for(Pokemoon poke : m_pokemoons){
            if(poke.getName().equals(nomPoke)){
                return m_pokemoons.remove(i);
            }
        }
        return null;
    }

    ArrayList<Pokemoon> tcheck(){
        ArrayList<Pokemoon> pokeDead = new ArrayList<Pokemoon>();
        // ajoute les pokes à la liste des morts
        for(Pokemoon poke : m_pokemoons){
            if(poke.getLife() == 0){
                pokeDead.add(poke);
            }
        }
        // supprime les mort du jeu
        for(Pokemoon poke : pokeDead){
            m_pokemoons.remove(poke);
        }
        return pokeDead;
    }

    int getSize(){
        return m_pokemoons.size();
    }

    @Override
    public String toString() {
        String res = "";

        // Entête des colonnes
        for (int i = 0; i < 3; i++) {
            res += "POKEMON " + (i + 1) + "---------\t\t";
        }
        res += "\n";

        // Lignes des noms
        for (int i = 0; i < 3; i++) {
            String name = m_pokemoons.get(i).getName();
            res += "| Nom : " + name;
            for(int y = name.length(); y<10; y++) {
                res+=" ";
            }
            res+="\t\t";
        }
        res += "\n";

        // Lignes de vie
        for (int i = 0; i < 3; i++) {
            res += "| Vie : " + m_pokemoons.get(i).getLife() + "/" + m_pokemoons.get(i).getLifeMax() + "   \t\t";
        }
        res += "\n";

        // Lignes de dégats
        for (int i = 0; i < 3; i++) {
            res += "| Dégats : " + m_pokemoons.get(i).getPower() + "     \t\t";
        }
        res += "\n";

        // Lignes de type
        for (int i = 0; i < 3; i++) {
            String element = m_pokemoons.get(i).getElement();
            res += "| Type : " + element+"      \t\t";
        }
        res += "\n";

        // Lignes d'affinité
        for (int i = 0; i < 3; i++) {
            String advantage = m_pokemoons.get(i).getAvantage();
            res += "| Affinité : " + advantage+"  \t\t";
        }
        res += "\n";

        return res;
    }
}
