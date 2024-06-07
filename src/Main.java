import partie.*;
import partie.affichage.Affichage;
import pokemoon.ListPokemoon;

public class Main
{
  public static void main(String args[])
  {
    //INTRODUCTION DU JEU
    Deroulement partie = new Deroulement();
    ListPokemoon.creerPoke();
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
      partie.usePouvJoueur();
      nbPokeMortBot = partie.userAttack();
      partie.usePouvBot();
      nbPokeMortUser = partie.botAttack();
    }
    else {
      System.out.println("\nAlbert l'ordinateur commence !\n");
      partie.botFillPlayground(nbPokeMortBot);
      partie.userFillPlayground(nbPokeMortUser);
      partie.usePouvBot();
      nbPokeMortUser = partie.botAttack();
      partie.usePouvJoueur();
      nbPokeMortBot = partie.userAttack();
    }
    //Deroulement du jeu en fonction du premier joueur :
    while(!partie.getGameOver()) {
      if(partie.playerIsFirst()) {
        partie.userFillPlayground(nbPokeMortUser);
        partie.usePouvJoueur();
        nbPokeMortBot = partie.userAttack();
        partie.botFillPlayground(nbPokeMortBot);
        partie.usePouvBot();
        nbPokeMortUser = partie.botAttack();
      }
      else {
        partie.botFillPlayground(nbPokeMortBot);
        partie.usePouvBot();
        nbPokeMortUser = partie.botAttack();
        partie.userFillPlayground(nbPokeMortUser);
        partie.usePouvJoueur();
        nbPokeMortBot = partie.userAttack();
      }
      if(partie.getGameOver()){
        Affichage.afficheFinJeu(partie.gameOver());
      }
    }
    partie.gameEnd();
  }
}
