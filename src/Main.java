import partie.Deroulement;

public class Main
{
  public static void main(String args[])
  {
    //INTRODUCTION DU JEU
    Deroulement partie = new Deroulement();
    partie.clearScreen();
    partie.getTitre();
    partie.createPlayer();
    boolean loop = true;
    //REMPLISSAGE DES TERRAINS
    while(loop) {
      if(partie.isBotFirst()) {
        partie.remplirPlaygroundBot();
        partie.remplirPlaygroundPlayer();
        partie.clearScreen();
        partie.botAttackUser();
        partie.userAttackBot();
      }
      else {
        partie.remplirPlaygroundPlayer();
        partie.remplirPlaygroundBot();
        partie.clearScreen();
        partie.userAttackBot();
        partie.botAttackUser();
      }
      if(partie.gameOver()) loop = false;
    }
    partie.gameEnd();
  }
}
