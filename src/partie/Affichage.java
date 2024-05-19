package partie;

import player.*;
import java.util.Scanner;

public class Affichage {
    private String m_titre = "\r\n" + //
            "██████╗  ██████╗ ██╗  ██╗███████╗███╗   ███╗ ██████╗  ██████╗ ███╗   ██╗\r\n" + //
            "██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝████╗ ████║██╔═══██╗██╔═══██╗████╗  ██║\r\n" + //
            "██████╔╝██║   ██║█████╔╝ █████╗  ██╔████╔██║██║   ██║██║   ██║██╔██╗ ██║\r\n" + //
            "██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║╚██╔╝██║██║   ██║██║   ██║██║╚██╗██║\r\n" + //
            "██║     ╚██████╔╝██║  ██╗███████╗██║ ╚═╝ ██║╚██████╔╝╚██████╔╝██║ ╚████║\r\n" + //
            "╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝\r\n" + //
            "                                                                        \r\n" + //
            "";
    private String m_separation = "----------------------------------------------------------------------------------------------------------\n";
    private Scanner m_scanf = new Scanner(System.in);

    /**
     * Reinitialise le terminal
     */
    public void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }

    /**
    * Demande d'appuyer sur Enter pour continuer (pour mettre des temps de pause dans le jeu)
    */
    public void continuer() {
      System.out.print("Appuye sur Enter pour continuer -");
      m_scanf.nextLine();
      clearScreen();
    }
      /**
       * Affiche le titre du jeu
       */
    public void getTitre() {
        System.out.println(m_titre+m_separation);
    }
      /**
       * donne la taille du deck
       * @param player
       * @return taille du deck
       */  
    public String getDeck(Player player) {
        return "Taille du Deck : "+player.getDeckSize()+" Pokémoons\n";
    }
      /**
       * donne la taille de la défausse
       * @param player
       * @return taille défausse
       */
    public String getDiscard(Player player) {
        return "Taille de la défausse : "+player.getDiscardSize()+" Pokémoons\n";
    }
      /**
       * affiche les toutes les infos d'un joueur à part le playground
       * @param player
       */
    public void getProfile(Player player) {
        System.out.println("PROFIL DE "+player.getPlayerName().toUpperCase()+" :\n\n"+
        getDeck(player)+
        getDiscard(player)+"\n"+
        player.getHand()+"\n"+m_separation);
    }
    /**
     * affiche le playground d'un joueur
     * @param player
    */
    public void getPlayground(Player player) {
        System.out.println("\nTERRAIN DE "+player.getPlayerName().toUpperCase()+" :\n\n"+
        player.getPlayground()+"\n"+m_separation);
    }
}
