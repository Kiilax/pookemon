import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import player.Bot;
import player.Player;
import player.User;

public class Pokemon
{
  private static User user;
  private static Bot bot;
  private static Scanner scanf = new Scanner(System.in);//permet de scanner les entrées de l'utilisateur
  private static String m_titre = "\r\n" + //
        "PPPPPPPPPPPPPPPPP                   kkkkkkkk                                                                                                        \r\n" + //
        "P::::::::::::::::P                  k::::::k                                                                                                        \r\n" + //
        "P::::::PPPPPP:::::P                 k::::::k                                                                                                        \r\n" + //
        "PP:::::P     P:::::P                k::::::k                                                                                                        \r\n" + //
        "  P::::P     P:::::P  ooooooooooo    k:::::k    kkkkkkk eeeeeeeeeeee       mmmmmmm    mmmmmmm      ooooooooooo      ooooooooooo   nnnn  nnnnnnnn    \r\n" + //
        "  P::::P     P:::::Poo:::::::::::oo  k:::::k   k:::::kee::::::::::::ee   mm:::::::m  m:::::::mm  oo:::::::::::oo  oo:::::::::::oo n:::nn::::::::nn  \r\n" + //
        "  P::::PPPPPP:::::Po:::::::::::::::o k:::::k  k:::::ke::::::eeeee:::::eem::::::::::mm::::::::::mo:::::::::::::::oo:::::::::::::::on::::::::::::::nn \r\n" + //
        "  P:::::::::::::PP o:::::ooooo:::::o k:::::k k:::::ke::::::e     e:::::em::::::::::::::::::::::mo:::::ooooo:::::oo:::::ooooo:::::onn:::::::::::::::n\r\n" + //
        "  P::::PPPPPPPPP   o::::o     o::::o k::::::k:::::k e:::::::eeeee::::::em:::::mmm::::::mmm:::::mo::::o     o::::oo::::o     o::::o  n:::::nnnn:::::n\r\n" + //
        "  P::::P           o::::o     o::::o k:::::::::::k  e:::::::::::::::::e m::::m   m::::m   m::::mo::::o     o::::oo::::o     o::::o  n::::n    n::::n\r\n" + //
        "  P::::P           o::::o     o::::o k:::::::::::k  e::::::eeeeeeeeeee  m::::m   m::::m   m::::mo::::o     o::::oo::::o     o::::o  n::::n    n::::n\r\n" + //
        "  P::::P           o::::o     o::::o k::::::k:::::k e:::::::e           m::::m   m::::m   m::::mo::::o     o::::oo::::o     o::::o  n::::n    n::::n\r\n" + //
        "PP::::::PP         o:::::ooooo:::::ok::::::k k:::::ke::::::::e          m::::m   m::::m   m::::mo:::::ooooo:::::oo:::::ooooo:::::o  n::::n    n::::n\r\n" + //
        "P::::::::P         o:::::::::::::::ok::::::k  k:::::ke::::::::eeeeeeee  m::::m   m::::m   m::::mo:::::::::::::::oo:::::::::::::::o  n::::n    n::::n\r\n" + //
        "P::::::::P          oo:::::::::::oo k::::::k   k:::::kee:::::::::::::e  m::::m   m::::m   m::::m oo:::::::::::oo  oo:::::::::::oo   n::::n    n::::n\r\n" + //
        "PPPPPPPPPP            ooooooooooo   kkkkkkkk    kkkkkkk eeeeeeeeeeeeee  mmmmmm   mmmmmm   mmmmmm   ooooooooooo      ooooooooooo     nnnnnn    nnnnnn\r\n" + //
        "                                                                                                                                                    \r\n" + //
        "";
  private static String m_separation = "----------------------------------------------------------------------------------------------------------------------------------------------------\n";

  public static void main(String args[])
  {
    //INTRODUCTION DU JEU
    clearScreen();
    getTitre();
    createPlayer();

    //REMPLISSAGE DES TERRAINS
    if(bot.getFirstPlayer()) {
      remplirPlaygroundBot();
      remplirPlaygroundPlayer();
      clearScreen();
      botAttackUser();
      userAttackBot();
    }
    else {
      remplirPlaygroundPlayer();
      remplirPlaygroundBot();
      clearScreen();
      userAttackBot();
      botAttackUser();
    }
    scanf.close();
  }

  /**
   * Affiche la main du user et demande quelles cartes il veut mettre sur son terrain
   */
  private static void remplirPlaygroundPlayer() {
    boolean[] indexesChoisis = new boolean[user.getHandSize()]; // Tableau de taille 3 pour stocker les index choisis
    getProfile(user);
    System.out.println("Donne le numéro de chaque pokemon que tu veux pour remplir ton terrain :");

    // Boucle pour remplir le terrain du user
    for (int i = user.getPlaygroundSize(); i < 3; i++) {
      System.out.print((i + 1) + "/3 : ");
      int indexDemande;
      boolean indexValide = false;
            
      while (!indexValide) {
        try {
          indexDemande = Integer.parseInt(scanf.nextLine()) - 1; // Ne soustrayez pas 1 ici
                
          if (indexDemande >= 0 && indexDemande < user.getHandSize() && !indexesChoisis[indexDemande]) {
            user.choosePoke(indexDemande);
            indexesChoisis[indexDemande] = true; // Marque l'index comme choisi
            indexValide = true;
          } else if (indexDemande >= 0 && indexDemande < user.getHandSize()) {
            System.out.print("Vous avez déjà choisi ce Pokémon. Veuillez choisir un autre numéro.\n" + (i + 1) + "/3 : ");
          } else {
            System.out.print("Index invalide. Veuillez choisir un numéro valide.\n" + (i + 1) + "/3 : ");
          }
        } catch (NumberFormatException e) {
          System.out.print("Veuillez entrer un numéro valide.\n"+(i + 1) + "/3 : ");
        }
      }
    }
    clearScreen();
  }

