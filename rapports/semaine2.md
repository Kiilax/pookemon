Package partie :
Le déroulement de la partie n'est disponible que dans la classe Deroulement. Celle-ci a pour responsabilité les échanges entre l'utilisateur et le programme. Elle va s'occuper d'afficher en sortie toutes les instructions et informations nécessaires au joueur. Elle va également lire en entrer tout ce que l'utilisateur veut faire (choisir les pokemons à mettre sur son terrain ou encore choisir quel pokemon attaquer avec lequel de ses pokemon). C'est le Main qui s'occupe d'appeler les méthodes de Deroulement pour faire fonctionner le jeu.
La classe Affichage est dans le package partie mais n'est pour le moment pas fonctionnel. Elle aura pour repsonsabilité l'affichage du jeu et sera utliser par le Main et Deroulement pour interargir avec l'utilisateur

Package Player :
La classe User a été créée et hérite de la classe Player. Elle permet, entre autre, de différencier l'attaque du joueur et celle de l'ordinateur

FAIT :

Actuellement, un joueur peut démarrer une partie en donnant son pseudo
La boucle principale du jeux est faite :

- Le joueur 1 commence par remplir son terrain selon le nombre de poke mort (initialement 3 car vide au début)
- ensuite il peut attaquer l'autre joeur (il attaque et a chaque fin d'attaque on regarde si il a tué un poke pour l'enlevé et ainsi être sur qu'il ne va pas le réataquer)
- et on recommence en remplissant selon le nombre de mort ...

A FAIRE :

Configurer correctement la classe Affichage.
Afficher le gagnant de la partie à la fin.
Revoir les toString() des différentes classes
Regler les bugs d'affichage
