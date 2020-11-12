# Structure de dossiers d'un projet standard

**Principe de base**

>_On sépare les fichiers de code source (`.java`) des fichiers bytecode (`.class`). Cela simplife l'emballage._
>
>* on emballe le dossier `bin` qui contient les fichiers bytecode `.class` pour distribuer notre programme à des utilisateurs
>* on emballe le dossier `src` qui contient le code source `.java` pour collaborer avec d'autres développeurs


# Les packages en Java

**Principe de base**

>_On se crée un package unique pour distinguer nos classes, qui peuvent porter le même nom que d'autres classes, afin de bien guider l'ordinateur vers le bon code._

Par exemple, la classe `Duration` est définie dans plusieurs librairies Java pour différentes fins. Voici deux exemples :

```
java.time.Duration
javafx.util.Duration
```

Dans cet exemple, les deux packages sont `java.time` et `javafx.util`.

Si on utilise juste le nom `Duration` il y aura confusion, mais si on utilise le **nom pleinement qualifié** - le nom incluant le package - c'est impossible que l'ordinateur se mélange entre `java.time.Duration` et `javafx.util.Duration`.


## Créer des packages

**Sur le disque dur**

Un package sur le disque dur est simplement une cascade de dossiers. Ainsi, si tu cherches dans le code source qui se trouve dans votre installation de Java, tu trouveras la structure suivante :

```
src
|---...
|---java
|   |---...
|   `---time
|       |---...
|       |---Duration.java
|       `---...
`---...
```

Donc le **chemin** pour `Duration.java` à l'intérieur du dossier `src` est `java/time/Duration.java`.


**Dans le code**

Dans nos fichiers `.java` on spécifie les packages avec la notation _dot (.)_ et le mot-clé **package**.

Continuons notre exemple avec la classe `Duration` qui se trouve via le chemin `java/time/Duration.java`. Le package pour `Duration.java` est `java.time`. En ouvrant `Duration.java`, on peut voir que la première ligne qui n'est pas un commentaire est :

```java
package java.time;
```

Donc le **package** est quelque chose qui est déclaré dans le code et reconnu par la Java Virtual Machine. Lors de la compilation et de l'exécution des programmes, le package est traduit à un chemin sur le disque dur pour trouver le bon code source.

**À retenir**
>_Le chemin d'un fichier `.java` et son nom de package ont la **même structure**, mais le **chemin** fait référence aux dossiers concrets et utilise des barres obliques (/) tandis que le **package** est déclaré dans le code utilisant des points (.)._

## Meilleures pratiques

>La structure d'un package est normalement comme _l'URL d'un site internet à l'envers_ : `<domaine>.<nom>.<section>` par exemple `com.google.docs`.

>Les noms dans les packages sont généralement tous en **minuscules**.

Je recommande que tu choisisses la structure de package suivante pour ton travail dans ce cours : `edu.<pseudo ou initiales>.<projet>`. Par exemple, j'utilise `edu.djc.<projet>` ou `edu.ics4u.<projet>` pour les exemples que je fais en classe.

Pour tes projets personnels, tu pourras choisir un autre domaine comme la base de tes noms de package, par exemple, `com.djc.moneymaker`.


**1. Dossier de projet**

Commence par créer le dossier de projet avec un sous-dossier `src` et un sous-dossier `bin`.

```
<MonProjet>
|---bin
`---src
```


**2. Fichiers du projet**

Ensuite, crée le premier fichier `.java` du projet. Voici les étapes à suivre :

1. Toujours créer ce fichier dans la racine du dossier `src`.
2. Écrire la déclaration du package tout de suite, par exemple : `package edu.djc.test;`
3. VS Code va signaler une erreur avec cette déclaration parce que la déclaration du package ne correspond pas à la structure des dossiers. Pas de stress! VS Code nous propose aussi des "Quick Fix" (`Ctrl + .`).
4. Dans les Quick Fix, choisir l'option _"Move `<Nom>.java` to package `<package déclaré>`"_. La structure de dossier sera créé pour toi!


>**Attention! Problème commun**
>
>Si le Quick Fix propose de bouger ton fichier au package `src/<package déclaré>` ou si tu as des avertissements que _"The declared package '`<package déclaré>`' does not match the expected package"_, il faut que tu nettoies le workspace comme suit :
>    1. Fait `Ctrl + Shift + P`
>    2. Tape "Clean" ou "Clean Java" et l'option _"Java: Clean the Java language server workspace"_ apparaîtra.
>    3. Clique sur cette option et accepte de supprimer et redémarrer le workspace.
>    4. Essaie le Quick Fix à nouveau. Il devrait maintenant reconnaître la structure de base du projet avec un dossier `src` qui ne fait pas partie des packages. Les avertissements disparaîtront.


Par exemple, si je crée le fichier `App.java` avec la déclaration de package

```java
package edu.ics4u.impressionnant;
```

mon dossier de projet ressemblera à ceci après avoir créé la structure de dossier avec le Quick Fix (ou manuellement).

```
<MonProjet>
|---bin
`---src
    `---edu
        `---ics4u
            `---impressionant
                `---App.java
```

mais VS Code l'affichera probablement comme ceci :

```
<MonProjet>
|---bin
`---src/edu/ics4u/impressionant
    `---App.java
```


# La compilation d'un projet avec cette structure

Dans le projet simple, où le dossier de projet n'a aucune structure interne, on pouvait créer un seul fichier `.java`, par exemple `Main.java`, et le compiler et l'exécuter avec les commandes suivantes à la console :

```
javac Main.java
java Main
```

et le résultat suivant en termes de fichiers dans le dossier :

```
ProjetSimple
|---Main.class
`---Main.java
```

>Cela **ne fonctionne plus** avec notre structure de projet standard!


## Options pour la machine virtuelle Java

**La solution**

>La solution est de déclarer un paramètre lors de la compilation qui spécifie le dossier où on veut placer nos fichiers compilés.

* Pour la **compilation**, l'option est `-d` (pour dossier/directory) et on donne le nom du dossier `bin` comme valeur. On complète l'appel au compilateur en spécifiant le chemin complet jusqu'à notre fichier Java.
* Pour l'**exécution**, l'option est `-cp` (pour classpath) et on donne encore le dossier `bin` comme valeur suivi par le _nom pleinement qualifié_ (incluant le package) de notre classe.

**Voici un exemple**. Si on a une classe `Main.java` dans le package `edu.ics4u.projet` et la structure de notre projet est la structure standard, soit :

```
ProjetStandard
|---bin
`---src/edu/ics4u/projet
    `---Main.java
```

Alors on va passer les commandes suivantes à la console pour compiler et exécuter notre programme :

```
javac -d bin src/edu/ics4u/projet/Main.java
java -cp bin edu.ics4u.projet.Main
```

>Remarque que lors de la compilation (`javac`) il faut spécifier le chemin entier vers le fichier qu'on veut compiler tandis que lors de l'exécution (`java`) on fournit juste le nom pleinement qualifié de notre classe.

Le résultat dans notre structure de dossier est le suivant :

```
ProjetStandard
|---bin/edu/ics4u/projet
|   `---Main.class
`---src/edu/ics4u/projet
    `---Main.java
```

>Remarque que la structure de dossier correspondant à notre déclaration de package a été dupliquée dans le dossier `bin` automatiquement lors de la compilation.