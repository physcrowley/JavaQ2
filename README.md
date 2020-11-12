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