package pokemoon;
/*
 * son rôle est de géré la distribution des pokemoons
 * @param : m_namePokemoonAvailable la liste des noms des pokemoon encore disponible
 * @param : m_namePokemoonTaken la liste des noms des pokemoon qui sont déjà utilisé
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import player.PouvSoinZone;
import pouvoir.Pouvoir;

public class ListPokemoon {
    private static ArrayList<String> m_namePokemoonAvailable = new ArrayList<String>(Arrays.asList("Aquali", "Araqua","Balbuto","Bulbizarre","Chamallot","Chenipan","Dracaufeu","Doduo","Évoli","Empiflor","Flamiaou","Fouinette","Gruikui","Galifeu","Herbizarre","Hoopa","Insécateur","Iguolta","Joliflor","Jirachi","Kirlia","Krabby","Lippoutou","Larvibule","M.Mime","Maganon","Noctali","Nidorina","Onix","Oratoria","Pikachu","Palkia","Qwilfish","Quartermac","Rattatac","Ramoloss","Salamèche","Smogo","Tortank","Tartard","Ursaring","Victini","Voltali","Wattouat","Wailord","Xatu","Xerneas","Yanma","Yveltal","Zorua","Zekrom"));
    private static ArrayList<String> m_namePokemoonTaken = new ArrayList<String>();

    private static ArrayList<Pouvoir> m_pouvPokeAvailable = new ArrayList<Pouvoir>(Arrays.asList(new PouvEther(), new PouvPlomb(), new PouvFerveurGuerriere(), new PouvKamikaz(), new PouvResistance(), new PouvSoinSimple(), new PouvSoinTotal(), new PouvSoinZone()));
    private static ArrayList<Pouvoir> m_pouvPokeTaken = new ArrayList<Pouvoir>();

    private static ArrayList<Pokemoon> m_pokeAvailable = new ArrayList<Pokemoon>();
    private static ArrayList<Pokemoon> m_pokeTaken = new ArrayList<Pokemoon>();

    //todo il faut fini la liste pour voir comment on donne un pouvoir au poke

    public static void creerPoke(){
        int size = m_namePokemoonAvailable.size();
        for(int i=0; i<size; i++) {
            if(m_pouvPokeAvailable.size()>=1){
                m_pokeAvailable.add(new Pokemoon(getPouv()));
            }
            else{
                m_pokeAvailable.add(new Pokemoon());
            }
        }
    }

    public static String toStringStat(){
        return "pokemoon disponible :\n"+m_namePokemoonAvailable.toString()+"\npokemoon pris :\n"+m_namePokemoonTaken.toString();
    }

    private static int getRandomIndex(int size){
        Random rd = new Random();
        return rd.nextInt(size);
    }

    private static Pouvoir getPouv(){
        int index = getRandomIndex(m_pouvPokeAvailable.size());
        Pouvoir pouv = m_pouvPokeAvailable.get(index);
        m_pouvPokeTaken.add(pouv);
        m_pouvPokeAvailable.remove(index);
        return pouv;
    }

    public static String getName(){
        int index = getRandomIndex(m_namePokemoonAvailable.size());
        String nom = m_namePokemoonAvailable.get(index);
        m_namePokemoonTaken.add(nom);
        m_namePokemoonAvailable.remove(index);
        return nom;
    }

    public static Pokemoon getPoke(){
        int index = getRandomIndex(m_pokeAvailable.size());
        Pokemoon poke = m_pokeAvailable.get(index);
        m_pokeTaken.add(poke);
        m_pokeAvailable.remove(index);
        return poke;
    }

    public static void reset(){
        for(String nom : m_namePokemoonTaken){
            m_namePokemoonAvailable.add(nom);
        }
        m_namePokemoonTaken.clear();
    }
}
