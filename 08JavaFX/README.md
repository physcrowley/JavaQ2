# Commencer avec JavaFX

JavaFX est un framework qui gère les interfaces graphiques en Java pour les applications de bureau et Web. Chaque programme JavaFX aura les composants suivants:

* un **graphe de scène** liant tous les éléments de la fenêtre de manière hiérarchique (avec des relations parent-enfant)
* **contrôles** qui réagissent aux interactions des utilisateurs
* comme tous les autres programmes Java, un **point d'entrée** pour l'application. En Java, c'est la méthode `main()`. En JavaFX, c'est la classe qui contient la méthode `main()`. Cette classe `extends` la classe JavaFX `Application` et a une structure prédéfinie.

Pour les programmes JavaFX simples, le graphe de scène est défini dans le point d'entrée, soit la classe d'application.

Pour les programmes JavaFX plus grands ou qui utilisent plusieurs scènes ou fenêtres, le ou les graphes de scène sont définis dans un fichier spécial avec l'extension `.fxml`. Le fichier `fmxl` est similaire aux fichiers `html` qui structurent les sites Web : ils utilisent tous deux des balises imbriquées. De même, les styles peuvent être définis dans le fichier `fxml` directement ou avec un fichier de styles `css`, tout comme le font les pages `html`. Dans ces programmes, au lieu d'être *défini* dans la classe d'application, le graphe de scène est *chargé* à partir du fichier `fxml` par une fonction `FXMLLoader` spéciale dans la classe d'application.

Maven a des archétypes de projet pour les projets JavaFX *simple* et avec *fxml*. Dans la fenêtre `Archetype` de l'assistant de projet Maven d'Eclipse, commencez à taper "openjfx" dans la barre de recherche. Choisissez `javafx-archetype-simple` pour un projet de base ou `javafx-archetype-fxml` pour un projet basé sur fxml.

## e(fx)clipse et Scene Builder

L'extension **e(fx)clipse** Eclipse vous donnera accès à des outils particulièrement utiles pour gérer les fichiers `fxml`.

> Il est également livré avec un modèle de projet JavaFX que vous pouvez utiliser au lieu d'utiliser les archétypes Maven. <p>
> ATTENTION: il est beaucoup plus difficile de partager ce type de projet car chaque développeur a besoin de gérer lui-même les modules JavaFX, ce qui entraîne inévitablement des problèmes lors du `push` et du `pull` depuis GitHub si les configurations de projet sur chaque machine ne sont pas identiques.

L'application **Scene Builder** est un moyen d'écrire des fichiers `fxml` avec un éditeur visuel, en faisant glisser et déposer des éléments sur la scène et en éditant leurs propriétés dans des zones de texte. Le travail effectué visuellement dans Scene Builder est automatiquement traduit dans la syntaxe `fxml` requis par le projet JavaFX. Alternativement, les fichiers `fxml` peuvvent être écrits comme tout autre code: des lignes de texte suivant la syntaxe spéciale.

Consultez les didacticiels vidéo suivants pour l'installation de ces deux logiciels:

