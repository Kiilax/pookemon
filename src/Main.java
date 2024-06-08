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

    //Debut de la partie en fonction du premier joueur :
    if(partie.playerIsFirst()) {
      System.out.println("\nC'est toi qui commence !\n");
      partie.userFillPlayground();
      partie.botFillPlayground();
      partie.usePouvJoueur();
      partie.userAttack();
      partie.usePouvBot();
      partie.botAttack();
    }
    else {
      System.out.println("\nAlbert l'ordinateur commence !\n");
      partie.botFillPlayground();
      partie.userFillPlayground();
      partie.usePouvBot();
      partie.botAttack();
      partie.usePouvJoueur();
      partie.userAttack();
    }
    //Deroulement du jeu en fonction du premier joueur :
    while(!partie.getGameOver()) {
      if(partie.playerIsFirst()) {
        partie.userFillPlayground();
        partie.usePouvJoueur();
        partie.userAttack();
        partie.botFillPlayground();
        partie.usePouvBot();
        partie.botAttack();
      }
      else {
        partie.botFillPlayground();
        partie.usePouvBot();
        partie.botAttack();
        partie.userFillPlayground();
        partie.usePouvJoueur();
        partie.userAttack();
      }
      if(partie.getGameOver()){
        Affichage.afficheFinJeu(partie.gameOver());
      }
    }
    partie.gameEnd();
  }
}
