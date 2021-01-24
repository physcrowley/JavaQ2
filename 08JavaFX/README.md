# Commencer avec JavaFX

---

## Table des matières

* [Introduction](#introduction)
* [Documentation officielle](#documentation-officielle)
* [Outils additionnels pour Eclipse](#outils-additionnels-pour-eclipse)
* [Graphe de scène](#graphe-de-sc%C3%A8ne)
* [Graphes de scène avec FXML](#graphes-de-sc%C3%A8ne-avec-fxml)
* [Contrôles](#contr%C3%B4les)
  * [JavaFX simple](#javafx-simple-et-les-expressions-lambda)
  * [Avec FXML](#javafx-avec-fxml)
* [Styles avec le CSS](#d%C3%A9finir-les-styles-avec-le-css)

--- 

## Introduction

JavaFX est un framework qui gère les interfaces graphiques en Java pour les applications de bureau et Web. Chaque programme JavaFX aura les composants suivants:

* un **graphe de scène** liant tous les éléments de la fenêtre de manière hiérarchique (avec des relations parent-enfant)
* **contrôles** qui réagissent aux interactions des utilisateurs
* comme tous les autres programmes Java, un **point d'entrée** pour l'application. En Java, c'est la méthode `main()`. En JavaFX, c'est la classe qui contient la méthode `main()`. Cette classe `extends` la classe JavaFX `Application` et a une structure prédéfinie.

```java
import javafx.application.Application;
import javafx.stage.Stage;

/** Application minimale JavaFX */
public class App extends Application {

    @Override
    public void start(Stage stage) 
    {
        /* TODO Définir le graphe de scène
        
        Options :
        - ici en ajoutant les composants directement
        - avec des fichiers FXML, en les chargeant ici           */

        /* TODO Spécifier l'action des contrôles

        Options :
        - ici avec des déclarations spécifiques
        - dans d'autres classes, notamment celles liées au FXML  */

        /* TODO Définir la logique du programme

        Options :
        - ici avec des déclarations spécifiques
        - dans cette classe avec des méthodes spécifiques
        - dans d'autres classes, selon le besoin                 */

        stage.show();
    }

    public static void main(String[] args) 
    {
        launch();
    }

}
```

### Programmes simples

Pour les programmes JavaFX simples, le graphe de scène est défini dans le point d'entrée, soit la classe d'application.

### Programmes structurés (avec FXML)

Pour les programmes JavaFX plus grands ou qui utilisent plusieurs scènes ou fenêtres, le ou les graphes de scène sont définis dans un fichier de type FXML. Le fichier FXML est similaire aux fichiers HTML qui structurent les sites Web : ils utilisent tous deux des balises imbriquées. De même, les styles peuvent être définis dans le fichier FXML directement ou avec un fichier de styles CSS, tout comme le font les pages HTML. Dans ces programmes, au lieu d'être *défini* dans la classe d'application, le graphe de scène est *chargé* à partir du fichier FXML par un objet `FXMLLoader` dans la classe de l'application.

### Gabarits de projets

**Maven** a des archétypes de projet pour les projets JavaFX *simple* et avec *fxml*. Dans la fenêtre `Archetype` de l'assistant de projet Maven d'Eclipse, commencez à taper "openjfx" dans la barre de recherche. Choisissez `javafx-archetype-simple` pour un projet de base ou `javafx-archetype-fxml` pour un projet basé sur FXML.

## Documentation officielle

Voici la documentation officielle préparé par OpenJFX pour JavaFX 13.

>⚠ La documentation officielle est souvent très sec et technique. Celle pour JavaFX 13 ne fait pas exception. Les sections ci-dessous sont plus faciles à digérer que le "manuel d'utilisation" produit par OpenJFX, mais c'est parfois nécessaire de s'y référer pour un détail ou un autre.


* [API (Application Programming Interface)](https://openjfx.io/javadoc/13/) - donne la liste de tous les objets avec toutes leurs champs/propriétés et toutes leurs méthodes... mais donne très peu d'exemples
* [FXML](https://openjfx.io/javadoc/13/javafx.fxml/javafx/fxml/doc-files/introduction_to_fxml.html) - traitement en profondeur de comment ça marche, mais c'est orienté vers les programmeurs Web qui ont l'habitude de mélanger des scripts dans leur HTML -> nous voulons seulement décrire le graphe de scène avec nos fichiers FXML et utiliser les fichiers Java pour les scripts
* [CSS](https://openjfx.io/javadoc/13/javafx.graphics/javafx/scene/doc-files/cssref.html) - excellente référence pour toutes les propriétés et leurs valeurs possibles, même si le texte est long

## Outils additionnels pour Eclipse

En travaillant sur des projets JavaFX dans Eclipse, deux outils additionnels sont très pratiques, notamment pour gérer les fichiers FXML :

1. e(fx)clipse
2. Scene Builder

### e(fx)clipse

L'extension e(fx)clipse Eclipse vous donnera accès à des outils particulièrement utiles pour gérer les différents fichiers d'un projet JavaFX.

> Il est également livré avec un modèle de projet JavaFX que vous pouvez utiliser au lieu d'utiliser les archétypes Maven. <p>
> ATTENTION: il est beaucoup plus difficile de partager ce type de projet car chaque développeur a besoin de gérer lui-même les modules JavaFX, ce qui entraîne inévitablement des problèmes lors du `push` et du `pull` depuis GitHub si les configurations de projet sur chaque machine ne sont pas identiques.

### Scene Builder

L'application Scene Builder est un moyen d'écrire des fichiers FXML avec un éditeur visuel, en faisant glisser et déposer des éléments sur la scène et en éditant leurs propriétés dans des zones de texte. Le travail effectué visuellement dans Scene Builder est automatiquement traduit dans la syntaxe FXML requis par le projet JavaFX.

On peut ensuite ouvrir le fichier FXML et l'éditer manuellement au lieu d'écrire toute la structure du graphe de scène de A à Z.

### Installation

Consultez les didacticiels vidéo suivants pour l'installation :

* [e(fx)clipse](https://www.loom.com/share/7c38e86ac597464e82d354a35cefdd2d)
* [Scene Builder](https://www.loom.com/share/057266251dc342249132d29f523d0f6b)

## Graphe de scène

Le **document object model** ou DOM est un terme qui vient du *javascript* pour décrire la structure des éléments sur un site Web. L'équivalent dans une application *JavaFX* s'appelle le **graphe de scène**. Dans les deux cas, le DOM et le graphe, on décrit la relation entre des objets *parents* et des objets *enfants*.

La base d'une application JavaFX est toujours pareille. On commence avec : un `Stage` et une `Scene`.

* Le `Stage` représente la **fenêtre de l'application**. C'est un champ hérité de `javafx.application.Application` et passé comme argument à la méthode `start()`. Le type de fenêtre est déterminé en arrière-plan tenant compte du système d'exploitation (Windows, macOS ou Linux).
* La `Scene` représente **l'objet de fond** de la fenêtre. C'est un **contenant** pour les objets visibles et actifs de l'application.

Pour lancer une fenêtre d'application, il faut placer *exactement 1* scène sur le stage.

C'est la scène qui héberge le graphe de scène. Chaque scène peut soit être *vide* ou avoir *exactement 1* objet à la racine, son objet `Root`. On peut placer aucun à plusieurs éléments comme `Node` enfant à l'objet `Root`. La **structure de tous ces objets** est ce qu'on appelle le graphe de scène.

Donc, après le `Stage` et la `Scene`, la structure de l'application (le graphe de scène) est déterminé par les choix du développeur. Le graphe de scène aura une arborescence qui reflète ces choix.

### Les éléments d'un graphe de scène

Les objets `Root` sont des contenants avec des façons différentes d'organiser les objets qui y seront ajoutés : en tas (`StackPane`), comme ruban horizontal (`HBox`), comme ruban vertical (`VBox`), comme matrice (`GridPane`), etc. Ce sont des objets du module **Graphics**, particulièrement du package `javafx.scene.layout`.

Les objets qu'on place dans l'objet `Root` s'appellent des `Node`, comme par exemple une étiquette (`Label`), un bouton (`Button`) ou un champ de texte (`TextField`). Si l'objet le permet, on peut placer d'autres `Node` dans ces `Node`. Les éléments intéractifs comme les boutons sont des objets du module **Controls**, particulièrement du package `javafx.scene.control`.

>Vous pouvez trouver une liste des ces différents objets dans la documentation du module *java.graphics* de JavaFX, notamment dans les packages [javafx.scene.layout](https://openjfx.io/javadoc/13/javafx.graphics/javafx/scene/layout/package-summary.html) et [javafx.scene.shape](https://openjfx.io/javadoc/13/javafx.graphics/javafx/scene/shape/package-summary.html) et dans la documentation du module *java.controls*, surtout son package [javafx.scene.control](https://openjfx.io/javadoc/13/javafx.controls/javafx/scene/control/package-summary.html).

### Un exemple

Par exemple, l'objet `Root` peut être un `VBox` qui contient un `Label` et un `Hbox` puis le `Hbox` peut contenir un `TextField` et un `Button`.

Voici la structure de l'application JavaFX pour cet exemple :

```
Stage
|
Scene
|
Vbox (Root) ⬅ le graphe de scène commence ici
|
|---Label (Node)
|
`---HBox (Node)
    |
    |---TextField (Node)
    |
    `---Button (Node)
```

Dans un programme JavaFX *simple*, on peut produire ce graphe de scène directement dans la méthode `start()` de notre application JavaFX avec les commandes suivantes :

```java
// les `Nodes`
var text = new TextField();
var button = new Button();
var hbox = new HBox(text, button); // text et button sont enfants de hbox
var label = new Label();
// le `Root`
var vbox = new VBox(label, hbox);  // label et hbox sont enfants de vbox
```

Noter qu'il faut déclarer les objets les plus bas dans l'arboresence en premier afin de composer les objets plus près de la racine.

>Dans les projets structurés avec FXML, le graphe de scène est déclaré autrement, mais ça ressemble plus directement à l'arborescence que nous avons vu plus haut. La [section suivante](#graphes-de-sc%C3%A8ne-avec-fxml) traite spécifiquement du FXML.

### Utiliser les liens de parenté dans le graphe de scène

Parce que le graphe de scène est hiérarchique, on peut aussi déclarer les `Node` ou le `Root` qui sont composés d'autres `Node` plus explicitement avec la chaîne de méthodes `.getChildren().add()` ou `.getChildren().addAll()`. La méthode `getChildren()` retourne la liste des enfants et les méthodes `add()` et `addAll()` ajoutent des éléments à cette liste. Par exemple :

```java
var hbox = new HBox();
hbox.getChildren().addAll(text, button);
```

On peut aussi obtenir de l'information sur les relations de parenté d'un `Node` spécifique en utilisant les méthodes `.getChildren()` et `.getParent()`. Par exemple :

```java
label.getParent(); // null (aucun `Node` plus haut... le VBox est le `Root`)
hbox.getChildren(); // retourne la liste contenant les `Node` TextField et Button
text.getParent(); // retourne le `Node` HBox
```

Ces commandes sont utilisés dans les programmes JavaFX simples et dans les *contrôleurs* des projets JavaFX structurés. Voir [cette section](#javafx-avec-fxml) pour plus d'information sur les contrôleurs.

### Placer le graphe de scène dans l'application

Finalement, pour établir la scène et le stage, on utilise les commandes suivantes dans le code, présumant que le `Stage` passé dans la méthode `start()` s'appelle `stage` :

```java
var height = 600;
var width = 800;

var scene = new Scene(vbox, width, height); // `vbox` est spécifié comme le `Root`
stage.setScene(scene); // `scene` est spécifié comme la scène de la fenêtre `stage`
```

ou
```java
var scene = new Scene();
scene.setRoot(vbox); // définir le `Root` avec une méthode spécifique
scene.setHeight(600);
scene.setWidth(400);

stage.setScene(scene); // `scene` est spécifié comme la scène de la fenêtre `stage`
```

### Quelques tutoriels

Pour des projets JavaFX *simples*, permettant la découverte de différents objets et leurs propriétés :

* [Tutoriel Coder's Legacy](https://coderslegacy.com/java/javafx-tutorial/)
  * bien structuré avec exemples complets est accessibles
* [Tutorials Point](https://www.tutorialspoint.com/javafx/index.htm)
  * détaillé et profond mais sec

Pour des projets JavaFX plus structurés (avec le *FXML*) :

* [Youtube - ProgrammingKnowledge](https://www.youtube.com/playlist?list=PLS1QulWo1RIaUGP446_pWLgTZPiFizEMq)
  * ignorer 1 et 2 (on le fait différemment avec Maven)
  * les autres tutoriels sont super
* [JavaFXpedia](https://javafxpedia.com/)
  * couvre les bases de JavaFX
  * explique aussi différentes stratégies de développement logiciel avec JavaFX (présume une certaine expérience)

## Graphes de scène avec FXML

Lorsqu'un projet passe d'une structure simple à une structure avec des fichiers FXML, c'est parce qu'on veut que les fichiers deviennent plus **spécialisés**.

Fichier | Rôle
--- | ---
App.java | point d'ancrage : lancer l'application et créer des objets centraux (notamment la scène)
*.fxml | décrire les graphes de scène
*Controller.java | définir les actions des contrôles ajoutés au graphe de scène avec un fichier FXML : il y a un fichier de ce type par fichier FXML
*.css | décrire l'apparence / le style des composants dans les graphes de scène : un projet peut avoir un seul fichier CSS global ou plusiers fichiers CSS si les styles de scène varient beaucoup d'une vue à l'autre.

>Les fichiers CSS sont un niveau de spécialisation encore plus profond, car c'est aussi possible de décrire les styles dans les fichiers JAVA et les fichiers FXML. C'est un sujet pour la prochaine leçon.

### Projet simple versus Projet structuré

Consulter les deux exemples suivants. Chacun décrit deux scènes distinctes et fournit un bouton pour changer à l'autre scène.

* [simpleswitch](https://github.com/physcrowley/simpleswitch/tree/main/simpleswitch) - réalisé sans FXML
* [fxmlswitch](https://github.com/physcrowley/fxmlswitch/tree/main/fxmlswitch) - introduit la spécialisation avec FXML

Regarder les **différences** entre les deux projets, notamment :

* le contenu et la taille de la classe principale de l'application (App.java)
  * aucune déclaration des objets sur le graphe de scène dans la version FXML. 
  * On a, par contre, deux nouvelles méthodes : `setRoot` pour changer la scène utilisant le nom du fichier FXML et `loadFXML` pour obtenir le graphe de scène à partir du fichier FXML)
* la structure des dossiers du projet
  * le dossier `main` a juste le sous-dossier `java` dans le projet simple mais aussi un sous-dossier `resources` pour contenir les fichiers FXML dans la version FXML.
* La présence de nouveaux fichiers JAVA dans la version FXML, soit PrimaryController.java et SecondaryController.java, qui sont utilisés pour définir les actions des boutons de chaque scène.

### Comment lire un fichier FXML

Voici le fichier FXML créé via le menu Eclipse : *New... > **Other** > JavaFX > New FXML Document* suivi par une description de ses éléments clés.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.AnchorPane?>

<AnchorPane xmlns:fx="http://javafx.com/fxml/1">
	<!-- TODO Add Nodes -->
</AnchorPane>
```

Partie | Explication
--- | ---
`<?xml version="1.0" encoding="UTF-8"?>` | La première ligne est une déclaration qui spécifie au compilateur le format du document utilisant la combinaison de balises `<?xml` et `?>`
`<?import javafx.scene.layout.AnchorPane?>` | La deuxième ligne est identique à ce que nous faisons dans les fichiers JAVA, soit déclarer les autres classes nécessaires, les `import`. Le *langage* est identique à ce que nous faisons dans Java, mais la *syntaxe* de la déclaration est comme celle de la première ligne : au lieu de terminer avec `;`, la déclaration est indiquée par les balises `<?import` et `?>`.
`<AnchorPane ...>` ... `</AnchorPane>` | Ces balises définissent l'élément `AnchorPane`, le début - le `Root` - de notre **graphe de scène**.
`xmlns:fx = "http://javafx.com/fxml/1"` | C'est le seul attribut définie par défaut pour l'`AnchorPane`. On déclare ce qui s'appelle un ***namespace** avec la partie `xmlns:fx = "http://javafx.com/fxml/1"`. Le mot-clé `xmlns:` (XML namespace) est nécessaire. L'URL n'a pas d'importance, mais doit être unique dans le document. La partie qui compte pour les projets JavaFX est ce qui vient après `xmlns:` soit `fx`. Le compilateur reconnaîtera tous les éléments identifiés avec `fx` comme des objets JavaFX et les ajoutera au graphe de scène.
`<!-- TODO Add Nodes -->` | Cette ligne est un commentaire. On peut ajouter des commentaires n'importe où avec les caractères initiaux `<!--` et finaux `-->`.

>Heureusement, vous n'aurez jamais à créer un document comme ça de rien parce qu'un modèle de base est toujours disponible soit via *e(fx)clipse* ou via les archétypes *Maven*.

#### Syntaxe générale

Tous les éléments JavaFX, comme n'importe quel élément XML, seront définis par des **balises** ("tags" en anglais). Les balises XML suivent le format `<élément attribut="valeur">` ... `</élément>` où :

* l'**élément** est un nom que le programme qui utilise le fichier XML reconnaîtera. S'il est dans le *namespace* `fx`, on saura qu'il faut chercher l'élément correspondant dans les classes JavaFX.
* les **attributs** sont un nombre restreint de caractéristiques, comme un *namespace* ou un style, qui sont déclarées avant de fermer la balise initiale.
* on assigne à chaque attribut une **valeur** entre guillemets avec la syntaxe `attribut="valeur"`
* pour la balise finale, le nom de l'élément est précédé par le symbole `/`. Donc, `<AnchorPane>` pour ouvrir et `</AnchorPane>` pour fermer.

#### Exemple plus complet

Voici le fichier primary.fxml de l'archétype Maven "javafx-archetype-fxml".

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Button?>
<?import javafx.geometry.Insets?>

<VBox alignment="CENTER" spacing="20.0" 
      xmlns="http://javafx.com/javafx/8.0.171" 
      xmlns:fx="http://javafx.com/fxml/1" 
      fx:controller="edu.djc.fxmlswitch.PrimaryController">

   <children>
      <Label text="Primary View" />
      <Button fx:id="primaryButton" text="Switch to Secondary View" onAction="#switchToSecondary"/>
   </children>

   <padding>
      <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
   </padding>

</VBox>
```

On reconnaît la structure de base d'un fichier FXML. Voici quelques nouveaux éléments à remarquer :

Partie | Remarques
--- | ---
l'attribut `fx:controller` du `Root` | spécifie le **nom pleinement qualifié** de la classe Java qui contient tout le code pour contrôler cet élément *et ses enfants*. Ici, la classe `PrimaryController` du package `edu.djc.fxmlswitch` est nommée.
`<VBox ...>` ... `</VBox>` | tout ce qui concerne les éléments inférieurs à `VBox` dans le graphe de scène se trouve *entre* les balises initiale et finale du `VBox`
`<children>` ... `</children>` | entoure les enfants de l'élément `VBox` (le `Label` et le `Button`)
attribut `text` | spécifie le texte à afficher sur un élément du graphe de scène
attribut `fx:id` | spécifie le **nom de variable** à utiliser dans le contrôleur JAVA pour référer à cet objet. p. ex. `Button`: `fx:id="primaryButton"`. <p> Dans PrimaryController.java, si on veut modifier les attributs du bouton, on trouvera la ligne `@FXML Button primaryButton;` où l'annotation `@FXML` dit au compilateur que cet objet est défini dans le fichier FXML. On pourra alors utiliser la variable `primaryButton` dans le code pour manipuler l'objet `Button` dans le graphe de scène.
attribut `onAction` | remplace le `setOnAction()` des programmes JavaFX simples. La valeur est une référence à une méthode spécifique. p. ex. `onAction="#switchToSecondary"` pointe à `switchToSecondary()` qui doit être définie dans la classe contrôleur `edu.djc.fxmlswitch.PrimaryController`. <p> ❗ le `#` devant le nom est essentiel

>Il y a d'autres éléments et attributs dans le fichier liés à l'apparence. On les laisse pour la leçon sur le CSS.

>Noter une syntaxe *raccourcie* pour les balises `Label` et `Button` qui n'avaient aucune propriété interne à spécifier : `<Label text="Primary View" />` au lieu de `<Label text="Primary View"> </Label>`. C'est une syntaxe acceptable.

### Utiliser Scene Builder

Quand le logiciel Scene Builder est installé, au lieu d'éditer le fichier FXML directement dans l'éditeur de texte, on peut l'éditer visuellement :

* en cliquant et déplaçant différents éléments sur la `Scene`
* en spécifiant le contrôleur du `Root` via un menu
* en spécifiant la méthode `onAction` via un menu
* en spécifiant d'autres attributs et propriétés via des menus

Scene Builder nous permet de prévisualiser le résultat avant de retourner dans l'EDI.

En sauvegardant le fichier FXML dans Scene Builder, on peut voir ces changements dans notre EDI et observer les ajouts et les modifications aux balises, aux attributs et aux propriétés de la structure XML. On peut alors ajuster les paramètres manuellement sans avoir à créer toute la structure du graphe de scène manuellement.

## Contrôles

Tous les éléments interactifs dans le graphe de scène  - p. ex. des `Button`, des `MenuItem` et des `TextField` - génèrent des événements qui doivent être gérés dans le code.

En JavaFX, les événements sont des **interfaces** de type `EventHandler` qui ont une méthode `handle` que le développeur doit implémenter.

>*Implémenter* veut dire "écrire le code spécifique" ou "écrire quoi faire quand la méthode est appelée".

### JavaFX simple et les expressions lambda

Dans un programme JavaFX *simple* on spécifie souvent quoi faire avec un outil qui s'appelle une **expression lambda**. Une expression lambda est une façon très courte d'implémenter (écrire le code pour) une méthode d'une interface. Les expressions lambda ont la syntaxe :

```java
() -> {}
```

Où on peut voir les choses suivantes :

* anonyme : on ne donne pas de nom à la fonction qu'on décrit (parce que le nom de cette fonction est déjà définie ailleurs, dans l'interface)
* `()` : les paramètres, d'aucun à plusieurs, correspondant à la signature de la méthode dans l'interface, mais on n'inclut pas les types (parce que les types sont aussi définis dans l'interface)
* `{}` : une ou plusieurs commandes Java qui peuvent retourner ou non une valeur selon la signature de la méthode dans l'interface... ces commandes doivent être simples (pas de nouvelles variables, ni de conditions, ni de boucles)
* opérateur `->` : indique que c'est une expression lambda est donc de prendre le(s) paramètre(s) à la gauche pour les commandes à la droite.

#### Utilisation

Les expressions lambda sont utilisées pour *implémenter une interface*, notamment quand :

1. l'interface spécifie seulement une méthode et
2. l'interface est un paramètre à une autre méthode

Dans JavaFX on le voit beacoup avec la méthode `.setOnAction` des boutons et des autres contrôles qui prennent l'interface `EventHandler` comme paramètre.

Voici comment on pourrait définir l'action d'un bouton qui affiche un texte à la console à chaque clic :

##### Sans les expressions lambda

```java
var button = new Button();

// implémentation explicite de la méthode `handle` de l'interface `EventHandler`
button.setOnAction( 
    new EventHandler<ActionEvent>() {
        
        @Override public void handle(ActionEvent e) {
            System.out.println("Hello World!");
        }
    }
);
```

##### Avec une expression lambda

```java
var button = new Button();

// l'expression lambda implémente la méthode `handle` implicitement
button.setOnAction( (e) -> {System.out.println("Hello World!");} );
```

>Parce que l'expression inclut seulement un paramètre et seulement une déclaration, elle peut être simplifiée encore à : <p> `button.setOnAction( e -> System.out.println("Hello World!") );` <p> C'est un cas très commun.

Sans ou avec expression lambda, le résultat est le même, mais le code est *beaucoup plus transparent et lisible* avec l'expression lambda. Dans les deux cas, le paramètre `ActionEvent e` représente l'événement (p.ex. un clic). On peut lire l'expression lambda `e -> System.out.println("Hello World!")` comme 'Lorsqu'il y a un ActionEvent e, affiche "Hello World!" à la console'.

##### En général

Plus généralement, les expressions lambda sont utilisées avec les méthodes `.forEach` des collections comme des `List` ou des `Map` et avec les méthodes `.filter` et `.map` qu'on peut utiliser sur un `Stream` de ces collections.

#### Tutoriels pour les expressions lambda

* [Oracle - explications de fond avec exemple JavaFX](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#lambda-expressions-in-gui-applications)
* [W3 Schools - tutoriel rapide pour l'usage général](https://www.w3schools.com/java/java_lambda.asp)

### JavaFX avec FXML

La façon de gérer les actions dans un projet structuré avec des fichiers FXML est différent, parce que l'interface `ActionEvent` est caché dans la communication entre le fichier FXML et le fichier JAVA qui le contrôle.

Dans ces projets, on a - en plus du fichier JAVA de la classe qui `extends Application` - les deux fichiers suivants :

* `<nom>.fxml` - qui décrit le graphe de scène
* `<nom>Controller.java` - qui fournit le code pour les contrôles dans le graphe de scène.

Présumant un graphe de scène comportant un `AnchorPane` comme `Root` et un `Button` comme contrôle, le fichier FXML (disons `primary.fxml`) contiendra (entre autres) les lignes suivantes :

```xml
<AnchorPane xmlns:fx="www.javafx.com" 
            fx:controller="edu.ics4u.exemple.PrimaryController">
    <children>
        <Button text="Say Hello" onAction="#sayHello"/>
    </children>
</AnchorPane>
```

Il y a deux éléments importants dans ce code :

* l'attribut `fx:controller` de l'AnchorPane qui nomme la classe `PrimaryController` dans le package `edu.ics4u.exemple` -> on dit au programme quel fichier JAVA utiliser pour les contrôles.
* l'attribut `onAction` du bouton qui désigne la méthode `sayHello()` comme son implémentation de l'interface `EventHandler`. La méthode `sayHello()` doit être définie dans la classe `PrimaryController`

On regarde alors la classe `PrimaryController` qui va contenir (entre autres) les lignes suivantes :

```java
@FXML
private void sayHello()
{
  System.out.println("Hello!");
}
```

Les deux éléments importants ici sont :

* l'annotation `@FXML` qui dit au compilateur de voir dans le fichier FXML pour déterminer quel contrôle utilise la méthode.
* le nom de la méthode `sayHello()` qui doit être identique à la valeur passée à l'attribut `onAction` du bouton

#### ⚠ Méthodes sans paramètres additionnels

Les deux options de signatures pour nos méthodes de contrôle sont :

1. `<nomDuControle>()` - sans paramètres
2. `<nomDuControle>(ActionEvent e)` - avec l'objet de l'événement comme paramètre

On utilise la 2e option si on a besoin d'utiliser les informations disponibles dans l'objet `ActionEvent` (p. ex. la position de la souris, la touche pressé).

Souvent, on utilise la version sans paramètres, comme pour les simples clics de bouton.

Par contre, si on a besoin d'utiliser d'autres valeurs ou objets de notre programme dans la méthode, cela veut dire qu'on ne peut pas les passer comme arguments à la méthode. Il faut qu'ils soient **déclarés comme variables privés de la classe** `<nom>Controller`. Ainsi, ces variables deviennent disponibles à l'intérieur de toutes les méthodes de la classe, incluant celles pour les contrôles.

## Définir les styles avec le CSS

### Référence principale

[Java CSS Reference Guide](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html)

Voici le site pour trouver comment appliquer les styles aux différents éléments d'un graphe de scène. Là, on trouve les noms et les valeurs pour tous les styles qu'on peut modifier pour chaque type d'objet possible dans un graphe de scène JavaFX.

>Noter que le CSS utilisé ici est très semblable au CSS utilisé pour les sites Web mais qu'il y a quelques différences, notamment le préfixe `fx` sur chacune des propriétés.

>Pour des références sur le CSS et le HTML, les tutoriels de [W3Schools](https://www.w3schools.com/Css/css_intro.asp) sont fortement recommandés.

### Exemple

Voici un exemple simple de fichier CSS pour les projets JavaFX.

```css
.root {
  -fx-background-color: mediumaquamarine;
  -fx-font-family: 'monospace';
}

.button {
  -fx-padding: 20;
}

/* un commentaire */
#btn1 {
  -fx-background-color: crimson;
}
```

Partie | Description
--- | ---
`.root`, `.button`  | Fait référence à **tous les objets JavaFX d'un même type** avec la notation `.<type>` où toutes les lettres sont en minuscule. Ainsi les styles spécifiés par le bloc `.root` s'appliquent à *tous* les objets dans le graphe de scène et les styles spécifiés par le bloc `.button` s'appliquent à tous les objets `Button` dans le graphe de scène. Les `Button` appliquent les deux ensembles de styles, les styles spécifiés par `.button` ayant priorité en cas de conflit.
`#btn1` | Fait référence au **nom de variable d'un objet**, ou si le nom est spécifié dans un fichier FXML, à son attribut `fx:id="<nom>"`. Ainsi, si le nom "btn1" réfère à un `Button`, les styles spécifiés par .`root`, `.button` **et** par `#btn1` seront tous appliqués, les styles pour `#btn1` ayant priorité en cas de conflit.
`-fx-padding: 20;` | Combinaison `<propriété>: <valeur>;` qui donne la spécification pour un élément de style. Les propriétés appliquables et les valeurs qu'elles acceptent sont décrites dans la référence Java CSS plus haut.
`/* ... */` | On peut ajouter des commentaires en entourant le texte par ces symboles, les mêmes que pour les commentaires multilignes en Java.

### Organisation des fichiers CSS dans le projet

⚠ C'est important de placer les fichiers CSS avec les fichiers FXML dans le dossier **"src/main/ressources"** du projet créé avec l'archétype Maven "javafx-archetype-fxml".

Avec la configuration de cet archétype Maven, les fichiers dans le dossier "src/main/ressources" seront **copiés** dans le même dossier que les fichiers `.class`. Cela permet au programme de les trouver relativement à la classe principale `App.class` lors de l'exécution du programme.

Voici une vue *partielle* de la structure sur le disque d'un projet utilisant cet archétype :

```
Projet
|---src/main/
|   |---java ⬅ Fichiers Java ici
|   |   `---edu/ics4u/exemple
|   |       |---App.java
|   |       |---PrimaryController.java
|   |       `---SecondaryController.java
|   `---ressources ⬅ Autres fichiers ici
|       `---edu/ics4u/exemple
|           |---app.css ⬅ le CSS ici
|           |---primary.fxml
|           `---secondary.fxml
|---target/classes/ ⬅ Fichiers compilés et copiés ici
|   `---edu/ics4u/exemple
|       |---App.class
|       |---app.css
|       |---primary.fxml
|       |---PrimaryController.class
|       |---secondary.fxml
|       `---SecondaryController.class
...

```

On voit que les contenus du même package sont placés ensemble dans le même dossier de sortie. C'est important, parce qu'on peut utiliser l'adresse d'`App.class` dans notre programme pour aller chercher les autres ressources au besoin.

### Utiliser un fichier CSS dans le programme

#### Avec un fichier CSS pour tout le programme

>Cette méthode s'applique avec les projets JavaFX simples ou structurés avec fichier FXML.

Avec un seul fichier CSS qui s'applique à l'ensemble du programme, on veut normalement lier le fichier CSS directement à la `Scene` du projet. La façon la plus simple est dans la méthode `start()` avec la commande suivante :

```java
// scene.getStylesheets.add(cheminDuFichier)
scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
```

*Wow!!!* Regardons ça en petites bouchées.

La partie `scene.getStylesheets.add()` fait exactement ce qui ça dit. La méthode `add()` prend le chemin au fichier CSS comme argument. C'est là que la commande devient plus compliqué.

Voici une analyse de comment `this.getClass().getResource("app.css").toExternalForm()` retourne le chemin complet du fichier "app.css" (son `url`) utilisant la classe principale du programme comme repère :

1. `this.getClass()` retourne le nom de la classe principale (`this`) sur le disque dur. Ce nom aura la forme de `<Nom>.class`, par exemple `App.class`
2. `getResource()` cherche un fichier suivant le chemin relatif à la position de la classe principale
3. `"app.css"` est le chemin relatif, présumant qu'un fichier nommé "app.css" se trouve dans le même dossier que la classe principale
4. `.toExternalForm()` retourne l'URL (le chemin). Sans ça, `getResource()` retourne l'objet fichier lui-même et non son adresse. 

>L'URL est le chemin *complet* sur le disque, alors le résultat sera différent sur chaque ordinateur. C'est pourquoi on utilise la classe principale du programme comme repère au lieu de fournir le chemin directement.

On voit aussi un appel semblable dans le code de démarrage de l'archétype "javafx-archetype-fxml", dans la méthode `loadFXML()` qui ajoute le fichier FXML au programme. C'est la partie :

```java
App.class.getResource(fxml + ".fxml")
```

où `fxml + ".fxml"` s'évalue à un nom de fichier, soit "primary.fxml" ou "secondary.fxml". Cette ligne de code veut dire :

1. `App.class` -> la classe principale (ce que `this.getClass()` retourne)
2. `.getResource()` -> trouve le fichier suivant un URL (un chemin) relatif à `App.class`
3. `fxml + ".fxml"` -> utilisant ce chemin. On ne spécifie pas de dossier parce que les fichiers FXML sont copiés dans le même dossier que les fichiers `.class` avec la configuration du projet Maven.

>Dans ce cas, on voulait charger le fichier lui-même alors la partie `toExternalForm()` qui retourne l'adresse du fichier n'est pas nécessaire.

#### Avec un fichier CSS pour chaque fichier FXML

C'est aussi possible d'écrire de nombreux fichiers CSS pour le même programme, notamment en assignant un fichier CSS par fichier FXML.

>Cela est déconseillé si l'objectif est une apparence uniforme d'une vue à l'autre dans l'application, mais peut être utile si la vue doit changer considérablement.

On le fait en ajoutant l'attribut suivant à l'élément `Root` du FXML :

```xml
...
<!-- VBox est l'objet `Root` du graphe de scène -->
<VBox stylesheets="@app.css" ... >
    ...
</VBox>
```

*Les `...` indiquent que des partie du fichier FXML n'ont pas été inclus afin de rendre l'exemple plus facile à lire.*

>⚠ Le symbole `@` est critique devant le chemin. Le code ne fonctionne pas sans ça.

Et *voila!* Dans ce cas, on spécifie le chemin du fichier CSS **relativement au fichier FXML**. Le programme va charger le fichier CSS si un fichier "app.css" est dans le même dossier que ce fichier FXML. Placer les fichiers FXML et CSS ensemble est recommandé.

>Parce qu'on modifie un fichier FXML, c'est aussi possible de faire ça avec Scene Builder. On ouvre le fichier, sélectionne l'objet `Root` du côté gauche et choisie le fichier CSS souhaité pour l'attribut "Stylesheets" sur le côté droit.