  /**
   * Rempli automatiquement le terrain de l'ordinateur dans l'ordre de sa main et affiche l'action
   */
  private static void remplirPlaygroundBot() {
    for(int i = bot.getPlaygroundSize(); i<3; i++) {
      bot.choosePoke(i);
    }
    System.out.println("Le bot a rempli son terrain !\n"+m_separation);
    continuer();
  }

  /**
   * Reinitialise le terminal
   */
  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  /**
   * Demande d'appuyer sur Enter pour continuer (pour mettre des temps de pause dans le jeu)
   */
  private static void continuer() {
    System.out.print("Appuye sur Enter pour continuer -");
    scanf.nextLine();
    clearScreen();
  }
  /**
   * Crée les deux joueurs en demandant à l'utilisateur son pseudo et en définissant aléatoirement qui commencera à jouer
   */
  private static void createPlayer() {
    System.out.print("Choisie ton pseudo : ");
    Random rd = new Random();
    boolean rdb = rd.nextBoolean();
    user = new User(scanf.nextLine(), rdb);
    bot = new Bot("L'ordinateur", !rdb);
    System.out.println("Bienvenue "+user.getPlayerName().toUpperCase()+" dans notre jeu !");
    if(!bot.getFirstPlayer()) {
      System.out.println("C'est toi qui va commencer !");
    }
    else {
      System.out.println("C'est l'ordinateur qui va commencer !");
    }
    continuer();
  }

  /**
   * Previent l'utilisateur d'une attaque.
   * Pour chaque pokemon dans playground de bot, attaque d'un pokemon du playground de user et l'affiche
   * A la fin, affiche le terrain de l'utilisateur
   */
  private static void botAttackUser() {
    System.out.println("L'ordinateur va attaquer !\n");
    continuer();
    System.out.println("Attaque de "+bot.getPlayerName()+"\n"+m_separation);
    for(int i = 0; i<bot.getPlaygroundSize(); i++) {
      System.out.println(bot.botAttack(user, i));
    }
    getPlayground(user);
  }

  /**
   * pour chaque pokemon dans playground de user, attaque d'un pokemon du playground de bot
   */
  private static void userAttackBot() {
    Set<Integer> indexsPokeJoues = new HashSet<>();// Ensemble pour stocker les index des Pokémon déjà joués
    System.out.println("A ton tour d'attaquer !\n");
    continuer();

    int indexMyPoke;
    int indexBotPoke;
    String res ="";
    
    // Boucle pour permettre à l'utilisateur d'attaquer autant de fois que nécessaire
    for(int i = 0; i < bot.getPlaygroundSize(); i++) {
      getPlayground(user);
      System.out.print("Choisis le numéro du Pokémon que tu veux JOUER : ");
      try {
        indexMyPoke = Integer.parseInt(scanf.nextLine()) - 1;
            
        if (indexMyPoke >= 0 && indexMyPoke < user.getPlaygroundSize() && !indexsPokeJoues.contains(indexMyPoke)) {
          clearScreen();
          getPlayground(bot);
          System.out.print("Choisis le numéro du Pokémon que tu veux ATTAQUER : ");
          indexBotPoke = Integer.parseInt(scanf.nextLine()) - 1;
                
          if (indexBotPoke >= 0 && indexBotPoke < bot.getPlaygroundSize()) {
            clearScreen();
            res +=user.userAttack(bot, indexMyPoke, indexBotPoke)+"\n";
            indexsPokeJoues.add(indexMyPoke);// Ajoute l'index du Pokémon joué à l'ensemble
          } else {
            clearScreen();
            System.out.println("Index du Pokémon à attaquer invalide.");
            i--; // Permet de redemander à l'utilisateur de choisir le Pokémon à attaquer pour la même position
          }
        } else {
          clearScreen();
          System.out.println("Index du Pokémon à jouer invalide ou déjà joué.");
          i--; // Permet de redemander à l'utilisateur de choisir le Pokémon à jouer pour la même position
        }
      } catch (NumberFormatException e) {
        clearScreen();
        System.out.println("Veuillez entrer un numéro valide.");
        i--; // Permet de redemander à l'utilisateur de choisir les Pokémon pour la même position
      }
    }
    System.out.println(res+m_separation);
    getPlayground(bot);
  }
  /**
   * Affiche le titre du jeu
   */
  private static void getTitre() {
    System.out.println(m_titre+m_separation);
  }
  /**
   * donne la taille du deck
   * @param player
   * @return taille du deck
   */  
  private static String getDeck(Player player) {
    return "Taille du Deck : "+player.getDeckSize()+" Pokémoons\n";
  }
  /**
   * donne la taille de la défausse
   * @param player
   * @return taille défausse
   */
  private static String getDiscard(Player player) {
    return "Taille de la défausse : "+player.getDiscardSize()+" Pokémoons\n";
  }
  /**
   * affiche les toutes les infos d'un joueur à part le playground
   * @param player
   */
  public static void getProfile(Player player) {
    System.out.println("PROFIL DE "+player.getPlayerName().toUpperCase()+" :\n\n"+
    getDeck(player)+
    getDiscard(player)+"\n"+
    player.getHand()+"\n"+m_separation);
  }
  /**
   * affiche le playground d'un joueur
   * @param player
   */
  public static void getPlayground(Player player) {
    System.out.println("\nTERRAIN DE "+player.getPlayerName().toUpperCase()+" :\n\n"+
    player.getPlayground()+"\n"+m_separation);
  }
}
