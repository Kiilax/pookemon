import pokemoon.*;

public class Pokemon
{
  public static void main(String args[])
  {
    double rd = Math.random();
    boolean rdb = rd<0.5;

    Player j1 = new Player("j1", rdb);
    Player j2 = new Player("j2", !rdb);
    System.out.println(j1.getDeck().toString());
    System.out.println(j1.getHand().toString());
    System.out.println(j2.getDeck().toString());
    System.out.println(j2.getHand().toString());

    //System.out.println(j1.toString());

    Pokemoon poke = new Pokemoon();
    Pokemoon poke2 = new Pokemoon();
    System.out.println("Lancement du jeu ...\n");
    System.out.println(poke.toString()+"\n\n"+poke2.toString());
    poke.fight(poke2);
    System.out.println("\noh non il y a eu une attaque\n\n"+poke2.toString());
  }
}
