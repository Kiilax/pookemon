package partie.affichage;

import player.*;
import java.util.Scanner;

public class Affichage {
    private static String m_titre = "\r\n" + //
            "██████╗  ██████╗ ██╗  ██╗███████╗███╗   ███╗ ██████╗  ██████╗ ███╗   ██╗\r\n" + //
            "██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝████╗ ████║██╔═══██╗██╔═══██╗████╗  ██║\r\n" + //
            "██████╔╝██║   ██║█████╔╝ █████╗  ██╔████╔██║██║   ██║██║   ██║██╔██╗ ██║\r\n" + //
            "██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║╚██╔╝██║██║   ██║██║   ██║██║╚██╗██║\r\n" + //
            "██║     ╚██████╔╝██║  ██╗███████╗██║ ╚═╝ ██║╚██████╔╝╚██████╔╝██║ ╚████║\r\n" + //
            "╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝\r\n" + //
            "                                                                        \r\n" + //
            "";
    private static String m_separation = "----------------------------------------------------------------------------------------------------------\n";
    private static Scanner m_scanf = new Scanner(System.in);

    public static void dodo(){
      try {
        Thread.sleep(2000);
      } 
      catch (InterruptedException ie) {
        System.out.println(ie.getMessage());
      }
    }
    /**
     * Reinitialise le terminal
     */
    public static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }

    /**
    * Demande d'appuyer sur Enter pour continuer (pour mettre des temps de pause dans le jeu)
    */
    public static void continuer() {
      System.out.print("Appuye sur Enter pour continuer -");
      m_scanf.nextLine();
      clearScreen();
    }
      /**
       * Affiche le titre du jeu
       */
    public static void getTitre() {
        System.out.println(m_titre+m_separation);
      }
      /**
       * donne la taille du deck
       * @param player
       * @return taille du deck
       */  
    private static String getDeck(Player player) {
      int nbPokes = player.getDeckSize();
      if(nbPokes>9) {
        return "| Pioche : "+nbPokes+" Pokémoons   |\n";
      }
      else {
        return "| Pioche : "+nbPokes+" Pokémoons    |\n";
      }
    }

    /**
     * donne la taille de la défausse
     * @param player
     * @return taille défausse
     */
    private static String getDiscard(Player player) {
      int nbPokes = player.getDiscardSize();
      if(nbPokes>9) {
        return "| Défausse : "+nbPokes+" Pokémoons |\n";
      }
      else {
        return "| Défausse : "+nbPokes+" Pokémoons  |\n";
      }
    }

    private static String getHand(Player player) {
      int nbPokes = player.getHandSize();
      return "| Main : "+nbPokes+" Pokémoons      |";
    }

    /**
     * affiche le playground d'un joueur
     * @param player
    */
    public static String getPlayground(Player p1, Player p2) {
        return "TERRAIN DE "+p1.getPlayerName().toUpperCase()+" :\n\n"+
        p1.getPlayground()+"\n"+
        m_separation+
        "\n\nTERRAIN DE "+p2.getPlayerName().toUpperCase()+" :\n\n"+
        p2.getPlayground();
    }

    public static void afficheJeu(Player p1, Player p2){
      System.out.println(
        "Infos de " + p1.getPlayerName().toUpperCase() + " :\n\n"+
        "o-------------------------o\n"+
        getDeck(p1)+
        getDiscard(p1)+
        getHand(p1)+"\n"+
        "o-------------------------o\n"+
        getPlayground(p1, p2)+"\n"+
        "Infos d'" + p2.getPlayerName().toUpperCase() + " :\n\n"+
        "o-------------------------o\n"+
        getDeck(p2)+
        getDiscard(p2)+
        getHand(p2)+"\n"+
        "o-------------------------o\n");
    }

    public static void afficheFinJeu(Player p){
      clearScreen();
      System.out.println(p.getPlayerName().toUpperCase() + " EST LE GRAND GAGNANT !!!");
    }
}
