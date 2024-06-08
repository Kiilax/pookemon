# Pokemoon

## Présentation des packages

### package pokemoon

    - enum Element : Cette classe a pour but de géré la création et les avantages des élèments
    - class ListPokemoon : Cette classe a pour but la création des pokemoons et leur distribution
    - class PokeLife : Cette classe a pour but la gestion de la vie des pokemoon
    - class Pokemoon : Cette classe a pour but la gestion des différentes actions que peu faire un pokemoon
    - class PokePower : Cette classe a pour but la gestion de la puissance d'attaque d'un pokemoon
    - class PouvEther : Cette classe permet de modifier le type d'un pokemoon en le transformant en type Ether
    - class PouvFerveurGuerriere : Cette classe permet d'augmenter de 10 l'attaque d'un pokemoon
    - class PouvKamikaz : Cette classe permet de tué deux pokemoon d'un coup
    - class PouvPlomb : Cette classe permet de modifier le type d'un pokemoon en le transformant en type Plomb
    - class Pouv Resistance : Cette classe permet de diminué de 10 chaque attaque reçut
    - class PouvSoinSimple : Cette classe permet de donné 30 pv en plus à un poke
    - class PouvSoinTotal : Cette classe permet de redonné toute sa vie à un pokemoon

### package player
    - class Deck : Cette carte a pour but la gestion des pokemoons du deck
    - class Discard : Cette classe a pour but la gestion des pokemoons dans la defausse
    - class Hand : Cette carte a pour but la gestion des pokemoons dans la main
    - class Player : Cette classe a pour but la gestion des actions d'un joueur (il doit pouvoir changé les pokemoons de tas et leur dire d'attaque / utiliser un pouvoir)
    - class Playground : Cette classe a pour but la gestion des pokemoons sur le plateau
    - class PouvSoinZone : Cette classe a pour but de redonné 10 pv a tout les poke d'un plateau
    - class User : Cette classe hérite de Playeur et a pour but de permettre à un humain de choisir ce qu'il veut jouer

### package partie
    - class Affichage : Cette classe permet d'afficher tout les élèments essenciel au bon déroulement de la partie
    - class Deroulement : Cette classe permet de gérè les intéraction joueur / jeux (demande ce que le joueur veut jouer / fait jouer le bot)

### packege pouvoir
    - class abstract Pouvoir : Cette class est hérité par tout les pouvoir pour pouvoir utiliser le polymorphisme

## Implémentation 

### Pokemoon
    Pour l'implémentation des pokemoons nous avons décidé de séparé toute les responsabilité dans des classe différentes. 
    
    Nous avons une enumération qui se charge de géré les différents type. Elle ne contient que des strings et elle intervient principalement dans pokePower pour savoir si l'attaque va changé ou pas. 

    La gestion de la vie se fait dans la classe PokeLife et c'est notament ici que la vie change si il y a une attaque ou un soins et c'est aussi ici que l'on a diminué la puissance des attaque reçu si le pokemoon est resistant.

    Et les pokemoons à la fin n'on presque rien a faire si ce n'est que d'attaque ou d'utiliser un pouvoir mais c'est tout

    L'implémentation des Pouvoir a était plutôt simple : 

        Les pouvoir ether et plomb on necessité un set pour modifié le type d'un pockemoon de visibilité package pour que l'on ne puisse pas fait ce que l'on veux avec les type. Il a aussi fallu changer les condition pour augmenté / diminué la puissance de l'attaque en fonction du type dans pokePower

        Les pouvoir soin simple et soin total on necessité une methode take heal dans la classe PokeLife

        Le pouvoir kamikaz n'a demander aucun changement car nous l'avons fait comme si le pokemoon fait une très grosse attaque au deux pokemoons

        Le pouvoir FerveurGuerriere a demander une methode pour augmenter la puissance du pokemoon dans la classe PokePower

        Le pouvoir Resistance a necessité l'ajout d'un attribut qui va diminué les poins de vie perdu après une attaque et d'une methode set pour cette attribu dans la classe PokePower

### Player
    Pour le joueur nous nous sommes mis dans une condition de jeux et on c'est dit que un joueur ne fait que déplacer des cartes et c'est donc ce que l'on a fait

    Chaque tas est responsable des pokemoons dedans, seul le Playground a une action en plus qui est de s'assuré que tout les pokemoon qui sont dedans ont de la vie sinon il les retire et le joueur les mets dans la défausse.

    Le pouvoir soins de zone ce trouve dans se package car il a besoins d'avoir accèes au playground des joueur pour pouvoir soigné tout les pokemoons.

## Partie 
    Le package partie est séparé en deux classe.

    La classe Affichage qui ne comporte que des méthodes static pour pouvoir afficher tout la partie sans avoir besoins d'être instancié

    La classe Deroulement passe sont temps a demander au joueur ce qu'il veut faire

