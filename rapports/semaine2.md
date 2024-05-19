Package partie :
Le déroulement de la partie n'est disponible que dans la classe Deroulement. Celle-ci a pour responsabilité les échanges entre l'utilisateur et le programme. Elle va s'occuper d'afficher en sortie toutes les instructions et informations nécessaires au joueur. Elle va également lire en entrer tout ce que l'utilisateur veut faire (choisir les pokemons à mettre sur son terrain ou encore choisir quel pokemon attaquer avec lequel de ses pokemon). C'est le Main qui s'occupe d'appeler les méthodes de Deroulement pour faire fonctionner le jeu.

FAIT :

Actuellement, un joueur peut démarrer une partie en donnant son pseudo
La boucle principale du jeux est faite :
- Le joueur qui commence commence par remplir son terrain avec le nombre de poke mort (initialement 3)
- ensuite il peut attaquer l'autre joeur (il attaque et a chaque fin d'attaque on regarde si il a tué un poke pour l'enlevé et ainsi être sur qu'il ne va pas le réataquer)
- et on recommence en remplissant avec le nombre de mort ...

A FAIRE :

Il faut réglé un bug lorsque le bot attaque un joeur car il y a un index trop grand donné ce qui créer une référence a un poke null ce qui génère une erreur
Il faudra surement réorganiser les classes Player et user car actuellement l'héritage entre la classe mère Player et les classes enfants User n'est pas forcément pertinant.

