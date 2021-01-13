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

## Démarrer un projet collaboratif

### Cloner un projet créé par un autre membre de l'équipe

Utilisez le didacticiel suivant:

* [Découvrez Git avec Eclipse et GitHub](https://openclassrooms.com/fr/courses/6106191-installez-votre-environnement-de-developpement-java-avec-eclipse/6250106-decouvrez-git-avec-eclipse-et-github)

mais clonez notre projet, [https://github.com/ics4u-2020-q2/q2ShareTest](https://github.com/ics4u-2020-q2/q2ShareTest) au lieu de celui du tutoriel ... ou faire les deux!

> Remarque: tout ce cours sur Open Classroom est très utile pour configurer correctement Eclipse.

### Démarrer un nouveau projet

#### Utiliser Maven

Maven crée des configurations de projet standard et récupère des modules externes à partir d'un pool commun sur Internet. Lorsqu'un projet Maven est partagé, les autres utilisateurs saisiront exactement les mêmes modules externes et utiliseront les mêmes paramètres de construction quelle que soit la configuration de leur propre ordinateur. Cela rend le partage de projets plus compliqués (que les simples exemples de formation que nous avons créés) assez simple. Aucune configuration manuelle n'est nécessaire.

Voir [ce fichier](Maven.md) pour plus de détails sur la configuration et l'utilisation des projets gérés avec Maven.

### Utilisation de Git et GitHub

Comme prérequis, vous devez:

* créer un compte GitHub ([ici](https://github.com/))
* (facultativement) installez Git (depuis [ici](https://git-scm.com/)) pour une utilisation / de la pratique sur la ligne de commande. Cette étape est facultative car l'EDI Eclipse fournit déja une version de Git appelée Egit qui est accessible en utilisant le logiciel.

#### Séquence de travail (*workflow*) générale

**Git** est un logiciel de gestion des versions qui fonctionne en utilisant une approche en trois étapes pour les fichiers qui sont "suivis", soit les fichiers dans un `repo` Git:

* dossier de travail / "working tree" - les fichiers sur le disque
* fichiers "staged" - ceux qui ont été ajoutés pour le prochain commit (version enregistrée)
* commits - instantanés de l'ensemble du projet à un moment donné.

**GitHub** est un serveur gratuit exécutant Git qui permet aux développeurs de collaborer sur des projets communs. Vous créez des versions sur votre ordinateur local, puis vous les envoyez (`push`) à GitHub pour les partager. Vous obtenez (`pull`) également des versions plus récentes qui ont été soumises (`push`) par vos collaborateurs depuis GitHub.

> Voici un [document](https://docs.google.com/presentation/d/13a6JAOmkw2xVrOSTWRljl5lGee1CULhxCsGnqbU40f0/view) pour une introduction de base à ce que sont Git et GitHub ainsi que le *workflow* de base de Git. Cependant, les détails de création d'un nouveau répertoire et de validation présentés dans ce document ne concernent que VS Code et Replit.
> Les détails d'Eclipse se trouvent dans le document actuel.

L'utilisation de GitHub mène à plusieurs versions du même fichier existant en même temps sur différents ordinateurs, donc Git inclut également des `branches`. Le projet est basé sur une branche `main`. Voici la séquence générale pour apporter des modifications à un projet:

1. Chaque fois que vous changez de fichier, vous créez une nouvelle branche à partir de la branche `main`.
2. Vous effectuez des `commit` **uniquement** sur **vos branches secondaires**, puis vous `push` ces commits sur GitHub.
3. Sur GitHub, vous créez un `pull request`. C'est l'auteur du `push` qui doit créer cette demande. La demande est pour fusionner les changements dans votre `branch` à la branche `main` et ainsi au projet principal.
4. Suite au `pull request` nous devons vérifier les conflits avec la version des fichiers sur la branche `main`.
    * S'il n'y a ** aucun conflit ** avec la branche `main`, nous pouvons `merge` les modifications directement dans la branche `main`. C'est ce qu'on appelle une *fast-forward* avec `main` enchaînant simplement vos commits sur la tête de sa branche et déplaçant l'index actuel du projet vers ton commit le plus récent.
    * S'il y a ** des conflits **, les collaborateurs doivent aller dans le fichier sur GitHub et éditer les zones en surbrillance afin que le nouveau matériel puisse être intégré sans casser le matériel existant. Il s'agit d'un * processus d'édition manuel *. Lorsque les modifications sont satisfaisantes, les nouvelles modifications, y compris les modifications manuelles, peuvent être fusionnées dans la branche «main».
5. La requête `pull` est alors fermée et votre branche secondaire peut être supprimée.

Ce processus est répété chaque fois qu'un nouveau changement doit être intégré dans le projet.

Voici quelques conseils pour ** éviter les conflits de fusion **:

* Divisez le travail afin qu'une seule personne travaille sur un fichier (ou un sous-ensemble de fichiers) à la fois
* Utilisez la messagerie, comme les `Issues` de GitHub, pour configurer des listes de tâches et les attribuer à des membres spécifiques de l'équipe. Les autres membres de l'équipe peuvent ensuite commenter chaque `Issue` / tâche au lieu de travailler dans les fichiers s'ils ont besoin de suggérer des modifications.

#### Initialisation d'un `repo` Git sur un projet existant

Pour un projet créé d'abord dans Eclipse (avec ou sans Maven), vous devrez:

* Partagez le projet: Faites un clic droit sur votre projet > Team > Share project ...
* New... > New Git repository... > parcourir le dossier `git` que nous avons créé dans le dossier `Eclipse` et ajouter le chemin suivant: `\<project>`. L'emplacement final sera : `chemin\vers\Eclipse\git\ projet>`. Cliquez sur Finish, puis sur Finish.
* Ouvrez la perspective Git: Window > Perspectives > Other > Git
* Cliquer le symbole `++` pour ajouter l'ensemble des fichiers à la zone "Staged", ajoutez un commentaire de 50 caractères ou moins décrivant le `commit` et cliquez sur `commit`.

> Si la branche par défaut s'appelle `master`, il est maintenant recommandé de la changer en `main` en ouvrant le dossier branches, en faire un clic droit sur la branche `master` et en sélectionnant Rename. <p> Vous devriez faire ceci ** avant ** de faire un `push` vers GitHub (sinon il faudra aussi modifier le nom de la branche sur GitHub, doublant le travail).

#### Création d'un nouveau répertoire GitHub pour un projet existant

Pour un projet créé d'abord sur votre ordinateur, vous devrez:

* accédez au site Web GitHub.
* créer un nouveau répertoire sans ajouter de fichiers
* copiez le lien vers ce nouveau repo

#### Pousser votre projet existant sur GitHub

* Dans l'onglet Git Staging, ou dans le sous-menu Team, sélectionnez `Push`.
* Collez l'URI GitHub copié précédemment dans la case appropriée
* assurez-vous que le nom de la branche pour le "remote" est `main`
* cliquez sur OK et à nouveau sur toutes les fenêtres d'aperçu et de confirmation.

#### Synchronisation des modifications vers et depuis GitHub

Lorsque vous ** ouvrez votre projet ** dans Eclipse, vous devez d'abord:

* Passez à la branche `main`.
* Utilisez le menu Team pour faire un `Pull` du projet. S'il y a des problèmes qui provoquent un échec de `pull`, parlez avec vos collaborateurs, ou assurez-vous que vous avez validé votre travail dans votre branche secondaire avant de tenter le `pull`.
* si le travail de votre branche latérale a été fusionné dans la branche `main`, vous devez maintenant supprimer la branche latérale qui est maintenant désuette.

Pour ** travailler sur le projet **, vous devez:

* créer une nouvelle branche latérale pour le travail que vous vous apprêtez à faire
* enregistrez votre travail et faites des commits sur cette branche latérale

Lorsque vous avez ** terminé les modifications que vous souhaitez fusionner dans la branche ** `main` ** ** ou que vous êtes simplement ** à la fin de la journée de travail **, vous devez:

* faire un `commit` final de votre branche latérale
* `push` votre branche latérale vers GitHub (pour que votre équipe puisse voir où vous en êtes)
* si les changements sont terminés, accédez à GitHub et créez une `pull request` pour que les nouveaux éléments puissent être ajoutés au projet principal.

Si vous ** gérez la base de code du projet **, vous devez réserver du temps en fin de journée (ou tout au long de la journée, selon les besoins de votre équipe) pour:

* passer en revue les `pull requests` et passez en revue tout conflit de `merge` avec les membres de l'équipe impliqués;
* fusionner les modifications dans la branche `main` sur GitHub;
* fermer les `pull requests` et supprimez les branches latérales sur GitHub.
