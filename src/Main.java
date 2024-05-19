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
    int nbPokeMortUser = 3;
    int nbPokeMortBot = 3;
    //REMPLISSAGE DES TERRAINS
    while(loop) {
      if(partie.playerIsFirst()) {
        System.out.println("le joueur commence");
        partie.userFillPlayground(nbPokeMortUser);
        partie.botFillPlayground(nbPokeMortBot);
        af.clearScreen();
        nbPokeMortBot = partie.userAttack();
        nbPokeMortUser = partie.botAttack();
      }
      else {
        System.out.println("albert commence");
        partie.botFillPlayground(nbPokeMortBot);
        partie.userFillPlayground(nbPokeMortUser);
        af.clearScreen();
        nbPokeMortUser = partie.botAttack();
        nbPokeMortBot = partie.userAttack();
      }
      if(partie.gameOver() != null){
        loop = false;
        // TODO fair fct printWiner(Player gagnan)
      }
    }
    partie.gameEnd();
  }
}
