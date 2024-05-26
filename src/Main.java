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

    //Debut de la partie en fonction du premier joueur :
    if(partie.playerIsFirst()) {
      System.out.println("\nC'est toi qui commence !\n");
      partie.userFillPlayground(nbPokeMortUser);
      partie.botFillPlayground(nbPokeMortBot);
      nbPokeMortBot = partie.userAttack();
      nbPokeMortUser = partie.botAttack();
    }
    else {
      System.out.println("\nAlbert l'ordinateur commence !\n");
      partie.botFillPlayground(nbPokeMortBot);
      partie.userFillPlayground(nbPokeMortUser);
      nbPokeMortUser = partie.botAttack();
      nbPokeMortBot = partie.userAttack();
    }
    //Deroulement du jeu en fonction du premier joueur :
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
