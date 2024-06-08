package partie;

import java.util.Random;
import java.util.Scanner;

import partie.affichage.Affichage;
import player.Player;
import player.User;

public class Deroulement {
    private User m_user;
    private Player m_bot;
    private static Scanner m_scanf = new Scanner(System.in);//permet de scanner les entrées de l'utilisateur
    private boolean m_gameOver = false;


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
      boolean rdb = rd.nextBoolean();
      m_user = new User(m_scanf.nextLine(), rdb);
      m_bot = new Player("albert",!rdb);
    }

    /**
     * S'assure que l'index choisi est valide et prend en compte les erreurs de l'utilisateur
     * @param size
     * @return l'index chois par l'utilisateur
     */
    public static int getIndexValide(int size){
        boolean indexValide = false;
        while(!indexValide){
          try {
            int index = Integer.parseInt(m_scanf.nextLine()) - 1; // Ne soustrayez pas 1 ici      
            if (index >= 0 && index < size) {
              indexValide = true;
              return index;
            }
            else {
              System.out.print("Index invalide. Choisi un numéro valide.\n");
            }
          } 
          catch (NumberFormatException e) {
            System.out.print("Entre un numéro valide.\n");
          }
        }
        return -1; // n'est jamais atteind
    }

    /**
     * Permet a l'utilisateur de choisir un index libre et correcte en gérant les erreurs
     * @param size l'utilisateur peu choisir un nombre entre 0 et size
     * @param indexUtiliser un tableau qui indique si un index a déjà était utiliser (false = utiliser, true = libre )
     * @return l'index choisi par l'utilisateur
     */
    public int getIndexValideSansRep(int size, boolean[] indexUtiliser){
      boolean indexValide = false;
      while(!indexValide){
        try {
          int index = Integer.parseInt(m_scanf.nextLine()) - 1; // Ne soustrayez pas 1 ici 
          if (index >= 0 && index < size && !indexUtiliser[index]) {
            indexUtiliser[index] = true;
            return index;
          }
          else if (index >= 0 && index < size) {
            System.out.print("T'as déjà choisi ce Pokémoon. Choisi un autre numéro.\n");
          } 
          else {
            System.out.print("Index invalide. Choisi un numéro valide.\n");
          }
        } 
        catch (NumberFormatException e) {
          System.out.print("Entre un numéro valide.\n");
        }
      }
      return -1; // n'est jamais atteind
  }

    /**
     * Rempli le plateau du joueur
     * @param nbPoke le nombre de poke que le joeur doit mettre
     */
    public void userFillPlayground(){
      if(m_user.getPlaygroundSize() != 3){
        Affichage.continuer();
        System.out.println(Affichage.getPlayground(m_user, m_bot));
        System.out.println(m_user.getHand());
        System.out.print("Donne le numéro du Pokemoon que tu veux prendre : ");
        while (m_user.getPlaygroundSize()<3 && m_user.getHandSize()>0) {
          m_user.choosePoke(getIndexValide(m_user.getHandSize()));
          Affichage.clearScreen();
          System.out.println(Affichage.getPlayground(m_user, m_bot));
          System.out.println(m_user.getHand());
          System.out.print("Donne le numéro du Pokemoon que tu veux prendre : ");
        }
        m_user.fillHand();
      }
    }

    /**
     * Fait remplir le plateau du bot
     * @param player le bot qui doit remplir son plateau
     * @param nbPoke le nombre de poke que le bot doit mettre 
     */
    public void botFillPlayground(){
      if(m_bot.getPlaygroundSize() != 3){
        while (m_bot.getPlaygroundSize() < 3 && m_bot.getHandSize()>0) {
          m_bot.choosePoke(0);
        }
        System.out.println(m_bot.getPlayerName() + " a rempli son terrain !\n");
        m_bot.fillHand();
      }
    }
    /**
     * il reste des pouv ou pas merci SAM
     * @param p
     * @param pouv_utiliser
     * @return
     */
    private boolean restePouv(Player p, boolean[] pouv_utiliser){
      for(int i=0; i<p.getPlaygroundSize(); i++){
        if(p.hasPower(i) && !pouv_utiliser[i]){
          return true;
        }
      }
      return false;
    }
    /**
     * le bot peut utiliser un pouvoir par tour si son random le permet.
     */
    public void usePouvBot() {
      Affichage.clearScreen();
      boolean[] pouv_utiliser = new boolean[3]; // met tout a false
      Random rd = new Random();
      boolean pouvUtil = false;
      while(restePouv(m_bot, pouv_utiliser)) {
        int index = rd.nextInt(3);
        if(m_bot.hasPower(index)) {
          pouv_utiliser[index] = false;
          // en fonction du type de pouvoir utilise le pouvoir en cherchant qui va le subire
          if(m_bot.pouvIsOffencif(index)==null){
            m_bot.usePouv( index,0, m_bot);
          }
          else if(m_bot.pouvIsOffencif(index)){
            int other = rd.nextInt(m_user.getPlaygroundSize());
            m_bot.usePouv(index, other, m_user);
          }
          else{
            int other = rd.nextInt(m_bot.getPlaygroundSize());
            m_bot.usePouv(index, other, m_bot);
          }
          pouvUtil = true;
        }
        m_bot.cleanPlayground();
        m_user.cleanPlayground();
        Affichage.afficheJeu(m_user, m_bot);
      }
      if(pouvUtil) {
        System.out.println("Le bot a utilisé un pouvoir !");
      }
      else {
        System.out.println("Le bot n'a pas utilisé de pouvoir !");
      }
      Affichage.continuer();
    }



    /**
     * Demande à l'utilisateur s'il veut utiliser un pouvoir puis demande lequel.
     * Si les index sont valides le pouvoir est utilisé.
     */
    public void usePouvJoueur(){
      boolean[] pouv_utiliser = new boolean[3]; // met tout a false
      
      //demande le num d'un pouvoir (le poke qui va utiliser son pouv)
      if(restePouv(m_user, pouv_utiliser)){
        Affichage.afficheJeu(m_user, m_bot);
        boolean indexValide = false;
        int poke = -2;
        System.out.print("Veux-tu afficher l'explication de chaque pouvoir ? [1]oui [2]non : ");
        int rep = getIndexValide(2);
        if(rep==0) {
          for(int i = 0; i < m_user.getPlaygroundSize(); i++) {
            if(m_user.hasPower(i)) {
              System.out.println(m_user.getDescPouvoir(i));
            }
          }
        }
        System.out.print("Veux-tu utiliser un pouvoir ? [1]oui [2]non : ");
        rep = getIndexValide(2);
        while(rep==0){
          System.out.print("Numéro du pokemoon avec un pouvoir : ");
          indexValide = false;
          while (!indexValide) {
            poke = getIndexValide(m_user.getPlaygroundSize());
            // regarde si le pouvoir n'est pas nul
            if(m_user.hasPower(poke)){
              indexValide = true;
              pouv_utiliser[poke] = true;
            }
            else{
              System.out.println("Il a pas de pouvoir connard (c'est Sam qui a mis ça, je suis désolé)");
            }
          }
          // en fonction du type de pouvoir utilise le pouvoir en cherchant qui va le subire
          if(m_user.pouvIsOffencif(poke)==null){
            m_user.usePouv(poke,0, m_user);
          }
          else if(m_user.pouvIsOffencif(poke)){
            System.out.println("quel poke veux tu attaquer");
            int other = getIndexValide(m_bot.getPlaygroundSize());
            m_user.usePouv(poke, other, m_bot);
          }
          else{ 
            System.out.println("quel poke veux tu aider ?");
            int other = getIndexValide(m_user.getPlaygroundSize());
            m_user.usePouv(poke, other, m_user);
          }
          if(restePouv(m_user, pouv_utiliser)){
            System.out.println("Veux-tu utiliser un autre pouvoir ? [1]oui [2]non");
            rep = getIndexValide(2);
          }
          else{
            rep = 1;
          }
          m_bot.cleanPlayground();
          m_user.cleanPlayground();
          Affichage.afficheJeu(m_user, m_bot);
        }
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
      boolean[] indexValide = new boolean[m_user.getPlaygroundSize()];
      for(int i=0; i<m_user.getPlaygroundSize() && !m_gameOver; i++) {
        Affichage.clearScreen();
        Affichage.afficheJeu(m_user,m_bot);
        System.out.print("Numéro du Pokemoon à jouer : ");
        // Pour l'indexe de notre poke
        int monPoke = getIndexValideSansRep(m_user.getPlaygroundSize(),indexValide);
        System.out.print("Numéro du Pokemoon à attaquer : ");
        int autrePoke = getIndexValide(m_bot.getPlaygroundSize());
        System.out.println(m_user.userAttack(m_bot,monPoke,autrePoke));
        nbDeMort += m_bot.cleanPlayground();
        gameOver();
      }
      return nbDeMort;
      }


    public int botAttack(){
      int nbDeMort = 0;
      Affichage.clearScreen();
      System.out.println(m_bot.getPlayerName()+ " attaque !");
      for(int i=0; i<m_bot.getPlaygroundSize() && !m_gameOver; i++){
        System.out.println(m_bot.autoAttack(m_user, i));
        nbDeMort += m_user.cleanPlayground();
        gameOver();
      }
      System.out.println(m_bot.getPlayerName() + " a tué " + nbDeMort + " de tes Pokemoons !");
      Affichage.continuer();
      return nbDeMort;
    }

    /**
     * Dit si je jeu est fini ou non
     * @return le joeur qui a gagné ou null
     */
    public Player gameOver() {
      if(m_bot.getFirstPlayer() && m_bot.getDiscardSize()==20) {
        m_gameOver = true;
        return m_user;
      }
      else if(!m_bot.getFirstPlayer() && m_bot.getDiscardSize()==21) {
        m_gameOver = true;
        return m_user;
      }
      else if(m_user.getFirstPlayer() && m_user.getDiscardSize()==20) {
        m_gameOver = true;
        return m_bot;
      }
      else if(!m_user.getFirstPlayer() && m_user.getDiscardSize()==21) {
        m_gameOver = true;
        return m_bot;
      }
      else return null;
    }

    public boolean getGameOver(){
      return m_gameOver;
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
