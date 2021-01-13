# ICS4U - q2

Ce dossier contient tous les exemples et une bonne partie des notes de cours pour le 2e quadrimestre.

## Encodage du texte

Les fichiers Java ont été encodés en **Windows 1252** afin de faciliter l'affichage du texte français (unicode) à la ligne de commande. Tous les autres fichiers sont encodés en **UTF8**, le standard international actuel.

Type de fichier | Encodage
--- | ---
`.java` | Windows 1252
tous les autres | UTF8

## Dossiers `src` et `bin`

Les projets *05Objets* et *06Polymorphisme* sont organisés comme *Projet Standard* dans des packages à l'intérieur du dossier `src`, compilant les fichiers dans le dossier `bin`.

>Les projets avant ça - de 00 à 04 - sont simplement organisés comme des *Projet Simple* sans structure interne.

Le *domaine* pour les packages du cours est `edu.ics4u` avec le dernier niveau du package nommé pour la leçon spécifique.

```
JavaQ2
|---00Structure
|---...
|---bin
|---src
|   `---edu
|       `---ics4u
|           |---objets
|           |---poly
|           `---...
|---launch-objets.sh
`---launch-poly.sh
```

Les fichiers de configuration `launch-<nom>.sh` et `launch-<nom>.bat` (qui incluent les commandes `javac` et `java` pour chaque projet) se trouvent à la racine de l'espace de travail.

>Voir le [README.md](./ProjetStandard/README.md) dans le gabarit de ProjetStandard pour les détails sur ce type d'organisation de projet.

## Gabarits de projets

Il y a deux dossiers de projets-gabarits ici :

* ProjetSimple
* ProjetStandard

Le [projet simple](ProjetSimple) est un dossier sans structure interne. Ce gabarit convient pour plusieurs de nos premiers programmes. Dès qu'on commence l'orienté objet, par contre, c'est mieux de passer au projet standard.

Le [projet standard](ProjetStandard) inclut une séparation des fichiers source et des fichiers compilés. Le `README.md` à la racine du gabarit explique :

* le pourquoi de la séparation `src` et `bin`
* le concept des **packages**
* comment compiler et exécuter des fichiers qui sont organisés en packages et séparés entre `src` et `bin`

## Scripts `java-c` et `java-r`

Ces scripts sont ceux que vous pouvez utiliser avec l'installation portable de Java sur les postes du local informatique où les commandes standards `javac` et `java` ne fonctionnent pas.

>Si tu as une installation valide de Java (où la commande `java --version`  et la commande `javac --version` t'affichent l'information sur la même version et ne donnent aucune erreur), ces scripts sont inutiles. Utiliser les commandes `javac` et `java` directement.

Noter que les scripts sont copiés et collés à la racine de chaque projet-gabarit. C'est un détail important car vous devriez travailler avec votre dossier de **projet** (simple) comme le dossier racine dans VS Code (les projets standard ont tous leur racine directement dans l'espace de travail). Ayant des copies des scripts à la racine de vos projets vous permet de les utiliser directement sans ajouter de chemin. Comme ça, ils sont aussi faciles à utiliser que les commandes naturelles `javac` et de `java`.

## Scripts `j-shell`

Semblable aux scripts `java-c` et `java-r`, le script `j-shell` lance la console Java qui est normalement atteinte directement avec la commande `jshell` quand Java est configuré correctement sur l'ordinateur.

### Utilité de `jshell`

La console `jshell` est très pratique pour tester des nouvelles fonctionnalités et voir le détail des déclarations à mesure qu'elles sont écrites, sans avoir à programmer l'affichage d'un résultat, ensuite compiler le programme et finalement exécuter le programme. L'outil est donc excellent pour **l'exploration et l'apprentissage de nouveaux concepts**, surtout si on peut les écrire en quelques lignes de code.

Son utilité est évidente pour les sujets suivants :

* les variables et les types
* la structure des `String` et des tableaux
* l'application de différentes méthodes d'objets (méthodes de `String`, d'`ArrayList`, de `LinkedList`, de `HashMap`, de `File`, etc.)
