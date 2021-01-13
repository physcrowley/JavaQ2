# Utiliser Eclipse avec Git, GitHub et Maven pour la collaboration

## Configuration des fichiers pour notre espace de travail et notre répertoire git

Créez la structure de dossiers suivante sur votre disque :

    Eclipse
    |---workspace
    `---git
        |---<projet1>
        `---<projet2>

* Sélectionnez le dossier `workspace` comme espace de travail en ouvrant Eclipse.
* Lorsque nous créons notre répertoire Git local, nous allons créer un sous-dossier pour notre projet dans le dossier `git`.

De cette façon, toutes nos informations sur l'espace de travail et les informations `Git` seront conservées ensemble dans un dossier Eclipse plus grand. Et chaque projet aura ses propres informations Git distinctes (et le répertoire GitHub associé).

Lorsque vous utilisez Git :

* Le code source de tous les projets collaboratifs sera conservé dans le dossier `git\<project>`.
* Seuls les *métadonnées* de l'espace de travail nécessaires pour intégrer correctement vos projets dans votre installation locale d'Eclipse seront stockées dans le dossier `workspace`.
* Tous les projets *locaux* (qui ne sont pas partagés via GitHub) doivent également être stockés *entièrement* dans le dossier `workspace` (métadonnées et code source).

## Prérequis

Il faut comprendre un peu sur [Git et GitHub](Git.md) avant de commencer à collaborer.

Il faut aussi comprendre un peu sur [Maven](Maven.md), un logiciel spécifiquement conçu pour créer des structures de projet et des configurations qui sont facilement partageables.

>Voir les détails dans les liens ci-dessus avant d'aller plus loin, et servez-vous en au besoin en cours de travail.

## Démarrer un projet collaboratif

### Quand je suis le membre de l'équipe qui crée le projet

* Créer un nouveau répertoire sur GitHub pour le projet et l'initier avec un README.md
* Cloner le repo GitHub dans Eclipse en le plaçant dans un nouveau sous-dossier dans le dossier "git" qui est dans le même dossier que ton espace de travail Eclipse.
  ```
  Eclipse
  |---git
  |   `---<nouveau_dossier_projet>
  `---workspace
  ```
* Créer un nouveau projet Maven avec un GroupID de `edu.ics4u` et un ArtifactID qui est le nom du projet en minuscules. Les archétypes recommandés sont les suivants :
  * Projet *Java* : recherche "gluon" - `client-archetype-java`
  * Projet *JavaFX* simple : recherche "openjfx" - `javafx-archetype-simple`
  * Projet *JavaFX avec FXML* : recherche "openjfx" - `javafx-archetype-fxml`
* Tester le projet en exécutant le fichier Java principal avec Run as… > Java Application.
* Initier le repo Git :
  * Aller dans Team > Share project...
  * Choisir le Repository cloné de GitHub à partir du menu "Repository:"
* Modifier le fichier `.gitignore` en ajoutant les lignes suivantes. Cela assure que seulement le code source et les fichiers de configuration Maven seront partagés :
  ```
  # output files
  /target/
  /bin/
  *.class
  *.jar
  
  # local configuration files and folders
  .classpath
  .project
  .settings
  ```
* Faire un `commit` et un `push` du projet Maven sur la branche `main`. Le projet apparaît comme un sous-dossier du répertoire sur GitHub.
* Partager le lien au repo GitHub avec les autres membres de l'équipe

### Je suis un autre membre de l'équipe

* Importer le projet avec File > Import > Git > Projects from Git (with smart import) > Clone URI.
* Pour le chemin du `repo`, créer un dossier dans le sous-dossier `git` de ton dossier Eclipse :
    ```
    Eclipse
    |---git
    |   `---<nouveau_dossier_projet>
    `---workspace
    ```
* Seulement cocher un projet si 2 apparaissent. Il faut que le projet retenu soit identifié comme "Maven" dans la colonne "Import as".
* Tester le projet en exécutant le fichier Java principal avec Run as… > Java Application.

## Travailler sur le projet collaboratif
Le travail individuel sur le projet se fait selon la séquence typique avec Git, soit : 
* créer une nouvelle branche, 
* faire des commit sur sa branche, 
* pousser ses commits, 
* créer un pull request sur GitHub, 
    >IMPORTANT : il faut toujours se rendre sur GitHub pour créer un pull request.
* S'il n'y a pas de gérant des pull requests, tu devrais faire les étapes 5 à 7 toi-même. Sinon, c'est le gérant qui s'en chargera… et tu peux aller à l'étape 8. 
* gérer les conflits avec les autres membres de l'équipe, au besoin,
* fusionner (merge) la branche avec main,
* supprimer la branche temporaire sur GitHub
*faire un pull de la branche main sur son poste
* supprimer la branche temporaire sur son poste.
* répéter le tout pour la prochaine tâche.
