# ICS4U - q2

Ce dossier contient tous les exemples et une bonne partie des notes de cours pour le 2e quadrimestre.

## Gabarits de projets

Il y a deux dossiers de projets-gabarits ici :

* ProjetSimple
* ProjetStandard

Le **projet simple** est un dossier sans structure interne. Ce gabarit convient pour plusieurs de nos premiers programmes. Dès qu'on commence l'orienté objet, par contre, c'est mieux de passer au projet standard.

Le **projet standard** inclut une séparation des fichiers source et des fichiers compilés. Le `README.md` à la racine du gabarit explique :

* le pourquoi de la séparation `src` et `bin`
* le concept des **packages**
* comment compiler et exécuter des fichiers qui sont organisés en packages et séparés entre `src` et `bin`

## Scripts `java-c` et `java-r`

Ces scripts sont ceux que vous pouvez utiliser avec l'installation portable de Java sur les postes du local informatique où les commandes standards `javac` et `java` ne fonctionnent pas.

Noter que les scripts sont copiés et collés à la racine de chaque projet-gabarit. C'est un détail important car vous devriez travailler avec votre dossier de **projet** comme le dossier racine dans VS Code. Ayant des copies des scripts à la racine de vos projets vous permet de les utiliser directement sans ajouter de chemin. Comme ça, ils sont aussi faciles à utiliser que les commandes naturelles `javac` et de `java`.

>Si tu as une installation valide de Java (où la commande `java --version` t'affiche l'information sur la version et aucune erreur), ces scripts sont inutiles. Utiliser les commandes `javac` et `java` directement.

## Scripts `j-shell`

Semblable aux scripts `java-c` et `java-r`, le script `j-shell` lance la console Java qui est normalement atteinte directement avec la commande `jshell` quand Java est configuré correctement sur l'ordinateur.

### Utilité de `jshell`

La console `jshell` est très pratique pour tester des nouvelles fonctionnalités et voir le détail des déclarations à mesure qu'elles sont écrites, sans avoir à programmer l'affichage d'un résultat, ensuite compiler le programme et finalement exécuter le programme. L'outil est donc excellent pour **l'exploration et l'apprentissage de nouveaux concepts**, surtout si on peut les écrire en quelques lignes de code.

Son utilité est évidente pour les sujets suivants :

* les variables et les types
* la structure des `String` et des tableaux
* l'application de différentes méthodes d'objets (méthodes de `String`, d'`ArrayList`, de `LinkedList`, de `HashMap`, de `File`, etc.)
