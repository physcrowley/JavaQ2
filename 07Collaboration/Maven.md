# Utiliser Maven pour les projets collaboratifs dans Eclipse

Maven crée des configurations de projet standard et récupère des modules externes à partir d'un pool commun sur Internet. Lorsqu'un projet Maven est partagé, les autres utilisateurs saisiront exactement les mêmes modules externes et utiliseront les mêmes paramètres de construction quelle que soit la configuration de leur propre ordinateur. Cela rend le partage de projets plus compliqués (que les simples exemples de formation que nous avons créés) assez simple. Aucune configuration manuelle n'est nécessaire.

La configuration de Maven pour les *dépendances* (modules externes) et *build* (compilation et emballage) est stockée dans un fichier spécial nommé `pom.xml`. En installant Maven séparément, les collaborateurs n'ont même pas besoin de travailler dans le même IDE ou éditeur: chaque personne peut choisir l'outil de développement de son choix: ligne de commande, VS Code, Eclipse, IntelliJ, etc. et le projet fonctionnera pour chacun. d'eux! C'est l'avantage d'avoir des paramètres de configuration de fichier standard, indépendants de l'outil de travail utilisé.

## Créer un projet Maven

Voici comment créer un projet à l'aide de Maven dans **Eclipse**:

* New... > Project... > Maven > Maven project
* Page `Name and location`
    * Laissez la première option (*simple > skip archetype selection*) décochée
    * Si le dossier `workspace` de votre système n'est pas celui par défaut, décochez *default* et sélectionnez le dossier `workspace` actuel.
    * Cliquez sur Next
* Page `Archetype`
    * Commencez à taper le nom de l'archétype que vous souhaitez utiliser. Vous pouvez parcourir [Maven Central](https://mvnrepository.com/repos/central) pour les archétypes.
    * Voici la liste des archétypes recommandés pour nos projets. Ils sont, par hasard, tous crées par Gluon :
        * projet **Java** de base : rechercher "gluon" et choisir `client-archetype-java`
        * projet **JavaFX** de base : rechercher "openjfx" et choisir `javafx-archetype-simple`
        * projet **JavaFX avec FXML** : rechercher "openjfx" et choisir `javafx-archetype-fxml`
* Page `Groupe ID`
    * groupID = le *domaine* de notre package... nous utilisons `edu.ics4u` pour les projets collectifs dans le cours
    * artifactID = le nom de votre projet en minuscules
    >En combinant le groupID et l'artifactID, nous obtenons le `package`, soit `edu.ics4u.<projet>`

Exécuter un projet Maven est assez simple, mais peut nécessiter quelques étapes supplémentaires (ou simplement différentes) par rapport à un simple projet Java bâti avec les outils de base dans Eclipse.

## Utilisation d'un projet Maven

### Si aucune modification n'a été apportée à la structure du projet

Si les seules modifications apportées concernaient du code dans des fichiers existants, le projet devrait s'exécuter comme n'importe quel autre projet, en cliquant sur le bouton "Run".

### Après toute modification à la structure du projet

Ces modifications peuvent être l'ajout de fichiers, l'ajout de dossiers de ressources ou l'ajout de modules externes. Dans ces cas, avant de cliquer sur "Run" :

* Faites un clic droit sur votre projet > Maven > Update Project (ou Alt + F5).


Lorsque vous cliquez sur "Run", le projet peut s'exécuter automatiquement si toutes les dépendances ont été téléchargées et liées précédemment. Sinon, Eclipse peut vous demander de sélectionner une configuration d'exécution. Si tel est le cas, sélectionnez "Maven Build". Cela appliquera tous les paramètres de configuration du projet et téléchargera / liera toutes les dépendances manquantes spécifiées dans le fichier `pom.xml`, mais cela n'exécutera pas nécessairement votre application. Cliquez une deuxième fois sur "Run" et sélectionnez simplement "Application Java". L'application devrait s'exécuter.

Si vous **ajoutez de nouveaux modules externes à votre projet**, assurez-vous d'ajouter les entrées appropriées au fichier `pom.xml` (*pas* à une bibliothèque utilisateur via les outils Eclipse).
* Si vous avez déjà utilisé ces modules dans un autre projet Maven, vous pouvez faire un clic droit sur votre projet > Maven > Add dependency et rechercher le module sur ton disque
* Sinon, vous pouvez utiliser Maven Central pour rechercher le module et copier / coller les informations Maven `pom.xml` dans le fichier `pom.xml` de votre projet. 
  >Il faut se méfier:
  >
  >* La dernière version de Maven Central ne semble pas toujours fonctionner dans Eclipse, vous devrez peut-être choisir une version plus ancienne (comme l'avant dernière).
  >* N'incluez pas les balises d'ouverture / fermeture `<dependencies> </dependencies>` si vous avez déjà des dépendances déclarées dans votre fichier `pom.xml`. Insérez simplement la partie `<dependency> </dependency>` qui décrit votre module.
