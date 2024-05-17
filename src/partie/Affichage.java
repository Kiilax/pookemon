package partie;

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
}
