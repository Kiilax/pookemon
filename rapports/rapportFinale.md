# Pokemoon

## Présentation des packages

### package pokemoon

    - enum Element : Cette classe a pour but de gérer la création et les avantages des élèments
    - class ListPokemoon : Cette classe a pour but la création des pokemoons et leur distribution
    - class PokeLife : Cette classe a pour but la gestion de la vie des pokemoons
    - class Pokemoon : Cette classe a pour but la gestion des différentes actions que peu faire un pokemoon
    - class PokePower : Cette classe a pour but la gestion de la puissance d'attaque d'un pokemoon
    - class PouvEther : Cette classe permet de modifier le type d'un pokemoon en le transformant en type Ether
    - class PouvFerveurGuerriere : Cette classe permet d'augmenter de 10 l'attaque d'un pokemoon
    - class PouvKamikaz : Cette classe permet de tuer deux pokemoons d'un coup
    - class PouvPlomb : Cette classe permet de modifier le type d'un pokemoon en le transformant en type Plomb
    - class Pouv Resistance : Cette classe permet de diminuer de 10 chaque attaque reçue
    - class PouvSoinSimple : Cette classe permet de donner 30 pv en plus à un pokemoon
    - class PouvSoinTotal : Cette classe permet de redonner toute sa vie à un pokemoon

### package player

    - class Deck : Cette classe a pour but la gestion des pokemoons du deck
    - class Discard : Cette classe a pour but la gestion des pokemoons dans la défausse
    - class Hand : Cette classe a pour but la gestion des pokemoons dans la main
    - class Player : Cette classe a pour but la gestion des actions d'un joueur (il doit pouvoir changer les pokemoons de tas et leur dire d'attaque / utiliser un pouvoir)
    - class Playground : Cette classe a pour but la gestion des pokemoons sur le plateau
    - class PouvSoinZone : Cette classe a pour but de redonner 10 pv a tous les pokemoons d'un plateau
    - class User : Cette classe hérite de Playeur et a pour but de permettre à un humain de choisir ce qu'il veut jouer

### package partie

    - class Affichage : Cette classe permet d'afficher tout les élèments essentiels au bon déroulement de la partie
    - class Deroulement : Cette classe permet de gérer les intéractions joueur / jeux (demande ce que le joueur veut jouer / fait jouer le bot)

### package pouvoir

    - class abstract Pouvoir : Cette classe est héritée par tous les pouvoirs pour utiliser le polymorphisme

## Implémentation

### Pokemoon

    Pour l'implémentation des pokemoons, nous avons décidé de séparer toutes les responsabilités dans des classes différentes.

    Nous avons une énumération qui se charge de gérer les différents types. Elle ne contient que des strings et elle intervient principalement dans pokePower pour savoir si l'attaque va changer ou pas.

    La gestion de la vie se fait dans la classe PokeLife et c'est notamment ici que la vie change si il y a une attaque ou un soins et c'est aussi ici que l'on a diminué la puissance des attaques reçus si le pokemoon est résistant.

    Et les pokemoons à la fin n'on presque rien à faire si ce n'est attaquer ou utiliser un pouvoir.

    L'implémentation des Pouvoir a été plutôt simple :

        Les pouvoirs ether et plomb ont necessité un set pour modifier le type d'un pokemoon de visibilité package pour que l'on ne puisse pas faire ce que l'on veux avec les typess. Il a aussi fallu changer les conditions pour augmenter / diminuer la puissance de l'attaque en fonction du type dans pokePower.

        Les pouvoirs soin simple et soin total ont nécessité une méthode takeHeal dans la classe PokeLife.

        Le pouvoir kamikaz n'a demandé aucun changement car nous avons fait comme si le pokemoon fait une très grosse attaque aux deux pokemoons

        Le pouvoir FerveurGuerriere a demandé une méthode pour augmenter la puissance du pokemoon dans la classe PokePower

        Le pouvoir Résistance a nécessité l'ajout d'un attribut qui va diminuer les points de vie perdus après une attaque et d'une méthode set pour cette attribut dans la classe PokePower

### Player

    Pour le joueur, nous nous sommes mis dans une condition de jeux et on s'est dit qu'un joueur ne fait que déplacer des cartes et c'est donc ce que l'on a fait

    Chaque tas est responsable des pokemoons qu'il stocke, seul le Playground a une action en plus qui est de s'assurer que tous les pokemoons qui sont dedans ont de la vie sinon il les retire et le joueur les mets dans la défausse.

    Le pouvoir soins de zone se trouve dans ce package car il a besoin d'avoir accès au playground des joueurs pour pouvoir soigner tous les pokemoons.

## Partie

    Le package partie est séparé en deux classes.

    La classe Affichage ne comporte que des méthodes static pour pouvoir afficher toute la partie sans avoir besoins d'être instanciée

    La classe Déroulement passe son temps à demander au joueur ce qu'il veut faire
