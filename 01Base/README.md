# Les types de données

Dans Java, chaque variable peut avoir un seul type durant toute la vie du programme. On doit déclarer explicitement le type de chaque variable dans nos programmes. Java est donc un langage de programmation avec des **types statiques**.

Le format pour cette déclaration de variable est la suivante :

```
<type> <nom> = <valeur>;
```

Où :
* `<type>` est le type de donnée (comme `String`, `int`, `double`), 
* `<nom>` est le nom de la variable et 
* `<valeur>` est une valeur du type approprié.

Voici trois exemples :

```java
String uneChaineDeTexte = "Une chaîne de texte";
int unNombreEntier = 42;
double unNombreDecimal = 3.1415;
```

>Noter que les `String` doivent être déclarés entre guillemets (`" "`). 
>
>En Python, les apostrophes (`' '`) pouvaient aussi être utilisés, mais les apostrophes sont réservés pour autre chose en Java.

## Utilisations recommandées pour chaque type

Type | Usage
---|---
`String`| général : noms, valeurs saisies à la console
`int`| nombre pour compter ou indexer
`double`| nombre pour calculer des valeurs
`boolean`| comme drapeau pour signaler quand quelque chose est `true` ou `false`

>Il y a plusieurs autres types dans Java, mais ceux-ci sont les plus couramment utilisés.


## Types natifs et objets Java

Les types **natifs** sont reconnus directement par le compilateur Java et sont de simples valeurs stockées en mémoire selon des standards externes au langage Java. Ces types sont tous numériques. Vous pouvez les reconnaître car ils sont les seuls types en Java qui commencent avec une **lettre minuscule** :

* booléens : `boolean` (`true` = 1, `false`= 0)
* caractères `char` (la valeur renvoie à un charactère dans le tableau ASCII ou Unicode)
* nombres entiers : `byte`, `short`, `int`, `long`
* nombres décimaux : `float`, `double`

Tous les autres types en Java sont définis par le langage Java comme un **objet**. Les noms de ces types commencent par une **lettre majuscule**.

* chaînes de texte : `String`
* listes : `List`, `ArrayList`, `LinkedList`, etc.
* dictionnaires : `Map`, `HashMap`, etc.

Pour bien gérér *tous les types*, Java définit des objets pour chacun de types natifs, soit un objet `Integer` pour le type natif `int`, `Double` pour `double`, etc. Ce que l'*objet* ajoute au type *natif* (la valeur pure) sont des méthodes pour manipuler les valeurs et simplifier leur interaction avec les autres objets Java.


## Conversions de texte vers un autre type

Les valeurs saisies via la console ou lues à partir d'un fichier sont toujours une chaîne de texte (`String`). Pour les utiliser comme valeur numérique il faut les convertir.

Voici des exemples où la valeur est stockée sous forme d'une variable du type approprié :

```java
// présume que les variables "s" contiennent des chaînes de texte 
// qui représentent les formats de nombre appropriés
// (p. ex. s1 = "3", s2 = "1.052")

int n = Integer.parseInt(s1);

double d = Double.parseDouble(s2);
```

On voit que la méthode utilisée suit, par convention, le format :
```
<ObjetJava>.parse<TypeNatif>(<texte>)
```

Le mot "parse" est synonyme de "interprèter" ou de "convertir" à partir de texte brut.


>Faire attention ici, parce qu'un texte qui n'a pas le bon format fera planté le programme lors de l'exécution


## Casting entre types numériques

C'est possible de convertir entre les types natifs numériques directement en utilisant ce qui s'appelle du **casting**. 

Par exemples :
```java
int n = (int) 54.32; // n = 54

int result = (int) (10 / 3); // result = 3

double d = (double) 765; // d = 765.0
```

Pour faire un casting, il faut simplement placer le type natif entre parenthèses devant le résultat numérique à convertir.



# La sortie standard (à la console)

La console à utiliser **pour afficher du texte** est définie par par Java dans l'objet `System.out`. Généralement, `System.out` réfère à la même console utilisée pour lancer la commande `java`. Cette console s'appelle **la sortie standard**.

Il y a quelques méthodes possibles pour utiliser la sortie standard.

`System.out.println(valeur);` -> `println()` affiche la valeur et positionne le curseur à la prochaine ligne à la console. Le prochain message sera alors sur une nouvelle ligne.

`System.out.print(valeur);` -> `print()` affiche la valeur laissant le curseur à la fin de la ligne. Le prochain message sera affiché sur la même ligne, sans séparation entre les deux textes.



# L'entrée standard (via la console)

La console à utiliser **pour saisir du texte** est définie par par Java dans l'objet `System.in`. Généralement, `System.in` réfère à la même console utilisée pour lancer la commande `java`. Cette console s'appelle **l'entrée standard**.

Pour saisir des valeurs via l'entrée standard, il faut créer un objet de type `Scanner` qui "écoutera" tous les caractères qui sont affichés à la console et qui peut, via une variété de méthodes, retourner des parties de ce texte au programme.

Pour utiliser des objets de type `Scanner` il y a trois étapes :
1. Importer la définition;
2. Déclarer un objet du type `Scanner`;
3. Utiliser des méthodes de `Scanner` dans le programme.


D'abord, il faut importer le code qui définit le type `Scanner` avec la ligne de code suivante au début du fichier (avant la déclaration de la classe) :

```java
import java.util.Scanner;
```

...


À la **toute fin, à la dernière ligne de `main()`** il faut aussi fermer le `Scanner` avec la méthode `.close()`.