package partie;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import player.Player;
import player.User;

public class Deroulement {
    private User m_user;
    private Player m_bot;
    private Scanner m_scanf = new Scanner(System.in);//permet de scanner les entrées de l'utilisateur
    private Affichage af = new Affichage();
    /**
    * Affiche la main du m_user et demande quelles cartes il veut mettre sur son terrain
    */
    public void remplirPlaygroundPlayer() {
      if(m_user.getPlaygroundSize() !=3 && m_user.getHandSize() > 0) {
        boolean[] indexesChoisis = new boolean[m_user.getHandSize()]; // Tableau de taille 3 pour stocker les index choisis
        af.getProfile(m_user);
        System.out.println("Donne le numéro de chaque pokemon que tu veux pour remplir ton terrain :");

        // Boucle pour remplir le terrain du m_user
        for (int i = m_user.getPlaygroundSize(); i < 3; i++) {
          System.out.print((i + 1) + "/3 : ");
          int indexDemande;
          boolean indexValide = false;
                
          while (!indexValide) {
            try {
              indexDemande = Integer.parseInt(m_scanf.nextLine()) - 1;
                    
              if (indexDemande >= 0 && indexDemande < m_user.getHandSize() && !indexesChoisis[indexDemande]) {
                m_user.choosePoke(indexDemande);
                indexesChoisis[indexDemande] = true; // Marque l'index comme choisi
                indexValide = true;
              } else if (indexDemande >= 0 && indexDemande < m_user.getHandSize()) {
                System.out.print("Vous avez déjà choisi ce Pokémon. Veuillez choisir un autre numéro.\n" + (i + 1) + "/3 : ");
              } else {
                System.out.print("Index invalide. Veuillez choisir un numéro valide.\n" + (i + 1) + "/3 : ");
              }
            } catch (NumberFormatException e) {
              System.out.print("Veuillez entrer un numéro valide.\n"+(i + 1) + "/3 : ");
            }
          }
        }
        af.clearScreen();
        m_user.fillHand();
      }
    }
    /**
    * Rempli automatiquement le terrain de l'ordinateur dans l'ordre de sa main et affiche l'action
    */
    public void remplirPlaygroundBot() {
      if(m_bot.getPlaygroundSize() != 3) {
        for(int i = m_bot.getPlaygroundSize(); i<3; i++) {
          m_bot.choosePoke(i);
        }
        System.out.println("Le bot a rempli son terrain !");
        af.continuer();
        af.getPlayground(m_bot);
        m_bot.fillHand();
      }
    }
    
    
    
    /**
     * Crée les deux joueurs en demandant à l'utilisateur son pseudo et en définissant aléatoirement qui commencera à jouer
     */
    public void createPlayer() {
      System.out.print("Choisie ton pseudo : ");
      Random rd = new Random();
      boolean rdb = rd.nextBoolean();
      m_user = new User(m_scanf.nextLine(), rdb);
      m_bot = new Player("L'ordinateur", !rdb);
      System.out.println("Bienvenue "+m_user.getPlayerName().toUpperCase()+" dans notre jeu !");
      if(!m_bot.getFirstPlayer()) {
        System.out.println("C'est toi qui va commencer !");
      }
      else {
        System.out.println("C'est l'ordinateur qui va commencer !");
      }
      af.continuer();
    }
    
      /**
       * Previent l'utilisateur d'une attaque.
       * Pour chaque pokemon dans playground de m_bot, attaque d'un pokemon du playground de m_user et l'affiche
       * A la fin, affiche le terrain de l'utilisateur
       */
    public void botAttackUser() {
      System.out.println("L'ordinateur va attaquer !\n");
      af.continuer();
      System.out.println("Attaque de "+m_bot.getPlayerName());
      for(int i = 0; i<m_bot.getPlaygroundSize(); i++) {
        System.out.println(m_bot.autoAttack(m_user, i));
      }
      m_user.cleanPlayground();
      remplirPlaygroundPlayer();
      af.getPlayground(m_user);
    }
    
      /**
       * pour chaque pokemon dans playground de m_user, attaque d'un pokemon du playground de m_bot
       */
    public void userAttackBot() {
        Set<Integer> indexsPokeJoues = new HashSet<>();// Ensemble pour stocker les index des Pokémon déjà joués
        System.out.println("A ton tour d'attaquer !\n");
        af.continuer();
    
        int indexMyPoke;
        int indexBotPoke;
        String res ="";
        
        af.getPlayground(m_user);
        af.getPlayground(m_bot);
        // Boucle pour permettre à l'utilisateur d'attaquer autant de fois que nécessaire
        for(int i = 0; i < m_bot.getPlaygroundSize(); i++) {
          System.out.print("Choisis le numéro du Pokémon que tu veux JOUER : ");
          try {
            indexMyPoke = Integer.parseInt(m_scanf.nextLine()) - 1;
                
            if (indexMyPoke >= 0 && indexMyPoke < m_user.getPlaygroundSize() && !indexsPokeJoues.contains(indexMyPoke)) {
              System.out.print("Choisis le numéro du Pokémon que tu veux ATTAQUER : ");
              indexBotPoke = Integer.parseInt(m_scanf.nextLine()) - 1;
                    
              if (indexBotPoke >= 0 && indexBotPoke < m_bot.getPlaygroundSize()) {
                res +=m_user.userAttack(m_bot, indexMyPoke, indexBotPoke)+"\n";
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
        af.clearScreen();
        System.out.println(res);
        m_bot.cleanPlayground();
        remplirPlaygroundBot();
        af.getPlayground(m_user);
        af.getPlayground(m_bot);
    }
    public boolean isBotFirst() {
        if(m_bot.getFirstPlayer()) return true;
        else return false;
    }
    public boolean gameOver() {
      if((m_bot.getFirstPlayer() && m_bot.getDiscardSize() == 20) || (!m_bot.getFirstPlayer() && m_bot.getDiscardSize() == 21)) {
        return true;
      }
      else if((m_user.getFirstPlayer() && m_user.getDiscardSize() == 20) || (!m_user.getFirstPlayer() && m_user.getDiscardSize() == 21)) {
        return true;
      }
      else return false;
    }
    public void gameEnd() {
      af.getProfile(m_bot);
      af.getProfile(m_user);
      m_scanf.close();
    }
}
