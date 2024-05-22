package pokemoon;
/*
 * son rôle est de géré la distribution des pokemoons
 * @param : m_namePokemoonAvailable la liste des noms des pokemoon encore disponible
 * @param : m_namePokemoonTaken la liste des noms des pokemoon qui sont déjà utilisé
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class ListPokemoon {
    private static ArrayList<String> m_namePokemoonAvailable = new ArrayList<String>(Arrays.asList("Aquali", "Araqua","Balbuto","Bulbizarre","Chamallot","Chenipan","Dracaufeu","Doduo","Évoli","Empiflor","Flamiaou","Fouinette","Gruikui","Galifeu","Herbizarre","Hoopa","Insécateur","Iguolta","Joliflor","Jirachi","Kirlia","Krabby","Lippoutou","Larvibule","M.Mime","Maganon","Noctali","Nidorina","Onix","Oratoria","Pikachu","Palkia","Qwilfish","Quartermac","Rattatac","Ramoloss","Salamèche","Smogo","Tortank","Tartard","Ursaring","Victini","Voltali","Wattouat","Wailord","Xatu","Xerneas","Yanma","Yveltal","Zorua","Zekrom"));
    private static ArrayList<String> m_namePokemoonTaken = new ArrayList<String>();

    public static String toStringStat(){
        return "pokemoon disponible :\n"+m_namePokemoonAvailable.toString()+"\npokemoon pris :\n"+m_namePokemoonTaken.toString();
    }

    private static int getRandomIndex(){
        Random rd = new Random();
        return rd.nextInt(m_namePokemoonAvailable.size()-1);
    }

    public static String getName(){
        int index = getRandomIndex();
        String nom = m_namePokemoonAvailable.get(index);
        m_namePokemoonTaken.add(nom);
        m_namePokemoonAvailable.remove(index);
        return nom;
    }

    public static void reset(){
        for(String nom : m_namePokemoonTaken){
            m_namePokemoonAvailable.add(nom);
        }
        m_namePokemoonTaken.clear();
    }
}
