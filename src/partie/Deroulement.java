package partie;

import java.util.Random;
import java.util.Scanner;

import player.Player;
import player.User;

public class Deroulement {
    private User m_user;
    private Player m_bot;
    private Scanner m_scanf = new Scanner(System.in);//permet de scanner les entrées de l'utilisateur


    // 1 - créer joueur et choisi joeur 1 
    // 2 - on rempli les mains des deux joueur
    // 3 - on demande de remplir son terrain (fct 1er) (et la main quand on a fini)
    // 4 - on fait les attaques
    // 5 - on nettoie le terrain


    /**
     * Crée les deux joueurs en demandant à l'utilisateur son pseudo et en définissant aléatoirement qui commencera à jouer
     */
    public void createPlayer() {
      System.out.print("Choisie ton pseudo : ");
      Random rd = new Random();
      if(rd.nextBoolean()){
        m_user = new User(m_scanf.nextLine());
        m_bot = new Player("Albert");
      }
      else{
        m_bot = new Player("Albert");
        m_user = new User(m_scanf.nextLine());
      }
    }

    /**
     * S'assure que l'index choisi est valide et prend en compte les erreurs de l'utilisateur
     * @param indexesChoisis
     * @return l'index chois par l'utilisateur
     */
    private int getIndexValide(int size){
        boolean indexValide = false;
        while(!indexValide){
          try {
            int index = Integer.parseInt(m_scanf.nextLine()) - 1; // Ne soustrayez pas 1 ici      
            if (index >= 0 && index < size) {
              indexValide = true;
              return index;
            } 
            else if (index >= 0 && index < size) {
              System.out.print("Vous avez déjà choisi ce Pokémon. Veuillez choisir un autre numéro.\n");
            } 
            else {
              System.out.print("Index invalide. Veuillez choisir un numéro valide.\n");
            }
          } 
          catch (NumberFormatException e) {
            System.out.print("Veuillez entrer un numéro valide.\n");
          }
        }
        return -1; // n'est jamais atteind
    }

    /**
     * Rempli le plateau du joueur
     * @param nbPoke le nombre de poke que le joeur doit mettre
     */
    public void userFillPlayground(int nbPoke){
      if(nbPoke > 0){
      int i=0;
      System.out.println(m_user.getHand());
      if(nbPoke == 1){
        System.out.println("Donne nom du poke que tu veux jouer !");
      }
      else{
        System.out.println("Donne les noms des "+nbPoke+" poke que tu veux jouer !");
      }
      while (i<nbPoke && m_user.getHandSize()>0) {
        m_user.choosePoke(getIndexValide(m_user.getHandSize()));
        i++;
        System.out.println(m_user.getHand());
      }
      }
    }

    /**
     * Fait remplir le plateau du bot
     * @param player le bot qui doit remplir son plateau
     * @param nbPoke le nombre de poke que le bot doit mettre 
     */
    public void botFillPlayground(int nbPoke){
      if(nbPoke > 0){
        int i=0;
        while (i<nbPoke && m_bot.getHandSize()>0) {
          m_bot.choosePoke(0);
          i++;
        }
        System.out.println(m_bot.getPlayerName() + " a rempli son plateau");
      }
    }

    /**
     * Fait les attaque d'un utilisateur
     * @param attaquant l'utilisateur qui attaque
     * @param other l'utilisateur qui reçoit l'attaque
     * @return le nombre de mort que l'attaquant a tué chez others
     */
    public int userAttack(){
      int nbDeMort = 0;
      for(int i=0; i<m_user.getHandSize(); i++) {
        System.out.println(m_user.getPlayerName() + " ecrit le numéro du pokemoon pour attaque");
        // Pour l'indexe de notre poke
        int monPoke = getIndexValide(m_user.getPlaygroundSize());
        System.out.println(m_user.getPlayerName() + " ecrit le numéro du pokemoon a attaque");
        int autrePoke = getIndexValide(m_bot.getPlaygroundSize());
        m_user.userAttack(m_bot,monPoke,autrePoke);
        nbDeMort += m_bot.cleanPlayground();
        // TODO ajouté l'affichage des deux terrains a chaque fin d'attaque 
      }
      return nbDeMort;
      }


    public int botAttack(){
      int nbDeMort = 0;
      for(int i=0; i<m_bot.getPlaygroundSize(); i++){
        m_bot.autoAttack(m_user, i);
        nbDeMort += m_user.cleanPlayground();
      }
      System.out.println(m_bot.getPlayerName() + " a tuer " + nbDeMort + "de tes poke");
      return nbDeMort;
    }

    /**
     * Dit si je jeu est fini ou non
     * @return le joeur qui a gagné ou null
     */
    public Player gameOver() {
      if(m_bot.getPokeAlive() == 0) {
        return m_user;
      }
      else if(m_user.getPokeAlive() == 0) {
        return m_bot;
      }
      else return null;
    }

    /**
     * @return le player qui commence a jouer
     */
    public boolean playerIsFirst(){
      if(m_bot.getNbPoke() > m_user.getNbPoke()){
        return false;
      }
      else {
        return true;
      }
    }

    public void gameEnd() {
      m_scanf.close();
    }
}
