import partie.*;
public class Main
{
  public static void main(String args[])
  {
    //INTRODUCTION DU JEU
    Deroulement partie = new Deroulement();
    Affichage.clearScreen();
    Affichage.getTitre();
    partie.createPlayer();
    int nbPokeMortUser = 3;
    int nbPokeMortBot = 3;
    if(partie.playerIsFirst()) {
      System.out.println("le joueur commence");
      partie.userFillPlayground(nbPokeMortUser);
      partie.botFillPlayground(nbPokeMortBot);
      nbPokeMortBot = partie.userAttack();
      nbPokeMortUser = partie.botAttack();
    }
    else {
      System.out.println("albert commence");
      partie.botFillPlayground(nbPokeMortBot);
      partie.userFillPlayground(nbPokeMortUser);
      nbPokeMortUser = partie.botAttack();
      nbPokeMortBot = partie.userAttack();
    }
    //REMPLISSAGE DES TERRAINS
    while(!partie.getGameOver()) {
      if(partie.playerIsFirst()) {
        partie.userFillPlayground(nbPokeMortUser);
        nbPokeMortBot = partie.userAttack();
        partie.botFillPlayground(nbPokeMortBot);
        nbPokeMortUser = partie.botAttack();
      }
      else {
        partie.botFillPlayground(nbPokeMortBot);
        nbPokeMortUser = partie.botAttack();
        partie.userFillPlayground(nbPokeMortUser);
        nbPokeMortBot = partie.userAttack();
      }
      if(partie.getGameOver()){
        Affichage.afficheFinJeu(partie.gameOver());
      }
    }
    partie.gameEnd();
  }
}
