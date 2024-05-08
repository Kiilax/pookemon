import java.util.Random;
import java.util.Scanner;

import aff.Affichage;
import player.Bot;
import player.User;

public class Pokemon
{
  private static Affichage aff = new Affichage();
  private static User joueur;
  private static Bot bot;
  private static Scanner scanf = new Scanner(System.in);//permet de scanner les entrées de l'utilisateur

  public static void main(String args[])
  {
    //INTRODUCTION DU JEU
    clearScreen();
    createPlayer();

    //REMPLISSAGE DES TERRAINS
    if(bot.getFirstPlayer()) {
      remplirPlaygroundBot();
      System.out.println(aff.getPlayground(bot));
      remplirPlaygroundPlayer();
      clearScreen();
      System.out.println(aff.getPlayground(bot));
      System.out.println(aff.getPlayground(joueur));
      System.out.print("L'ordinateur va attaquer, appuyez sur Entrée pour continuer - ");
      scanf.nextLine();
      clearScreen();
      for(int i = 0; i<bot.getPlaygroundSize(); i++) {
        bot.botAttack(joueur, i);
      }
      System.out.println(aff.getPlayground(bot));
      System.out.println(aff.getPlayground(joueur));
      
    }
    else {
      remplirPlaygroundPlayer();
      remplirPlaygroundBot();
      clearScreen();
      System.out.println(aff.getPlayground(bot));
      System.out.println(aff.getPlayground(joueur));
    }
    scanf.close();
  }

  /**
   * Affiche la main du joueur et demande quelles cartes il veut mettre sur son terrain
   */
  private static void remplirPlaygroundPlayer() {
    System.out.println(aff.getProfile(joueur));
    System.out.println("Choisis chaque pokemon par son numéro :");
    for(int i = joueur.getPlaygroundSize(); i<3; i++) {
      System.out.print((char)(i+97)+" : ");
      joueur.choosePoke((Integer.parseInt(scanf.nextLine()))-1);
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
    System.out.println(aff.getTitre());
  }

  /**
   * Crée les deux joueurs en demandant à l'utilisateur son pseudo et en déffinissant aleatoirement qui commencera à jouer
   */
  private static void createPlayer() {
    System.out.println("Choisie ton pseudo :");
    Random rd = new Random();
    boolean rdb = rd.nextBoolean();
    joueur = new User(scanf.nextLine(), rdb);
    bot = new Bot("L'ordinateur", !rdb);
    clearScreen();
  }
}
