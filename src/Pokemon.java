import pokemoon.*;

public class Pokemon
{
  public static void main(String args[])
  {
    Pokemoon poke = new Pokemoon();
    Pokemoon poke2 = new Pokemoon();
    System.out.println("Lancement du jeu ...\n");
    System.out.println(poke.toString()+"\n\n"+poke2.toString());
    poke.fight(poke2);
    System.out.println("\noh non il y a eu une attaque\n\n"+poke2.toString());
  }
}
