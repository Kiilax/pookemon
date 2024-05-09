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
    createPlayer();

    //REMPLISSAGE DES TERRAINS
    if(bot.getFirstPlayer()) {
      remplirPlaygroundBot();
      System.out.println(getPlayground(bot));
      remplirPlaygroundPlayer();
      clearScreen();
      System.out.println(getPlayground(bot));
      System.out.println(getPlayground(user));
      botAttackUser();
      userAttackBot();
    }
    else {
      remplirPlaygroundPlayer();
      remplirPlaygroundBot();
      clearScreen();
      System.out.println(getPlayground(bot));
      System.out.println(getPlayground(user));
    }
    scanf.close();
  }

  /**
   * Affiche la main du user et demande quelles cartes il veut mettre sur son terrain
   */
  private static void remplirPlaygroundPlayer() {
    boolean[] indexesChoisis = new boolean[3]; // Tableau de taille 3 pour stocker les index choisis
    System.out.println(getProfile(user));
    System.out.println("Choisissez chaque Pokémon par son numéro :");

    // Boucle pour remplir le terrain du user
    for (int i = user.getPlaygroundSize(); i < 3; i++) {
      System.out.print((i + 1) + "/3 : ");
      int indexDemande;
      boolean indexValide = false;
            
      while (!indexValide) {
        try {
          indexDemande = Integer.parseInt(scanf.nextLine()) - 1;
          if (indexDemande >= 0 && indexDemande < user.getHandSize()) {
            if (!indexesChoisis[indexDemande]) { // Vérifie si l'index n'a pas déjà été choisi
              user.choosePoke(indexDemande);
              indexesChoisis[indexDemande] = true; // Marque l'index comme choisi
              indexValide = true;
            } else {
              System.out.print("Vous avez déjà choisi ce Pokémon. Veuillez choisir un autre numéro.\n"+(i + 1) + "/3 : ");
            }
          } else {
            System.out.print("Index invalide. Veuillez choisir un numéro valide.\n"+(i + 1) + "/3 : ");
          }
        } catch (NumberFormatException e) {
          System.out.print("Veuillez entrer un numéro valide.\n"+(i + 1) + "/3 : ");
        }
      }
    }
    clearScreen();
  }

  /**
   * Rempli automatiquement le terrain de l'ordinateur dans l'ordre de sa main
   */
  private static void remplirPlaygroundBot() {
    for(int i = bot.getPlaygroundSize(); i<3; i++) {
      bot.choosePoke(i);
    }
  }

  /**
   * Reinitialise le terminal pour n'afficher que le titre du jeu
   */
  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println(getTitre());
  }

  /**
   * Crée les deux joueurs en demandant à l'utilisateur son pseudo et en définissant aléatoirement qui commencera à jouer
   */
  private static void createPlayer() {
    System.out.println("Choisie ton pseudo :");
    Random rd = new Random();
    boolean rdb = rd.nextBoolean();
    user = new User(scanf.nextLine(), false);
    bot = new Bot("L'ordinateur", true);
    clearScreen();
  }

  /**
   * pour chaque pokemon dans playground de bot, attaque d'un pokemon du playground de user
   */
  private static void botAttackUser() {
    System.out.print("L'ordinateur va attaquer, appuyez sur Entrée pour continuer - ");
    scanf.nextLine();
    clearScreen();
    for(int i = 0; i<bot.getPlaygroundSize(); i++) {
      System.out.println(bot.botAttack(user, i));
    }
    System.out.println(getPlayground(bot));
    System.out.println(getPlayground(user));
  }

  /**
   * pour chaque pokemon dans playground de user, attaque d'un pokemon du playground de bot
   */
  private static void userAttackBot() {
    Set<Integer> indexsPokeJoues = new HashSet<>();// Ensemble pour stocker les index des Pokémon déjà joués
    System.out.println("A ton tour d'attaquer !\n");
    int indexMyPoke;
    int indexBotPoke;
    
    // Boucle pour permettre à l'utilisateur d'attaquer autant de fois que nécessaire
    for(int i = 0; i < bot.getPlaygroundSize(); i++) {
      System.out.println("******\nAttaque "+(i+1)+"/"+bot.getPlaygroundSize()+" :\n******");
      System.out.print("Choisis le numéro du Pokémon que tu veux jouer : ");
      try {
        indexMyPoke = Integer.parseInt(scanf.nextLine()) - 1;
            
        if (indexMyPoke >= 0 && indexMyPoke < user.getPlaygroundSize() && !indexsPokeJoues.contains(indexMyPoke)) {
          System.out.print("Choisis le numéro du Pokémon que tu veux attaquer : ");
          indexBotPoke = Integer.parseInt(scanf.nextLine()) - 1;
                
          if (indexBotPoke >= 0 && indexBotPoke < bot.getPlaygroundSize()) {
            System.out.println(user.userAttack(bot, indexMyPoke, indexBotPoke));
            indexsPokeJoues.add(indexMyPoke);// Ajoute l'index du Pokémon joué à l'ensemble
          } else {
            System.out.println("Index du Pokémon à attaquer invalide.");
            i--; // Permet de redemander à l'utilisateur de choisir le Pokémon à attaquer pour la même position
          }
        } else {
          System.out.println("Index du Pokémon à jouer invalide ou déjà joué.");
          i--; // Permet de redemander à l'utilisateur de choisir le Pokémon à jouer pour la même position
        }
      } catch (NumberFormatException e) {
        System.out.println("Veuillez entrer un numéro valide.");
        i--; // Permet de redemander à l'utilisateur de choisir les Pokémon pour la même position
      }
    }
  }
  private static String getTitre() {
    return m_titre+m_separation;
  }
    
  private static String getDeck(Player player) {
    return "Taille du Deck : "+player.getDeckSize()+" Pokémoons\n";
  }
  private static String getDiscard(Player player) {
    return "Taille de la défausse : "+player.getDiscardSize()+" Pokémoons\n";
  }
  private static String getHand(Player player) {
    return player.getHand();
  }
  public static String getProfile(Player player) {
    return player.getPlayerName().toUpperCase()+" :\n\n"+
    getDeck(player)+
    getDiscard(player)+"\n"+
    getHand(player)+"\n"+m_separation;
  }
  public static String getPlayground(Player player) {
    return "TERRAIN DE "+player.getPlayerName().toUpperCase()+" :\n\n"+
    player.getPlayground()+"\n"+m_separation;
  }
}
