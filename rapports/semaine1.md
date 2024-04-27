Package pokemoon : 
    Un pokemoon n'est accessible que via la classe Pokemoon. (toute les autres méthode pour les pokemoon ne sont accessible que dans le package)
    Les affinités sont gérè avec une énumération element car il y en a un petit nombre, et en fonction du type les attributs sont toujours les mêmes et il est très simple de rajouté un élèment a une énumération ce qui est très pratique.
    La gestion de la distribution aléatoire des noms des poke est gérè par une classe ListPokemoon qui n'est pas instanciable et qui en contient que des méthodes et attributs statique
    La vie des poke est gérè par la classe PokeLife qui se charge de retenir la vie actuel, la vie max et de modifier la vie au besoin (si le poke subit une attaque par exemple)
    La puissance de l'attaque elle est gérè par la classe PokePower stock la valeur de l'attaque de base et se charge aussi d'adapté la puissance en fonction des affinitées
    Tout ça sert dans la classe Pokemoon qui représente un pokemoon, elle se charge de créer un pokemon avec beaucoup trop d'aléatoire, et de gérè ses actions tel que attaquer un autre pokemon, et de fournir toute les infos sur ses atributs (qui sont lisible mais pas modifiable en dehors de la classe)

Package player :
    Le joueur n'est accessible que via la classe Player. (toute les autres méthode pour le joueur ne sont accessible que dans le package)
    Le deck est une pile qui doit gérè les pokemons qui sont en lui
    La defausse est aussi une pile qui doit gérè les pokemons qui sont en elle
    La main est une liste de pokemons
    Le terrain est une liste de pokemons aussi
    Leur rôle est de gérè les cartes et de permettre la simplification de la gestion des déplacement des poke pour la classe Player
    Le joueur lui est donc chargé de bouger les différent pokemon en fonction des besoins et il doit aussi permettre de tapé sur les pokemons d'un autres joueur.