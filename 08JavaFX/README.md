# Commencer avec JavaFX

## Table des matières

* [e(fx)clipse et Scene Builder](#efxclipse-et-scene-builder)
* [Le graphe de scène](#le-graphe-de-sc%C3%A8ne)
* [Contrôles avec les expressions lambda](#les-contr%C3%B4les-et-les-expressions-lambda-en-java)
* [Travailler avec les fichiers FXML](#travailler-avec-les-fichiers-fxml)
* [Styles avec le CSS](#d%C3%A9finir-les-styles-avec-le-css)

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
        - avec des fichiers fxml, en les chargeant ici           */

        /* TODO Spécifier l'action des contrôles

        Options :
        - ici avec des déclarations spécifiques
        - dans d'autres classes, notamment celles liées au fxml  */

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

Pour les programmes JavaFX simples, le graphe de scène est défini dans le point d'entrée, soit la classe d'application.

Pour les programmes JavaFX plus grands ou qui utilisent plusieurs scènes ou fenêtres, le ou les graphes de scène sont définis dans un fichier de type `fxml`. Le fichier `fmxl` est similaire aux fichiers `html` qui structurent les sites Web : ils utilisent tous deux des balises imbriquées. De même, les styles peuvent être définis dans le fichier `fxml` directement ou avec un fichier de styles `css`, tout comme le font les pages `html`. Dans ces programmes, au lieu d'être *défini* dans la classe d'application, le graphe de scène est *chargé* à partir du fichier `fxml` par une fonction `FXMLLoader()` spéciale dans la classe d'application.

Maven a des archétypes de projet pour les projets JavaFX *simple* et avec *fxml*. Dans la fenêtre `Archetype` de l'assistant de projet Maven d'Eclipse, commencez à taper "openjfx" dans la barre de recherche. Choisissez `javafx-archetype-simple` pour un projet de base ou `javafx-archetype-fxml` pour un projet basé sur fxml.

## e(fx)clipse et Scene Builder

L'extension **e(fx)clipse** Eclipse vous donnera accès à des outils particulièrement utiles pour gérer les fichiers `fxml`.

> Il est également livré avec un modèle de projet JavaFX que vous pouvez utiliser au lieu d'utiliser les archétypes Maven. <p>
> ATTENTION: il est beaucoup plus difficile de partager ce type de projet car chaque développeur a besoin de gérer lui-même les modules JavaFX, ce qui entraîne inévitablement des problèmes lors du `push` et du `pull` depuis GitHub si les configurations de projet sur chaque machine ne sont pas identiques.

L'application **Scene Builder** est un moyen d'écrire des fichiers `fxml` avec un éditeur visuel, en faisant glisser et déposer des éléments sur la scène et en éditant leurs propriétés dans des zones de texte. Le travail effectué visuellement dans Scene Builder est automatiquement traduit dans la syntaxe `fxml` requis par le projet JavaFX. Alternativement, les fichiers `fxml` peuvvent être écrits comme tout autre code: des lignes de texte suivant la syntaxe spéciale.

Consultez les didacticiels vidéo suivants pour l'installation de ces deux logiciels:

* [e(fx)clipse](https://www.loom.com/share/7c38e86ac597464e82d354a35cefdd2d)
* [Scene Builder](https://www.loom.com/share/057266251dc342249132d29f523d0f6b)

## Le graphe de scène

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

>Noter qu'il faut déclarer les objets les plus bas dans l'arboresence en premier afin de composer les objets plus près de la racine.

Parce que le graphe de scène est hiérarchique, on peut aussi déclarer les `Node` ou le `Root` qui sont composé d'autres `Node` plus explicitement avec la chaîne de méthodes `.getChildren().add()` ou `.getChildren().addAll()`. La méthode `getChildren()` retourne la liste des enfants et les méthodes `add()` et `addAll()` ajoutent des éléments à cette liste. Par exemple :

```java
var hbox = new HBox();
hbox.getChildren().addAll(text, button);
```

On peut aussi obtenir de l'information sur les relations de parenté d'un `Node` spécifique en utilisant les méthodes `.getChildren()` et `.getParent()`. Par exemple :

```java
label.getParent(); // null (aucun `Node` plus haut... le VBox est un `Root`)
hbox.getChildren(); // retourne la liste contenant les `Node` TextBox et Button
text.getParent(); // retourne le `Node` HBox
```

Finalement, pour établir la scène et le stage, on utiliserait les commandes suivantes dans le code (ou vous pouvez repérer des commandes semblables dans les modèles de projet JavaFX), présumant que le `Stage` passé dans la méthode `start()` s'appelle `stage` :

```java
var height = 600;
var width = 800;

var scene = new Scene(vbox, width, height); // `vbox` est spécifié comme le `Root`
stage.setScene(scene); // `scene` est spécifié comme la scène de la fenêtre `stage`
```

### Ressources sur les composants JavaFX et la structure de projets JavaFX

La découverte des différents composants est laissé à votre curiosité et besoin. Voici quelques ressources utiles à cette fin :

* [Tutoriel pour débutats](https://coderslegacy.com/java/javafx-tutorial/)
  * bien structuré avec exemples complets
* [Tutoriel Youtube](https://www.youtube.com/playlist?list=PLS1QulWo1RIaUGP446_pWLgTZPiFizEMq)
  * ignorer 1 et 2 (on le fait différemment avec Maven); 3 à 7 sont essentiels; les autres sont utiles selon ton intérêt
* [Tutorials Point JavaFX](https://www.tutorialspoint.com/javafx/index.htm)
  * complet, détaillé, profond
* [Javapedia](https://javafxpedia.com/)
  * couvre des stratégies de développement logiciel avec JavaFX, présumant une certaine expérience en développement

## Les contrôles et les expressions lambda en Java

Les **expressions lambda** sont utilisées pour *implémenter succinctement une méthode décrite dans une interface* avec la syntaxe :

```java
() -> {}
```

Passons à travers chaque élément :

* anonyme : on ne donne pas de nom à la fonction qu'on décrit (parce que le nom de cette fonction est déjà définie ailleurs, dans l'interface)
* `()` : les paramètres, d'aucun à plusieurs, comme pour une fonction normale, mais on n'inclut pas les types des paramètres (parce que les types sont aussi définis dans l'interface)
* `{}` : une ou plusieurs commandes Java qui peuvent retourner ou non une valeur... elles devraient être simples (pas de nouvelles variables, ni de conditions, ni de boucles)
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

### Quelques tutoriels pour les expressions lambda

* [Oracle - explications de fond avec exemple JavaFX](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#lambda-expressions-in-gui-applications)
* [W3 Schools - tutoriel rapide pour l'usage général](https://www.w3schools.com/java/java_lambda.asp)

## Travailler avec les fichiers FXML

Lorsqu'un projet passe d'une structure simple à une structure avec des fichiers FXML, c'est parce qu'on veut que les fichiers deviennents plus **spécialisés**.

Fichier | Rôle
--- | ---
App.java | point d'ancrage : lancer l'application et créer des objets centraux
*.fxml | décrire les graphes de scène
*Controller.java | définir les actions des contrôles décrites dans un fichier `fxml` : il y a généralement un fichier de ce type par fichier `fxml`
*.css | décrire l'apparence des composants dans les graphes de scène : un projet peut avoir un seul fichier `css` global ou plusiers fichiers `css` si les styles de scène varient beaucoup d'une vue à l'autre.

>Les fichiers `css` sont un niveau de spécialisation encore plus profond, car c'est possible de décrire les styles dans les fichiers `fxml` aussi. C'est un sujet pour la prochaine leçon.

### Comparaison avec le projet simple

Consulter les deux exemples suivants. Chacun décrit deux scenes distinctes et fournit un bouton pour changer à l'autre scène. Dans un cas, c'est fait sans `fxml` et dans le deuxième, on introduit la spécialisation avec des fichiers `fxml`.

* [simpleswitch](https://github.com/physcrowley/simpleswitch/tree/main/simpleswitch)
* [fxmlswitch](https://github.com/physcrowley/fxmlswitch/tree/main/fxmlswitch)

### Structure d'un fichier FXML de base

Voici le fichier `fxml` créer via le menu Eclipse : New... > **Other** > JavaFX > New FXML Document.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.AnchorPane?>

<AnchorPane xmlns:fx="http://javafx.com/fxml/1">
	<!-- TODO Add Nodes -->
</AnchorPane>
```

#### Analyse du fichier

Partie | Explication
--- | ---
`<?xml version="1.0" encoding="UTF-8"?>` | La première ligne est une déclaration qui spécifie au compilateur le format du document utilisant la combinaison de balises `<?xml` et `?>`
`<?import javafx.scene.layout.AnchorPane?>` | La deuxième ligne est identique à ce que nous faisons dans les fichiers `java`, soit déclarer les autres modules nécessaires, les `import`. Le *langage* est identique à ce que nous faisons dans Java, mais la *syntaxe* de la déclaration est comme celle de la première ligne : au lieu de terminer avec `;`, la déclaration est indiquée par les balises `<?import` et `?>`.
`<AnchorPane ...>` ... `</AnchorPane>` | Les prochaines lignes définissent l'élément `AnchorPane`. En fait, c'est le début de notre définition du **graphe de scène**. Il y a seulement deux détails en ce moment pour le graphe de scène : <p> **UN** Que l'élément `AnchorPane` est le `Root`, le premier dans le graphe. <p> **DEUX** Qu'on veut que le compilateur reconnaisse le nom "AnchorPane" comme un élément JavaFX. On déclare ce qui s'appelle un *namespace* avec la partie `xmlns:fx = "http://javafx.com/fxml/1"`. Le mot-clé `xmlns:` est nécessaire. L'URL n'a pas d'importance, mais doit être unique dans le document. La partie qui compte est ce qui vient après `xmlns:` soit `fx`. Le compilateur utilisera tous les éléments identifiés comme `fx` et les ajoutera au **graphe de scène**.
`<!-- TODO Add Nodes -->` | Cette ligne est un commentaire. On peut ajouter des commentaires n'importe òu avec les caractères initiaux `<!--` et finaux `-->`.


>Heureusement, vous n'aurez jamais à créer un document comme ça de rien parce qu'un modèle de base est toujours disponible soit via *e(fx)clipse* ou via les archétypes *Maven*.

#### Syntaxe générale

Tous les éléments JavaFX, comme n'importe quel élément `xml` seront définis par des balises. Les balises `xml` suivent le format `<élément attribut="valeur">` ... `</élément>` où :

* l'**élément** est un nom que le programme qui utilise le fichier `xml` reconnaîtera. S'il est dans le *namespace* `fx`, on saura qu'il faut chercher l'élément correspondant dans les modules JavaFX.
* les **attributs** sont un nombre restreint de caractéristiques, comme un *namespace* ou un autre identifiant, qui sont déclarées avant de fermer la balise initiale.
* on assigne à chaque attribut une **valeur** entre guillemets avec la syntaxe `attribut="valeur"`
* pour la balise finale, le nom de l'élément est précédé par le symbole `/`. Donc, `<AnchorPane>` pour ouvrir et `</AnchorPane>` pour fermer.

### Exemple plus complet

Voici un des deux fichiers `fxml` dans l'archétype Maven "javafx-archetype-fxml".

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Button?>
<?import javafx.geometry.Insets?>

<VBox alignment="CENTER" spacing="20.0" xmlns="http://javafx.com/javafx/8.0.171" xmlns:fx="http://javafx.com/fxml/1" fx:controller="edu.djc.fxmlswitch.PrimaryController">
   <children>
      <Label text="Primary View" />
      <Button fx:id="primaryButton" text="Switch to Secondary View" onAction="#switchToSecondary"/>
   </children>
   <padding>
      <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
   </padding>
</VBox>
```

On reconnaît la structure de base d'un fichier `fxml`. Voici quelques nouveaux éléments à remarquer :

Partie | Remarques
--- | ---
l'attribut `fx:controller` du `Root` | spécifie le **nom pleinement qualifié** de la classe Java qui contient tout le code pour contrôler cet élément *et ses enfants*, p. ex. `fx:controller = "edu.djc.fxmlswitch.PrimaryController"`
`<VBox ...>` ... `</VBox>` | tout ce qui concerne les éléments inférieurs à `VBox` dans le graphe de scène se trouve *entre* les balises initiale et finale du `VBox`
`<children>` ... `</children>` | entoure les enfants de l'élément `VBox` (le `Label` et le `Button`)
attribut `text` | spécifie le texte à afficher sur un élément du graphe de scène
attribut `fx:id` | spécifie le **nom de variable** utilisé dans les fichiers `java`. p. ex. `Button`: `fx:id="primaryButton"`
attribut `onAction` | remplace le `setOnAction()` des programmes JavaFX simples. La valeur est une référence à une méthode spécifique. p. ex. `onAction="#switchToSecondary"` pointe à `switchToSecondary()` qui doit être définie dans la classe contrôleur `edu.djc.fxmlswitch.PrimaryController`. <p> ❗ le `#` devant le nom est essentiel

>Il y a d'autres éléments et attributs dans le fichier liés à l'apparence. On les laisse pour la leçon sur le `css`.

>Noter une syntaxe *raccourcie* pour les balises `Label` et `Button` qui n'avaient aucune propriété interne à spécifier : `<Label text="Primary View" />` au lieu de `<Label text="Primary View"> </Label>`. C'est une syntaxe acceptable.

### Utiliser Scene Builder

Quand le logiciel Scene Builder est installé, au lieu d'éditer le fichier `fxml` directement dans l'éditeur de texte, on peut l'éditer visuellement :

* en cliquant et déplaçant différents éléments sur la `Scene`
* en spécifiant le contrôleur du `Root` via un menu
* en spécifiant la méthode `onAction` via un menu
* en spécifiant d'autres attributs et propriétés via des menus

Scene Builder nous permet de prévisualiser le résultat avant de retourner dans l'EDI.

En sauvegardant le fichier `fxml` dans Scene Builder, vous pouvez voir ces changements dans votre EDI et observer les ajouts et les modifications aux balises, aux attributs et aux propriétés de la structure `xml`.

## Définir les styles avec le CSS

### Référence principale

Voici le site pour trouver comment appliquer les styles aux différents éléments d'un graphe de scène. Là, on trouve les noms et les valeurs pour tous les styles qu'on peut modifier pour chaque type d'objet possible dans un graphe de scène JavaFX.

[Java CSS Reference Guide](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html)

>Noter que le `css` utilisé ici est très semblable au `css` utilisé pour les sites Web mais qu'il y a quelques différences, notamment le préfixe `fx` sur chacune des propriétés.

>Pour des références sur le `css` et le `html`, les tutoriels de [W3Schools](https://www.w3schools.com/Css/css_intro.asp) sont fortement recommandés.

### Exemple

Voir la référence pour des détails additionnels, mais voici un exemple simple de fichier `css` pour les projets JavaFX.

```css
.root {
  -fx-background-color: mediumaquamarine;
  -fx-font-family: 'monospace';
}

.button {
  -fx-padding: 20;
}

#btn1 {
  -fx-background-color: crimson;
}
```

Partie | Description
--- | ---
`.root`, `.button`  | Fait référence à **tous les objets JavaFX d'un même type** avec la notation `.<type>` où toutes les lettres sont en minuscule. Ainsi les styles spécifiés par le bloc `.root` s'appliquent à *tous* les objets dans le graphe de scène et les styles spécifiés par le bloc `.button` s'appliquent à tous les objets `Button` dans le graphe de scène. Les `Button` appliquent les deux ensembles de styles, les styles spécifiés par `.button` ayant priorité en cas de conflit.
`#btn1` | Fait référence au **nom de variable d'un objet**, ou si le nom est spécifié dans un fichier `fxml`, à son attribut `fx:id="<nom>"`. Ainsi, si le nom "btn1" réfère à un `Button`, les styles spécifiés par .`root`, `.button` **et** par `#btn1` seront tous appliqués, les styles pour `#btn1` ayant priorité en cas de conflit.
`-fx-padding: 20;` | Combinaison `<propriété>: <valeur>;` qui donne la spécification pour un élément de style. Les propriétés appliquables et les valeurs qu'elles acceptent sont décrites dans la référence Java CSS plus haut.

### Organisation des fichiers CSS dans le projet

⚠ C'est important de placer les fichiers `css` avec les fichiers `fxml` dans le dossier "src/main/ressources" du projet créé avec l'archétype Maven `javafx-archetype-fxml`.

Selon la configuration de cet archétype Maven, les fichiers dans le dossier "src/main/ressources" seront **copiés** dans le même dossier que les fichiers `.class`. Cela permet au programme de les trouver relativement à la classe principale `App.class` lors de l'exécution du programme.

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
|---target/classes/ ⬅ Fichiers compilés ici
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

>Cette méthode s'applique avec les projets JavaFX simple ou avec fichier `fxml`.

Avec un seul fichier `css` qui s'applique à l'ensemble du programme, on veut normalement lier le fichier `css` directement à la `Root` du projet. La façon la plus simple est dans la méthode `start()` avec la commande suivante :

```java
// scene.getStylesheets.add(cheminDuFichier)
scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
```

Wow!!! Regardons ça en petites bouchées.

La partie `scene.getStylesheets.add()` fait exactement ce qui ça dit. La méthode `add()` prend le chemin au fichier `css` comme argument. C'est là que la commande devient plus compliqué.

Voici une analyse de comment `this.getClass().getResource("app.css").toExternalForm()` retourne le chemin relatif du fichier "app.css" (son `url`) par rapport à la classe principale du programme :

1. `this.getClass()` retourne le nom de la classe principale (`this`) sur le disque dur. Ce nom aura la forme de `<Nom>.class`, par exemple `App.class`
2. `getResource()` cherche un fichier suivant le chemin relatif à la position de la classe principale
3. `"app.css"` est le chemin relatif, présumant qu'un fichier nommé "app.css" se trouve dans le même dossier que la classe principale
4. `.toExternalForm()` retourne l'URL (le chemin). Sans ça, `getResource()` retourne l'objet fichier lui-même et non son adresse.

On voit quelque chose de semblable dans le code de démarrage de l'archétype `javafx-archetype-fxml`, dans la méthode `loadFXML()` qui ajoute le fichier `fxml` au programme. C'est la partie :

```java
App.class.getResource(fxml + ".fxml")
```

où `fxml + ".fxml"` s'évalue à un nom de fichier, soit "primary.fxml" ou "secondary.fxml". Cette ligne de code veut dire :

1. `App.class` -> la classe principale (ce que `this.getClass()` retourne)
2. `.getResource()` -> trouve le fichier suivant un URL (un chemin) relatif à `App.class`
3. `fxml + ".fxml"` -> utilisant ce chemin. Les fichiers `fxml` sont copiés dans le même dossier que les fichiers `.class` du programme.

Dans ce cas, on voulait charger le fichier lui-même alors la partie `toExternalForm()` qui retourne l'adresse du fichier n'est pas nécessaire.

#### Avec un fichier CSS pour chaque fichier FXML

C'est aussi possible d'écrire de nombreux fichiers `css` pour le même programme, notamment en assignant un fichier `css` par fichier `fxml`.

>Cela est déconseillé si l'objectif est une apparence uniforme d'une vue à l'autre dans l'application, mais peut être utile si la vue doit changer considérablement.

On le fait en ajoutant l'attribut suivant à l'élément `Root` du `fxml` :

```xml
...
<!-- VBox est l'objet `Root` du graphe de scène -->
<VBox stylesheets="@app.css" ... >
  <!-- les <children> seraient déclarés ici -->
</VBox>
```

*Les `...` indiquent que des lignes ou des attributs ont été omis du fichier `fxml` afin de rendre l'exemple plus clair.*

>⚠ Le symbole `@` est critique devant le chemin. Le code ne fonctionne pas sans ça.

Et *voila!* Dans ce cas, on spécifie le chemin du fichier `css` relativement au **fichier FXML**. Le programme va charger le fichier `css` si un fichier "app.css" est dans le même dossier que ce fichier `fxml`. Placer les fichiers `fxml` et `css` ensemble est recommandé.

>Parce qu'on modifie un fichier `fxml`, c'est aussi possible de faire ça avec Scene Builder. On ouvre le fichier, sélectionne l'objet `Root` du côté gauche et choisie le fichier `css` souhaité pour l'attribut "Stylesheets" sur le côté droit.
