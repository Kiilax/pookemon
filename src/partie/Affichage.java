package partie;

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
    private Scanner m_scanf = new Scanner(System.in);

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
    public void continuer() {
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
        return "Nombre de carte dans le deck : "+player.getDeckSize()+" Pokémoons\n";
    }

      /**
       * donne la taille de la défausse
       * @param player
       * @return taille défausse
       */
    private static String getDiscard(Player player) {
        return "Nombre de carte dans la défausse : "+player.getDiscardSize()+" Pokémoons\n";
    }

    private static String getHand(Player player) {
      return "Nombre de carte dans la main : "+player.getHandSize()+" Pokémoons\n";
    }

    /**
     * affiche le playground d'un joueur
     * @param player
    */
    static String getPlayground(Player p1, Player p2) {
        return "TERRAIN DE "+p1.getPlayerName().toUpperCase()+" :\n\n"+
        p1.getPlayground()+"\n"+m_separation+p2.getPlayground()+"\n\nTERRAIN DE "+p2.getPlayerName()+"\n";
    }

    public static void afficheJeu(Player p1, Player p2){
      System.out.println("Infos de " + p1.getPlayerName().toUpperCase() + " :\n"+
      getDeck(p1)+getDiscard(p1)+getHand(p1)+
      getPlayground(p1, p2)+
      getHand(p2)+getDiscard(p2)+getDeck(p2)+
      "Infos de " + p2.getPlayerName().toLowerCase());
    }

    public static void afficheFinJeu(Player p){
      System.out.println("\t\t\t"+ p.getPlayerName().toUpperCase() + " EST LE GRAND GAGNAN");
    }
}
