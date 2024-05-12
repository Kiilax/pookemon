Package partie :
Le déroulement de la partie n'est disponible que dans la classe Deroulement. Celle-ci a pour responsabilité les échanges entre l'utilisateur et le programme. Elle va s'occuper d'afficher en sortie toutes les instructions et informations nécessaires au joueur. Elle va également lire en entrer tout ce que l'utilisateur veut faire (choisir les pokemons à mettre sur son terrain ou encore choisir quel pokemon attaquer avec lequel de ses pokemon). C'est le Main qui s'occupe d'appeler les méthodes de Deroulement pour faire fonctionner le jeu.

FAIT :

Actuellement, un joueur peut démarrer une partie en donnant son pseudo, remplir son terrain. Il peut effectuer une attaque sur 3 pokemons de l'ordinateur (ceux de son choix) avec chaque pokemon de son terrain (c'est lui qui choisit l'ordre). Il peut se faire attaquer une fois par le bot (selon l'algorithme du ReadMe avec les affinités etc). Le premier joueur est déjà définit aléatoirement.

A FAIRE :

Il faut encore coder dans déroulement la possibilité pour un pokemon de mourrir et donc de le mettre dans la défausse et donc de rajouter un nouveau pokemon au terrain et à la main. Il faudra ensuite créer une boucle dans le Main qui va permettre au jeu de continuer jusqu'à ce que l'un des joueurs ai tous ses pokemons dans la défausse.
Il faudra surement réorganiser les classes car actuellement l'héritage entre la classe mère Player et les classes enfants Bot et User n'est pas forcément pertinant.
Il y a aussi des ajustements à faire au niveau des toString() des différentes classes pour que la classe Deroulement n'est plus besoin de les remodifier.
