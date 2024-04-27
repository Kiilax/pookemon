Package pokemoon :
Un pokemoon n'est accessible que via la classe Pokemoon. (toutes les autres méthodes pour les pokemoons ne sont accessibles que dans le package)
Les affinités sont gérées avec une énumération Element car il y en a un petit nombre. En fonction du type, les attributs sont toujours les mêmes et il est très simple de rajouter un élément a une énumération (ce qui est très pratique).
La gestion de la distribution aléatoire des noms des poke est gérée par une classe ListPokemoon qui n'est pas instanciable et qui ne contient que des méthodes et des attributs statiques.
La vie des poke est gérée par la classe PokeLife qui se charge de stocker la vie actuelle, la vie max et de modifier la vie au besoin (si le poke subit une attaque par exemple).
La puissance de l'attaque, elle, est gérée par la classe PokePower qui stocke la valeur de l'attaque de base et se charge aussi d'adapter la puissance en fonction des affinités.
Tout ça sert dans la classe Pokemoon qui représente un pokemoon. Elle se charge de créer un pokemon de manière aléatoire, et de gérer ses actions (attaquer un autre pokemon, fournir toutes les infos sur ses atributs qui sont lisibles mais non-modifiables en dehors de la classe)

Package player :
Le joueur n'est accessible que via la classe Player. (toutes les autres méthode pour le joueur ne sont accessibles que dans le package player)
Le deck (=Deck) est une pile qui doit gérer les 20 ou 21 pokemons qui y sont stockés en fonction de qui est le premier joueur.
La défausse (=Discard) est également une pile qui stocke les pokemons éliminés.
La main (=Hand) est une liste de 5 pokemons maximum.
Le terrain (=Playground) est aussi une liste de 3 pokemons maximum.
Leur rôle est de gérer les cartes pokemons et de permettre la simplification de la gestion des déplacements des pokemons pour la classe Player
Le joueur, lui, est donc chargé de sélectionner les pokemons de sa main pour les positionner sur le terrain en fonction de ses besoins et d'attaquer les pokemons adverses avec ceux-ci.
