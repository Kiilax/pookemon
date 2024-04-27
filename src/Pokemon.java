import player.*;

public class Pokemon
{
  public static void main(String args[])
  {
    // simulation du premier tour

    // créer joueur
    Player p1 = new Player();
    Player p2 = new Player();

    // rempli les main
    p1.fillHand();
    p2.fillHand();


    //joue autant de poke qu'il n'y a de mort
    for(int i=0; i<p1.cleanPlayground();i++){
      p1.choosePoke("");
    }
    for(int i=0; i<p2.cleanPlayground();i++){
      p2.choosePoke("");
    }
    //ici on en met que 1 pcq flemme
    for(int i=0; i<3; i++){
      p1.choosePoke("");
      p2.choosePoke("");

    }

    System.out.println(p1);
    System.out.println(p2);
    
    //p1 attaque p2
    p1.attack(p2, "", "");

    System.out.println(p1);
    System.out.println(p2);


  }
}
