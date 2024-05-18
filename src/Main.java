import partie.*;
public class Main
{
  public static void main(String args[])
  {
    //INTRODUCTION DU JEU
    Deroulement partie = new Deroulement();
    Affichage af = new Affichage();
    af.clearScreen();
    af.getTitre();
    partie.createPlayer();
    boolean loop = true;
    //REMPLISSAGE DES TERRAINS
    while(loop) {
      if(partie.isBotFirst()) {
        partie.remplirPlaygroundBot();
        partie.remplirPlaygroundPlayer();
        af.clearScreen();
        partie.botAttackUser();
        partie.userAttackBot();
      }
      else {
        partie.remplirPlaygroundPlayer();
        partie.remplirPlaygroundBot();
        af.clearScreen();
        partie.userAttackBot();
        partie.botAttackUser();
      }
      if(partie.gameOver()) loop = false;
    }
    partie.gameEnd();
  }
}