* [e(fx)clipse](https://www.loom.com/share/7c38e86ac597464e82d354a35cefdd2d)
* [Scene Builder](https://www.loom.com/share/057266251dc342249132d29f523d0f6b)

## Le "Document Object Model" et le graphe de scène

Le **document object model** ou DOM est un terme qui vient du *javascript* pour décrire la structure des éléments sur un site Web. L'équivalent dans une application *JavaFX* s'appelle le **graphe de scène**. Dans les deux cas, le DOM et le graphe, on décrit la relation entre des objets *parents* et des objets *enfants*.

La base du graphe de scène en JavaFX est toujours pareil parce qu'il y a deux objets spéciaux qui doivent se trouver dans chaque application JavaFX : un `Stage` et une `Scene`.

* Le `Stage` représente la **fenêtre de l'application**. C'est un champ hérité de `javafx.application.Application` et passé comme argument à la méthode `start()`. Le type de fenêtre est déterminé en arrière-plan tenant compte du système d'exploitation.
* La `Scene` représente **l'objet de fond** de la fenêtre. C'est un **contenant** pour les objets visibles et actifs de l'application.

Pour lancer une fenêtre d'application, il faut placer *exactement 1* scène sur le stage. Chaque scène peut soit être *vide* ou avoir *exactement 1* objet à la racine, son objet `Root`.

Les objets `Root` sont des contenants avec des façons différentes d'organiser les objets qui y seront ajoutés : en tas (`StackPane`), comme ruban horizontal (`HBox`), comme ruban vertical (`VBox`), comme matrice (`GridPane`), etc.

Les objets qu'on place dans l'objet `Root` s'appellent des `Node`, comme par exemple une étiquette (`Label`), un bouton (`Button`) ou un champ de texte(`TextBox`). Si l'objet le permet, on peut placer d'autres `Node` dans ces `Node`. Par exemple, l'objet `Root` peut être un `VBox` qui contient un `Label` et un `Hbox` puis le `Hbox` peut contenir un `TextField` et un `Button`.

>Vous pouvez trouver une liste des ces différents objets dans la documentation de JavaFX

Ainsi, après le `Stage` et la `Scene`, la structure de l'application est déterminé par les choix du développeur. Le graphe de scène aura une arborescence qui reflète ces choix. Voici le graphe de scène pour l'exemple précédent :

```
Stage
|
Scene
|
Vbox (Root)
|
|---Label (Node)
|
`---HBox (Node)
    |
    |---TextField (Node)
    |
    `---Button (Node)
```

Dans un programme JavaFX *simple* -> où le graphe de scène est définie dans la `class` qui `extends Application`, on peut obtenir de l'information sur les relations de parenté d'un `Node` spécifique en utilisant les méthodes `.getChildren()` et `.getParent()`.

On peut produire le graphe de scène directement dans la méthode `start()` de notre application JavaFX avec les commandes suivantes :

```java
// les `Nodes`
var text = new TextField();
var button = new Button();
var hbox = new HBox(text, button); // text et button sont enfants de hbox
var label = new Label();
// le `Root`
var vbox = new VBox(label, hbox);  // label et hbox sont enfants de vbox
```

>Noter qu'il faut déclarer les objets les plus bas dans l'arboresence en premier afin de composer les objet plus près de la racine.

Parce que le graphe de scène est hiérarchique, on peut aussi déclarer les `Node` ou le `Root` qui sont composé d'autres `Node` plus explicitement avec la chaîne de méthodes `.getChildren().add()` ou `.getChildren().addAll()`. La méthode `getChildren()` retourne la liste des enfants et les méthodes `add()` et `addAll()` ajoute des éléments à cette liste. Par exemple :

```java
var hbox = new HBox();
hbox.getChildren().addAll(text, button);
```

Finalement, on peut sonder les liens de parenté des `Node`. Par exemple :

```java
label.getParent(); // null (aucun `Node` plus haut... le VBox est un `Root`)
hbox.getChildren(); // retourne la liste contenant les `Node` TextBox et Button
text.getParent(); // retourne le `Node` HBox
```

Pour établir la scène et le stage, on utiliserait les commandes suivantes dans le code (ou vous pouvez repérer des commandes semblables dans les modèles de projet JavaFX), présumant que le `Stage` passé dans la méthode `start()` s'appelle `stage` :

```java
var height = 600;
var width = 800;

var scene = new Scene(vbox, width, height); // `vbox` est spécifié comme le `Root`
stage.setScene(scene); // `scene` est spécifié comme la scène de la fenêtre `stage`
```

### Ressources pour apprendre d'avantage sur les objets JavaFX

* [Tutoriel pour débutats](https://coderslegacy.com/java/javafx-tutorial/)
  * bien structuré avec exemples complets
* [Tutorials Point JavaFX](https://www.tutorialspoint.com/javafx/index.htm)
  * complet, détaillé, profond
* [Javapedia](https://javafxpedia.com/)
  * couvre des stratégies de développement logiciel, présumant une certaine expérience en développement
* [Tutoriel Youtube](https://www.youtube.com/playlist?list=PLS1QulWo1RIaUGP446_pWLgTZPiFizEMq)
  * ignorer 1 et 2 (on le fait différemment avec Maven); 3 à 7 sont essentiels; les autres sont utiles selon ton intérêt

## Les contrôles et les expressions lambda en Java

Les **expressions lambda** sont utilisées pour *implémenter succinctement une méthode décrite dans une interface* avec la syntaxe :

```java
() -> {}
```

Passons à travers chaque élément :

* anonyme : on ne donne pas de nom à la fonction qu'on décrit (parce que le nom de cette fonction est déjà définie ailleurs, dans l'interface)
* `()` : les paramètres, d'aucun à plusieurs, comme pour une fonction normale, mais on n'inclut pas les types des paramètres (parce que les types sont aussi définis dans l'interface)
* `{}` : une ou plusieurs commandes Java qui peuvent retourner ou non une valeur... elles si devraient être simples (pas de nouvelles variables, ni de conditions, ni de boucles)
* opérateur `->` : indique que c'est une expression lambda est donc de prendre le(s) paramètre(s) à la gauche pour les commandes à la droite.

### Utilisation

Les expressions lambda sont utilisées pour *implémenter une interface*, notamment quand :

1. l'interface spécifie seulement une méthode et
2. l'interface est un paramètre à une autre méthode

Dans JavaFX on le voit beacoup avec la méthode `.setOnAction` des boutons et des autres contrôles qui prennent l'interface `EventHandler` comme paramètre.

Voici comment on pourrait définir l'action d'un bouton qui affiche un texte à la console à chaque clic :

#### Sans les expressions lambda

```java
var button = new Button();

button.setOnAction(
    // interface passé comme argument à la méthode setOnAction
    //     son seul but est d'implémenter l'interface `EventHandler`
    new EventHandler<ActionEvent>() {
            
            @Override
            // implémentation de la méthode `handle` de l'interface
            public void handle(ActionEvent e) {
                System.out.println("Hello World!");
            }
        }
    );
```

#### Avec une expression lambda

```java
var button = new Button();

// l'expression lambda qui représente la partie utile de l'exemple précédant
button.setOnAction( e -> System.out.println("Hello World!") );
```

Dans les deux versions, le résultat est le même, mais c'est *beaucoup plus transparent et lisible* avec l'expression lambda. Dans les deux cas, le paramètre `ActionEvent e` représente l'événement (p.ex. un clic). On peut lire l'expression lambda `e -> System.out.println("Hello World!")` comme 'Prend l'événement et fait ceci avec : affiche "Hello World!" à la console'.

#### En général

Plus généralement, les expressions lambda sont utilisées avec les méthodes `.forEach` des collections comme des `List` ou des `Map` et avec les méthodes `.filter` et `.map` qu'on peut utiliser sur un `Stream` de ces collections.

### Quelques tutoriels pour les interfaces

* [Oracle - explications de fond avec exemple JavaFX](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#lambda-expressions-in-gui-applications)
* [W3 Schools - tutoriel rapide pour l'usage général](https://www.w3schools.com/java/java_lambda.asp)

## Définir les styles avec le CSS

>Info à venir
